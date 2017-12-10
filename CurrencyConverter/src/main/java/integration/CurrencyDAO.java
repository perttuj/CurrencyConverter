package integration;

import model.Currency;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *  Database access object for fetching and
 * storing various currencies along with their exchange rates
 * @author Perttu Jääskeläinen
 */
@Startup
@Singleton
public class CurrencyDAO {
    @PersistenceContext(unitName = "currencyPU")
    private EntityManager manager;
    /**
     * Class for filling the database with currencies,
     * in this program, they are hardcoded
     * All currencies are following the exhange rate 1 USD = X Currency
     */
    @PostConstruct
    void init() {
        addCurrency(new Currency("USD", 1.0));
        addCurrency(new Currency("Euro", 0.85));
        addCurrency(new Currency("SEK", 8.5));
        addCurrency(new Currency("GBP", 0.74));
    }
    /**
     * Called to add a currency to the database
     * @param c the currency to add
     */
    public void addCurrency(Currency c) {
        if (manager.find(Currency.class, c.getCurrency()) != null) {
            return;
        }
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
