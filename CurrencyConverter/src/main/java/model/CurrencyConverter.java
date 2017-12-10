package model;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import integration.CurrencyDAO;

/**
 *  Class that fetches and converts values received from the database
 * using EJB transaction handling
 * @author Perttu.Jaaskelainen
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class CurrencyConverter implements Serializable {
    @EJB
    CurrencyDAO dao;
    /**
     * Add a currency to the database
     * @param currency  currency name to add
     * @param rate      the currencys rate to dollars
     */
    public void addCurrency(String currency, double rate) {
        dao.addCurrency(new Currency(currency, rate));
    }
    /**
     * Gets all the currencies from the database
     * @return  a list of all the currencies
     */
    public List<String> getCurrencies() {
        return dao.getCurrencies();
    }
    /**
    /**
     * Perform a conversion between two currencies
     * @param from  the currency to convert from
     * @param to    the currency to convert to
     * @param amount    the amount to convert
     * @return  a object implementing the ConversionDTO interface
     */
    public ConversionDTO convert(String from, String to, double amount) {
        double fromRate = dao.getConversionRate(from);
        double toRate   = dao.getConversionRate(to);
        double base = amount / fromRate;
        double nextAmount = (double) Math.round(base * toRate * 100) / 100;
        Conversion c = new Conversion(from, to, amount, nextAmount);
        return c;
    }
}
