package co.edu.uniandes.historias.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("historias")
public class HistoriaClinica {

    @Id
    private String _id;
    private String pacienteNombre;
    private List<Orden> ordenes;
    private String diagnostico;


    public HistoriaClinica() {
    }


    public HistoriaClinica(String pacienteNombre,  String diagnostico) {
        this.pacienteNombre = pacienteNombre;
        this.diagnostico = diagnostico;
    }



    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getPacienteNombre() {
        return pacienteNombre;
    }

    public void setPacienteNombre(String pacienteNombre) {
        this.pacienteNombre = pacienteNombre;
    }
    

    public List<Orden> getOrdenes() {
        return ordenes;
    }


    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }


    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
