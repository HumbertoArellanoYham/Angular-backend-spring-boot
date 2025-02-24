package com.arellano.application.rest.springboot.springbootrest.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
// @RedisHash(value = "Product")
@Table(name = "producto")
public class Product implements Serializable {

    // @Indexed // For faster retrieve
    @Id // Represent a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproducto;
    
    private String nombre;
    private String marca;
    private float volumen; 
    private int precio;
    private int existencia;
    private int stock_max;
    private int stock_min;
    
    @Column(name = "familia_olfativa")
    private String familiaOlfativa;

    private String imagen;

    public Product() {
    }

    public Long getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Long idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getVolumen() {
        return volumen;
    }

    public void setVolumen(float volumen) {
        this.volumen = volumen;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getStock_max() {
        return stock_max;
    }

    public void setStock_max(int stock_max) {
        this.stock_max = stock_max;
    }

    public int getStock_min() {
        return stock_min;
    }

    public void setStock_min(int stock_min) {
        this.stock_min = stock_min;
    }

    public String getFamiliaOlfativa() {
        return familiaOlfativa;
    }

    public void setFamiliaOlfativa(String familiaOlfativa) {
        this.familiaOlfativa = familiaOlfativa;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Product [idproducto=" + idproducto + ", nombre=" + nombre + ", marca=" + marca + ", volumen=" + volumen
                + ", precio=" + precio + ", existencia=" + existencia + ", stock_max=" + stock_max + ", stock_min="
                + stock_min + ", familiaOlfativa=" + familiaOlfativa + ", imagen=" + imagen + "]";
    }

}
