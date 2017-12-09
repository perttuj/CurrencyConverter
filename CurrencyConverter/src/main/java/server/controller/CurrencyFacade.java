/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import server.model.Currency;
import server.model.CurrencyConverter;

/**
 *
 * @author Perttu.Jaaskelainen
 */
@Singleton
@Startup
@Stateless
public class CurrencyFacade {
    @EJB
    CurrencyConverter con;
    /**
     * Class for filling the database with currencies,
     * in this program, they are hardcoded
     * All currencies are following the exhange rate 1 USD = X Currency
     */
    @PostConstruct
    void init() {
        con.addCurrency("USD", 1.0);
        con.addCurrency("Euro", 0.85);
        con.addCurrency("SEK", 8.5);
        con.addCurrency("GDP", 0.74);
    }
    
    public List<String> getCurrencies() {
        return con.getCurrencies();
    }
    public double convert(String from, String to, double amount) {
        return con.convert(from, to, amount);
    }
}
