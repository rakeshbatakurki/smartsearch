package com.interview.smartsearch.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interview.smartsearch.entities.WebDetail;
import com.interview.smartsearch.service.SearchSevice;

@RestController
@RequestMapping("/search")
public class SearchControllerRest {

	@Autowired
	SearchSevice searchService;

	@RequestMapping("/{serchString}")
	public List<String> getSuggestions(@PathVariable String serchString) {

		System.out.println(">>>>>>>>>>>>>>" + serchString);

		List<String> list = searchService.getSuggestions(serchString);

		System.out.println(list);

		return list;
	}

	@RequestMapping("/result/{searchResult}")
	public List<WebDetail> getResults(@PathVariable String searchResult) {
		return searchService.getSearchResult(searchResult);
	}

	@RequestMapping("/result")
	public List<WebDetail> getResultsByPages(@RequestParam("searchResult") String searchResult,
			@RequestParam("pageNumber") int pageNumber) {
		return searchService.getSearchResultByPages(searchResult, pageNumber);
	}
}
