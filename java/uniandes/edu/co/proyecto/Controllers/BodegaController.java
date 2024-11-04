package uniandes.edu.co.proyecto.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.Entities.BodegaEntity;
import uniandes.edu.co.proyecto.Repositories.BodegaRepository;



@RestController
public class BodegaController {
    
    @Autowired
    private BodegaRepository bodegaRepository;

    @GetMapping("/bodegas")
    public Collection<BodegaEntity> bodegas(){
        return bodegaRepository.darBodegas();
    }


    @PostMapping("/bodegas/new/save")
    public ResponseEntity<String> bodegaGuardar(@RequestBody BodegaEntity bodegaEntity){
        try{
            bodegaRepository.insertBodega(bodegaEntity.getNombre(), bodegaEntity.getTamano());
            return new ResponseEntity<>("Bodega creada exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<> ("Error al crear una bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/bodegas/{id}/edit/save")
    public ResponseEntity<String> bodegaEditarGuardar(@PathVariable("id") int id, @RequestBody BodegaEntity bodegaEntity){
        try{
            bodegaRepository.actualizarBodega(id, bodegaEntity.getNombre(), bodegaEntity.getTamano());
            return new ResponseEntity<>("Bodega actualizada exitosamente",HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al actualizar la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        }
        

        @GetMapping("/bodegas/{id}/delete")
        public ResponseEntity<String> bodegaEliminar(@PathVariable("id") int id){
            try{
                bodegaRepository.eliminarBodega(id);
                return new ResponseEntity<>("Bodega eliminada exitosamente", HttpStatus.OK);
            }
            catch (Exception e){
                return new ResponseEntity<>("Error al eliminar la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        
    }
    

