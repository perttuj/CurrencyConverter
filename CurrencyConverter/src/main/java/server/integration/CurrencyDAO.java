/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.integration;

import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Perttu Jääskeläinen
 */
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
public class CurrencyDAO {
    @PersistenceContext(unitName = "currencyPU")
    private String s = null;
    
    public static Map<String, Integer> getCurrencies() {
        return null; // make databaes calls and sort currencies
    }
    public static double getConversionValue(String currency) {
        return 0.0; // return conversion value for a currency
    }
}
