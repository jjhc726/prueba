package uniandes.edu.co.proyecto.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.DTOs.IngresoProductoDTO;
import uniandes.edu.co.proyecto.Entities.RegistroIngresoEntity;

import java.util.List;

@Repository
public interface RegistroIngresoRepository extends JpaRepository<RegistroIngresoEntity, Integer> {

    @Query("SELECT new com.example.dto.IngresoProductoDTO(d.numero, d.fechaIngreso, p.nombre) " +
           "FROM RegistroIngresoEntity d " +
           "JOIN d.proveedor p " +
           "JOIN d.bodega b " +
           "JOIN b.sucursal s " +
           "WHERE s.id = :sucursalId AND b.id = :bodegaId " +
           "AND d.fechaIngreso >= CURRENT_DATE - 30")
    List<IngresoProductoDTO> findIngresosBySucursalAndBodega(@Param("sucursalId") Integer sucursalId,
                                                             @Param("bodegaId") Integer bodegaId);
}
