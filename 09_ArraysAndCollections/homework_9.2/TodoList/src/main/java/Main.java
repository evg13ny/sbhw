import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList

        Scanner scanner = new Scanner(System.in);
        String number;
        int item;
        String task;
        while (true) {
            System.out.println("Выберите команду: LIST, ADD, EDIT, DELETE, EXIT");
            String str = scanner.nextLine();
            String[] order = str.split(" ");
            String action = order[0];
            switch (action) {
                case "LIST":
                    todoList.getTodos();
                    break;
                case "ADD":
                    try {
                        number = order[1];
                        item = Integer.parseInt(number);
                        task = str.replace(action, "").replace(number, "").trim();
                        todoList.add(item, task);
                    } catch (NumberFormatException e) {
                        task = str.replace(action, "").trim();
                        todoList.add(task);
                    }
                    break;
                case "EDIT":
                    try {
                        number = order[1];
                        item = Integer.parseInt(number);
                        task = str.replace(action, "").replace(number, "").trim();
                        todoList.edit(task, item);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Дело с таким номером не существует");
                    }
                    break;
                case "DELETE":
                    try {
                        number = order[1];
                        item = Integer.parseInt(number);
                        todoList.delete(item);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Дело с таким номером не существует");
                    }
                    break;
                case "EXIT":
                    return;
            }
        }
    }
}
