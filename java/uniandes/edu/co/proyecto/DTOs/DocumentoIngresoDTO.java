package uniandes.edu.co.proyecto.DTOs;

public class DocumentoIngresoDTO {
    private Integer numeroDocumento;
    private String fechaDocumento;
    private String nombreProveedor;

    // Constructor
    public DocumentoIngresoDTO(Integer numeroDocumento, String fechaDocumento, String nombreProveedor) {
        this.numeroDocumento = numeroDocumento;
        this.fechaDocumento = fechaDocumento;
        this.nombreProveedor = nombreProveedor;
    }

    // Getters y Setters
    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(String fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
}

