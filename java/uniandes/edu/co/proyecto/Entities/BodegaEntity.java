package uniandes.edu.co.proyecto.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="bodegas")
public class BodegaEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private String nombre;
    private float tamano;
    
    public BodegaEntity (String nombre, float tamano){
        this.nombre = nombre;
        this.tamano = tamano;
    }

    public BodegaEntity(){
        ;
    }

    public Integer getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public float getTamano(){
        return tamano;
    }
}
