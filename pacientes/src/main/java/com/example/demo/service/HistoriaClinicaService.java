package com.example.demo.service;

import com.example.demo.model.HistoriaClinica;
import com.example.demo.repository.HistoriaClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriaClinicaService {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    public List<HistoriaClinica> obtenerTodasLasHistoriasClinicas() {
        return historiaClinicaRepository.findAll();
    }

    public HistoriaClinica obtenerHistoriaClinicaPorId(String id) {
        Optional<HistoriaClinica> historiaClinicaOptional = historiaClinicaRepository.findById(id);
        return historiaClinicaOptional.orElse(null);
    }

    public HistoriaClinica guardarHistoriaClinica(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }

    public HistoriaClinica actualizarHistoriaClinica(String id, HistoriaClinica historiaClinica) {
        if (historiaClinicaRepository.existsById(id)) {
            historiaClinica.setId(id);
            return historiaClinicaRepository.save(historiaClinica);
        }
        return null; // Puedes manejar esto según tus necesidades, como lanzar una excepción, devolver un objeto específico, etc.
    }

    public void eliminarHistoriaClinica(String id) {
        historiaClinicaRepository.deleteById(id);
    }
}

