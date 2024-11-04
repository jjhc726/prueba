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

import uniandes.edu.co.proyecto.Entities.CategoriaEntity;
import uniandes.edu.co.proyecto.Repositories.CategoriaRepository;


@RestController
public class CategoriaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/categorias")
    public Collection<CategoriaEntity> categorias(){
        return categoriaRepository.darCategorias();
    }


    @PostMapping("/categorias/new/save")
    public ResponseEntity<String> categoriaGuardar(@RequestBody CategoriaEntity categoriaEntity){
        try{
            categoriaRepository.insertCategoria(categoriaEntity.getCodigo(), categoriaEntity.getNombre(), categoriaEntity.getDescripcion(), categoriaEntity.getCaracteristicas());
            return new ResponseEntity<>("Categoria creada exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<> ("Error al crear una categoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/categorias/{id}/edit/save")
    public ResponseEntity<String> categoriaEditarGuardar(@PathVariable("id") int id, @RequestBody CategoriaEntity categoriaEntity){
        try{
            categoriaRepository.actualizarCategoria(id, categoriaEntity.getCodigo(), categoriaEntity.getNombre(), categoriaEntity.getDescripcion(), categoriaEntity.getCaracteristicas());;
            return new ResponseEntity<>("Categoria actualizada exitosamente",HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al actualizar la categoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        }
        

        @GetMapping("/categorias/{id}/delete")
        public ResponseEntity<String> categoriaEliminar(@PathVariable("id") int id){
            try{
                categoriaRepository.eliminarCategoria(id);
                return new ResponseEntity<>("Categoria eliminada exitosamente", HttpStatus.OK);
            }
            catch (Exception e){
                return new ResponseEntity<>("Error al eliminar la categoria", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        
}
