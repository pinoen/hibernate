package com.pinoen.hibernate.controller;

import com.pinoen.hibernate.entity.Movimiento;
import com.pinoen.hibernate.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    private MovimientoService movimientoService;

    @Autowired
    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @GetMapping
    public List<Movimiento> getAllMovimientos(){
        return movimientoService.getMovimientos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movimiento>> findMovimientoById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(movimientoService.findMovimiento(id));
    }

    @PostMapping
    public ResponseEntity<Movimiento> saveMovimiento(@RequestBody Movimiento movimiento){
        return ResponseEntity.ok(movimientoService.saveMovimiento(movimiento));
    }

    @PutMapping
    public ResponseEntity<String> updateMovimiento(@RequestBody Movimiento movimiento){
        movimientoService.updateMovimiento(movimiento);
        return ResponseEntity.ok("Se actualizo movimiento id = " + movimiento.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovimiento(@PathVariable("id") Integer id){
        movimientoService.deleteMovimiento(id);
        return ResponseEntity.ok("Se elimino movimiento con id = " + id);
    }
}
