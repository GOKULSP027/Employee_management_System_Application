package com.spring.EMS_Application.exception;

public class ResourceNotFoundException extends RuntimeException{
	@Override
	public String getMessage()
	{
		return"ResourceNotFoundException";
	}

}
