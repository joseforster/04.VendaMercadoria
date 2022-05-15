/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author forster
 */
public class CompraModel {
    private int id;
    private FornecedorModel fornecedor;
    private ArrayList<ItemCompraModel> produtos;
    private Date data;

    public CompraModel() {
        this.produtos = new ArrayList<ItemCompraModel>();
        this.data = new Date();
    }
    
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FornecedorModel getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorModel fornecedor) {
        this.fornecedor = fornecedor;
    }

    public ArrayList<ItemCompraModel> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<ItemCompraModel> produtos) {
        this.produtos = produtos;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}
