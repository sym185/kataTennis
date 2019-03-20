package com.tennis.utils.errors;

public class FunctionalException extends Exception {

    public FunctionalException(EnumFunctionalException exception){
        super(exception.getMessage());
    }

    public FunctionalException(EnumFunctionalException exception, Throwable e) {
        super(exception.toString(), e);
    }
}
