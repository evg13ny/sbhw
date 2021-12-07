import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        final String patternEmail = "\\w+@\\w+\\.\\w+";
        final String patternPhoneNumber = "\\+7[\\d]{10}";

        String[] components = data.split("\\s+");

        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong format. Correct format - Василий Петров vasily.petrov@gmail.com +79215637722");
        } else if (!Pattern.matches(patternEmail, components[INDEX_EMAIL])) {
            throw new EmailFormatException("Wrong email format. Correct email format - vasily.petrov@gmail.com");
        } else if (!Pattern.matches(patternPhoneNumber, components[INDEX_PHONE])) {
            throw new PhoneNumberFormatException("Wrong phone number format. Correct phone number format - +79215637722");
        }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        if (!storage.containsKey(name)) {
            throw new IllegalArgumentException("Wrong name. Name was not found.");
        }
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}