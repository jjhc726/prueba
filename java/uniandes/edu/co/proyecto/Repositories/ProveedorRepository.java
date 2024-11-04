package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.Entities.ProveedorEntity;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Integer> {
    
    @Query(value="SELECT * FROM proveedores", nativeQuery=true)
    Collection<ProveedorEntity> darProveedores();

    @Query(value="SELECT * FROM proveedores WHERE id= :id", nativeQuery=true)
    ProveedorEntity darProveedor(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO proveedores (id, nit, nombre, direccion, nombreContacto, telefonoContacto) VALUES (parranderos_sequence.nextval, :nit, :nombre, :direccion, :nombreContacto, :telefonoContacto )", nativeQuery=true)
    void insertProveedor(@Param("nit") int nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("nombreContacto") String nombreContacto, @Param("telefonoContacto") int telefonoContacto );

    @Modifying
    @Transactional
    @Query(value="UPDATE proveedores SET nit=:nit, nombre=:nombre, direccion=:direccion, nombreContacto=:nombreContacto, telefonoContacto=:telefonoContacto WHERE id=:id", nativeQuery=true)
    void actualizarProveedor(@Param("id") int id, @Param("nit") int nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("nombreContacto") String nombreContacto, @Param("telefonoContacto") int telefonoContacto );

    @Modifying
    @Transactional
    @Query(value="DELETE FROM proveedores WHERE id= :id", nativeQuery=true)
    void eliminarProveedor(@Param("id") int id);
}
