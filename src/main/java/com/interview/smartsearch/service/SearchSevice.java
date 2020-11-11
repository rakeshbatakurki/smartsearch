package com.interview.smartsearch.service;

import java.util.List;

import com.interview.smartsearch.entities.WebDetail;

public interface SearchSevice {

	public List<String> getSuggestions(String serchString);

	public List<WebDetail> getSearchResult(String serchString);

	public List<WebDetail> getSearchResultByPages(String serchString, int pageNumber);
}
