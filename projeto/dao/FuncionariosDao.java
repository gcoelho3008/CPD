/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.Funcionarios;
import br.com.projeto.model.WebServiceCep;
import br.com.projeto.view.FrmLogin;
import br.com.projeto.view.FrmMenu;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;



/**
 *
 * @author USER
 */
public class FuncionariosDao {
    
    //Conexão
      private Connection con;
    
    public FuncionariosDao(){
       this.con = new ConnectionFactory().getConnection();
        
    
    }
    //Metodo Cdastrar
     public void cadastrarFuncionarios(Funcionarios obj){
        
        try {
            // 1º passo, criando o comando sql
            String sql = "insert into tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
 + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            //2º passo - conectar o banc de dads e organizar o comando sql
          PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivelAcesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getEstado());
            
            //3º passo - executar o comando sql
            stmt.execute();
            stmt.close();
           
            JOptionPane.showMessageDialog(null, "Cadastro com sucesso");
        
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
        
    }

   //metodo listar todos os clientes
        public List<Funcionarios> listarFuncionarios(){
            try {
                //1º passo criar a lista
                List<Funcionarios> lista = new ArrayList<>();
                
                //2º criar comando sql
                
                String sql = "select * from tb_funcionarios";
                
                PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
                
                ResultSet rs = stmt.executeQuery();
                
                
                while(rs.next()){
                    Funcionarios obj = new Funcionarios();
                    
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setRg(rs.getString("rg"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));
                    obj.setSenha(rs.getString("senha"));
                    obj.setCargo(rs.getString("cargo"));
                    obj.setNivelAcesso(rs.getString("nivel_acesso"));
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
        public void alterarFuncionarios(Funcionarios obj){
            
             try {
            // 1º passo, criando o comando sql
            String sql = "update tb_funcionarios set nome=?, rg=?, cpf=?, email=?, sennha=?, cargo=?, nivel_acesso? telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id";
 
            
            //2º passo - conectar o banc de dads e organizar o comando sql
          PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getEmail());
            stmt.setString(7, obj.getSenha());
            stmt.setString(8, obj.getCargo());
            stmt.setString(9, obj.getNivelAcesso());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getEstado());
            
            stmt.setInt(17, obj.getId());
            
            //3º passo - executar o comando sql
            stmt.execute();
            stmt.close();
           
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
            
        }
         //Método Excluir Funcionarios
        public void excluirFuncionarios(Funcionarios obj){
            
             try {
            // 1º passo, criando o comando sql
            String sql = "delete from tb_funcionarios where id = ?";
            
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
            public List<Funcionarios> buscaFuncionariosPorNome(String nome){
             try {
                //1º passo criar a lista
                List<Funcionarios> lista = new ArrayList<>();
                
                //2º criar comando sql
                
                String sql = "select * from tb_funcionarios where nome like ?";
                
                PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
                stmt.setString(1, nome);
                
                ResultSet rs = stmt.executeQuery();
                
                
                while(rs.next()){
                    Funcionarios obj = new Funcionarios();
                    
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setRg(rs.getString("rg"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));
                    obj.setSenha(rs.getString("senha"));
                    obj.setCargo(rs.getString("cargo"));
                    obj.setNivelAcesso(rs.getString("acesso"));
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
                    Funcionarios obj = new Funcionarios();
                    
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setRg(rs.getString("rg"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));
                    obj.setSenha(rs.getString("senha"));
                    obj.setCargo(rs.getString("cargo"));
                    obj.setNivelAcesso(rs.getString("acesso"));
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
            //Busca Cep
                
	  public Funcionarios buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Funcionarios obj = new Funcionarios();

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
          
          //Metodo de login
          
          public void efetuaLogin(String email, String senha){
              try {
                  
                  //1 passo- comando sql
                  
                  String sql = "select * from tb_funcionarios where email = ? and senha = ?";
                  PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
                  stmt.setString(1,email);
                  stmt.setString(2, senha);
                  
                  ResultSet rs = stmt.executeQuery();
                  
                  if(rs.next()){
                      //usuario logou
                 JOptionPane.showMessageDialog(null, "Bem vindo");
                 FrmMenu tela = new FrmMenu();
                 tela.usuarioLogado = rs.getString("nome");
                 tela.setVisible(true);
                  }else{
                      JOptionPane.showMessageDialog(null, "e-mail ou senha incorretos ");
                       new FrmLogin().setVisible(true);
                  }
              } catch (SQLException erro) {
                  JOptionPane.showMessageDialog(null, "Erro: " + erro);
                 
              }
          }
}

