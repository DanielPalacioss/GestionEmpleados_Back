package com.gestionempleados.GestionEmpleados.controlador;

import com.gestionempleados.GestionEmpleados.excepciones.ResourceNotFoundException;
import com.gestionempleados.GestionEmpleados.modelo.ModeloEmpleados;
import com.gestionempleados.GestionEmpleados.modelo.repositorio.RepositorioEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")

public class ControladorEmpleado {

    @Autowired
    private RepositorioEmpleados repositorio;

    @GetMapping("/empleados")
    public List<ModeloEmpleados> listarTodosLosEmpleados()
    {
        return repositorio.findAll();
    }

    @PostMapping("/empleados")
    public ModeloEmpleados guardarEmpleado (@RequestBody ModeloEmpleados empleado)
    {
        return repositorio.save(empleado);
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<ModeloEmpleados> obtenerEmpleadoPorId(@PathVariable Long id)
    {
        ModeloEmpleados empleado = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el Id: "+ id));
        return ResponseEntity.ok(empleado);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<ModeloEmpleados> actualizarEmpleado(@PathVariable Long id, @RequestBody ModeloEmpleados detallesEmpleados)
    {
        ModeloEmpleados empleado = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el Id: "+ id));
        empleado.setNombre(detallesEmpleados.getNombre());
        empleado.setApellido(detallesEmpleados.getApellido());
        empleado.setEmail(detallesEmpleados.getEmail());
        ModeloEmpleados actualizarEmpleado =  repositorio.save(empleado);
        return ResponseEntity.ok(actualizarEmpleado);
    }


}
