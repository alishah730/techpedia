/**
 * 
 */
package com.techpedia.projectmanagement.bean;

/**
 * @author charan_teja
 *
 */
public class TotalProjectsYearWiseStatisticsVO {

	public String sector;
	public long size;
	/**
	 * @return the sector
	 */
	public String getSector() {
		return sector;
	}
	/**
	 * @param sector the sector to set
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}
	/**
	 * @return the size
	 */
	public long getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(long size) {
		this.size = size;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TotalProjectsYearWiseStatisticsVO [sector=" + sector + ", size=" + size + "]";
	}
	
}
