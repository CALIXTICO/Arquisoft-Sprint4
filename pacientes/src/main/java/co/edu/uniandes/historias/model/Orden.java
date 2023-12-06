package co.edu.uniandes.historias.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
public class Orden {


    @Id
    private ObjectId _id;
    private String doctor;
    private String medicina;

    public Orden() {}

    public Orden(ObjectId _id, String doctor, String medicina) {
        this._id = _id;
        this.doctor = doctor;
        this.medicina = medicina;
    }






}
