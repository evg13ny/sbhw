import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO:напишите ваш код тут, результат вывести в консоль.
            //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

            boolean isCyrillic = false;
            int count = 1;

            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == 32){
                    count++;
                }
            }

            for (int i = 0; i < input.length(); i++) {
                int x = input.charAt(i);

                if (((x <= 1040 || x >= 1103) && x != 45 && x != 1025 && x != 1105) || count != 3) {
                    continue;
                }
                isCyrillic = true;
            }

            if (isCyrillic) {
                System.out.println("Фамилия: " + input.substring(0, input.indexOf(" ")));
                System.out.println("Имя: " + input.substring(input.indexOf(" "), input.lastIndexOf(" ")).trim());
                System.out.println("Отчество: " + input.substring(input.lastIndexOf(" ")).trim());
            } else {
                System.out.println("Введенная строка не является ФИО");
            }
        }
    }
}