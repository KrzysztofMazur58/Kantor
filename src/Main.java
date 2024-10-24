import model.Currency;
import model.ICurrencyCollection;
import parser.IDataParser;
import parser.XMLParser;
import provider.DataProvider;
import provider.Encoder;
import provider.IDataProvider;
import provider.IEncoder;
import service.Exchanger;
import ui.IUserInterface;
import ui.UserInterface;

public class Main {
    public static void main(String[] args) {
        String apiUrl = "https://api.nbp.pl/api/exchangerates/tables/a/";
        IDataProvider dataProvider = new DataProvider(apiUrl);

        byte[] responseData = dataProvider.getData();
        IEncoder encoder = new Encoder();
        String xmlData = encoder.encode(responseData, "UTF-8");

        IDataParser xmlParser = new XMLParser();
        ICurrencyCollection currencies = xmlParser.parse(xmlData);

        IUserInterface userInterface = new UserInterface();
        userInterface.displayAvailableCurrencies(currencies);

        boolean continueExchange = true;

        while (continueExchange) {
            String fromCurrencyCode = userInterface.getUserInput("Podaj kod waluty, którą chcesz wymienić (lub wpisz 'exit', aby zakończyć): ");

            if (fromCurrencyCode.equalsIgnoreCase("exit")) {
                continueExchange = false;
                break;
            }

            String toCurrencyCode = userInterface.getUserInput("Podaj kod waluty, na którą chcesz wymienić: ");
            double amount;

            try {
                amount = Double.parseDouble(userInterface.getUserInput("Podaj kwotę do wymiany: "));
            } catch (NumberFormatException e) {
                userInterface.displayExchangeResult("Niepoprawna kwota. Proszę podać wartość liczbową.");
                continue;
            }

            Currency fromCurrency = currencies.get(fromCurrencyCode);
            Currency toCurrency = currencies.get(toCurrencyCode);

            if (fromCurrency != null && toCurrency != null) {
                double exchangedAmount = Exchanger.getInstance().exchange(fromCurrency, toCurrency, amount);
                userInterface.displayExchangeResult("Wymieniona kwota: " + exchangedAmount + " " + toCurrency.getCode());
            } else {
                userInterface.displayExchangeResult("Nie znaleziono jednej z podanych walut.");
            }

            String continueResponse = userInterface.getUserInput("Czy chcesz wykonać kolejną wymianę? ");
            continueExchange = continueResponse.equalsIgnoreCase("tak");
        }

        System.out.println("Zakończono działanie programu.");
    }
}