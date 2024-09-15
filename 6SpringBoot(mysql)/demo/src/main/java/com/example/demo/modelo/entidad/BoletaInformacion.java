package com.example.demo.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "boleta_informacion")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BoletaInformacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_b_i;

    private Integer cant;

    @ManyToOne
    @JoinColumn(name = "cod_bol", nullable = false)
    private Boleta boleta;

    @ManyToOne
    @JoinColumn(name = "cod_pro", nullable = false)
    private Producto producto;
}