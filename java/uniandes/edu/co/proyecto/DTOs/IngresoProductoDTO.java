package uniandes.edu.co.proyecto.DTOs;

import java.time.LocalDate;

public class IngresoProductoDTO {
    private String numeroDocumento;
    private LocalDate fechaIngreso;
    private String nombreProveedor;

    public IngresoProductoDTO(String numeroDocumento, LocalDate fechaIngreso, String nombreProveedor) {
        this.numeroDocumento = numeroDocumento;
        this.fechaIngreso = fechaIngreso;
        this.nombreProveedor = nombreProveedor;
    }

    // Getters y Setters

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

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
}

