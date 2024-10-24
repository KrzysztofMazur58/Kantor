package service;

import model.Currency;

public interface IExchanger {

    double exchange(Currency currency1, Currency currency2, double amount);
}

