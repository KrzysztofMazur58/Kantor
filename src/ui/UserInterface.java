package ui;

import model.Currency;
import model.ICurrencyCollection;

import java.util.List;
import java.util.Scanner;

public class UserInterface implements IUserInterface {

    private final Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayAvailableCurrencies(ICurrencyCollection currencies) {
        System.out.println("Dostępne waluty:");
        List<Currency> allCurrencies = currencies.getAll();

        for (Currency currency : allCurrencies) {
            System.out.println(currency.getName() + " (" + currency.getCode() + "): " + currency.getMid());
        }
    }

    @Override
    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void displayExchangeResult(String message) {
        System.out.println(message);
    }
}
