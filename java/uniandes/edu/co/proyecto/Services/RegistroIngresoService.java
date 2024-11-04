package uniandes.edu.co.proyecto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.DTOs.IngresoProductoDTO;
import uniandes.edu.co.proyecto.DTOs.ProductoDTO;
import uniandes.edu.co.proyecto.DTOs.RegistroIngresoDTO;
import uniandes.edu.co.proyecto.Entities.ProductoIngresoEntity;
import uniandes.edu.co.proyecto.Entities.RegistroIngresoEntity;
import uniandes.edu.co.proyecto.Repositories.BodegaRepository;
import uniandes.edu.co.proyecto.Repositories.ProveedorRepository;
import uniandes.edu.co.proyecto.Repositories.RegistroIngresoRepository;
import uniandes.edu.co.proyecto.Repositories.SucursalRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistroIngresoService {

    @Autowired
    private RegistroIngresoRepository registroIngresoRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private BodegaRepository bodegaRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public List<IngresoProductoDTO> getDocumentosIngresoSerializable(Integer sucursalId, Integer bodegaId) {
        try {
            Thread.sleep(30000); // Simulación de un tiempo de ejecución de 30 segundos
            return registroIngresoRepository.findIngresosBySucursalAndBodega(sucursalId, bodegaId);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los documentos de ingreso de productos (SERIALIZABLE)", e);
        }
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public List<IngresoProductoDTO> getDocumentosIngresoReadCommitted(Integer sucursalId, Integer bodegaId) {
        try {
            Thread.sleep(30000); // Simulación de un tiempo de ejecución de 30 segundos
            return registroIngresoRepository.findIngresosBySucursalAndBodega(sucursalId, bodegaId);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los documentos de ingreso de productos (READ COMMITTED)", e);
        }
    }

    @Transactional
    public RegistroIngresoEntity registrarIngreso(RegistroIngresoDTO registroIngresoDTO) {
        // Mapea los datos del DTO a la entidad RegistroIngresoEntity
        RegistroIngresoEntity registroIngreso = new RegistroIngresoEntity(
            registroIngresoDTO.getNumeroDocumento(),
            registroIngresoDTO.getFechaIngreso(),
            sucursalRepository.findById(registroIngresoDTO.getSucursalId()).orElseThrow(() -> new RuntimeException("Sucursal no encontrada")),
            bodegaRepository.findById(registroIngresoDTO.getBodegaId()).orElseThrow(() -> new RuntimeException("Bodega no encontrada")),
            proveedorRepository.findById(registroIngresoDTO.getProveedorId()).orElseThrow(() -> new RuntimeException("Proveedor no encontrado"))
        );

        // Guardar productos asociados
        List<ProductoIngresoEntity> productos = new ArrayList<>();
        for (ProductoDTO productoDTO : registroIngresoDTO.getProductos()) {
            ProductoIngresoEntity producto = new ProductoIngresoEntity(
                registroIngreso, 
                productoDTO.getNombreProducto(), 
                productoDTO.getCantidad(), 
                productoDTO.getPrecioUnitario()
            );
            productos.add(producto);
        }
        registroIngreso.setProductos(productos);

        // Guardar el registro de ingreso en la base de datos
        return registroIngresoRepository.save(registroIngreso);
    }
}
