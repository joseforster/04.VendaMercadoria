/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.ConexaoBD;
import Interfaces.IDAO;
import Model.PedidoModel;
import java.sql.ResultSet;
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
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sqlCount = "select count(id) as qtde from prog_aplicacoes.pedido where ativo ='S';";
            
            ResultSet rsCount = st.executeQuery(sqlCount);
            
            int quantidadeRegistros = 0;
            
            while(rsCount.next()){
                quantidadeRegistros = rsCount.getInt("qtde");
            }
            
            String sql = "select ped.id, cast(ped.data as date) as dt, c.nome as cliente, ped.endereco_entrega as endereco, ped.observacao " +
            "from prog_aplicacoes.pedido as ped " +
            "inner join prog_aplicacoes.cliente as c on c.id = ped.cliente_id " +
            "where ped.ativo ='S' " +
            "order by ped.id desc;";
            
            ResultSet rsSelect = st.executeQuery(sql);
            
            String[] colunas = new String[]{"Id","Data","Cliente","Endereço","Observação"};
            
            String [][] data = new String[quantidadeRegistros][colunas.length];
            
            int i = 0;
            
            while(rsSelect.next()){
                int id = rsSelect.getInt("id");
                String dt = rsSelect.getString("dt");
                String cliente = rsSelect.getString("cliente");
                String endereco = rsSelect.getString("endereco");
                String observacao = rsSelect.getString("observacao");
                
                
     
                
                data[i][0] = id+"";
                data[i][1] = dt;
                data[i][2] = cliente;
                data[i][3] = endereco;
                data[i][4] = observacao;
                
                i++;
                
            }
            
            return data;
            
        }catch(Exception e){
            System.out.println("Erro ao buscar todos os registros: "+e);
            return new String[0][0];
        }
    }

    @Override
    public PedidoModel GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql = "update prog_aplicacoes.pedido "
                    + "set ativo = 'N' "
                    + "where id = " + id + ";";
            
            System.out.println(sql);
            
            st.executeUpdate(sql);
            
            return true;
            
        }catch(Exception e){
            
            System.out.println("Erro ao excluir registro: " + e);
            
            return false;
        }
    }
    
    public String[][] GetProdutosPorPedido(){
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sqlCount = "select count(id) as qtde from prog_aplicacoes.item_pedido;";
            
            ResultSet rsCount = st.executeQuery(sqlCount);
            
            int quantidadeRegistros = 0;
            
            while(rsCount.next()){
                quantidadeRegistros = rsCount.getInt("qtde");
            }
            
            String sql = "select ped.id, cast(ped.data as date) as dt, c.nome as cliente, prod.descricao as produto, ip.qtde, ip.valor_item as valor, ped.ativo " +
            "from prog_aplicacoes.pedido as ped " +
            "inner join prog_aplicacoes.item_pedido as ip ON ip.pedido_id = ped.id " +
            "inner join prog_aplicacoes.produto as prod on ip.produto_id = prod.id " +
            "inner join prog_aplicacoes.cliente as c on c.id = ped.cliente_id " +
            "order by ped.id desc;";
            
            ResultSet rsSelect = st.executeQuery(sql);
            
            String[] colunas = new String[]{"Id","Data","Cliente","Produto","Quantidade","Valor","Ativo"};
            
            String [][] data = new String[quantidadeRegistros][colunas.length];
            
            int i = 0;
            
            while(rsSelect.next()){
                int id = rsSelect.getInt("id");
                String dt = rsSelect.getString("dt");
                String cliente = rsSelect.getString("cliente");
                String produto = rsSelect.getString("produto");
                String quantidade = rsSelect.getString("qtde");
                String valor = rsSelect.getString("valor");
                String ativo = rsSelect.getString("ativo");
                
     
                
                data[i][0] = id+"";
                data[i][1] = dt;
                data[i][2] = cliente;
                data[i][3] = produto;
                data[i][4] = quantidade;
                data[i][5] = valor;
                data[i][6] = ativo;
                
                i++;
                
            }
            
            return data;
            
        }catch(Exception e){
            System.out.println("Erro ao buscar todos os registros: "+e);
            return new String[0][0];
        }
    }
    
}
