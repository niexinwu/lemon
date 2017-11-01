package com.lemon.sp.dao.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import com.google.common.base.Preconditions;
import com.lemon.sp.common.Constant;
import com.lemon.sp.common.PageResults;
import com.lemon.sp.common.UtiltyHelper;
import com.lemon.sp.dao.BaseDao;

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDao<T extends Serializable> implements BaseDao<T> {

	private Class<T> clazz;
	public String errorCode;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	protected final void setClazz(final Class<T> clazzToSet) {
		this.clazz = Preconditions.checkNotNull(clazzToSet);
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public final T findOne(final int id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	@Override
	public final List<T> findAll() {
		return getCurrentSession().createQuery("from " + clazz.getName()).list();
	}

	@Override
	public final Object create(final T entity) {
		Preconditions.checkNotNull(entity);
		// getCurrentSession().persist(entity);
		Object ob = getCurrentSession().save(entity);
		getCurrentSession().flush();
		return ob;
	}

	@Override
	public final T update(final T entity) {
		Preconditions.checkNotNull(entity);
		getCurrentSession().update(entity);
		getCurrentSession().flush();
		return entity;
		// return (T)getCurrentSession().merge(entity);
	}

	@Override
	public final void delete(final T entity) {
		try {
			Preconditions.checkNotNull(entity);
			getCurrentSession().delete(entity);
			getCurrentSession().flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * 使用原生SQL执行增删改操作
	 * 
	 * @param sql
	 * @param params
	 */
	public final void executeBySQL(String sql, Object[] params) {
		Query query = getCurrentSession().createSQLQuery(sql);
		setQueryParams(query, params);
		query.executeUpdate();
	}

	@Override
	public final void deleteById(final int entityId) {
		final T entity = findOne(entityId);
		Preconditions.checkState(entity != null);
		delete(entity);
	}

	private void setQueryParams(Query query, Object[] params) {
		if (null == params) {
			return;
		}
		for (int i = 0; i < params.length; i++) {
			if (params[i] != null)
				query.setParameter(i, params[i]);
		}
	}

	/**
	 * 
	 */
	@Override
	public List<T> queryForList(final String hql, final Object[] params, final int recordNum) {
		Query query = getCurrentSession().createQuery(hql);
		setQueryParams(query, params);
		return query.setFirstResult(0).setMaxResults(recordNum).list();
	}

	/**
	 * 
	 *
	 */
	@Override
	public List<T> queryForList(String hql, Object[] params) {
		Query query = getCurrentSession().createQuery(hql);
		setQueryParams(query, params);
		return query.list();
	}

	/**
	 * 
	 */
	@Override
	public T queryForTopObject(String hql, Object[] params) {
		Query query = getCurrentSession().createQuery(hql);
		setQueryParams(query, params);
		return (T) query.setFirstResult(0).setMaxResults(1).uniqueResult();
	}

	@Override
	public Map queryForOneObject(String sql, Object[] params) {
		Query query = getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		setQueryParams(query, params);
		return (Map) query.setFirstResult(0).setMaxResults(1).uniqueResult();
	}

	/**
	 *
	 */
	@Override
	public PageResults<T> findPageByFetchedHql(String hql, String countHql, int pageNo, int pageSize,
			Object... values) {
		PageResults<T> retValue = new PageResults<T>();
		Query query = getCurrentSession().createQuery(hql);
		if (values != null) {
			int j = 0;
			for (int i = 0; i < values.length; i++) {
				if (values[i] != null) {
					query.setParameter(j, values[i]);
					j++;
				}
			}
		}
		int currentPage = pageNo > 1 ? pageNo : 1;
		retValue.setCurrentPage(currentPage);
		retValue.setPageSize(pageSize);
		if (countHql == null) {
			ScrollableResults results = query.scroll();
			results.last();
			retValue.setTotalCount(results.getRowNumber() + 1);// 设置总记录数
		} else {
			Long count = countByHql(countHql, values);
			retValue.setTotalCount(count.intValue());
		}
		retValue.resetPageNo();
		List<T> itemList = query.setFirstResult((currentPage - 1) * pageSize).setMaxResults(pageSize).list();
		if (itemList == null) {
			itemList = new ArrayList<T>();
		}
		retValue.setResults(itemList);

		return retValue;
	}

	/**
	 * HQL方式查询，返回Long
	 */
	@Override
	public Long countByHql(String hql, Object... values) {
		Query query = getCurrentSession().createQuery(hql);
		if (values != null) {
			int j = 0;
			for (int i = 0; i < values.length; i++) {
				if (values[i] != null) {
					query.setParameter(j, values[i]);
					j++;
				}
			}
		}
		return (Long) query.uniqueResult();
	}

	/**
	 * SQL方式查询，返回Long
	 */
	@Override
	public Long countBySQL(String sql, Object... values) {
		Query query = getCurrentSession().createQuery(sql);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return (Long) query.uniqueResult();
	}

	/**
	 * SQL方式查询，返回Object
	 */
	@Override
	public Object countBySql(String sql, Object... values) {
		Query query = getCurrentSession().createSQLQuery(sql);
		if (values != null) {
			int j = 0;
			for (int i = 0; i < values.length; i++) {
				if (values[i] != null) {
					query.setParameter(j, values[i]);
					j++;
				}
			}
		}
		return query.uniqueResult();
	}

	/**
	 * SQL方式查询，返回Object
	 */
	public Object countBySql(String sql, Map<String, Object> map) {
		Query query = getCurrentSession().createSQLQuery(sql);
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			query.setString(entry.getKey().toString(), entry.getValue().toString());
		}
		return query.uniqueResult();
	}

	/**
	 * 
	 */
	public List findPageBySQL(String sql, int pageNo, Object... values) {
		Query query = getCurrentSession().createSQLQuery(sql);
		int currentPage = pageNo > 1 ? pageNo : 1;
		int pageSize = Constant.pageSize;
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).setFirstResult((currentPage - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	public List findListBySQL(String sql, Object... values) {
		Query query = getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query.list();
	}

	/**
	 * 通过SQL查询分页
	 */
	@Override
	public PageResults<T> findPageByFetchedSql(String sql, String countSql, int pageNo, int pageSize,
			Object... values) {
		PageResults<T> retValue = new PageResults<T>();
		Query query = getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		if (values != null) {
			int j = 0;
			for (int i = 0; i < values.length; i++) {
				if (values[i] != null) {
					query.setParameter(j, values[i]);
					j++;
				}
			}
		}
		int currentPage = pageNo > 1 ? pageNo : 1;
		retValue.setCurrentPage(currentPage);
		retValue.setPageSize(pageSize);
		if (countSql == null) {
			ScrollableResults results = query.scroll();
			results.last();
			retValue.setTotalCount(results.getRowNumber() + 1);// 设置总记录数
		} else {
			Integer count = UtiltyHelper.parseInteger(countBySql(countSql, values));
			retValue.setTotalCount(count);
		}
		retValue.resetPageNo();
		List<T> itemList = query.setFirstResult((currentPage - 1) * pageSize).setMaxResults(pageSize).list();
		if (itemList == null) {
			itemList = new ArrayList<T>();
		}
		retValue.setResults(itemList);

		return retValue;
	}

	/**
	 * 通过SQL查询分页
	 */
	public PageResults<T> findPageByFetchedSql(String sql, String countSql, int pageNo, int pageSize,
			Map<String, Object> map) {
		PageResults<T> retValue = new PageResults<T>();
		Query query = getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		if (map != null) {
			for (String key : map.keySet()) {
				query.setParameter(key, map.get(key));
			}
		}
		int currentPage = pageNo > 1 ? pageNo : 1;
		retValue.setCurrentPage(currentPage);
		retValue.setPageSize(pageSize);
		if (countSql == null) {
			ScrollableResults results = query.scroll();
			results.last();
			retValue.setTotalCount(results.getRowNumber() + 1);// 设置总记录数
		} else {
			Integer count = UtiltyHelper.parseInteger(countBySql(countSql, map));
			retValue.setTotalCount(count);
		}
		retValue.resetPageNo();
		List<T> itemList = query.setFirstResult((currentPage - 1) * pageSize).setMaxResults(pageSize).list();
		if (itemList == null) {
			itemList = new ArrayList<T>();
		}
		retValue.setResults(itemList);

		return retValue;
	}

	/**
	 * 批处理插入
	 */
	public void batchsforinsert(List<T> list) {
		Session session = null;
		if (list != null && list.size() > 0) {
			try {
				session = getCurrentSession(); // 获取Session
				// session.beginTransaction(); // 开启事物
				T t = null;
				for (int i = 0; i < list.size(); i++) {
					t = (T) list.get(i);
					session.save(t);
					if (i % 100 == 0) {
						session.flush();
						session.clear();
					}
				}
				// session.getTransaction().commit(); // 提交事物
			} catch (Exception e) {
				e.printStackTrace(); // 打印错误信息
				session.getTransaction().rollback(); // 出错将回滚事物
			}
		}
	}

}
