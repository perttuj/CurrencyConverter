/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import server.integration.CurrencyDAO;

/**
 *  Class that fetches and converts values received from the database
 * @author Perttu.Jaaskelainen
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class CurrencyConverter implements Serializable {
    @EJB
    CurrencyDAO dao;
    public void addCurrency(String currency, double amount) {
        dao.addCurrency(new Currency(currency, amount));
    }
    /**
     * Gets all the currencies from the database
     * @return  a list of all the currencies
     */
    public List<String> getCurrencies() {
        return dao.getCurrencies();
    }
    /**
     * Converts an amount from a currency 'from' to
     * a currency 'to' using conversion values from the database
     * @param from  the currency to convert from
     * @param to    the currency to convert to
     * @param amount    the amount to convert
     * @return      the converted amount
     */
    public double convert(String from, String to, double amount) {
        double fromRate = dao.getConversionRate(from);
        double toRate   = dao.getConversionRate(to);
        double base = amount / fromRate;
        return base * toRate;
    }
}
