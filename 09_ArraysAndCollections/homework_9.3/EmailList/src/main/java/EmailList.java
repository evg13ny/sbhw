import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class EmailList {

    TreeSet<String> emailList = new TreeSet<>();

    public void add(String email) {
        // TODO: валидный формат email добавляется

        String regex = "\\w+@\\w+\\.\\w+";

        if (email.matches(regex)) {
            emailList.add(email.toLowerCase());
        } else {
            System.out.println(Main.WRONG_EMAIL_ANSWER);
        }
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке

        return new ArrayList<>(emailList);
    }
}
