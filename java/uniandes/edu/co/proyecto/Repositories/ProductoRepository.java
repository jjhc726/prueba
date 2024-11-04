package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.Entities.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {
    
    @Query(value="SELECT * FROM productos", nativeQuery=true)
    Collection<ProductoEntity> darProductos();

    @Query(value="SELECT * FROM productos WHERE id= :id", nativeQuery=true)
    ProductoEntity darProducto(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO productos (id, nombre, costoBodega, precioUnitario, presentacion, cantidad, unidad, codigoBarras, fechaVencimiento, especificaciones) VALUES (parranderos_sequence.nextval, :nombre, :costoBodega, :precioUnitario, :presentacion, :cantidad, :unidad, :codigoBarras, :fechaVencimiento, :especificaciones)", nativeQuery=true)
    void insertProducto(@Param("nombre") String nombre, @Param("costoBodega") float costoBodega, @Param("precioUnitario") float precioUnitario, @Param("presentacion") String presentacion, @Param("cantidad") float cantidad, @Param("unidad") String unidad, @Param("codigoBarras") String codigoBarras, @Param("fechaVencimiento") Date fechaVencimiento, @Param("especificaciones") String especificaciones);

    @Modifying
    @Transactional
    @Query(value="UPDATE productos SET nombre=:nombre, costoBodega=:costoBodega, precioUnitario=:precioUnitario, presentacion=:presentacion, cantidad=:cantidad, unidad=:unidad, codigoBarras=:codigoBarras, fechaVencimiento=:fechaVencimiento, especificaciones=:especificaciones WHERE id=:id", nativeQuery=true)
    void actualizarProducto( @Param("id") int id, @Param("nombre") String nombre,  @Param("costoBodega") float costoBodega, @Param("precioUnitario") float precioUnitario, @Param("presentacion") String presentacion, @Param("cantidad") float cantidad, @Param("unidad") String unidad, @Param("codigoBarras") String codigoBarras, @Param("fechaVencimiento") Date fechaVencimiento, @Param("especificaciones") String especificaciones);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM productos WHERE id= :id", nativeQuery=true)
    void eliminarProducto(@Param("id") int id);

    @Query(value= "SELECT p.codigo_barras, p.id_producto, p.nombre, p.costo_bodega,  p.precio_unitario, p.presentacion,  p.cantidad, p.unidad_medida, p.especificaciones, p.fecha_vencimiento,  p.id_categoria \r\n" +
    "FROM Productos p \r\n" +
    "WHERE p.precio_unitario BETWEEN rango_min AND rango_max AND p.fecha_vencimiento >= TO_DATE('fecha_cliente', 'DD/MM/YY') AND p.id_categoria = id_categoria_cliente;", nativeQuery = true)
    Collection<ProductoEntity> productoConCaracteristicas(@Param("rango_min") int min_rango,
    @Param("rango_max") int max_rango, @Param("fecha_cliente") int fecha_cliente, @Param("id_categoria_cliente") int categoria_cliente);


    @Query(value = "SELECT s.id_sucursal, s.nombre, s.direccion, s.telefono \r\n" + 
    "FROM Productos p \r\n" +
    "JOIN Bodegas b ON p.id_bodega = b.id_bodega \r\n" +
    "JOIN Sucursales s ON b.id_sucursal = s.id_sucursal \r\n" +
    "WHERE p.id_producto = id_prod_cliente OR p.nombre = nombre_prod_cliente")
    Collection<ProductoEntity> nombreOidProducto(@Param("id_prod_cliente") int id_producto,
    @Param("nombre_prod_cliente") String nombre_producto);

}
