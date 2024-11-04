package uniandes.edu.co.proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.Entities.SucursalEntity;
import uniandes.edu.co.proyecto.Repositories.SucursalRepository;

@RestController
public class SucursalController {
    
    @Autowired
    private SucursalRepository sucursalRepository;

    @GetMapping("/sucursales")
    public java.util.Collection<SucursalEntity> sucursales(){
        return sucursalRepository.darSucursales();
    }


    @PostMapping("/sucursales/new/save")
    public ResponseEntity<String> sucursalGuardar(@RequestBody SucursalEntity sucursalEntity){
        try{
            sucursalRepository.insertSucursal(sucursalEntity.getCodigo(),  sucursalEntity.getNombre(), sucursalEntity.getTelefono(), sucursalEntity.getDireccion());
            return new ResponseEntity<>("Sucursal creada exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<> ("Error al crear una sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/sucursales/{id}/edit/save")
    public ResponseEntity<String> sucursalEditarGuardar(@PathVariable("id") int id, @RequestBody SucursalEntity sucursalEntity){
        try{
            sucursalRepository.actualizarSucursal(id, sucursalEntity.getCodigo(), sucursalEntity.getNombre(), sucursalEntity.getTelefono(), sucursalEntity.getDireccion());
            return new ResponseEntity<>("Sucursal actualizada exitosamente",HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al actualizar la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        }
        

        @GetMapping("/sucursales/{id}/delete")
        public ResponseEntity<String> sucursalEliminar(@PathVariable("id") int id){
            try{
                sucursalRepository.eliminarSucursal(id);
                return new ResponseEntity<>("Sucursal eliminada exitosamente", HttpStatus.OK);
            }
            catch (Exception e){
                return new ResponseEntity<>("Error al eliminar la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}
