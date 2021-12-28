import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path;
        int count = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите путь до папки:");
            path = scanner.nextLine().trim();
            if (path.equals("0")) break;
            try {
                System.out.println("Размер папки " + path + " составляет " + FileUtils.readableFormat(FileUtils.calculateFolderSize(path)));
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Указан неверный путь до папки");
                count++;
                if (count > 3) break;
            }
        }
    }
}
