package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.Entities.BodegaEntity;


@Repository
public interface BodegaRepository extends JpaRepository<BodegaEntity, Integer> {
    
    @Query(value="SELECT * FROM bodegas", nativeQuery=true)
    Collection<BodegaEntity> darBodegas();

    @Query(value="SELECT * FROM bodegas WHERE id= :id", nativeQuery=true)
    BodegaEntity darBodega(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO bodegas (id, nombre, tamano) VALUES(parranderos_sequence.nextval, :nombre, :tamano)", nativeQuery=true)
    void insertBodega(@Param("nombre") String nombre, @Param("tamano") float tamano);

    @Modifying
    @Transactional
    @Query(value="UPDATE bodegas SET nombre=:nombre, tamano=:tamano WHERE id=:id", nativeQuery=true)
    void actualizarBodega(@Param("id") int id, @Param("nombre") String nombre, @Param("tamano") float tamano);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM bodegas WHERE id= :id", nativeQuery=true)
    void eliminarBodega(@Param("id") int id);
}
