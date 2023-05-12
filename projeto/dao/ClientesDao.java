/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.WebServiceCep;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author USER
 */
public class ClientesDao {
    
    private Connection con;
    
    public ClientesDao(){
       this.con = new ConnectionFactory().getConnection();
        
    }
    // Método para cadastrar cliente
    public void cadastrarCliente(Clientes obj){
        
        try {
            // 1º passo, criando o comando sql
            String sql = "insert into tb_clientes (nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
 + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            //2º passo - conectar o banc de dads e organizar o comando sql
          PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getEmail());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());
            
            //3º passo - executar o comando sql
            stmt.execute();
            stmt.close();
           
            JOptionPane.showMessageDialog(null, "Cadastro com sucesso");
        
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
        
    }
        // metodo listar todos os clientes
        public List<Clientes> listarClientes(){
            try {
                //1º passo criar a lista
                List<Clientes> lista = new ArrayList<>();
                
                //2º criar comando sql
                
                String sql = "select * from tb_clientes";
                
                PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
                
                ResultSet rs = stmt.executeQuery();
                
                
                while(rs.next()){
                    Clientes obj = new Clientes();
                    
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setRg(rs.getString("rg"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));
                    obj.setTelefone(rs.getString("telefone"));
                    obj.setCelular(rs.getString("celular"));
                    obj.setCep(rs.getString("cep"));
                    obj.setEndereco(rs.getString("endereco"));
                    obj.setNumero(rs.getInt("numero")); 
                    obj.setComplemento(rs.getString("complemento"));
                    obj.setBairro(rs.getString("bairro"));
                    obj.setCidade(rs.getString("cidade"));
                    obj.setEstado(rs.getString("estado"));
                    
                    lista.add(obj);
                    
                }
                
                return lista;
                
            } catch (Exception erro) {
                
                JOptionPane.showMessageDialog(null, "Erro " + erro);
                return null;
            }
        }
        //Método Alterar Cliente
        public void alterarCliente(Clientes obj){
            
             try {
            // 1º passo, criando o comando sql
            String sql = "update tb_clientes set nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id";
 
            
            //2º passo - conectar o banc de dads e organizar o comando sql
          PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getEmail());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());
            
            stmt.setInt(14, obj.getId());
            
            //3º passo - executar o comando sql
            stmt.execute();
            stmt.close();
           
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
            
        }
        
        //Método Ecluir Cliente
        public void excluirCliente(Clientes obj){
            
             try {
            // 1º passo, criando o comando sql
            String sql = "delete from tb_clientes where id = ?";
            
            //2º passo - conectar o banc de dads e organizar o comando sql
          PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getId());
            
            
            //3º passo - executar o comando sql
            stmt.execute();
            stmt.close();
           
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
        
                          
        }
        //metodo procurar por nome
        public List<Clientes> buscaClientePorNome(String nome){
            try {
                //1º passo criar a lista
                List<Clientes> lista = new ArrayList<>();
                
                //2º criar comando sql
                
                String sql = "select * from tb_clientes where nome like ?";
                
                PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
                stmt.setString(1, nome);
                
                ResultSet rs = stmt.executeQuery();
                
                
                while(rs.next()){
                    Clientes obj = new Clientes();
                    
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setRg(rs.getString("rg"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));
                    obj.setTelefone(rs.getString("telefone"));
                    obj.setCelular(rs.getString("celular"));
                    obj.setCep(rs.getString("cep"));
                    obj.setEndereco(rs.getString("endereco"));
                    obj.setNumero(rs.getInt("numero")); 
                    obj.setComplemento(rs.getString("complemento"));
                    obj.setBairro(rs.getString("bairro"));
                    obj.setCidade(rs.getString("cidade"));
                    obj.setEstado(rs.getString("estado"));
                    
                    lista.add(obj);
                    
                }
                
                return lista;
                
            } catch (Exception erro) {
                
                JOptionPane.showMessageDialog(null, "Erro " + erro);
                return null;
            }
        }
        
        //metodo busca Cliente  por Cpf
    public Clientes buscaPorCpf(String cpf) {
        try {
            //1 passo - criar o sql , organizar e executar.
            String sql = "select * from tb_clientes where cpf = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }
    }
        //Busca Cep
                
	  public Clientes buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Clientes obj = new Clientes();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setBairro(webServiceCep.getBairro());
            obj.setCidade(webServiceCep.getCidade());
            obj.setEstado(WebServiceCep.getEstado());
            
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
	
	
         
     }

