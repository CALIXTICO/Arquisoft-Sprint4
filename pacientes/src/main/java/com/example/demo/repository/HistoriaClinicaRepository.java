package com.example.demo.repository;

import com.example.demo.model.HistoriaClinica;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistoriaClinicaRepository extends MongoRepository<HistoriaClinica, String> {
    // Puedes agregar consultas personalizadas aquí si es necesario
}
