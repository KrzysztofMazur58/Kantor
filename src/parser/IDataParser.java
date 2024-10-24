package parser;

import model.ICurrencyCollection;

public interface IDataParser {
    ICurrencyCollection parse(String data);
}
