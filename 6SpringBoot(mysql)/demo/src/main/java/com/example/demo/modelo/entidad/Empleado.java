package com.example.demo.modelo.entidad;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "empleado")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Empleado {
    @Id
    @Column(nullable = false, length=30)
    private String user_emp;

    @Column(nullable = false, length=30)
    private String pass_emp;

    @Column(nullable = false, length = 8)
    private String dni_emp;

    @Column(nullable = false, length = 25)
    private String nom_emp, ape_emp, carg_emp;

    @Column(nullable = false)
    private Double sala_emp;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fe_naci_emp;

    @Column(nullable = false, length = 45)
    private String dir_emp;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Boleta> boletas;
}
