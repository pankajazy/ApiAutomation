package com.rivigo.pojo.response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City_Weather_Forcast_Respone {
	@SerializedName("query")
	@Expose
	private Query query;

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}
}
