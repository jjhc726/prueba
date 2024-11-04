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

import uniandes.edu.co.proyecto.Entities.ProveedorEntity;
import uniandes.edu.co.proyecto.Repositories.ProveedorRepository;

@RestController
public class ProveedorController {
    
    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping("/proveedores")
    public Collection<ProveedorEntity> proveedor(){
        return proveedorRepository.darProveedores();
    }


    @PostMapping("/proveedores/new/save")
    public ResponseEntity<String> proveedorGuardar(@RequestBody ProveedorEntity proveedorEntity){
        try{
            proveedorRepository.insertProveedor(proveedorEntity.getNit(), proveedorEntity.getNombre(), proveedorEntity.getDireccion(), proveedorEntity.getNombreContacto(), proveedorEntity.getTelefonoContacto());
            return new ResponseEntity<>("Proveedor creado exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<> ("Error al crear un proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/proveedores/{id}/edit/save")
    public ResponseEntity<String> proveedorEditarGuardar(@PathVariable("id") int id, @RequestBody ProveedorEntity proveedorEntity){
        try{
            proveedorRepository.actualizarProveedor(id, proveedorEntity.getNit(), proveedorEntity.getNombre(), proveedorEntity.getDireccion(), proveedorEntity.getNombreContacto(), proveedorEntity.getTelefonoContacto());
            return new ResponseEntity<>("Proveedor actualizado exitosamente",HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al actualizar el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        }
        

        @GetMapping("/proveedores/{id}/delete")
        public ResponseEntity<String> proveedorEliminar(@PathVariable("id") int id){
            try{
                proveedorRepository.eliminarProveedor(id);
                return new ResponseEntity<>("Proveedor eliminado exitosamente", HttpStatus.OK);
            }
            catch (Exception e){
                return new ResponseEntity<>("Error al eliminar el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}
