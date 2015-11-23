package com.techpedia.usermanagement.dataobject;

import java.util.Arrays;

public class UpdateUserPhotoDO {
	
	private String registerID;
	private String photoByteStream;
	/**
	 * @return the registerID
	 */
	public String getRegisterID() {
		return registerID;
	}
	/**
	 * @param registerID the registerID to set
	 */
	public void setRegisterID(String registerID) {
		this.registerID = registerID;
	}
	/**
	 * @return the photoByteStream
	 */
	public String getPhotoByteStream() {
		return photoByteStream;
	}
	/**
	 * @param photoByteStream the photoByteStream to set
	 */
	public void setPhotoByteStream(String photoByteStream) {
		this.photoByteStream = photoByteStream;
	}
	public UpdateUserPhotoDO(String registerID, String photoByteStream) {
		super();
		this.registerID = registerID;
		this.photoByteStream = photoByteStream;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdateUserPhotoDO [registerID=" + registerID
				+ ", photoByteStream=" + photoByteStream + "]";
	}
	public UpdateUserPhotoDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	
	
}
