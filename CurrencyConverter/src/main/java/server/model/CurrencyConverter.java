/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

import java.io.Serializable;
import java.util.Map;
import javax.ejb.EJB;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import server.integration.CurrencyDAO;

/**
 *
 * @author Perttu.Jaaskelainen
 */
@Entity
public class CurrencyConverter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    /**
     * called to get the list of all available currencies
     * @return 
     */
    public Map<String, Integer> getCurrencies() {
        return CurrencyDAO.getCurrencies();
    }
    
    /**
     * perform a conversion between two currencies
     * @param from  the currency to convert from
     * @param to    the currency to convert to
     * @param amount    the amount to convert
     * @return  the converted amount
     */
    public Integer convert(String from, String to, Integer amount) {
        double fromVal = CurrencyDAO.getConversionValue(from);
        double toVal   = CurrencyDAO.getConversionValue(to);
        double diff = toVal / fromVal;
        return (int) diff * amount;
    }
}
