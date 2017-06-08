/**
 * 
 */
package com.techpedia.projectmanagement.bean;

import java.util.Map;

/**
 * @author 455959
 *
 */
public class UploadMultipleProjDocVO {
	
	private long rgstrId;
	private long projId;
	private Map<String, String> documentMap;
	public long getRgstrId() {
		return rgstrId;
	}
	public void setRgstrId(long rgstrId) {
		this.rgstrId = rgstrId;
	}
	public long getProjId() {
		return projId;
	}
	public void setProjId(long projId) {
		this.projId = projId;
	}
	public Map<String, String> getDocumentMap() {
		return documentMap;
	}
	public void setDocumentMap(Map<String, String> documentMap) {
		this.documentMap = documentMap;
	}
	
	
}
