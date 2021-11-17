import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook contacts = new PhoneBook();
        String name;
        String phone;

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine();

            if (input.equals("EXIT")) {
                break;
            } else if (input.equals("LIST")) {
                Set<String> allContacts = contacts.getAllContacts();
                for (String contact : allContacts) {
                    System.out.println(contact);
                }
            } else {
                // ввёл имя
                // имя не найдено
                if (contacts.isValidName(input) && !contacts.isValidPhone(input)) {
                    name = input;
                    boolean isNewName = !contacts.phoneBook.containsValue(name);
                    if (isNewName) {
                        System.out.println("Такого имени в телефонной книге нет.");
                        System.out.println("Введите номер телефона для абонента " + '“' + name + '“' + ":");
                        phone = scanner.nextLine();
                        if (contacts.isValidPhone(phone)) {
                            contacts.addContact(phone, name);
                            System.out.println("Контакт сохранен!");
                        } else {
                            System.out.println("Неверный формат ввода");
                        }
                        // имя найдено
                    } else {
                        System.out.println(contacts.getContactByName(name));
                    }
                }

                // ввёл телефон
                // телефон не найден
                else if (contacts.isValidPhone(input) && !contacts.isValidName(input)) {
                    phone = input;
                    boolean isNewPhone = !contacts.phoneBook.containsKey(phone);
                    if (isNewPhone) {
                        System.out.println("Такого номера нет в телефонной книге.");
                        System.out.println("Введите имя абонента для номера " + '“' + phone + '”' + ":");
                        name = scanner.nextLine();
                        if (contacts.isValidName(name)) {
                            contacts.addContact(phone, name);
                            System.out.println("Контакт сохранен!");
                        } else {
                            System.out.println("Неверный формат ввода");
                        }
                        // телефон найден
                    } else {
                        System.out.println(contacts.getContactByPhone(phone));
                    }
                    // ошибка
                } else {
                    System.out.println("Неверный формат ввода");
                }
            }
        }
    }
}
