package model;

import java.util.List;

public interface ICurrencyCollection {

    void add(Currency currency);
    Currency get(String code);
    void update(Currency currency);
    void delete(Currency currency);
    List<Currency> getAll();
}
