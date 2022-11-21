package com.netbiis.wasabibackend.entetys;

import javax.persistence.*;

@Entity
@Table(name = "cliente", schema = "wassabidb", catalog = "")
public class ClienteEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_cliente")
    private int idCliente;
    @Basic
    @Column(name = "cliente_name")
    private String clienteName;
    @Basic
    @Column(name = "cliente_cpf")
    private String clienteCpf;
    @Basic
    @Column(name = "cliente_endereco")
    private String clienteEndereco;
    @Basic
    @Column(name = "cliente_numero")
    private String clienteNumero;
    @Basic
    @Column(name = "cliente_cartao")
    private String clienteCartao;
    @Basic
    @Column(name = "cliente_email")
    private String clienteEmail;
    @Basic
    @Column(name = "cliente_senha")
    private String clienteSenha;

    public ClienteEntity( String nome, String Cpf,String Endereco,String Numero, String Cartao, String Email, String Senha){
        clienteName = nome;
        clienteCpf = Cpf;
        clienteEndereco = Endereco;
        clienteNumero = Numero;
        clienteCartao = Cartao;
        clienteEmail = Email;
        clienteSenha = Senha;

    }

    public ClienteEntity() {

    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getClienteName() {
        return clienteName;
    }

    public void setClienteName(String clienteName) {
        this.clienteName = clienteName;
    }

    public String getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = clienteCpf;
    }

    public String getClienteEndereco() {
        return clienteEndereco;
    }

    public void setClienteEndereco(String clienteEndereco) {
        this.clienteEndereco = clienteEndereco;
    }

    public String getClienteNumero() {
        return clienteNumero;
    }

    public void setClienteNumero(String clienteNumero) {
        this.clienteNumero = clienteNumero;
    }

    public String getClienteCartao() {
        return clienteCartao;
    }

    public void setClienteCartao(String clienteCartao) {
        this.clienteCartao = clienteCartao;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public String getClienteSenha() {
        return clienteSenha;
    }

    public void setClienteSenha(String clienteSenha) {
        this.clienteSenha = clienteSenha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClienteEntity that = (ClienteEntity) o;

        if (idCliente != that.idCliente) return false;
        if (clienteName != null ? !clienteName.equals(that.clienteName) : that.clienteName != null) return false;
        if (clienteCpf != null ? !clienteCpf.equals(that.clienteCpf) : that.clienteCpf != null) return false;
        if (clienteEndereco != null ? !clienteEndereco.equals(that.clienteEndereco) : that.clienteEndereco != null)
            return false;
        if (clienteNumero != null ? !clienteNumero.equals(that.clienteNumero) : that.clienteNumero != null)
            return false;
        if (clienteCartao != null ? !clienteCartao.equals(that.clienteCartao) : that.clienteCartao != null)
            return false;
        if (clienteEmail != null ? !clienteEmail.equals(that.clienteEmail) : that.clienteEmail != null) return false;
        if (clienteSenha != null ? !clienteSenha.equals(that.clienteSenha) : that.clienteSenha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCliente;
        result = 31 * result + (clienteName != null ? clienteName.hashCode() : 0);
        result = 31 * result + (clienteCpf != null ? clienteCpf.hashCode() : 0);
        result = 31 * result + (clienteEndereco != null ? clienteEndereco.hashCode() : 0);
        result = 31 * result + (clienteNumero != null ? clienteNumero.hashCode() : 0);
        result = 31 * result + (clienteCartao != null ? clienteCartao.hashCode() : 0);
        result = 31 * result + (clienteEmail != null ? clienteEmail.hashCode() : 0);
        result = 31 * result + (clienteSenha != null ? clienteSenha.hashCode() : 0);
        return result;
    }
}
