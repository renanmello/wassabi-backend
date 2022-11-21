package com.netbiis.wasabibackend.entetys;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "produtos", schema = "wassabidb", catalog = "")
public class ProdutosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_produto")
    private int idProduto;
    @Basic
    @Column(name = "name_produdo")
    private String nameProdudo;
    @Basic
    @Column(name = "preco_produto")
    private double precoProduto;
    @Basic
    @Column(name = "disc_produto")
    private String discProduto;

    @Basic
    @Column(name = "url_produto")
    private String urlProduto;
    @Basic
    @Column(name = "id_categoria",insertable = false,updatable = false)
    private int idCategoria;
    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
    private CategoriaEntity categoriaByIdCategoria;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNameProdudo() {
        return nameProdudo;
    }

    public void setNameProdudo(String nameProdudo) {
        this.nameProdudo = nameProdudo;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getDiscProduto() {
        return discProduto;
    }

    public void setDiscProduto(String discProduto) {
        this.discProduto = discProduto;
    }

    public void setUrlProduto(String urlProduto) {this.urlProduto = urlProduto;}

    public String getUrlProduto() {return urlProduto;}

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProdutosEntity that = (ProdutosEntity) o;

        if (idProduto != that.idProduto) return false;
        if (Double.compare(that.precoProduto, precoProduto) != 0) return false;
        if (idCategoria != that.idCategoria) return false;
        if (nameProdudo != null ? !nameProdudo.equals(that.nameProdudo) : that.nameProdudo != null) return false;
        if (discProduto != null ? !discProduto.equals(that.discProduto) : that.discProduto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idProduto;
        result = 31 * result + (nameProdudo != null ? nameProdudo.hashCode() : 0);
        temp = Double.doubleToLongBits(precoProduto);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (discProduto != null ? discProduto.hashCode() : 0);
        result = 31 * result + idCategoria;
        return result;
    }

    /*
    public Collection<PagamentoEntity> getPagamentosByIdProduto() {
        return pagamentosByIdProduto;
    }

    public void setPagamentosByIdProduto(Collection<PagamentoEntity> pagamentosByIdProduto) {
        this.pagamentosByIdProduto = pagamentosByIdProduto;
    } */

    public CategoriaEntity getCategoriaByIdCategoria() {
        return categoriaByIdCategoria;
    }

    public void setCategoriaByIdCategoria(CategoriaEntity categoriaByIdCategoria) {
        this.categoriaByIdCategoria = categoriaByIdCategoria;
    }
}
