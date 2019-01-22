package com.railway.dao.impl;

import org.apache.log4j.Logger;

import javax.xml.crypto.Data;
import java.io.PrintWriter;

public class DataAccessException extends Exception {

    public final static int _FAIL_TO_INSERT = 1;
    public final static int _UPDATE_FAILED = 2;
    public final static int _SQL_ERROR = 3;
    private int errorCode;

    public DataAccessException(int errorCode) {
        this.errorCode=errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
