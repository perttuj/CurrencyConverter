/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.view;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import server.controller.CurrencyFacade;

/**
 *
 * @author Perttu Jääskeläinen
 */
@Named("userManager")
@ConversationScoped
public class UserManager implements Serializable {
    @EJB
    private CurrencyFacade contr;
    @Inject
    private Conversation conversation;
    private double amt;
    private double result;
    private String fromCurrency;
    private String toCurrency;
    
    public UserManager() {
    }
    public void setFromCurrency(String currency) {
        this.fromCurrency = currency;
    }
    public String getFromCurrency() {
        return this.fromCurrency;
    }
    
    public void setToCurrency(String currency) {
        this.toCurrency = currency;
    }
    public String getToCurrency() {
        return this.toCurrency;
    }
    
    public List<String> getCurrencies() {
        return contr.getCurrencies();
    }
    public void performConversion() {
        this.result = contr.convert(fromCurrency, toCurrency, amt);
    }
    /**
     * Start a EJB session bean 
     */
    public void startConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }
    /**
     * End the EJB session bean
     */
    public void endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }
    public boolean getConverted() {
        return true;
    }
    public double getResult() {
        return this.result;
    }
    public double getAmount() {
        return this.amt;
    }
    public void setAmount(double amount) {
        this.amt = amount;
    }
}
