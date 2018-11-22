package model;


import view.Login;
import view.ProdutoVisual;
import dao.LogSistemaDao;
import model.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class Fornecedor {
    LogSistemaDao lg = new LogSistemaDao();
    Login l = new Login();
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stm = null;
    
    public void deletarFornecedor(int cod){
        try {
                stm = con.prepareStatement("DELETE FROM fornecedor WHERE forn_cod="+cod);
                stm.executeUpdate();
                lg.registrarLog("Deletar Fornecedor",l.getUsuarioLogado());
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoVisual.class.getName()).log(Level.SEVERE, null, ex);
            }
            ConnectionFactory.closeConnection(con, stm);
    }
    public void atualizarFornecedor(String nome, int cnpj,  String end,String cont, String tel, String cid, int id){
        try {
            stm = con.prepareStatement("UPDATE fornecedor SET forn_nome='"+nome+"',forn_cnpj="+cnpj+",forn_telefone='"+tel+"',forn_endereco='"+end+"',forn_cidade='"+cid+"',forn_contato='"+cont+"' WHERE forn_cod= "+id);
            stm.executeUpdate();
            lg.registrarLog("Atualizar Fornecedor",l.getUsuarioLogado());
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.closeConnection(con, stm);
    }
    public void cadastrarFornecedor(String nome, int cnpj,  String end,String cont, String tel, String cid){
        try{   
        stm = con.prepareStatement("INSERT INTO fornecedor (forn_nome,forn_cnpj,forn_telefone, forn_endereco, forn_cidade, forn_contato) values ('"+nome+"',"+cnpj+",'"+tel+"','"+end+"','"+cid+"','"+cont+"')");
            stm.executeUpdate();
            lg.registrarLog("Cadastrar Fornecedor",l.getUsuarioLogado());

        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.closeConnection(con, stm);
    }
}
