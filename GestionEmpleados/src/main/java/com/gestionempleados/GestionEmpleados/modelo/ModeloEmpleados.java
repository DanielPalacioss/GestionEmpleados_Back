package com.gestionempleados.GestionEmpleados.modelo;

import javax.persistence.*;

@Entity
@Table(name = "empleados")
public class ModeloEmpleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre", length = 60, nullable = false)
    private String nombre;

    @Column(name="apellido", length = 60, nullable = false)
    private String apellido;

    @Column(name="email", length = 60, nullable = false, unique = true)
    private String email;

    public ModeloEmpleados()
    {

    }

    public ModeloEmpleados(Long id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
