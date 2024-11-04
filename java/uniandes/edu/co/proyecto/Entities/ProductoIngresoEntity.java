package uniandes.edu.co.proyecto.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos_ingreso")
public class ProductoIngresoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "registro_ingreso_id", nullable = false)
    private RegistroIngresoEntity registroIngreso;

    private String nombreProducto;
    private int cantidad;
    private double precioUnitario;

    // Constructor
    public ProductoIngresoEntity(RegistroIngresoEntity registroIngreso, String nombreProducto, 
                                 int cantidad, double precioUnitario) {
        this.registroIngreso = registroIngreso;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RegistroIngresoEntity getRegistroIngreso() {
        return registroIngreso;
    }

    public void setRegistroIngreso(RegistroIngresoEntity registroIngreso) {
        this.registroIngreso = registroIngreso;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
