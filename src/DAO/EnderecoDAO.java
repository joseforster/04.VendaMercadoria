/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.EnderecoModel;
import java.util.ArrayList;
import BD.*;
import java.sql.Statement;
import java.sql.ResultSet;
import Interfaces.IDAO;

/**
 *
 * @author forster
 */
public class EnderecoDAO implements IDAO<EnderecoModel> {

    public EnderecoDAO() {
        
    }

    @Override
    public boolean create(EnderecoModel objeto) {
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql = "insert into prog_aplicacoes.endereco(descricao, cep) values ("
                    + "'" + objeto.getDescricao() +"',"
                    +"'"+objeto.getCep()+"');";
            
            System.out.println(sql);
            
            st.executeUpdate(sql);
            
            return true;
            
        }catch(Exception e){
            
            System.out.println("Erro ao inserir registro: " + e);
            return false;
        }
        
    }

    @Override
    public boolean update(EnderecoModel objeto) {
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql = "update prog_aplicacoes.endereco "
                    + "set descricao = "+"'"+objeto.getDescricao()+"',"
                    + " cep = "+"'"+objeto.getCep()+"' "
                    + "where id = " + objeto.getId() + ";";
            
            System.out.println(sql);
            
            st.executeUpdate(sql);
            
            return true;
            
        }catch(Exception e){
            
            System.out.println("Erro ao editar registro: " + e);
            return false;
        }
    }

    @Override
    public String[][] GetAll() {
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sqlCount = "select count(id) as qtde from prog_aplicacoes.endereco where ativo = 'S';";
            
            ResultSet rsCount = st.executeQuery(sqlCount);
            
            int quantidadeRegistros = 0;
            
            while(rsCount.next()){
                quantidadeRegistros = rsCount.getInt("qtde");
            }
            
            String sql = "select id, descricao, cep from prog_aplicacoes.endereco where ativo = 'S';";
            
            ResultSet rsSelect = st.executeQuery(sql);
            
            String[] colunas = new String[]{"Id","Descrição","CEP"};
            
            String [][] data = new String[quantidadeRegistros][colunas.length];
            
            int i = 0;
            
            while(rsSelect.next()){
                int id = rsSelect.getInt("id");
                String descricao = rsSelect.getString("descricao");
                String cep = rsSelect.getString("cep");
                
                data[i][0] = id+"";
                data[i][1] = descricao;
                data[i][2] = cep;
                
                i++;
                
            }
            
            return data;
            
        }catch(Exception e){
            System.out.println("Erro ao buscar todos os registros: "+e);
            return new String[0][0];
        }
    }

    @Override
    public EnderecoModel GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql = "update prog_aplicacoes.endereco "
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
    
    public String[] GetAllComboBox(){
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sqlCount = "select count(id) as qtde from prog_aplicacoes.endereco where ativo = 'S';";
            
            ResultSet rsCount = st.executeQuery(sqlCount);
            
            int quantidadeRegistros = 0;
            
            while(rsCount.next()){
                quantidadeRegistros = rsCount.getInt("qtde");
            }
            
            String sql = "select id ||' - '||descricao||' - '||cep as endereco from prog_aplicacoes.endereco where ativo = 'S';";
            
            ResultSet rsSelect = st.executeQuery(sql);
            
            String [] data = new String[quantidadeRegistros];
            
            int i = 0;
            
            while(rsSelect.next()){

                String endereco = rsSelect.getString("endereco");
                
                data[i] = endereco;
                
                i++;
                
            }
            
            return data;
            
        }catch(Exception e){
            System.out.println("Erro ao buscar todos os registros para combo box: "+e);
            return new String[0];
        }
    }
    
    public String[] GetEnderecoByClienteComboBox(int cliente_id){
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sqlCount = "select count(id) as qtde from prog_aplicacoes.cliente_endereco where cliente_id = " + cliente_id + ";";
            
            ResultSet rsCount = st.executeQuery(sqlCount);
            
            int quantidadeRegistros = 0;
            
            while(rsCount.next()){
                quantidadeRegistros = rsCount.getInt("qtde");
            }
            
            String sql = "select descricao||' - '||cep as endereco from prog_aplicacoes.endereco " +
            "inner join prog_aplicacoes.cliente_endereco ON cliente_endereco.endereco_id = endereco.id " +
            "where cliente_endereco.cliente_id = " + cliente_id + ";";
            
            ResultSet rsSelect = st.executeQuery(sql);
            
            String [] data = new String[quantidadeRegistros];
            
            int i = 0;
            
            while(rsSelect.next()){

                String endereco = rsSelect.getString("endereco");
                
                data[i] = endereco;
                
                i++;
                
            }
            
            return data;
            
        }catch(Exception e){
            System.out.println("Erro ao buscar todos os registros para combo box: "+e);
            return new String[0];
        }
    }
    
}
