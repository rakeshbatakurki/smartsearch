package com.interview.smartsearch.dao;

import java.util.List;

import com.interview.smartsearch.entities.WebDetail;

public interface SearchDao {

	public List<String> getSuggestions(String serchString);

	public List<WebDetail> getSearchResult(String serchString);

	public List<WebDetail> getSearchResultByPages(String serchString, int pageNumber);

}
