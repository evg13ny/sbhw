import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    Map<String, String> phoneBook = new TreeMap<>(); // <phone, name>

    // отдельный метод для проверки корректности формата имени
    public boolean isValidName(String name) {
        Pattern pattern = Pattern.compile("[А-я]+");
        Matcher matcher = pattern.matcher(name);

        return matcher.find();
    }

    // отдельный метод для проверки корректности формата телефона
    public boolean isValidPhone(String phone) {
        Pattern pattern = Pattern.compile("7[\\d]{10}");
        Matcher matcher = pattern.matcher(phone);

        return matcher.find();
    }

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона (отдельные методы для проверки)
        // если такой номер уже есть в списке, то перезаписать имя абонента

        if (isValidName(name) && isValidPhone(phone)) {
            phoneBook.put(phone, name);
        }
    }

    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку

        if (phoneBook.containsKey(phone)) {
            return phoneBook.get(phone) + " - " + phone;
        }
        return "";
    }

    public Set<String> getContactByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet

        List<String> phones = new ArrayList<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (name.equals(entry.getValue())) {
                phones.add(entry.getKey());
            }
        }

        TreeSet<String> contacts = new TreeSet<>();
        if (!phones.isEmpty()) {
            String contact = name + " - " + phoneToBook(phones);
            contacts.add(contact);
        }

        return contacts;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet

        TreeSet<String> contacts = new TreeSet<>();
        for (String name : phoneBook.values()) {
            List<String> phones = new ArrayList<>();
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                if (name.equals(entry.getValue())) {
                    phones.add(entry.getKey());
                }
            }
            String contact = name + " - " + phoneToBook(phones);
            contacts.add(contact);
        }

        return contacts;
    }

    private String phoneToBook(List list) {
        String result = "";
        String split = ", ";

        for (int i = 0; i < list.size(); i++) {
            result = result.concat(list.get(i).toString());
            if (i < list.size() - 1) {
                result = result.concat(split);
            }
        }

        return result;
    }

    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
}
