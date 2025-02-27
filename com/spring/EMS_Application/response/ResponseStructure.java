package com.spring.EMS_Application.response;

import java.time.LocalDateTime;
import lombok.Data;
@Data
public class ResponseStructure<T>
{
	private T data;
	private String message;
	private LocalDateTime datetime;
	private int statusCode;
}
