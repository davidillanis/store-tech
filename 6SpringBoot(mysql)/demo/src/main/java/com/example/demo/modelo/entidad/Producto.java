package com.example.demo.modelo.entidad;

import java.util.List;
import java.util.Objects;

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
@Table(name = "producto")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Producto {
    @Id
    @Column(nullable = false, length = 10)
    private String cod_pro;

    @Column(nullable = false, length = 30)
    private String cat_pro, nom_pro;

    @Column(nullable = false)
    private Double pre_pro;

    private Integer stock;

    @Column(nullable = true, length = 255)
    private String url_pro;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoletaInformacion> BoletaInformacions;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Producto producto = (Producto) o;
        return Objects.equals(cod_pro, producto.cod_pro) &&
                Objects.equals(cat_pro, producto.cat_pro)&&
                Objects.equals(nom_pro, producto.nom_pro); // Ajusta según tus atributos
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_pro, cat_pro ,nom_pro); // Ajusta según tus atributos
    }
    public String toString2() {
        return "Producto{" +
                "cod_pro='" + cod_pro + '\'' +
                ", cat_pro='" + cat_pro + '\'' +
                ", nom_pro='" + nom_pro + '\'' +
                ", pre_pro=" + pre_pro +
                ", stock=" + stock +
                ", url_pro='" + url_pro + '\'' +
                '}';
    }
}
