package model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cfelix
 */
public class SistemaComuns {
    public String coletarDataSistema(){
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
    Date date = new Date(); 
    return dateFormat.format(date);
    
    }
}
