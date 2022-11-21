package com.netbiis.wasabibackend.entetys;

import javax.persistence.*;

@Entity
@Table(name = "categoria", schema = "wassabidb", catalog = "")
public class CategoriaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_categoria")
    private int idCategoria;
    @Basic
    @Column(name = "nome_categoria")
    private String nomeCategoria;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoriaEntity that = (CategoriaEntity) o;

        if (idCategoria != that.idCategoria) return false;
        if (nomeCategoria != null ? !nomeCategoria.equals(that.nomeCategoria) : that.nomeCategoria != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCategoria;
        result = 31 * result + (nomeCategoria != null ? nomeCategoria.hashCode() : 0);
        return result;
    }

}
