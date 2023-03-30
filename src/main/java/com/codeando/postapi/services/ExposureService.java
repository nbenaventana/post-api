package com.codeando.postapi.services;

import com.codeando.postapi.entity.Exposure;

public interface ExposureService {

    Exposure findById(Long id);

    Exposure create(Exposure exposure);

}
