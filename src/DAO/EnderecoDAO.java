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
            
            System.out.println("Erro ao criar um endereço: " + e);
            return false;
        }
        
        
        
        
        
        
    }

    @Override
    public boolean update(EnderecoModel objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[][] GetAll() {
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sqlCount = "select count(id) as qtde from prog_aplicacoes.endereco;";
            
            ResultSet rsCount = st.executeQuery(sqlCount);
            
            int quantidadeRegistros = 0;
            
            while(rsCount.next()){
                quantidadeRegistros = rsCount.getInt("qtde");
            }
                        
            String[] listaEndereco = new String[quantidadeRegistros];
            
            String sql = "select id, descricao, cep from prog_aplicacoes.endereco;";
            
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
    public boolean delete(EnderecoModel objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
