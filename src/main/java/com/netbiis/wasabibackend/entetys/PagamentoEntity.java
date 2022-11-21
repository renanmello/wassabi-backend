package com.netbiis.wasabibackend.entetys;

import javax.persistence.*;

@Entity
@Table(name = "pagamento", schema = "wassabidb", catalog = "")
public class PagamentoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_pagamento")
    private int idPagamento;
    @Basic
    @Column(name = "id_cliente",insertable = false,updatable = false)
    private int idCliente;
    @Basic
    @Column(name = "id_produto")
    private int idProduto;
    @Basic
    @Column(name = "quantidade")
    private int quantidade;
    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", nullable = false)
    private ClienteEntity clienteByIdCliente;

    public PagamentoEntity(int idC, int idP, int quantidade, ClienteEntity cliente){
        idCliente = idC;
        idProduto = idP;
        this.quantidade = quantidade;
        clienteByIdCliente = cliente;
    }

    public PagamentoEntity() {

    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PagamentoEntity that = (PagamentoEntity) o;

        if (idPagamento != that.idPagamento) return false;
        if (idCliente != that.idCliente) return false;
        if (idProduto != that.idProduto) return false;
        if (quantidade != that.quantidade) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPagamento;
        result = 31 * result + idCliente;
        result = 31 * result + idProduto;
        result = 31 * result + quantidade;
        return result;
    }

    public ClienteEntity getClienteByIdCliente() {
        return clienteByIdCliente;
    }

    public void setClienteByIdCliente(ClienteEntity clienteByIdCliente) {
        this.clienteByIdCliente = clienteByIdCliente;
    }
}
