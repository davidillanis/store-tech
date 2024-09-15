package com.example.demo.modelo.entidad;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "boleta")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Boleta {
    @Id
    @Column(nullable = false, length = 8)
    private String cod_bol;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fec_ven;

    @ManyToOne
    @JoinColumn(name = "cod_emp", nullable = false)
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "cod_cli", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "boleta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoletaInformacion> BoletaInformacions;
}
