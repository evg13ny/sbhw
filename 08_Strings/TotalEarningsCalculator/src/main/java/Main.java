public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        //TODO: напишите ваш код, результат вывести в консоль

        int sum = 0;

        for (int i = 0; i < text.length(); i++) {
            try {
                int end = text.indexOf(" руб");
                int start = text.lastIndexOf(' ', end - 1);
                String salary = text.substring(start, end);
                sum = sum + Integer.parseInt(salary.trim());
                text = text.substring(end + 1);
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
        System.out.println(sum);
    }
}
