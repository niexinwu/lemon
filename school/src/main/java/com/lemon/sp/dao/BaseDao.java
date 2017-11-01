package com.lemon.sp.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.lemon.sp.common.PageResults;

public interface BaseDao<T extends Serializable>{
    T findOne(final int id);

    List<T> findAll();

    Object create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final int entityId);

	List<T> queryForList(String hql, Object[] params, int recordNum);

	List<T> queryForList(String hql, Object[] params);

	T queryForTopObject(String hql, Object[] params);
	
	Map queryForOneObject(String sql, Object[] params);
	
	PageResults<T> findPageByFetchedHql(String hql, String countHql,
			int pageNo, int pageSize, Object[] values);

	Long countByHql(String hql, Object[] values);
	
	Long countBySQL(String sql, Object[] values);

	Object countBySql(String sql, Object... values);
	
	List findPageBySQL(String sql,int pageNo,Object... values);
	
	List findListBySQL(String sql,Object... values);

	PageResults<T> findPageByFetchedSql(String sql, String countSql,int pageNo, int pageSize, Object... values);
	
	void batchsforinsert(List<T> list);
	//Integer countReadMsg(int uid, String msgId, String projectCode);
}

