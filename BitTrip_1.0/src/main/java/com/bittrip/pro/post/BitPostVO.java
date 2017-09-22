package com.bittrip.pro.post;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BitPostVO {
	private int post_id;
	private String user_id;
	private String name;
	private String title;
	private int trip_date;
	private String country;
	private int month;
	private String trip_thema;
	private Date create_date;
	private int count;
	private String post_id_day;
	private String content;
	private String location;
	private List<String> contentList;
	private List<String> locationList;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTrip_date() {
		return trip_date;
	}

	public void setTrip_date(int trip_date) {
		this.trip_date = trip_date;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getTrip_thema() {
		return trip_thema;
	}

	public void setTrip_thema(String trip_thema) {
		this.trip_thema = trip_thema;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<String> getContentList() {
		return contentList;
	}

	public void setContentList(List<String> contentList) {
		this.contentList = contentList;
	}

	public String getPost_id_day() {
		return post_id_day;
	}

	public void setPost_id_day(String post_id_day) {
		this.post_id_day = post_id_day;
	}

	public List<String> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<String> location) {
		this.locationList = location;
	}

}
