public class Main {

    public static void main(String[] args) {
        String text = "Two households, both alike in dignity,\n" +
                "In fair Verona, where we lay our scene,\n" +
                "From ancient grudge break to new mutiny,\n" +
                "Where civil blood makes civil hands unclean.\n" +
                "From forth the fatal loins of these two foes\n" +
                "A pair of star-cross'd lovers take their life;\n" +
                "Whose misadventured piteous overthrows\n" +
                "Do with their death bury their parents' strife.\n" +
                "The fearful passage of their death-mark'd love,\n" +
                "And the continuance of their parents' rage,\n" +
                "Which, but their children's end, nought could remove,\n" +
                "Is now the two hours' traffic of our stage;\n" +
                "The which if you with patient ears attend,\n" +
                "What here shall miss, our toil shall strive to mend.";
        System.out.println(splitTextIntoWords(text));
    }

    public static String splitTextIntoWords(String text) {
        //TODO реализуйте метод

        String regex = "[\\d\\p{Punct}&&[^']]";
        text = text.replaceAll(regex," ");
        String[] words = text.split("\\s+");
        String result = "";

        for (int i = 0; i < words.length;i++){
            result += "\n" + words[i];
        }

        return result.trim();
    }
}