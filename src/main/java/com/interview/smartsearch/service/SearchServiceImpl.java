package com.interview.smartsearch.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.smartsearch.dao.SearchDao;
import com.interview.smartsearch.entities.WebDetail;

@Service
public class SearchServiceImpl implements SearchSevice {

	@Autowired
	private SearchDao searchDao;

	@Override
	@Transactional
	public List<String> getSuggestions(String serchString) {

		return searchDao.getSuggestions(serchString);
	}

	@Override
	public List<WebDetail> getSearchResult(String serchString) {
		return searchDao.getSearchResult(serchString);
	}

	@Override
	public List<WebDetail> getSearchResultByPages(String serchString, int pageNumber) {
		return searchDao.getSearchResultByPages(serchString, pageNumber);
	}

}
