package uniandes.edu.co.proyecto.Entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ordenes")
public class OrdenEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private long numOrden;
    private Date fechaEntrega;
    private String estado;

    public OrdenEntity (Long numOrden, Date fechaEntrega, String estado){
        this.numOrden = numOrden;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public long getNumOrden() {
        return numOrden;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    
}
