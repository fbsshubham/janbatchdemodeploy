package dto;

import java.util.List;

import model.Student;

public class ResponseDTO<T> {
	
	int status;
	String message;
	List<T> data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> students) {
		this.data = students;
	}

	
	
}
