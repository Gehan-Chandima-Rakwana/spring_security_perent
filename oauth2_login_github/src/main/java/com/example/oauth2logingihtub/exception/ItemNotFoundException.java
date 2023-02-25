package com.example.oauth2logingihtub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Item not found")
public class ItemNotFoundException extends Throwable {
    public ItemNotFoundException(String itemsNotInList) {
    }
}
