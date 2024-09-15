package com.example.demo.modelo.entidad;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Cliente {
    @Id
    @Column(nullable = false, length=30)
    private String user_cli;

    @Column(nullable = false, length=30)
    private String pass_cli;

    @Column(nullable = true, length = 8)
    private String dni_cli;

    @Column(nullable = true, length = 35)
    private String nom_cli, ape_cli, correo_cli;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Boleta> boletas;
}