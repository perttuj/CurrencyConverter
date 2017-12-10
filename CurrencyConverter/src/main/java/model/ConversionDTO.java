package model;

/**
 *  Interface for a conversion object, used to return 
 * a restricted object to the user
 * @author Perttu.Jaaskelainen
 */
public interface ConversionDTO {
    public String getFromCurrency();
    public String getToCurrency();
    public double getBeforeAmount();
    public double getAfterAmount();
}
