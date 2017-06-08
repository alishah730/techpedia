package com.techpedia.projectmanagement.bean;

public class SaveProjectPhotoVO {
private long projectId;
private String imgName;
private String imgByteArray;
private String footerImgName;
private String footerImgByteArray;

/**
 * @return the projectId
 */
public long getProjectId() {
	return projectId;
}
/**
 * @param projectId the projectId to set
 */
public void setProjectId(long projectId) {
	this.projectId = projectId;
}

/**
 * @return the imgName
 */
public String getImgName() {
	return imgName;
}
/**
 * @param imgName the imgName to set
 */
public void setImgName(String imgName) {
	this.imgName = imgName;
}
/**
 * @return the imgByteArray
 */
public String getImgByteArray() {
	return imgByteArray;
}
/**
 * @param imgByteArray the imgByteArray to set
 */
public void setImgByteArray(String imgByteArray) {
	this.imgByteArray = imgByteArray;
}



/**
 * @return the footerImgName
 */
public String getFooterImgName() {
	return footerImgName;
}
/**
 * @param footerImgName the footerImgName to set
 */
public void setFooterImgName(String footerImgName) {
	this.footerImgName = footerImgName;
}
/**
 * @return the footerImgByteArray
 */
public String getFooterImgByteArray() {
	return footerImgByteArray;
}
/**
 * @param footerImgByteArray the footerImgByteArray to set
 */
public void setFooterImgByteArray(String footerImgByteArray) {
	this.footerImgByteArray = footerImgByteArray;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "SaveProjectPhoto [projectId=" + projectId + ", imgName=" + imgName
			+ ", imgByteArray=" + imgByteArray + ", footerImgName=" + footerImgName + ", footerImgByteArray=" + footerImgByteArray + "]";
}


}

