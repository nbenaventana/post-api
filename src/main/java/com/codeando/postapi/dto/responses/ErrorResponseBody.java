package com.codeando.postapi.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseBody {

    public ErrorResponseBody(String... errors) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, errors);
        this.errors = list;
    }

    private List<String> errors = new ArrayList<>();

    public boolean addError(String error) {
        return errors.add(error);
    }
}
