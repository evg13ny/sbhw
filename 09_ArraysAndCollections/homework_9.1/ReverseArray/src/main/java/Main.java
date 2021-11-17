public class Main {

    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан";

        String[] colors = line.split(",?\\s+");
        String[] reverseArray = ReverseArray.reverse(colors);
        for (String colorWord : reverseArray) {
            System.out.println(colorWord);
        }
    }
}
