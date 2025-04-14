package com.app.util;

import java.util.List;

public class QueryData {

	private String query;
	private List<Object> params;

	public QueryData(String query, List<Object> params) {
		this.query = query;
		this.params = params;
	}

	public String getQuery() {
		return query;
	}

	public List<Object> getParams() {
		return params;
	}

}
