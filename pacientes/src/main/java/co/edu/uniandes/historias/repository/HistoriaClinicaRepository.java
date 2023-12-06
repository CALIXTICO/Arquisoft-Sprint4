package co.edu.uniandes.historias.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.uniandes.historias.model.HistoriaClinica;

public interface HistoriaClinicaRepository extends MongoRepository<HistoriaClinica, String> {

}
