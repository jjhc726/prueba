package uniandes.edu.co.proyecto.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="recepciones")
public class RecepcionEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private String codigo;

    
    public Integer getId() {
        return id;
    }
    public String getCodigo() {
        return codigo;
    }
}
