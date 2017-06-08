/**
 * 
 */
package com.techpedia.projectmanagement.bean;

/**
 * @author charan_teja
 *
 */
public class GetReviewRatingVO {
	private long projId;
	private long revRgstrId;
	/**
	 * @return the projId
	 */
	public long getProjId() {
		return projId;
	}
	/**
	 * @param projId the projId to set
	 */
	public void setProjId(long projId) {
		this.projId = projId;
	}
	/**
	 * @return the revRgstrId
	 */
	public long getRevRgstrId() {
		return revRgstrId;
	}
	/**
	 * @param revRgstrId the revRgstrId to set
	 */
	public void setRevRgstrId(long revRgstrId) {
		this.revRgstrId = revRgstrId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GetReviewRatingVO [projId=" + projId + ", revRgstrId=" + revRgstrId + "]";
	}
	
	

}
