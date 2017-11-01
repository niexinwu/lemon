package com.lemon.sp.service.base.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lemon.sp.common.PageResults;
import com.lemon.sp.dao.BaseDao;
import com.lemon.sp.service.base.BaseService;

/**
 * 
 * @author Niejun
 * @Date 2015/03/12
 * @param <T>
 * @param <PK>
 * 公共父类Service 支持泛型 hibernate4 新特性
 */

public abstract class AbstractService<T extends Serializable> implements BaseService<T> {
    
    protected abstract BaseDao<T> getDao();
    
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
    @Override
    public T findOne(final int id) {
        return getDao().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public Object create(final T entity) {
        return getDao().create(entity);
    }

    @Override
    public T update(final T entity) {
        return getDao().update(entity);
    }

    @Override
    public void delete(final T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(int entityId) {
        getDao().deleteById(entityId);
    }  
    
    @Override
	public List<T> queryForList(String hql, Object[] params, int recordNum){
		return getDao().queryForList(hql, params,recordNum);
	}
    
    @Override
	public List<T> queryForList(String hql, Object[] params){
		return getDao().queryForList(hql, params);
	}
    
    @Override
	public T queryForTopObject(String hql, Object[] params){
		return getDao().queryForTopObject(hql, params);
	}
    
    @Override
	public PageResults<T> findPageByFetchedHql(String hql, String countHql,
			int pageNo, int pageSize, Object[] values){
		return getDao().findPageByFetchedHql(hql, countHql, pageNo, pageSize, values);
	}
    
    @Override
	public Long countByHql(String hql, Object[] values){
		return getDao().countByHql(hql, values);
	}
    
        
}
