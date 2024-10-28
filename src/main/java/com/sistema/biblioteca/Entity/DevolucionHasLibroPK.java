package com.sistema.biblioteca.Entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class DevolucionHasLibroPK implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idPrestamo;
    private int idLibro;
}