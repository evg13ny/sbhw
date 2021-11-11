public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

        for (int i = 1025; i <= 1105; i++) {
            char c = (char) i;
            if ((i > 1025 && i < 1040) || (i > 1103 && i < 1105)) continue;
            System.out.println(i + " - " + c);
        }
    }
}
