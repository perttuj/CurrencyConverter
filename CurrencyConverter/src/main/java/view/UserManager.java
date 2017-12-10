/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import controller.CurrencyFacade;
import javax.enterprise.context.SessionScoped;
import model.ConversionDTO;

/**
 *  Class for handling commands received from the user
 * @author Perttu Jääskeläinen
 */
@Named("userManager")   // name used by the .xhtml files to refer to this object
@SessionScoped
public class UserManager implements Serializable {
    @EJB    // inserts a CurrencyFacade object into the EJB container
    private CurrencyFacade contr;
    private ConversionDTO conversion = null;
    private double amt;
    private String fromCurrency;
    private String toCurrency;
    
    public UserManager() {
    }
    
    /**
     * Gets the currency to convert from, chosen from the first drop-down menu
     * @param currency 
     */
    public void setFromCurrency(String currency) {
        this.fromCurrency = currency;
    }
    /**
     * Retreives the currency that is to be converted from
     * @return  the currency to convert from
     */
    public String getFromCurrency() {
        return this.fromCurrency;
    }
    /**
     * Sets the currency that is to be converted to
     * @param currency  the currency to be converted to
     */
    public void setToCurrency(String currency) {
        this.toCurrency = currency;
    }
    /**
     * Gets the currency that is to be converted to
     * @return  the currency to be converted to
     */
    public String getToCurrency() {
        return this.toCurrency;
    }
    /**
     * Gets a list of all currencies from the database
     * @return  a list of all available currencies
     */
    public List<String> getCurrencies() {
        return contr.getCurrencies();
    }
    /**
     * Performs a conversion, storing it in the user view
     */
    public void performConversion() {
        this.conversion = contr.convert(fromCurrency, toCurrency, amt);
    }
    /**
     * Called to check if a conversion has been made during this session
     * @return  true if a conversion has been made
     */
    public boolean getConverted() {
        return this.conversion != null;
    }
    /**
     * Gets the result of the latest conversion
     * @return  the amount converted in the latest conversion
     */
    public double getResult() {
        return this.conversion.getAfterAmount();
    }
    /**
     * Gets the amount of 'from' currency converted to the 'to' currency
     * @return 
     */
    public double getAmount() {
        return this.conversion.getBeforeAmont();
    }
    /**
     * Sets the amount to convert to the 'to' currency
     * @param amount 
     */
    public void setAmount(double amount) {
        this.amt = amount;
    }
}
