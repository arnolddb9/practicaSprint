package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="TCLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private  String nombre;
    @Column
    private String apellido;
    @Column
    private String cedula;
    @Column
    private String telefono;
    @Column
    private String paisrecidencia;
    @Column
    private String paisnacimiento;
    @Column
    private String direccion;
    @Column
    private Boolean estado;

}
