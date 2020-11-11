package com.interview.smartsearch.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.interview.smartsearch.entities.WebDetail;
import com.interview.smartsearch.service.SearchSevice;

@Controller
public class SearchController {

	@Autowired
	SearchSevice searchService;

	/*
	 * @RequestMapping("/search") public String showPage() {
	 * 
	 * System.out.println("/////////////////////////////////////"); return
	 * "firstpage"; }
	 */

	@RequestMapping("/{serchString}")
	public String getSuggestions(@PathVariable String serchString, Model model) {
		model.addAttribute("", searchService.getSuggestions(serchString));
		return "firstpage";
	}

	/*
	 * @RequestMapping("/result") public String
	 * getResults(@RequestParam("searchString") String searchResult, Model model) {
	 * 
	 * if (searchResult != null && !searchResult.isEmpty()) {
	 * model.addAttribute("webdetail", searchService.getSearchResult(searchResult));
	 * 
	 * System.out.println(searchService.getSearchResult(searchResult)); } return
	 * "firstpage"; }
	 */

	@RequestMapping("/result")
	public String getResultsByPages(@RequestParam("searchString") String searchResult,
			@RequestParam("pageNumber") int pageNumber, Model model) {

		if (searchResult != null && !searchResult.isEmpty()) {
			model.addAttribute("webdetail", searchService.getSearchResultByPages(searchResult, pageNumber));
			
			int nuberOfPages = (int) (searchService.getSearchResult(searchResult).size() / 5);

			if ((int) (searchService.getSearchResult(searchResult).size()) % 5 != 0) {
				nuberOfPages = nuberOfPages + 1;
			}
			
			System.out.println(">>>>>>>>>>>>>" + nuberOfPages);

			model.addAttribute("numberOfPages", nuberOfPages);
			model.addAttribute("searcgString", searchResult);

			System.out.println(searchService.getSearchResult(searchResult));
		}
		return "firstpage";
	}

	@GetMapping("/result/{searchString}/{pageNumber}")
	public String getResultsByPagesByGet(@PathVariable("searchString") String searchResult,
			@PathVariable("pageNumber") int pageNumber, Model model) {

		if (searchResult != null && !searchResult.isEmpty()) {
			model.addAttribute("webdetail", searchService.getSearchResultByPages(searchResult, pageNumber));

			System.out.println(">>>>>>>>>>>>>" + searchService.getSearchResult(searchResult).size());
		}

		int nuberOfPages = (int) (searchService.getSearchResult(searchResult).size() / 5);

		if ((int) (searchService.getSearchResult(searchResult).size()) % 5 != 0) {
			nuberOfPages = nuberOfPages + 1;
		}

		model.addAttribute("numberOfPages", nuberOfPages);
		model.addAttribute("searcgString", searchResult);

		return "firstpage";
	}
}
