package uniandes.edu.co.proyecto.Entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "registro_ingreso")
public class RegistroIngresoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "numero_documento", nullable = false, unique = true)
    private String numeroDocumento;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "sucursal_id", nullable = false)
    private SucursalEntity sucursal;

    @ManyToOne
    @JoinColumn(name = "bodega_id", nullable = false)
    private BodegaEntity bodega;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private ProveedorEntity proveedor;

    @OneToMany(mappedBy = "registroIngreso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoIngresoEntity> productos;

    // Constructor
    public RegistroIngresoEntity(String numeroDocumento, LocalDate fechaIngreso, 
                                  SucursalEntity sucursal, BodegaEntity bodega, 
                                  ProveedorEntity proveedor) {
        this.numeroDocumento = numeroDocumento;
        this.fechaIngreso = fechaIngreso;
        this.sucursal = sucursal;
        this.bodega = bodega;
        this.proveedor = proveedor;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public SucursalEntity getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalEntity sucursal) {
        this.sucursal = sucursal;
    }

    public BodegaEntity getBodega() {
        return bodega;
    }

    public void setBodega(BodegaEntity bodega) {
        this.bodega = bodega;
    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    public List<ProductoIngresoEntity> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoIngresoEntity> productos) {
        this.productos = productos;
    }
}

