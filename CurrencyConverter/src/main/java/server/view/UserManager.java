/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.view;

import java.io.Serializable;
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
    private Integer amt;
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
    
    public Map<String, Integer> getCurrencies() {
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
        return this.result > 0;
    }
    public double getResult() {
        return this.result;
    }
    public Integer getAmount() {
        return this.amt;
    }
    public void setAmount(Integer amount) {
        this.amt = amount;
    }
}
