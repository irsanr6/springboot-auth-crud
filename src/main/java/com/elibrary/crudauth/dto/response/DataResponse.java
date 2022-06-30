package com.elibrary.crudauth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse<T> {

    private boolean status;
    private String message;
    private T data;
}
