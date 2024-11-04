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

import uniandes.edu.co.proyecto.Entities.CiudadEntity;
import uniandes.edu.co.proyecto.Repositories.CiudadRepository;

@RestController
public class CiudadController {
    
    @Autowired
    private CiudadRepository ciudadRepository;

    @GetMapping("/ciudades")
    public Collection<CiudadEntity> ciudades(){
        return ciudadRepository.darCiudades();
    }


    @PostMapping("/ciudades/new/save")
    public ResponseEntity<String> ciudadGuardar(@RequestBody CiudadEntity ciudadEntity){
        try{
            ciudadRepository.insertCiudad(ciudadEntity.getCodigo(), ciudadEntity.getNombre(), ciudadEntity.getDescripcion(), ciudadEntity.getCaracteristicas());;
            return new ResponseEntity<>("Ciudad creada exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<> ("Error al crear una ciudad", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/ciudades/{id}/edit/save")
    public ResponseEntity<String> categoriaEditarGuardar(@PathVariable("id") int id, @RequestBody CiudadEntity ciudadEntity){
        try{
            ciudadRepository.actualizarCiudad(id, ciudadEntity.getCodigo(), ciudadEntity.getNombre(), ciudadEntity.getDescripcion(), ciudadEntity.getCaracteristicas());;
            return new ResponseEntity<>("Ciudad actualizada exitosamente",HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al actualizar la ciudad", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        }
        

        @GetMapping("/ciudades/{id}/delete")
        public ResponseEntity<String> ciudadEliminar(@PathVariable("id") int id){
            try{
                ciudadRepository.eliminarCiudad(id);
                return new ResponseEntity<>("Ciudad eliminada exitosamente", HttpStatus.OK);
            }
            catch (Exception e){
                return new ResponseEntity<>("Error al eliminar la ciudad", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}
