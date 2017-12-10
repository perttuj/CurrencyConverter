package controller;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.ConversionDTO;
import model.CurrencyConverter;

/**
 *  Controller called by the UserManager to forward
 * requests to the model
 * @author Perttu.Jaaskelainen
 */
@Stateless
public class CurrencyFacade {
    @EJB    // inserts a CurrencyConverter into the EJB container
    CurrencyConverter con;
    
    /**
     * Gets a list of all available currencies in the database
     * @return  a list of all currencies available
     */
    public List<String> getCurrencies() {
        return con.getCurrencies();
    }
    /**
     * Performs a conversion between two currencies for a set amount
     * @param from  the currency to convert from
     * @param to    the currency to convert to
     * @param amount    amount of from currency to convert
     * @return  a ConversionDTO object containing the conversions details
     */
    public ConversionDTO convert(String from, String to, double amount) {
        return con.convert(from, to, amount);
    }
}
