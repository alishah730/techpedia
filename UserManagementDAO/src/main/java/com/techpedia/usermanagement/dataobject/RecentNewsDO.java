package com.techpedia.usermanagement.dataobject;
public class RecentNewsDO {

	private String newsDate;
	private String newsId;
	private String colgName;
	private String newsHeadline;
	private String isActive;
	private String newsDescription;
	
	

	/**
	 * @return the isActive
	 */
	public String getIsActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the newsDate
	 */
	public String getNewsDate() {
		return newsDate;
	}
	/**
	 * @param newsDate the newsDate to set
	 */
	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}
	/**
	 * @return the newsId
	 */
	public String getNewsId() {
		return newsId;
	}
	/**
	 * @param newsId the newsId to set
	 */
	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}
	/**
	 * @return the newsHeadline
	 */
	public String getNewsHeadline() {
		return newsHeadline;
	}
	/**
	 * @param newsHeadline the newsHeadline to set
	 */
	public void setNewsHeadline(String newsHeadline) {
		this.newsHeadline = newsHeadline;
	}
	/**
	 * @return the newsDescription
	 */
	public String getNewsDescription() {
		return newsDescription;
	}
	/**
	 * @param newsDescription the newsDescription to set
	 */
	public void setNewsDescription(String newsDescription) {
		this.newsDescription = newsDescription;
	}
	/**
	 * @return the colgName
	 */
	public String getColgName() {
		return colgName;
	}
	/**
	 * @param colgName the colgName to set
	 */
	public void setColgName(String colgName) {
		this.colgName = colgName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RecentNewsDO [newsDate=" + newsDate + ", newsId=" + newsId
				+ ", colgName=" + colgName + ", newsHeadline=" + newsHeadline
				+ ", isActive=" + isActive + ", newsDescription="
				+ newsDescription + "]";
	}



	

}