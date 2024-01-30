package com.maxi.ecommerce.models;

import com.maxi.ecommerce.enums.TipoUsuario;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

//@Entity
public class Usuario {

    private Integer id;
    private String nombre;
    private String username;
    private String email;
    private String telefono;
    private String direccion;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;
    private String password;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String username, String email, String telefono, String direccion,
            TipoUsuario tipo,
            String password) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipo = tipo;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", username=" + username + ", email=" + email
                + ", telefono=" + telefono + ", direccion=" + direccion + ", tipo=" + tipo + ", password=" + password
                + "]";
    }

}
