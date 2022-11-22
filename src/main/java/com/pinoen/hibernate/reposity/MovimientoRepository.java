package com.pinoen.hibernate.reposity;

import com.pinoen.hibernate.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
}
