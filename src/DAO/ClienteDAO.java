/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.ConexaoBD;
import Interfaces.IDAO;
import Model.ClienteModel;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author forster
 */
public class ClienteDAO implements IDAO<ClienteModel> {

    @Override
    public boolean create(ClienteModel objeto) {
                try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql = "insert into prog_aplicacoes.cliente(nome, email, cpf, telefone) values ("
                    + "'" + objeto.getNome()+"',"
                    + "'" + objeto.getEmail()+"',"
                    + "'" + objeto.getCpf()+"',"
                    +"'"+objeto.getTelefone()+"');";
            
            System.out.println(sql);
            
            st.executeUpdate(sql);
            
            sql = "insert into prog_aplicacoes.cliente_endereco(cliente_id, endereco_id) values "
                    + "((select max(id) from prog_aplicacoes.cliente), "
                    +objeto.getEndereco().getId()+");";
                    
            st.executeUpdate(sql);
            
            return true;
            
        }catch(Exception e){
            
            System.out.println("Erro ao inserir registro: " + e);
            return false;
        }
    }

    @Override
    public boolean update(ClienteModel objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[][] GetAll() {
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sqlCount = "select count(c.id) as qtde FROM prog_aplicacoes.cliente as c " +
            "inner join prog_aplicacoes.cliente_endereco as ce on c.id = ce.cliente_id " +
            "inner join prog_aplicacoes.endereco as e on e.id = ce.endereco_id;";
            
            ResultSet rsCount = st.executeQuery(sqlCount);
            
            int quantidadeRegistros = 0;
            
            while(rsCount.next()){
                quantidadeRegistros = rsCount.getInt("qtde");
            }
            
            String sql = "select c.id, c.nome, c.email, c.cpf, c.telefone, e.descricao as endereco FROM prog_aplicacoes.cliente as c " +
            "inner join prog_aplicacoes.cliente_endereco as ce on c.id = ce.cliente_id " +
            "inner join prog_aplicacoes.endereco as e on e.id = ce.endereco_id;";
            
            ResultSet rsSelect = st.executeQuery(sql);
            
            String[] colunas = new String[]{"Id","Nome","Email", "CPF", "Telefone", "Endereço"};
            
            String [][] data = new String[quantidadeRegistros][colunas.length];
            
            int i = 0;
            
            while(rsSelect.next()){
                int id = rsSelect.getInt("id");
                String nome = rsSelect.getString("nome");
                String email = rsSelect.getString("email");
                String cpf = rsSelect.getString("cpf");
                String telefone = rsSelect.getString("telefone");
                String endereco = rsSelect.getString("endereco");
                
                data[i][0] = id+"";
                data[i][1] = nome;
                data[i][2] = email;
                data[i][3] = cpf;
                data[i][4] = telefone;
                data[i][5] = endereco;
                
                i++;
                
            }
            
            return data;
            
        }catch(Exception e){
            System.out.println("Erro ao buscar todos os registros: "+e);
            return new String[0][0];
        }
    }

    @Override
    public ClienteModel GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(ClienteModel objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
