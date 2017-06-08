/**
 * 
 */
package com.techpedia.projectmanagement.bean;

/**
 * @author charan_teja
 *
 */
public class TotalProjectsStatisticsVO {
	
	private String  status;
	private long value;
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the value
	 */
	public long getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(long value) {
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TotalProectsStatisticsVO [status=" + status + ", value=" + value + "]";
	}

}
