package ui;

import model.ICurrencyCollection;

public interface IUserInterface {
    void displayAvailableCurrencies(ICurrencyCollection currencies);
    String getUserInput(String prompt);
    void displayExchangeResult(String message);
}
