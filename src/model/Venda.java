package model;


import dao.LogSistemaDao;
import view.Login;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cfelix
 */
public class Venda {

    LogSistemaDao lg = new LogSistemaDao();
    Login l = new Login();
    PreparedStatement stm = null;
    ResultSet rs = null;

    public void cadastrarVenda(int idProd, int idCliente, int qtdProd, double vTotal,String data) {
        Connection con = ConnectionFactory.getConnection();
        try {
            if (consultarQuantidadeProd(idProd, qtdProd)==true){
            stm = con.prepareStatement("INSERT INTO venda (id_produto,id_cliente,qtd_prod_vend,vTotal_venda,data_venda) VALUES (" + idProd + "," + idCliente + "," + qtdProd + "," + vTotal + ",'"+data+"')");
            stm.executeUpdate();
            stm = con.prepareStatement("UPDATE produto SET prod_qtd=prod_qtd-" + qtdProd + " where prod_id=" + idProd);
            stm.executeUpdate();
            lg.registrarLog("Cadastrar Venda", l.getUsuarioLogado());}
            else {
                JOptionPane.showMessageDialog(null, "O item não possui esta quantidade em estoque");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.closeConnection(con, stm);
    }

    public boolean consultarQuantidadeProd(int idProd, int qtdProd) {
        Connection con = ConnectionFactory.getConnection();
        int qtdProdBanco = 0;
        try {
            stm = con.prepareStatement("SELECT prod_qtd from produto where prod_id=" + idProd);
            rs = stm.executeQuery();
            while (rs.next()) {
                qtdProdBanco = rs.getInt("prod_qtd");
                if (qtdProd <= qtdProdBanco) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.closeConnection(con, stm);
        return false;

    }
}
