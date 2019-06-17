
package com.zl.credit.exception;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(Exception.class)

	@ResponseBody
	public ModelAndView exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		ErrorMessage<String> errorMessage = handleErrorInfo(request, exception.getMessage(), exception);
		modelAndView.setViewName("/index.html");
		modelAndView.addObject("error", errorMessage);
		return modelAndView;
	}

	private ErrorMessage<String> handleErrorInfo(HttpServletRequest request, String message, Exception exception) {
		ErrorMessage<String> errorMessage = new ErrorMessage<>();
		errorMessage.setMessage(message);
		errorMessage.setCode(ErrorMessage.ERROR);
		errorMessage.setData(message);
		errorMessage.setUrl(request.getRequestURL().toString());
		return errorMessage;
	}
}
