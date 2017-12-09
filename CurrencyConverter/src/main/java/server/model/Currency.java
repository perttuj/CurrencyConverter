/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *  Class for storing currencies as entities in the
 * database, inserted using the entity manager in the 
 * DAO class, uniqueliy identified by their name
 * @author Perttu.Jaaskelainen
 */
@Entity
public class Currency implements Serializable {
    @Id
    private String currency;
    private double val;
    
    public Currency() {
    }
    
    public Currency(String currency, double value) {
        this.currency = currency;
        this.val = value;
    }
    
    public double getValue() {
        return this.val;
    }
    public String getCurrency() {
        return this.currency;
    }
    
}
