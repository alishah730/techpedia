package com.techpedia.usermanagement.dataobject;

public class SaveUserPhoto {
private long registerId;
private String imgName;
private String imgByteArray;
/**
 * @return the registerId
 */
public long getRegisterId() {
	return registerId;
}
/**
 * @param registerId the registerId to set
 */
public void setRegisterId(long registerId) {
	this.registerId = registerId;
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
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "SaveUserPhoto [registerId=" + registerId + ", imgName=" + imgName
			+ ", imgByteArray=" + imgByteArray + "]";
}


}
