package com.contable.account.companies.domain;

public class IdentityTakenException extends RuntimeException {

    public IdentityTakenException(String message) {
        super(message);
    }
}
