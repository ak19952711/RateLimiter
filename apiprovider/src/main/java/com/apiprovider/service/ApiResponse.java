package com.apiprovider.service;

import java.util.List;

public class ApiResponse<T> {

    private int status;
    private String message;
    private Object result;
    private List<String> errors;

    public ApiResponse(int status, String message, Object result,List<String> errors) {
        this.status = status;
        this.message = message;
        this.result = result;
        this.errors=errors;
    }

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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "ApiResponse [status=" + status + ", message=" + message + ", result=" + result + ", errors=" + errors
				+ "]";
	}
    
    
}