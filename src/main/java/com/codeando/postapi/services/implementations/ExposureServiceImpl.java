package com.codeando.postapi.services.implementations;

import com.codeando.postapi.entity.Exposure;
import com.codeando.postapi.exceptions.EntityNotFoundException;
import com.codeando.postapi.repository.ExposureRepository;
import com.codeando.postapi.services.ExposureService;
import org.springframework.stereotype.Service;

@Service
public class ExposureServiceImpl implements ExposureService {

    private final ExposureRepository repository;

    public ExposureServiceImpl(ExposureRepository repository) {
        this.repository = repository;
    }

    @Override
    public Exposure findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la exposición con id: " + id));
    }

    @Override
    public Exposure create(Exposure exposure) {
        return repository.save(exposure);
    }

    @Override
    public Exposure findByName(String name) {
        try {
            return repository.findByType(name);
        } catch (Exception e) {
            throw new EntityNotFoundException("No se encontró la exposición con nombre: " + name);
        }

    }

}
