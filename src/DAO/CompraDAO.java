/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.ConexaoBD;
import Interfaces.IDAO;
import Model.CompraModel;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author forster
 */
public class CompraDAO implements IDAO<CompraModel>{

    @Override
    public boolean create(CompraModel objeto) {
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql = "insert into prog_aplicacoes.compra(data,fornecedor_id) values ("
                    + "'" + objeto.getData()+"',"
                    +"'"+objeto.getFornecedor().getId()+"');";
            
            System.out.println(sql);
            
            st.executeUpdate(sql);
            
            for(var produto : objeto.getProdutos()){
                sql = "insert into prog_aplicacoes.item_compra(compra_id, produto_id, qtde,valor) values ("+
                      "(select max(id) from prog_aplicacoes.compra),"+
                      produto.getProduto().getId()+","+
                      produto.getQuantidade()+","+
                      produto.getValorTotal()
                      +");";
                
                System.out.println(sql);
                        
                st.executeUpdate(sql);
                
                sql = "update prog_aplicacoes.produto " +
                "set qtde_estoque = cast(produto.qtde_estoque as int) + " + produto.getQuantidade() +
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
    public boolean update(CompraModel objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[][] GetAll() {
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sqlCount = "select count(id) as qtde from prog_aplicacoes.compra;";
            
            ResultSet rsCount = st.executeQuery(sqlCount);
            
            int quantidadeRegistros = 0;
            
            while(rsCount.next()){
                quantidadeRegistros = rsCount.getInt("qtde");
            }
            
            String sql = "select compra.id, TO_CHAR(cast(data as timestamp), 'DD-MM-YYYY HH24:MI') as dt, f.nome as fornecedor from prog_aplicacoes.compra " +
            "inner join prog_aplicacoes.fornecedor as f on f.id = compra.fornecedor_id " +
            "order by compra.id desc;";
            
            ResultSet rsSelect = st.executeQuery(sql);
            
            String[] colunas = new String[]{"Id","Data","Fornecedor"};
            
            String [][] data = new String[quantidadeRegistros][colunas.length];
            
            int i = 0;
            
            while(rsSelect.next()){
                int id = rsSelect.getInt("id");
                String dt = rsSelect.getString("dt");
                String fornecedor = rsSelect.getString("fornecedor");
     
                
                data[i][0] = id+"";
                data[i][1] = dt;
                data[i][2] = fornecedor;
                
                i++;
                
            }
            
            return data;
            
        }catch(Exception e){
            System.out.println("Erro ao buscar todos os registros: "+e);
            return new String[0][0];
        }
    }

    @Override
    public CompraModel GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(CompraModel objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String[][] GetItensPorCompra(){
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sqlCount = "select count(id) as qtde from prog_aplicacoes.item_compra;";
            
            ResultSet rsCount = st.executeQuery(sqlCount);
            
            int quantidadeRegistros = 0;
            
            while(rsCount.next()){
                quantidadeRegistros = rsCount.getInt("qtde");
            }
            
            String sql = "select compra.id, " +
            "TO_CHAR(cast(data as timestamp), 'DD-MM-YYYY HH24:MI') as dt," +
            "pr.descricao as produto," +
            "ic.qtde," +
            "ic.valor," +
            "f.nome as fornecedor " +
            "from prog_aplicacoes.compra " +
            "inner join prog_aplicacoes.fornecedor as f on f.id = compra.fornecedor_id " +
            "inner join prog_aplicacoes.item_compra as ic on ic.compra_id = compra.id " +
            "inner join prog_aplicacoes.produto as pr on pr.id = ic.produto_id " +
            "order by compra.id desc;";
            
            System.out.println(sql);
            
            ResultSet rsSelect = st.executeQuery(sql);
            
            String[] colunas = new String[]{"Id","Data","Produto","Quantidade", "Valor Total", "Fornecedor"};
            
            String [][] data = new String[quantidadeRegistros][colunas.length];
            
            int i = 0;
            
            while(rsSelect.next()){
                int id = rsSelect.getInt("id");
                String dt = rsSelect.getString("dt");
                String produto = rsSelect.getString("produto");
                String qtde = rsSelect.getString("qtde");
                String valor = rsSelect.getString("valor");
                String fornecedor = rsSelect.getString("fornecedor");
     
                
                data[i][0] = id+"";
                data[i][1] = dt;
                data[i][2] = produto;
                data[i][3] = qtde;
                data[i][4] = valor;
                data[i][5] = fornecedor;
                
                i++;
                
            }
            
            return data;
            
        }catch(Exception e){
            System.out.println("Erro ao buscar todos os registros: "+e);
            return new String[0][0];
        }
    }
    
}
