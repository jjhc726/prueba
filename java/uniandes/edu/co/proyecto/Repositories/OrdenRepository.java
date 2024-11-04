package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.Entities.OrdenEntity;

@Repository
public interface OrdenRepository extends JpaRepository<OrdenEntity, Integer>{
    
    @Query(value="SELECT * FROM ordenes", nativeQuery=true)
    Collection<OrdenEntity> darOrdenes();

    @Query(value="SELECT * FROM ordenes WHERE id= :id", nativeQuery=true)
    OrdenEntity darOrden(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO ordenes (id, numOrden, fechaEntrega, estado) VALUES (parranderos_sequence.nextval, :numOrden, :fechaEntrega, :estado)", nativeQuery=true)
    void insertOrden(@Param ("numOrden") long numOrden, @Param("fechaEntrega") Date fechaEntrega, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value="UPDATE ordenes SET numOrden=:numOrden, fechaEntrega=:fechaEntrega, estado=:estado WHERE id=:id", nativeQuery=true)
    void actualizarOrden(@Param("id") int id, @Param("numOrden") long numOrden, @Param("fechaEntrega") Date fechaEntrega, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM ordenes WHERE id= :id", nativeQuery=true)
    void eliminarOrden(@Param("id") int id);
}
