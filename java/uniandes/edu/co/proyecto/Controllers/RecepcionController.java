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

import uniandes.edu.co.proyecto.Entities.RecepcionEntity;
import uniandes.edu.co.proyecto.Repositories.RecepcionRepository;

@RestController
public class RecepcionController {
    
    @Autowired
    private RecepcionRepository recepcionRepository;

    @GetMapping("/recepciones")
    public Collection<RecepcionEntity> recepciones(){
        return recepcionRepository.darRecepciones();
    }


    @PostMapping("/recepciones/new/save")
    public ResponseEntity<String> recepcionGuardar(@RequestBody RecepcionEntity recepcionEntity){
        try{
            recepcionRepository.insertRecepcion(recepcionEntity.getCodigo());
            return new ResponseEntity<>("Recepcion creada exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<> ("Error al crear una recepcion", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/recepciones/{id}/edit/save")
    public ResponseEntity<String> recepcionEditarGuardar(@PathVariable("id") int id, @RequestBody RecepcionEntity recepcionEntity){
        try{
            recepcionRepository.actualizarRecepcion(recepcionEntity.getCodigo());
            return new ResponseEntity<>("Recepcion actualizada exitosamente",HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al actualizar la recepcion", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        }
        

        @GetMapping("/recepciones/{id}/delete")
        public ResponseEntity<String> recepcionEliminar(@PathVariable("id") int id){
            try{
                recepcionRepository.eliminarRecepcion(id);
                return new ResponseEntity<>("Recepcion eliminada exitosamente", HttpStatus.OK);
            }
            catch (Exception e){
                return new ResponseEntity<>("Error al eliminar la recepcion", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}
