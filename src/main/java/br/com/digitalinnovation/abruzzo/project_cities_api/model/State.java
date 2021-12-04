/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.digitalinnovation.abruzzo.project_cities_api.model;

import org.hibernate.annotations.Type;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author emmanuel
 */

@NamedQuery(name = "State.findAll", query = "SELECT e FROM State e")
@NamedQuery(name = "State.findById", query = "SELECT e FROM State e WHERE e.id = :id")
@NamedQuery(name = "State.findByNome", query = "SELECT e FROM State e WHERE e.nome = :nome")
@NamedQuery(name = "State.findByUf", query = "SELECT e FROM State e WHERE e.uf = :uf")
@NamedQuery(name = "State.findByIbge", query = "SELECT e FROM State e WHERE e.ibge = :ibge")
@NamedQuery(name = "State.findByPais", query = "SELECT e FROM State e WHERE e.pais = :pais")
@Entity
@Table(name = "estado", catalog = "cities", schema = "public")
public class State implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "uf")
    private String uf;

    @Column(name = "ibge")
    private Integer ibge;

    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Country pais;

    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "ddd")
    @Basic(fetch = FetchType.LAZY)
    @Transient
    private String ddd;


    public State() {
    }

    public State(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }


    public Country getPais() {
        return pais;
    }

    public void setPais(Country pais) {
        this.pais = pais;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

}
