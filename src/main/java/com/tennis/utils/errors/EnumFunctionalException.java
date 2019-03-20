package com.tennis.utils.errors;

public enum EnumFunctionalException {

    //POINT
    ERROR_POINT("ERROR_POINT_NOT_VALID");

    private final String message;

    EnumFunctionalException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
