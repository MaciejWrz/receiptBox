package com.receiptbox.exception;

public class ReceiptValidationException extends RuntimeException {
    public ReceiptValidationException(String message) {
        super(message);
    }
}
