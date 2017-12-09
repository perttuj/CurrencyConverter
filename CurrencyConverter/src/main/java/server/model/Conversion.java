/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

/**
 *
 * @author Perttu.Jaaskelainen
 */
public class Conversion {
    public String from;
    public String to;
    public double be;
    public double af;
    
    public Conversion(String from, String to, double before, double after) {
        this.from = from;
        this.to = to;
        this.be = before;
        this.af = after;
    }
}
