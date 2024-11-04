package uniandes.edu.co.proyecto.Entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class ProductoEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private String nombre;
    private float costoBodega;
    private float precioUnitario;
    private String presentacion;
    private float cantidad;
    private String unidad;
    private String codigoBarras;
    private Date fechaVencimiento;
    private String especificaciones;



    public ProductoEntity(String nombre, float costoBodega, float precioUnitario, String presentacion, float cantidad, String unidad, String especificaciones){
        this.costoBodega = costoBodega;
        this.precioUnitario = precioUnitario;
        this.presentacion= presentacion;
        this.cantidad= cantidad;
        this.unidad= unidad;
        this.nombre = nombre;
        this.especificaciones = especificaciones;
    }


    public Integer getId() {
        return id;
    }

    public float getCostoBodega() {
        return costoBodega;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public float getCantidad() {
        return cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }
}
