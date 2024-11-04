package uniandes.edu.co.proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.DTOs.IngresoProductoDTO;
import uniandes.edu.co.proyecto.DTOs.RegistroIngresoDTO;
import uniandes.edu.co.proyecto.Entities.RegistroIngresoEntity;
import uniandes.edu.co.proyecto.Services.RegistroIngresoService;

import java.util.List;

@RestController
@RequestMapping("/api/ingreso-productos")
public class RegistroIngresoController {

    @Autowired
    private RegistroIngresoService registroIngresoService;

    @GetMapping("/consulta-serializable")
    public ResponseEntity<List<IngresoProductoDTO>> getDocumentosIngresoSerializable(
            @RequestParam Integer sucursalId,
            @RequestParam Integer bodegaId) {
        try {
            List<IngresoProductoDTO> documentos = registroIngresoService.getDocumentosIngresoSerializable(sucursalId, bodegaId);
            return ResponseEntity.ok(documentos);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/consulta-read-committed")
    public ResponseEntity<List<IngresoProductoDTO>> getDocumentosIngresoReadCommitted(
            @RequestParam Integer sucursalId,
            @RequestParam Integer bodegaId) {
        try {
            List<IngresoProductoDTO> documentos = registroIngresoService.getDocumentosIngresoReadCommitted(sucursalId, bodegaId);
            return ResponseEntity.ok(documentos);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<RegistroIngresoEntity> registrarIngreso(@RequestBody RegistroIngresoDTO registroIngresoDTO) {
        try {
            RegistroIngresoEntity ingresoRegistrado = registroIngresoService.registrarIngreso(registroIngresoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(ingresoRegistrado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
