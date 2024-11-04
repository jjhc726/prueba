package uniandes.edu.co.proyecto.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.Entities.OrdenEntity;
import uniandes.edu.co.proyecto.Repositories.OrdenRepository;

@RestController
public class OrdenController {
    
    @Autowired
    private OrdenRepository ordenRepository;

    @GetMapping("/ordenes")
    public java.util.Collection<OrdenEntity> ordenes(){
        return ordenRepository.darOrdenes();
    }


    @PostMapping("/ordenes/new/save")
    public ResponseEntity<String> ordenGuardar(@RequestBody OrdenEntity ordenEntity){
        try{
            ordenRepository.insertOrden(ordenEntity.getNumOrden(), ordenEntity.getFechaEntrega(), ordenEntity.getEstado());
            return new ResponseEntity<>("Orden creada exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<> ("Error al crear una orden", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/ordenes/{id}/edit/save")
    public ResponseEntity<String> ordenEditarGuardar(@PathVariable("id") int id, @RequestBody OrdenEntity ordenEntity){
        try{
            ordenRepository.actualizarOrden(id, ordenEntity.getNumOrden(), ordenEntity.getFechaEntrega(), ordenEntity.getEstado());
            return new ResponseEntity<>("Orden actualizada exitosamente",HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al actualizar la orden", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        }
        

        @GetMapping("/ordenes/{id}/delete")
        public ResponseEntity<String> ordenEliminar(@PathVariable("id") int id){
            try{
                ordenRepository.eliminarOrden(id);
                return new ResponseEntity<>("Orden eliminada exitosamente", HttpStatus.OK);
            }
            catch (Exception e){
                return new ResponseEntity<>("Error al eliminar la orden", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}
