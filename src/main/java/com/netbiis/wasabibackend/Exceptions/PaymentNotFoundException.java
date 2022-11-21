package com.netbiis.wasabibackend.Exceptions;

public class PaymentNotFoundException extends Throwable {
    public PaymentNotFoundException(String message) {
        super(message);
    }
}
