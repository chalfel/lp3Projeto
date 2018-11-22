package model;


import dao.LogSistemaDao;
import view.Login;
import view.VendaVisual;
import model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cfelix
 */
public class Produto {
        LogSistemaDao lg = new LogSistemaDao();
        Login l = new Login();
        PreparedStatement stm = null;
        ResultSet rs = null;
    public void cadastrarProduto(String prodDesc, Double prodValor, int prodQtd, String prodUnid){
    
    Connection con = ConnectionFactory.getConnection();
        try {
            stm = con.prepareStatement("INSERT INTO produto (prod_desc,prod_valor,prod_qtd,prod_unid) values ('"+prodDesc+"',"+prodValor+","+prodQtd+",'"+prodUnid+"')");
            stm.executeUpdate();
            lg.registrarLog("Cadastrar Produto",l.getUsuarioLogado());
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
       ConnectionFactory.closeConnection(con, stm);
    }
    public void atualizarProduto(String prodDesc, Double prodValor, int prodQtd, String prodUnid, int id){
         Connection con = ConnectionFactory.getConnection();
        try {
            stm = con.prepareStatement("UPDATE produto SET prod_desc='"+prodDesc+"',prod_valor="+prodValor+",prod_qtd="+prodQtd+",prod_unid='"+prodUnid+"' WHERE prod_id="+id+"");
            stm.executeUpdate();
            lg.registrarLog("Atualizar Produto",l.getUsuarioLogado());
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.closeConnection(con, stm);
    }
    public void deletarProduto (int id){
         Connection con = ConnectionFactory.getConnection();
     try {
                stm = con.prepareStatement("DELETE FROM produto WHERE prod_id="+id);
                stm.executeUpdate();
                lg.registrarLog("Deletar Produto",l.getUsuarioLogado());
            } catch (SQLException ex) {
                Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
            }
            ConnectionFactory.closeConnection(con, stm);
    }
    public int consultarQuantidadeProduto(int id) {
        Connection con = ConnectionFactory.getConnection();
        int qtd=0;

        try {
            stm = con.prepareStatement("SELECT prod_qtd FROM produto where prod_id=" + id);
            rs = stm.executeQuery();
            while (rs.next()){
            qtd=rs.getInt("prod_qtd");
            return qtd;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qtd;
    }  
    public double valorProduto(int id){
    double valor=0;
    Connection con = ConnectionFactory.getConnection();
    try{
        stm = con.prepareStatement("SELECT prod_valor from produto where prod_id="+id);
        rs = stm.executeQuery();
        while (rs.next()){
        valor = rs.getDouble("prod_valor");
        return valor;
        }
    }
    catch(SQLException ex){
    Logger.getLogger(VendaVisual.class.getName()).log(Level.SEVERE, null, ex);
    }
       
        return valor;
    
    }   
}
