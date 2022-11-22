package com.pinoen.hibernate.service;

import com.pinoen.hibernate.entity.Movimiento;
import com.pinoen.hibernate.reposity.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {

    private MovimientoRepository movimientoRepository;

    @Autowired
    public MovimientoService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    public List<Movimiento> getMovimientos(){
        return movimientoRepository.findAll();
    }

    public Movimiento saveMovimiento(Movimiento movimiento){
        return movimientoRepository.save(movimiento);
    }

    public Optional<Movimiento> findMovimiento(Integer id){
        return movimientoRepository.findById(id);
    }

    public void updateMovimiento(Movimiento movimiento){
        movimientoRepository.save(movimiento);
    }

    public void deleteMovimiento(Integer id){
        movimientoRepository.deleteById(id);
    }
}
