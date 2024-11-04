package uniandes.edu.co.proyecto.Repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.Entities.CategoriaEntity;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {
    
    @Query(value="SELECT * FROM categorias", nativeQuery=true)
    Collection<CategoriaEntity> darCategorias();

    @Query(value="SELECT * FROM categorias WHERE id= :id", nativeQuery=true)
    CategoriaEntity darCategoria(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO categorias (id, codigo, nombre, descripcion, caracteristicas) VALUES (parranderos_sequence.nextval, :codigo, :nombre, :descripcion, :caracteristicas)",nativeQuery=true)
    void insertCategoria(@Param	("codigo") String codigo, @Param("nombre") String nombre, @Param ("descripcion") String descripcion, @Param ("caracteristicas") String caracteristicas);

    @Modifying
    @Transactional
    @Query(value="UPDATE categorias SET codigo=:codigo, nombre=:nombre, descripcion=:descripcion, caracteristicas=:caracteristicas WHERE id=:id", nativeQuery=true)
    void actualizarCategoria(@Param("id") int id, @Param("codigo") String codigo, @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("caracteristicas") String caracteristicas);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM categorias WHERE id= :id", nativeQuery=true)
    void eliminarCategoria(@Param("id") int id);
}
