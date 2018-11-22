/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Cliente;
import dao.ClienteDao;

/**
 *
 * @author ht3000877
 */
public class ClienteController {
    ClienteDao dao = new ClienteDao();
    public void cadastroCliente(Cliente cl){
        dao.cadastro(cl);
    
    }
    public void atualizarCliente (Cliente cl){
    dao.atualizar(cl);
    
    }
    public void excluirCliente(Cliente cl){
    dao.excluir(cl);
    
    }
}
