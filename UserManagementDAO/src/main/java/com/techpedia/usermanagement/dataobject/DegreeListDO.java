/**
 * 
 */
package com.techpedia.usermanagement.dataobject;

/**
 * @author charan_teja
 *
 */
public class DegreeListDO {

	private long id;
	private String degreeName;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the degreeName
	 */
	public String getDegreeName() {
		return degreeName;
	}
	/**
	 * @param degreeName the degreeName to set
	 */
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DegreeListDO [id=" + id + ", degreeName=" + degreeName + "]";
	}
	
}
