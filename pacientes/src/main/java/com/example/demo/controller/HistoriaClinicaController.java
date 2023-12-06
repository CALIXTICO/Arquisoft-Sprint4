package com.example.demo.controller;

import com.example.demo.model.HistoriaClinica;
import com.example.demo.service.HistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historiasclinicas")
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @GetMapping
    public ResponseEntity<List<HistoriaClinica>> obtenerTodasLasHistoriasClinicas() {
        List<HistoriaClinica> historiasClinicas = historiaClinicaService.obtenerTodasLasHistoriasClinicas();
        return new ResponseEntity<>(historiasClinicas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinica> obtenerHistoriaClinicaPorId(@PathVariable String id) {
        HistoriaClinica historiaClinica = historiaClinicaService.obtenerHistoriaClinicaPorId(id);
        return new ResponseEntity<>(historiaClinica, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HistoriaClinica> guardarHistoriaClinica(@RequestBody HistoriaClinica historiaClinica) {
        HistoriaClinica nuevaHistoriaClinica = historiaClinicaService.guardarHistoriaClinica(historiaClinica);
        return new ResponseEntity<>(nuevaHistoriaClinica, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriaClinica> actualizarHistoriaClinica(@PathVariable String id, @RequestBody HistoriaClinica historiaClinica) {
        HistoriaClinica historiaClinicaActualizada = historiaClinicaService.actualizarHistoriaClinica(id, historiaClinica);
        if (historiaClinicaActualizada != null) {
            return new ResponseEntity<>(historiaClinicaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHistoriaClinica(@PathVariable String id) {
        historiaClinicaService.eliminarHistoriaClinica(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
