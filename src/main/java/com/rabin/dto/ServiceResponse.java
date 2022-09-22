package com.rabin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponse <T>{

    public HttpStatus status;
    private T response;
    private List<ErrorDTO> error;

    public ServiceResponse(HttpStatus status, T response) {
        this.status = status;
        this.response = response;
    }
}
