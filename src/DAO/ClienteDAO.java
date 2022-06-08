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
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql = "update prog_aplicacoes.cliente "
                    + "set nome = "+"'"+objeto.getNome()+"',"
                    + " email = "+"'"+objeto.getEmail()+"',"
                    + " cpf = "+"'"+objeto.getCpf()+"',"
                    + " telefone = "+"'"+objeto.getTelefone()+"' "
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
            
            String sqlCount = "select count(id) as qtde FROM prog_aplicacoes.cliente where ativo = 'S';";
            
            ResultSet rsCount = st.executeQuery(sqlCount);
            
            int quantidadeRegistros = 0;
            
            while(rsCount.next()){
                quantidadeRegistros = rsCount.getInt("qtde");
            }
            
            String sql = "select * FROM prog_aplicacoes.cliente where ativo = 'S' order by id;";
            
            ResultSet rsSelect = st.executeQuery(sql);
            
            String[] colunas = new String[]{"Id","Nome","Email", "CPF", "Telefone"};
            
            String [][] data = new String[quantidadeRegistros][colunas.length];
            
            int i = 0;
            
            while(rsSelect.next()){
                int id = rsSelect.getInt("id");
                String nome = rsSelect.getString("nome");
                String email = rsSelect.getString("email");
                String cpf = rsSelect.getString("cpf");
                String telefone = rsSelect.getString("telefone");
          
                data[i][0] = id+"";
                data[i][1] = nome;
                data[i][2] = email;
                data[i][3] = cpf;
                data[i][4] = telefone;
        
                
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
    public boolean delete(int id) {
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql = "update prog_aplicacoes.cliente "
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
    
    public String[][] GetClientesPorEndereco() {
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
            
            String sql = "select c.id, c.nome, e.descricao as endereco, c.ativo FROM prog_aplicacoes.cliente as c " +
            "inner join prog_aplicacoes.cliente_endereco as ce on c.id = ce.cliente_id " +
            "inner join prog_aplicacoes.endereco as e on e.id = ce.endereco_id " +
            "order by c.id asc;";
            
            ResultSet rsSelect = st.executeQuery(sql);
            
            String[] colunas = new String[]{"Id","Nome","Endereço","Ativo"};
            
            String [][] data = new String[quantidadeRegistros][colunas.length];
            
            int i = 0;
            
            while(rsSelect.next()){
                int id = rsSelect.getInt("id");
                String nome = rsSelect.getString("nome");
                String endereco = rsSelect.getString("endereco");
                String ativo = rsSelect.getString("ativo");
          
                data[i][0] = id+"";
                data[i][1] = nome;
                data[i][2] = endereco;
                data[i][3] = ativo;
        
                
                i++;
                
            }
            
            return data;
            
        }catch(Exception e){
            System.out.println("Erro ao buscar todos os registros: "+e);
            return new String[0][0];
        }
    }
    
    public String [] GetAllComboBox(){
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sqlCount = "select count(id) as qtde from prog_aplicacoes.cliente where ativo = 'S';";

            ResultSet rsCount = st.executeQuery(sqlCount);

            int quantidadeRegistros = 0;

            while(rsCount.next()){
                quantidadeRegistros = rsCount.getInt("qtde");
            }

            String sql = "select id||' - '||nome||' - '||cpf as cliente  from prog_aplicacoes.cliente where ativo = 'S' order by cliente.id;";

            ResultSet rsSelect = st.executeQuery(sql);

            String [] data = new String[quantidadeRegistros];

            int i = 0;

            while(rsSelect.next()){

                String cliente = rsSelect.getString("cliente");

                data[i] = cliente;

                i++;

            }

            return data;

        }catch(Exception e){
            System.out.println("Erro ao buscar todos os registros para combo box: "+e);
            return new String[0];
        }
    }
    
}
