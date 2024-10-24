package model;

import java.util.ArrayList;
import java.util.List;

public class CurrencyCollection implements ICurrencyCollection {

    private List<Currency> currencies;

    public CurrencyCollection() {
        this.currencies = new ArrayList<>();
    }

    @Override
    public void add(Currency currency) {
        if (currency != null) {
            if (!currencies.contains(currency)) {
                currencies.add(currency);
            } else {
                System.out.println("Waluta już istnieje: " + currency.getName() + " (" + currency.getCode() + ")");
            }
        } else {
            System.out.println("Waluta jest null.");
        }
    }


    @Override
    public Currency get(String code) {
        for (Currency currency : currencies) {
            if (currency.getCode().equals(code)) {
                return currency;
            }
        }
        return null;
    }

    @Override
    public void update(Currency currency) {
        if (currency != null) {
            for (int i = 0; i < currencies.size(); i++) {
                if (currencies.get(i).getCode().equals(currency.getCode())) {
                    currencies.set(i, currency);
                    return;
                }
            }
        }
    }

    @Override
    public void delete(Currency currency) {
        currencies.remove(currency);
    }

    @Override
    public List<Currency> getAll() {
        return currencies;
    }

    public void displayCurrencies() {
        for (Currency currency : currencies) {
            System.out.println(currency.getName() + " (" + currency.getCode() + "): " + currency.getMid());
        }
    }
}

