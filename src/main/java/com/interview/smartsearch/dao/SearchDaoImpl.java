package com.interview.smartsearch.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.interview.smartsearch.entities.WebDetail;

@Repository
public class SearchDaoImpl implements SearchDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<String> getSuggestions(String serchString) {

		Session session = entityManager.unwrap(Session.class);

		@SuppressWarnings("unused")
		String tempString = serchString + "%";

		Query<String> query = session.createQuery("select w.title from WebDetail w where w.title LIKE :searchString");

		query.setParameter("searchString", serchString + "%");

		return query.getResultList();

	}

	@Override
	public List<WebDetail> getSearchResult(String serchString) {
		Session session = entityManager.unwrap(Session.class);

		Query<WebDetail> query = session.createQuery("from WebDetail w where w.title LIKE :searchString");

		query.setParameter("searchString", serchString + "%");

		return query.getResultList();
	}

	@Override
	public List<WebDetail> getSearchResultByPages(String serchString, int pageNumber) {

		Session session = entityManager.unwrap(Session.class);

		Query<WebDetail> query = session.createQuery("from WebDetail w where w.title LIKE :searchString");

		query.setParameter("searchString", serchString + "%");
		query.setFirstResult(((pageNumber * 5) - 5));
		query.setMaxResults((pageNumber * 5));

		return query.getResultList();

	}

}
