package com.lemon.sp.service.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lemon.sp.common.PageResults;

@Service
public interface BaseService<T extends Serializable> {

    T findOne(final int id);

    List<T> findAll();

    Object create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final int entityId);

	List<T> queryForList(String hql, Object[] params, int recordNum);

	List<T> queryForList(String hql, Object[] params);

	T queryForTopObject(String hql, Object[] params);

	PageResults<T> findPageByFetchedHql(String hql, String countHql,
			int pageNo, int pageSize, Object[] values);

	Long countByHql(String hql, Object[] values);
	
}
