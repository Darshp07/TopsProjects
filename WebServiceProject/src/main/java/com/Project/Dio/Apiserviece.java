package com.Project.Dio;

public class Apiserviece<T> {

	private boolean Status;
	private String massege;
	private T data;

	public Apiserviece(boolean status, String massege, T data) {

		Status = status;
		this.massege = massege;
		this.data = data;
	}

	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

	public String getMassege() {
		return massege;
	}

	public void setMassege(String massege) {
		this.massege = massege;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}

