package model;

public class Currency {

    private String name;
    private String code;
    private double mid;

    public Currency(String name, String code, double mid) {
        this.name = name;
        this.code = code;
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String currency) {
        this.name = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency1 = (Currency) o;
        return code.equals(currency1.code);
    }
}
