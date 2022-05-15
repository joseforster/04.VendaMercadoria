/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.ConexaoBD;
import Interfaces.IDAO;
import Model.FornecedorModel;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author forster
 */
public class FornecedorDAO implements IDAO<FornecedorModel>{

    @Override
    public boolean create(FornecedorModel objeto) {
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql = "insert into prog_aplicacoes.fornecedor(nome, email, telefone, cnpj) values ("
                    + "'" + objeto.getNome() +"',"
                    + "'" + objeto.getEmail() +"',"
                    + "'" + objeto.getTelefone() +"',"
                    +"'"+objeto.getCnpj()+"');";
            
            System.out.println(sql);
            
            st.executeUpdate(sql);
            
            return true;
            
        }catch(Exception e){
            
            System.out.println("Erro ao inserir registro: " + e);
            return false;
        }
    }

    @Override
    public boolean update(FornecedorModel objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[][] GetAll() {
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sqlCount = "select count(id) as qtde from prog_aplicacoes.fornecedor;";
            
            ResultSet rsCount = st.executeQuery(sqlCount);
            
            int quantidadeRegistros = 0;
            
            while(rsCount.next()){
                quantidadeRegistros = rsCount.getInt("qtde");
            }
            
            String sql = "select *  from prog_aplicacoes.fornecedor;";
            
            ResultSet rsSelect = st.executeQuery(sql);
            
            String[] colunas = new String[]{"Id","Nome","Email", "Telefone", "CNPJ"};
            
            String [][] data = new String[quantidadeRegistros][colunas.length];
            
            int i = 0;
            
            while(rsSelect.next()){
                int id = rsSelect.getInt("id");
                String nome = rsSelect.getString("nome");
                String email = rsSelect.getString("email");
                String telefone = rsSelect.getString("telefone");
                String cnpj = rsSelect.getString("cnpj");
                
                
                data[i][0] = id+"";
                data[i][1] = nome;
                data[i][2] = email;
                data[i][3] = telefone;
                data[i][4] = cnpj;
                
                i++;
                
            }
            
            return data;
            
        }catch(Exception e){
            System.out.println("Erro ao buscar todos os registros: "+e);
            return new String[0][0];
        }
    }

    @Override
    public FornecedorModel GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(FornecedorModel objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
    public String[] GetAllComboBox(){
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sqlCount = "select count(id) as qtde from prog_aplicacoes.fornecedor;";

            ResultSet rsCount = st.executeQuery(sqlCount);

            int quantidadeRegistros = 0;

            while(rsCount.next()){
                quantidadeRegistros = rsCount.getInt("qtde");
            }

            String sql = "select id ||' - '||nome||' - '||cnpj as fornecedor from prog_aplicacoes.fornecedor;";

            ResultSet rsSelect = st.executeQuery(sql);

            String [] data = new String[quantidadeRegistros];

            int i = 0;

            while(rsSelect.next()){

                String endereco = rsSelect.getString("fornecedor");

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
