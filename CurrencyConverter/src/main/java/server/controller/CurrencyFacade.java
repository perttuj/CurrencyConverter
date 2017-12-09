/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.controller;

import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import server.model.CurrencyConverter;

/**
 *
 * @author Perttu.Jaaskelainen
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class CurrencyFacade {
    @EJB
    CurrencyConverter con;
    
    public Map<String, Integer> getCurrencies() {
        return con.getCurrencies();
    }
    public double convert(String from, String to, Integer amount) {
        return con.convert(from, to, amount);
    }
}
