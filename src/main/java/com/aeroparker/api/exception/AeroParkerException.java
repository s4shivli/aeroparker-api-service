package com.aeroparker.api.exception;

import java.util.Set;

public class AeroParkerException extends RuntimeException {

    public AeroParkerException(Set<String> messages) {
        super(messages.toString());
    }
}
