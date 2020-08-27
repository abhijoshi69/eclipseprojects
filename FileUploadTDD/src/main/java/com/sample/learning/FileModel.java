package com.sample.learning;

public class FileModel 
{
	String name;
	String path;
	String filename;
	
	public FileModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileModel(String name, String path, String filename) {
		super();
		this.name = name;
		this.path = path;
		this.filename = filename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "FileModel [name=" + name + ", path=" + path + ", filename=" + filename + "]";
	}
	
	
}
