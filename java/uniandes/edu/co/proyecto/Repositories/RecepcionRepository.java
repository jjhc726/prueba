package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.Entities.RecepcionEntity;

@Repository
public interface RecepcionRepository extends JpaRepository<RecepcionEntity, Integer> {
    
    @Query(value="SELECT * FROM recepciones", nativeQuery=true)
    Collection<RecepcionEntity> darRecepciones();
    
    @Query(value="SELECT * FROM recepciones WHERE id= :id", nativeQuery=true)
    RecepcionEntity darRecepcion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO recepciones (id, codigo) VALUES (parranderos_sequence.nextval, :codigo)", nativeQuery=true)
    void insertRecepcion(@Param("codigo") String codigo);

    @Modifying
    @Transactional
    @Query(value="UPDATE recepciones SET codigo=:codigo WHERE id=:id", nativeQuery=true)
    void actualizarRecepcion(@Param("codigo") String codigo);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM recepciones WHERE id= :id", nativeQuery=true)
    void eliminarRecepcion(@Param("id") int id);
}
