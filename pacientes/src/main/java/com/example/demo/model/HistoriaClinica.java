package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class HistoriaClinica {

    @Id
    private String id;
    private String pacienteNombre;
    private String medicoNombre;
    private String diagnostico;


    public HistoriaClinica() {
    }

    // Constructor
    public HistoriaClinica(String pacienteNombre, String medicoNombre, String diagnostico) {
        this.pacienteNombre = pacienteNombre;
        this.medicoNombre = medicoNombre;
        this.diagnostico = diagnostico;
    }


    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPacienteNombre() {
        return pacienteNombre;
    }

    public void setPacienteNombre(String pacienteNombre) {
        this.pacienteNombre = pacienteNombre;
    }

    public String getMedicoNombre() {
        return medicoNombre;
    }

    public void setMedicoNombre(String medicoNombre) {
        this.medicoNombre = medicoNombre;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
