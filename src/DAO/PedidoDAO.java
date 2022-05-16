/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.ConexaoBD;
import Interfaces.IDAO;
import Model.PedidoModel;
import java.sql.Statement;

/**
 *
 * @author forster
 */
public class PedidoDAO implements IDAO<PedidoModel>{

    @Override
    public boolean create(PedidoModel objeto) {
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql = "insert into prog_aplicacoes.pedido(data,endereco_entrega, observacao, cliente_id) values ("
                    + "'" + objeto.getData()+"',"
                    + "'" + objeto.getEndereco().getDescricao()+ " - " + objeto.getEndereco().getCep() + "'" +","
                    + "'" + objeto.getObservacao()+"',"
                    +"'"+objeto.getCliente().getId()+"');";
            
            System.out.println(sql);
            
            st.executeUpdate(sql);
            
            for(var produto : objeto.getProdutos()){
                sql = "insert into prog_aplicacoes.item_pedido(pedido_id, produto_id, qtde,valor_item) values ("+
                      "(select max(id) from prog_aplicacoes.pedido),"+
                      produto.getProduto().getId()+","+
                      produto.getQuantidade()+","+
                      produto.getValorTotal()
                      +");";
                
                System.out.println(sql);
                        
                st.executeUpdate(sql);
                
                sql = "update prog_aplicacoes.produto " +
                "set qtde_estoque = cast(produto.qtde_estoque as int) - " + produto.getQuantidade() +
                " where id = " + produto.getProduto().getId() + ";";
                
                System.out.println(sql);
                        
                st.executeUpdate(sql);
            }

            
            return true;
            
        }catch(Exception e){
            
            System.out.println("Erro ao inserir registro: " + e);
            return false;
        }
    }

    @Override
    public boolean update(PedidoModel objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[][] GetAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PedidoModel GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(PedidoModel objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
