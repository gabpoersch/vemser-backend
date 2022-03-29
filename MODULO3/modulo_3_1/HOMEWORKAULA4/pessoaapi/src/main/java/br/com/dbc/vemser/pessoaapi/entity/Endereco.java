package br.com.dbc.vemser.pessoaapi.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Endereco {
    private Integer idEndereco;
    private Integer idPessoa;

    @NotNull
    @Size(max = 8)
    private String cep;

    @NotNull
    @NotEmpty
    private Integer numero;

    public Endereco() {
    }

    public Endereco(Integer idEndereco, Integer idPessoa, String cep, Integer numero) {
        this.idEndereco = idEndereco;
        this.idPessoa = idPessoa;
        this.cep = cep;
        this.numero = numero;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }
    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }
    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "idEndereco=" + idEndereco +
                ", idPessoa=" + idPessoa +
                ", cep=" + cep +
                ", numero=" + numero +
                '}';
    }
}