package com.interview.smartsearch.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "web_details")
public class WebDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;

	@Column(name = "title")
	String title;

	@Column(name = "detail")
	String details;

	public WebDetail() {
	}

	public WebDetail(String title, String detail) {

		this.title = title;
		this.details = detail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String detail) {
		this.details = detail;
	}

	@Override
	public String toString() {
		return "WebDetail [id=" + id + ", title=" + title + ", detail=" + details + "]";
	}

}
