package service;

import model.Currency;

public class Exchanger implements IExchanger{

    public static Exchanger exchanger = null;

    private Exchanger() {

    }

    public static Exchanger getInstance(){

        if(exchanger == null){
            exchanger = new Exchanger();
        }
        return exchanger;
    }

    public double exchange(Currency currency1, Currency currency2, double amount)
    {
        double exchangedAmount;

        if (currency1.getCode().equals("PLN")) {
            exchangedAmount = amount / currency2.getMid();
        }

        else if (currency2.getCode().equals("PLN")) {

            exchangedAmount = amount * currency1.getMid();
        }

        else {
            exchangedAmount = (amount / currency2.getMid()) * currency1.getMid();
        }

        return Math.round(exchangedAmount * 100.0) / 100.0;

    }
}
