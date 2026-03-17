package com.e_mart.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
@Entity
@Table(name="brand")
public class Brand {
	@Id
	private String name;
	private String fileName;
	private String fileType;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] fileData;

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setFileData(byte[] bs) {
		this.fileData = bs;
	}
	public String getStatus() {
		return status;
	}
	private String status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "MainCatagoryClass  , name=" + name + ", fileName=" + fileName + ", fileType=" + fileType
				+ ", fileData=" + fileData + ", status=" + status + "]";
	}
	public String isStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Brand(String name, String fileName, String fileType, byte[] fileData, String status) {
		super();
		this.name = name;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileData = fileData;
		this.status = status;
	}

	
}
