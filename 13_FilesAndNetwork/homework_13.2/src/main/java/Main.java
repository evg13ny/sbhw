import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к копируемой папке:");
        String source = scanner.nextLine().trim();
        System.out.println("Введите путь, куда скопировать папку:");
        String destination = scanner.nextLine().trim();
        FileUtils.copyFolder(source, destination);
        System.out.println("Папка " + source + " скопирована в " + destination);
    }
}
