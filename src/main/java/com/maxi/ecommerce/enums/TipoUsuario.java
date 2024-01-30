package com.maxi.ecommerce.enums;

public enum TipoUsuario {
    ADMIN("Admin"),
    USER("User");

    private String tipo;

    private TipoUsuario(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
