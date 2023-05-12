/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class TestaConexao {
    
    public static void main(String[] args) {
        
        try {
            new ConnectionFactory().getConnection();
            
            JOptionPane.showMessageDialog(null, "conectado");
        
        
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ops acoteceu erro:" + erro);
        }
        
    }
    
}
