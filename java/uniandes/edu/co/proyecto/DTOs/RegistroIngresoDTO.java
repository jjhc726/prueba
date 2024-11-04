package uniandes.edu.co.proyecto.DTOs;

import java.time.LocalDate;
import java.util.List;

public class RegistroIngresoDTO {
    private String numeroDocumento;
    private LocalDate fechaIngreso;
    private Integer sucursalId;
    private Integer bodegaId;
    private Integer proveedorId;
    private List<ProductoDTO> productos;

    public RegistroIngresoDTO(String numeroDocumento, LocalDate fechaIngreso, Integer sucursalId, Integer bodegaId, Integer proveedorId, List<ProductoDTO> productos) {
        this.numeroDocumento = numeroDocumento;
        this.fechaIngreso = fechaIngreso;
        this.sucursalId = sucursalId;
        this.bodegaId = bodegaId;
        this.proveedorId = proveedorId;
        this.productos = productos;
    }

    // Getters y setters
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

    public Integer getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Integer sucursalId) {
        this.sucursalId = sucursalId;
    }

    public Integer getBodegaId() {
        return bodegaId;
    }

    public void setBodegaId(Integer bodegaId) {
        this.bodegaId = bodegaId;
    }

    public Integer getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Integer proveedorId) {
        this.proveedorId = proveedorId;
    }

    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }
}
