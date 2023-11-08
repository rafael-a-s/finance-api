package com.arquiteture.core.exception;

import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

public class ClientExeception implements ResponseExceptionMapper<RuntimeException> {
    @Override
    public RuntimeException toThrowable(Response response) {
        if (response.getStatus() == 500) {
            throw new RuntimeException("The remote service responded with HTTP 500");
        }
        return null;
    }
}
