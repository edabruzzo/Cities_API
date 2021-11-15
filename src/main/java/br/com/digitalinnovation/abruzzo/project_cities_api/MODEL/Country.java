/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.digitalinnovation.abruzzo.project_cities_api.MODEL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author emmanuel
 */
@Entity
@Table(name = "pais", catalog = "cities", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT p FROM Country p"),
    @NamedQuery(name = "Country.findById", query = "SELECT p FROM Country p WHERE p.id = :id"),
    @NamedQuery(name = "Country.findByNome", query = "SELECT p FROM Country p WHERE p.nome = :nome"),
    @NamedQuery(name = "Country.findByNomePt", query = "SELECT p FROM Country p WHERE p.nomePt = :nomePt"),
    @NamedQuery(name = "Country.findBySigla", query = "SELECT p FROM Country p WHERE p.sigla = :sigla"),
    @NamedQuery(name = "Country.findByBacen", query = "SELECT p FROM Country p WHERE p.bacen = :bacen")})
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "nome_pt")
    private String nomePt;
    
    @Column(name = "sigla")
    private String sigla;
    
    @Column(name = "bacen")
    private Integer bacen;

    public Country(Long id, String nome, String nomePt, String sigla, Integer bacen) {
        this.id = id;
        this.nome = nome;
        this.nomePt = nomePt;
        this.sigla = sigla;
        this.bacen = bacen;
    }

    public Country() {
    }

    public Country(Long id) {
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

    public String getNomePt() {
        return nomePt;
    }

    public void setNomePt(String nomePt) {
        this.nomePt = nomePt;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getBacen() {
        return bacen;
    }

    public void setBacen(Integer bacen) {
        this.bacen = bacen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.digitalinnovation.abruzzo.project_cities_api.MODEL.Country[ id=" + id + " ]";
    }
    
}
