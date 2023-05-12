/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.Fornecedores;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class FornecedoresDao {
     private Connection con;
    
   
     public FornecedoresDao(){
       this.con = new ConnectionFactory().getConnection();
        
    }
    
      // Método para cadastrar cliente
    public void cadastrarFornecedores(Fornecedores obj){
        
        try {
            // 1º passo, criando o comando sql
            String sql = "insert into tb_fornecedores (nome,cnpj,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
 + " values (?,?,?,?,?,?,?,?,?,?,?,?)";
            
            //2º passo - conectar o banc de dads e organizar o comando sql
          PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getTelefone());
            stmt.setString(4, obj.getCelular());
            stmt.setString(5, obj.getEmail());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());

            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getEstado());
            
            //3º passo - executar o comando sql
            stmt.execute();
            stmt.close();
           
            JOptionPane.showMessageDialog(null, "Cadastro com sucesso");
        
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
        
    }
    
    //metodo excluir
      public void excluirFornecedores(Fornecedores obj){
            
             try {
            // 1º passo, criando o comando sql
            String sql = "delete from tb_fornecedores where id = ?";
            
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
    
       //Método Alterar Fornecedores
        public void alterarFornecdores(Fornecedores obj){
            
             try {
            // 1º passo, criando o comando sql
            String sql = "update tb_fornecedores set nome=?, cnpj=?, email=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id";
 
            
            //2º passo - conectar o banc de dads e organizar o comando sql
          PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getTelefone());
            stmt.setString(4, obj.getCelular());
            stmt.setString(5, obj.getEmail());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
           
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getEstado());
            
            stmt.setInt(13, obj.getId());
            
            //3º passo - executar o comando sql
            stmt.execute();
            stmt.close();
           
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
            
        }
        
        //metodo listar fornecedores
        
        public List<Fornecedores> listarFornecedores(){
            try {
                //1º passo criar a lista
                List<Fornecedores> lista = new ArrayList<>();
                
                //2º criar comando sql
                
                String sql = "select * from tb_fornecedores";
                
                PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
                
                ResultSet rs = stmt.executeQuery();
                
                
                while(rs.next()){
                    Fornecedores obj = new Fornecedores();
                    
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setCnpj(rs.getString("cnpj"));
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
        // Listar Fornecedores por Nome
        
          public List<Fornecedores> buscarFornecedoresPorNome(String nome){
            try {
                //1º passo criar a lista
                List<Fornecedores> lista = new ArrayList<>();
                
                //2º criar comando sql
                
                String sql = "select * from tb_fornecedores where nome like ?";
                
                PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
                stmt.setString(1, nome);
                ResultSet rs = stmt.executeQuery();
                
                
                while(rs.next()){
                    Fornecedores obj = new Fornecedores();
                    
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setCnpj(rs.getString("cnpj"));
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

          
}
