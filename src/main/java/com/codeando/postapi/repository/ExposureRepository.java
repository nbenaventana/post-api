package com.codeando.postapi.repository;

import com.codeando.postapi.entity.Exposure;
import com.codeando.postapi.exceptions.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExposureRepository extends JpaRepository<Exposure, Long>{

    Exposure findByType(String type) throws EntityNotFoundException;

}
