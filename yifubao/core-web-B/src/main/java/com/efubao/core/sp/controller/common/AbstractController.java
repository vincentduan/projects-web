package com.efubao.core.sp.controller.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;

import com.efubao.core.common.config.Config;
import com.efubao.core.common.exception.BusinessException;

/**
 */
public class AbstractController {

    /** LOOGER */
    protected Logger logger = LoggerFactory.getLogger(AbstractController.class);

    @Autowired
    private Config config;

    /**
     * set
     *
     * @param model
     * @param request
     * @throws BusinessException
     */
    @ModelAttribute
    public void modelAttribute(Model model, WebRequest request)
            throws BusinessException {
       
    }


    /**
     * 获取当前用户登录ID
     *
     * @return
     */
    protected Long getUserId() {
    	return null;
    }

}
