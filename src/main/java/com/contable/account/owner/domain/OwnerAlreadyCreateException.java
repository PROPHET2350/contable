package com.contable.account.owner.domain;

public class OwnerAlreadyCreateException extends RuntimeException {

    public OwnerAlreadyCreateException(String message) {
        super(message);
    }
}
