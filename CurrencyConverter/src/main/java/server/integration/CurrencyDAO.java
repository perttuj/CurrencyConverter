package server.integration;

import server.model.Currency;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *  Database access object for fetching and
 * storing various currencies along with their exchange rates
 * @author Perttu Jääskeläinen
 */
@Singleton
public class CurrencyDAO {
    @PersistenceContext(unitName = "currencyPU")
    private EntityManager manager;
    /**
     * Called to add a currency to the database
     * @param c the currency to add
     */
    public void addCurrency(Currency c) {
        manager.persist(c);
    }
    /**
     * Get a list of all currency names from
     * the database
     * @return  a list of all currency names
     */
    public List<String> getCurrencies() {
        List<String> s = manager.createQuery("SELECT c.currency FROM Currency c").getResultList();
        return s;
    }
    /**
     * Gets a value for a currency, used to
     * convert between currencies
     * @param currency  the currency to fetch value for
     * @return  the conversion value for the currency
     */
    public double getConversionRate(String currency) {
        Currency c = manager.find(Currency.class, currency);
        return c.getValue(); // return conversion value for a currency
    }
}
