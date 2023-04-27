package com.pfcti.practicaSprint.dto;

import lombok.Data;



@Data
public class ClienteDto {
    private int id;

    private  String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String paisresidencia;
    private String paisnacimiento;
    private String direccion;
    private Boolean estado;


}
