package dao;


import view.Login;
import model.ConnectionFactory; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.ConnectionFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cfelix
 */
public class ClienteDao {
    LogSistemaDao lg = new LogSistemaDao();
    Login l = new Login();
    PreparedStatement stm = null;

    public void cadastro(Cliente cl) {
        Connection con = ConnectionFactory.getConnection();
        try {
            stm = con.prepareStatement("INSERT INTO cliente (nome_cli, end_cli, cid_cli, est_cli, tel_cli) VALUES ('" +cl.getNomeCliente() + "','" + cl.getEndCliente() + "','" + cl.getCidCliente() + "','" + cl.getEstCliente() + "','" + cl.getTelCliente()+ "')");
            
            stm.executeUpdate();
            
            lg.registrarLog("Cadastrar Cliente",l.getUsuarioLogado());
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.closeConnection(con, stm);
    }
    public void atualizar(Cliente cl){
    Connection con = ConnectionFactory.getConnection();
        try {
            stm = con.prepareStatement("UPDATE cliente SET nome_cli='"+cl.getNomeCliente()+"',end_cli='"+cl.getEndCliente()+"',cid_cli='"+cl.getCidCliente()+"',est_cli='"+cl.getEstCliente()+"',tel_cli='"+cl.getTelCliente()+"' WHERE id_cli="+cl.getIdClient());
                    stm.executeUpdate();
                    lg.registrarLog("Atualizar Cliente",l.getUsuarioLogado());
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.closeConnection(con, stm);
    }
    public void excluir(Cliente cl){
    Connection con = ConnectionFactory.getConnection();
        try {
            stm = con.prepareStatement("DELETE FROM cliente where id_cli="+cl.getIdClient());
            stm.executeUpdate();
            lg.registrarLog("Deletar Cliente",l.getUsuarioLogado());
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.closeConnection(con, stm);
    
    }
}
