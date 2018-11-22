package dao;


import view.Login;
import model.ConnectionFactory;
import model.SistemaComuns;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ConnectionFactory;
import model.SistemaComuns;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cfelix
 */
public class LogSistemaDao extends Login {

    SistemaComuns sc = new SistemaComuns();
    Login l = new Login();
    PreparedStatement stm = null;
    ResultSet rs = null;
    

    public void registrarLog(String op, int usr) {
       Connection con = ConnectionFactory.getConnection();
        String dataSis = sc.coletarDataSistema();
        if (usr == 0) {
            usr = 999;
        }
        try {
            stm = con.prepareStatement("INSERT INTO log_sistema (operacao,data_op,id_usuario) VALUES ('" + op + "','" + dataSis + "'," + usr + ")");
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.closeConnection(con, stm);
    }
}
