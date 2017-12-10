package model;

/**
 *  An object containing details of a conversion
 * @author Perttu.Jaaskelainen
 */
class Conversion implements ConversionDTO {
    private final String from;
    private final String to;
    private final double be;
    private final double af;
    
    Conversion(String from, String to, double before, double after) {
        this.from = from;
        this.to = to;
        this.be = before;
        this.af = after;
    }

    @Override
    public String getFromCurrency() {
        return this.from;
    }

    @Override
    public String getToCurrency() {
        return this.to;
    }

    @Override
    public double getBeforeAmont() {
        return this.be;
    }

    @Override
    public double getAfterAmount() {
        return this.af;
    }
}
