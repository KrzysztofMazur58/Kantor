package parser;

import model.Currency;
import model.CurrencyCollection;
import model.ICurrencyCollection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import org.xml.sax.InputSource;

public class XMLParser implements IDataParser {

    @Override
    public ICurrencyCollection parse(String xmlData) {
        ICurrencyCollection currencies = new CurrencyCollection();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new InputSource(new ByteArrayInputStream(xmlData.getBytes(StandardCharsets.UTF_8))));
            document.getDocumentElement().normalize();

            NodeList rateNodes = document.getElementsByTagName("Rate");

            for (int i = 0; i < rateNodes.getLength(); i++) {
                Node rateNode = rateNodes.item(i);
                if (rateNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element rateElement = (Element) rateNode;

                    String currencyName = rateElement.getElementsByTagName("Currency").item(0).getTextContent();
                    String code = rateElement.getElementsByTagName("Code").item(0).getTextContent();
                    double mid = Double.parseDouble(rateElement.getElementsByTagName("Mid").item(0).getTextContent());

                    Currency currency = new Currency(currencyName, code, mid);
                    currencies.add(currency);
                }
            }

            Currency pln = new Currency("złoty polski", "PLN", 1.0);

            currencies.add(pln);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return currencies;
    }
}