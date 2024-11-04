package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.Entities.SucursalEntity;

@Repository
public interface  SucursalRepository extends JpaRepository<SucursalEntity, Integer>{
    
    @Query(value="SELECT * FROM sucursales", nativeQuery=true)
    Collection<SucursalEntity> darSucursales();

    @Query(value="SELECT * FROM sucursales WHERE id= :id", nativeQuery=true)
    SucursalEntity darSucursal(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO sucursales (id, codigo, nombre, telefono, direccion) VALUES (parranderos_sequence.nextval, :codigo, :nombre, :telefono, :direccion)", nativeQuery=true)
    void insertSucursal(@Param("codigo") String codigo, @Param("nombre") String nombre, @Param("telefono") int telefono, @Param("direccion") String direccion );

    @Modifying
    @Transactional
    @Query(value="UPDATE sucursales SET codigo=:codigo, nombre=:nombre, telefono=:telefono, direccion=:direccion WHERE id=:id", nativeQuery=true)
    void actualizarSucursal(@Param("id") int id, @Param("codigo") String codigo, @Param("nombre") String nombre, @Param("telefono") int telefono, @Param("direccion") String direccion );

    @Modifying
    @Transactional
    @Query(value="DELETE FROM sucursales WHERE id= :id", nativeQuery=true)
    void eliminarSucursal(@Param("id") int id);
}
