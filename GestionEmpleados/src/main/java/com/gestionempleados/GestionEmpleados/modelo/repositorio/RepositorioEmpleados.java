package com.gestionempleados.GestionEmpleados.modelo.repositorio;

import com.gestionempleados.GestionEmpleados.modelo.ModeloEmpleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpleados extends JpaRepository <ModeloEmpleados, Long> {

}
