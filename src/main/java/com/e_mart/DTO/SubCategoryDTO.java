package com.e_mart.DTO;

import jakarta.persistence.Id;

public class SubCategoryDTO {
	@Id
	private String name;
	private String fileName;
	private String fileType;
	private String file;

	public String getFileName() {
		return fileName;
	}
	public String getFile() {
		return file;
	}
	public void setFileName(String file) {
		this.fileName = file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public SubCategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
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
				 + ", status=" + status + "]";
	}
	public String isStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public SubCategoryDTO(String name, String fileName, String fileType, String status) {
		super();
		this.name = name;
		this.fileName = fileName;
		this.fileType = fileType;
		this.status = status;
	}

	

}
