/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.ConexaoBD;
import Interfaces.IDAO;
import Model.UsuarioModel;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author forster
 */
public class UsuarioDAO implements IDAO<UsuarioModel>{

    @Override
    public boolean create(UsuarioModel objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(UsuarioModel objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[][] GetAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UsuarioModel GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean autenticar(UsuarioModel model){
        try{
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql = "select * from prog_aplicacoes.usuario where ativo = 'S' and "
                    + "username like '"+model.getUsername()+"' and "
                    + "senha like md5('"+model.getSenha()+"');";
            
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                return true;
            }
            
            return false;
                
        }catch(Exception e){
            
            System.out.println("Erro ao autenticar usuário"+e);
            return false;
        }
    }
    
}
