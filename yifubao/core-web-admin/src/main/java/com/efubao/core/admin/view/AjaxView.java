package com.efubao.core.admin.view;

/**
 */
public class AjaxView {

    private Object status;

    private Object result;


    public AjaxView(){

    }

    public AjaxView(Object status, Object result){
        this.status = status;
        this.result = result;
    }

    public Object getStatus(){
        return this.status;
    }

    public Object getResult(){
        return this.result;
    }

}
