/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.EnderecoModel;
import Interfaces.Idao;
import java.util.ArrayList;
import BD.*;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author forster
 */
public class EnderecoDAO implements Idao<EnderecoModel> {

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
    public ArrayList<EnderecoModel> GetAll() {
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql = "select id, descricao, cep from prog_aplicacoes.endereco;";
            
            ResultSet resultado = st.executeQuery(sql);
            
            ArrayList<EnderecoModel> listaEndereco = new ArrayList<EnderecoModel>();
            
            while(resultado.next()){
                EnderecoModel model = new EnderecoModel();
                
                model.setId(resultado.getInt("id"));
                model.setDescricao(resultado.getString("descricao"));
                model.setCep(resultado.getString("cep"));
                
                listaEndereco.add(model); 
            }
            
            return listaEndereco;
            
        }catch(Exception e){
            System.out.println("Erro ao buscar todos os registros: "+e);
            return new ArrayList<EnderecoModel>();
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
