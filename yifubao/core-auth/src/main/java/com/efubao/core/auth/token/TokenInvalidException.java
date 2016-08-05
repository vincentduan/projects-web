package com.efubao.core.auth.token;

/**
 * token invalid exception
 * 来源于V
 */
public class TokenInvalidException extends Exception {
    
    /**
     * 
     */
    private static final long serialVersionUID = 7861647682646392551L;

    /**
     * constructor
     * @param message Exception message
     */
    public TokenInvalidException(final String message) {
        super(message);
    }

}
