/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author forster
 */
public class PedidoModel {
    private int id;
    private Date data;
    private ClienteModel cliente;
    private EnderecoModel endereco;
    private String observacao;
    private ArrayList<ItemPedidoModel> produtos;

    public PedidoModel() {
        this.data = new Date();
        this.produtos = new ArrayList<ItemPedidoModel>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public ArrayList<ItemPedidoModel> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<ItemPedidoModel> produtos) {
        this.produtos = produtos;
    }
    
    
    
    
}
