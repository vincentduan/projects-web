/**
 * GlobalExceptionHandler.java
 * Copyright (c) 2013 by efubao.com
 */
package com.efubao.core.admin.controller.exception;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;

import com.efubao.core.common.exception.BusinessException;
import com.efubao.core.common.exception.TokenInvalidException;

/**
 * global controller exception handler
 * 全局异常处理，参考org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver
 * 
 * Exception    Http Code
 * NoSuchRequestHandlingMethodException    404 (Not Found)
 * HttpRequestMethodNotSupportedException  405 (Method Not Allowed)
 * HttpMediaTypeNotSupportedException  415 (Unsupported Media Type)
 * MissingServletRequestParameterException 400 (Bad Request)
 * ServletRequestBindingException  400 (Bad Request)
 * ConversionNotSupportedException 500 (Internal Server Error)
 * TypeMismatchException   400 (Bad Request)
 * HttpMessageNotReadableException 400 (Bad Request)
 * HttpMessageNotWritableException 500 (Internal Server Error)
 * MethodArgumentNotValidException 400 (Bad Request)
 * MissingServletRequestPartException  400 (Bad Request)
 * 
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	/** Logger */
    static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
	/**
	 * handle business exception
	 * @param ex business exception
	 * @return
	 */
	@ExceptionHandler
	@ResponseBody
	public String handleBusinessException(BusinessException ex) {
		return ex.getMessage();
	}
	
	/**
	 * handle token invalid exception
	 * @param ex business exception
	 * @return
	 */
	@ExceptionHandler
	@ResponseBody
	public String handleTokenInvalidException(TokenInvalidException ex) {
	    return ex.getMessage();
	}

	/**
	 * handle token invalid exception
	 * @param ex HttpRequestMethodNotSupportedException
	 * @return
	 */
	@ExceptionHandler
	@ResponseBody
	public String handle(HttpRequestMethodNotSupportedException ex) {
	    return ex.getMessage();
	}

	/**
	 * handle IO exception
	 * @param ex IOException
	 * @return
	 */
	@ExceptionHandler
	public void handle(IOException ex) {
        if (ex.getClass().getSimpleName().equalsIgnoreCase("ClientAbortException")) {
            // ignore
            LOGGER.warn("ex ClientAbort");
        }else {
            LOGGER.warn("IO错误" + ex.getMessage());
        }
	}
	


    @ExceptionHandler( IllegalStateException.class )
    public String handleException( IllegalStateException ex ){
        return "IllegalSate";
    }

    @ExceptionHandler( MultipartException.class )
    @ResponseBody
    public String handle(MultipartException exception){
        return "multipart";
    }
}
