package co.edu.uniandes.historias.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.uniandes.historias.model.HistoriaClinica;
import  co.edu.uniandes.historias.repository.HistoriaClinicaRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @GetMapping("/historias")
    public String read(Model model) {
        model.addAttribute("historias", historiaClinicaRepository.findAll());
        return "historias";
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinica> getHistoriaClinicaById(@PathVariable("id") String id) {
        Optional<HistoriaClinica> historiaClinicaData = historiaClinicaRepository.findById(id);

        return historiaClinicaData.map(historiaClinica -> new ResponseEntity<>(historiaClinica, HttpStatus.OK))
                                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    public ResponseEntity<HttpStatus> deleteHistoriaClinica(@PathVariable("id") String id) {
        try {
            historiaClinicaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
