package model;


import dao.LogSistemaDao;
import view.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cfelix
 */
public class Usuario {

    Login l = new Login();
    LogSistemaDao lg = new LogSistemaDao();
    PreparedStatement stm = null;
    ResultSet rs = null;
   

    public void SelecionarUsuario(String usu) {
         Connection con = ConnectionFactory.getConnection();
        try {
            stm = con.prepareStatement("SELECT * FROM usuario where login = '" + usu + "'");

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.closeConnection(con, stm);
    }

    public void cadastrarUsuario(String usu, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        try {

            stm = con.prepareStatement("INSERT INTO usuario (login,senha) values (?,?)");
            stm.setString(1, usu);
            stm.setString(2, senha);
            stm.executeUpdate();
            lg.registrarLog("Cadastrar", l.getUsuarioLogado());

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.closeConnection(con, stm);

    }

    public boolean consultarUsuario(String usuario) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        Connection con = ConnectionFactory.getConnection();
        String usuBanco = null;
        try {
            stm = con.prepareStatement("SELECT * FROM usuario");
            rs = stm.executeQuery();
            while (rs.next()) {
                usuBanco = rs.getString("login");
                if (usuBanco.equals(usuario)) {
                    lg.registrarLog("Consulta Usuario", l.getUsuarioLogado());
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
        ConnectionFactory.closeConnection(con, stm);
        return false;
        
    }

    public void alterarSenha(int chaveMestra, String usu, String senha) {
         Connection con = ConnectionFactory.getConnection();
        int chavePrimaria=0;
        String usuBanco=null;
        if (chaveMestra == 123456) {
            if (consultarUsuario(usu) == true) {
                try {
                    stm = con.prepareStatement("SELECT * from usuario where login= '" + usu + "'");
                    rs = stm.executeQuery();
                    while (rs.next()){
                        chavePrimaria = rs.getInt("id");
                        usuBanco = rs.getString("login");}
                        if (usuBanco.equals(usu)) {
                            atualizarSenhaUsuario(senha, chavePrimaria);
                        }
                    

                } catch (SQLException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        ConnectionFactory.closeConnection(con, stm);
    }

    public void atualizarSenhaUsuario(String senha, int chavePrimaria) {
         Connection con = ConnectionFactory.getConnection();
        try {
            stm = con.prepareStatement("UPDATE usuario SET senha = '" + senha + "' WHERE id = " + chavePrimaria);
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Senha Atualizada");
            lg.registrarLog("Alteracao Senha", l.getUsuarioLogado());
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.closeConnection(con, stm);
    }

    public void deletarUsuario(String chavePrimaria) {
         Connection con = ConnectionFactory.getConnection();
        try {
            stm = con.prepareStatement("DELETE FROM USUARIO WHERE id =" + chavePrimaria);

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.closeConnection(con, stm);

    }
}
