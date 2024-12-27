# Currency Exchange Application

This application provides a simple framework for fetching, parsing, and displaying currency exchange rates, and performing currency exchange calculations.

## Features

- **Fetch Currency Data**: Retrieves currency exchange rates from an external API in XML format.
- **Parse XML Data**: Extracts currency details such as name, code, and mid-rate from the XML.
- **Manage Currency Collection**: Provides functionalities to add, update, retrieve, or delete currencies from the collection.
- **Perform Exchange Calculations**: Allows conversion between currencies based on current exchange rates.
- **User Interaction**: A console-based interface to interact with users for currency operations.

## Architecture

### Modules Overview

1. **UI Module (`UserInterface`)**
   - Provides methods for displaying currencies, capturing user input, and displaying exchange results.

2. **Service Module (`Exchanger`)**
   - Implements the exchange calculation logic using exchange rates.

3. **Data Provider Module (`DataProvider`)**
   - Fetches raw XML data from an external API via HTTP requests.

4. **Encoding Module (`Encoder`)**
   - Converts byte arrays to strings using the specified character set.

5. **Parser Module (`XMLParser`)**
   - Parses the XML data to extract currency details and populate the currency collection.

6. **Model Module (`Currency` and `CurrencyCollection`)**
   - Represents individual currencies and manages a collection of currencies.

## Usage

1. Fetch currency data from an API using `DataProvider`.
2. Parse the fetched XML data using `XMLParser` to populate the `CurrencyCollection`.
3. Use `UserInterface` to display available currencies.
4. Perform currency exchange using the `Exchanger`.

## Example Workflow

1. Retrieve XML data from an API (e.g., exchange rates for various currencies).
2. Parse the XML data to extract currency details.
3. Display the list of available currencies in the console.
4. Capture user input for the desired currency conversion.
5. Perform the conversion and display the result.
