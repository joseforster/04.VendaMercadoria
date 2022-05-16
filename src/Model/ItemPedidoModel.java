/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author forster
 */
public class ItemPedidoModel {
    private ProdutoModel produto;
    private int quantidade;
    private double valorTotal;
    private PedidoModel pedido;

    public ItemPedidoModel(ProdutoModel produto, int quantidade, PedidoModel pedido) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.valorTotal = quantidade * produto.getValor_unitario();
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public PedidoModel getPedido() {
        return pedido;
    }

    public void setPedido(PedidoModel pedido) {
        this.pedido = this.pedido;
    }
    
    
    
    
    
    
}
