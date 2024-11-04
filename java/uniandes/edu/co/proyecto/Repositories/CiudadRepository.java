package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.Entities.CiudadEntity;

@Repository
public interface CiudadRepository extends JpaRepository<CiudadEntity, Integer>{
    
    @Query(value="SELECT * FROM ciudades2", nativeQuery=true)
    Collection<CiudadEntity> darCiudades();

    @Query(value="SELECT * FROM ciudades WHERE id)= : id", nativeQuery=true)
    CiudadEntity darCiudad(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO ciudades (id, codigo_ciudad, nombre, descripcion, caracteristicas) VALUES(parranderos_sequence.nextval, :codigo, :nombre, :descripcion, :caracteristicas)",nativeQuery=true)
    void insertCiudad(@Param("codigo") String codigo, @Param("nombre") String nombre, @Param ("descripcion") String descripcion, @Param ("caracteristicas") String caracteristicas);

    @Modifying
    @Transactional
    @Query(value="UPDATE ciudades SET codigo=:codigo, nombre=:nombre, descripcion=:descripcion, caracteristicas=:caracteristicas WHERE id=:id", nativeQuery=true)
    void actualizarCiudad(@Param("id") int id, @Param("codigo") String codigo, @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("caracteristicas") String caracteristicas);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM ciudades WHERE id= :id", nativeQuery=true)
    void eliminarCiudad(@Param("id") int id);
}
