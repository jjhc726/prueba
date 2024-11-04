package uniandes.edu.co.proyecto.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="proveedores")
public class ProveedorEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private int nit;
    private String nombre;
    private String direccion;
    private String nombreContacto;
    private int telefonoContacto;

    public ProveedorEntity (int nit, String nombre, String direccion, String nombreContacto, int telefonoContacto){
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nombreContacto = nombreContacto;
        this.telefonoContacto = telefonoContacto;
    }

    public Integer getId() {
        return id;
    }

    public int getNit() {
        return nit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public int getTelefonoContacto() {
        return telefonoContacto;
    }

    
}
