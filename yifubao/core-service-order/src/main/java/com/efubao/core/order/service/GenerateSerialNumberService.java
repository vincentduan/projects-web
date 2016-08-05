package com.efubao.core.order.service;



public interface GenerateSerialNumberService {
	
	public enum SerialNumberEnum{
        ORDER(1), MEASURE_ORDER(2), PAYMENT(3);
        
        private final Integer value;

        SerialNumberEnum(Integer value) {
            this.value = value;
        }
        
        public Integer getValue() {
            return value;
        }
    }
	
    String getSerialNumber(SerialNumberEnum type);
}