package com.mastercard.tao.zhang.demo.exception;

public class NoSuchCsvFileException extends RuntimeException {

    public NoSuchCsvFileException(String message) {
        super(message);
    }
}