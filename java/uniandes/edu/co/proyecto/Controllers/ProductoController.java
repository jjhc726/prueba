package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.Entities.ProductoEntity;
import uniandes.edu.co.proyecto.Repositories.ProductoRepository;

@RestController
public class ProductoController {
    
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/productos")
    public Collection<ProductoEntity> productos(){
        return productoRepository.darProductos();
    }

    @GetMapping("/productos/consulta2")
    public ResponseEntity<Map<String,Object>> productos(
        @RequestParam(required = false) int min_rango,
        @RequestParam(required = false) int max_rango,
        @RequestParam(required = false) int fecha_cliente,
        @RequestParam(required = false) int categoria_cliente) {
    
    Collection<ProductoEntity> productos;
    productos = productoRepository.productoConCaracteristicas(min_rango, max_rango, fecha_cliente, categoria_cliente);
    Map<String, Object> response = new HashMap<>();
    response.put("productos", productos);
    return ResponseEntity.ok(response);
    



}


    @PostMapping("/productos/new/save")
    public ResponseEntity<String> productoGuardar(@RequestBody ProductoEntity productoEntity){
        try{
            productoRepository.insertProducto(productoEntity.getNombre(), productoEntity.getCostoBodega(), productoEntity.getPrecioUnitario(), productoEntity.getPresentacion(), productoEntity.getCantidad(), productoEntity.getUnidad(), productoEntity.getCodigoBarras(), productoEntity.getFechaVencimiento(), productoEntity.getEspecificaciones());
            return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<> ("Error al crear un producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/productos/{id}/edit/save")
    public ResponseEntity<String> productoEditarGuardar(@PathVariable("id") int id, @RequestBody ProductoEntity productoEntity){
        try{
            productoRepository.actualizarProducto(id, productoEntity.getNombre(), productoEntity.getCostoBodega(), productoEntity.getPrecioUnitario(), productoEntity.getPresentacion(), productoEntity.getCantidad(), productoEntity.getUnidad(), productoEntity.getCodigoBarras(), productoEntity.getFechaVencimiento(), productoEntity.getEspecificaciones());
            return new ResponseEntity<>("Producto actualizado exitosamente",HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al actualizar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        }
        

        @GetMapping("/productos/{id}/delete")
        public ResponseEntity<String> productoEliminar(@PathVariable("id") int id){
            try{
                productoRepository.eliminarProducto(id);
                return new ResponseEntity<>("Producto eliminado exitosamente", HttpStatus.OK);
            }
            catch (Exception e){
                return new ResponseEntity<>("Error al eliminar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @GetMapping("/productos/consulta4")
        public Collection<ProductoEntity> getSucursalesDisponibilidad(
                @RequestParam(required = false) Integer id_producto,
                @RequestParam(required = false) String nombre_producto) {

        // Validación para asegurarse de que al menos uno de los parámetros sea proporcionado
            if (id_producto == null && (nombre_producto == null || nombre_producto.isEmpty())) {
             throw new IllegalArgumentException("Debe proporcionar un id de producto o un nombre de producto.");
          }
 
        // Consulta el repositorio para obtener la lista de sucursales donde el producto está disponible
         return productoRepository.nombreOidProducto(id_producto, nombre_producto);
    }
}
