package com.contable.core.account.owner.domain;

public class OwnerAlreadyCreateException extends RuntimeException {

    public OwnerAlreadyCreateException(String message) {
        super(message);
    }
}
