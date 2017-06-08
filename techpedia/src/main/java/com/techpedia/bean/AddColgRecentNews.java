package com.techpedia.bean;

public class AddColgRecentNews {
	private String newsDate;
	private String newsId;
	private String colgName;
	private String newsHeadline;
	private String newsDescription;
	public String getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}
	public String getNewsId() {
		return newsId;
	}
	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}
	public String getColgName() {
		return colgName;
	}
	public void setColgName(String colgName) {
		this.colgName = colgName;
	}
	public String getNewsHeadline() {
		return newsHeadline;
	}
	public void setNewsHeadline(String newsHeadline) {
		this.newsHeadline = newsHeadline;
	}
	
	public String getNewsDescription() {
		return newsDescription;
	}
	public void setNewsDescription(String newsDescription) {
		this.newsDescription = newsDescription;
	}
	@Override
	public String toString() {
		return "AddColgRecentNews [newsDate=" + newsDate + ", newsId=" + newsId + ", colgName=" + colgName
				+ ", newsHeadline=" + newsHeadline + ", newsDescription=" + newsDescription + "]";
	}
	
}
