import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Movements {
    private List<List<String>> records;

    public Movements(String pathMovementsList) {
        fileReader(pathMovementsList);
    }

    public double getExpenseSum() {
        double expenseSum = 0;
        for (List<String> record : records) {
            expenseSum += Double.parseDouble(record.get(7));
        }
        return expenseSum;
    }

    public double getIncomeSum() {
        double incomeSum = 0;
        for (List<String> record : records) {
            incomeSum += Double.parseDouble(record.get(6));
        }
        return incomeSum;
    }

    private void fileReader(String pathMovementList) {
        records = new ArrayList<>();
        List<String> values = new ArrayList<>();
        try {
            values = Files.readAllLines(Path.of(pathMovementList));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for (String value : values) {
            String[] parts = value.split(",");
            if (parts[7].contains("\"") && parts[8].contains("\"")) {
                parts[7] = parts[7].replace("\"", "") + "." + parts[8].replace("\"", "");
                ArrayList<String> line = new ArrayList<>(Arrays.asList(parts));
                line.remove(8);
                this.records.add(line);
            } else if (parts[6].contains("\"") && parts[7].contains("\"")) {
                parts[6] = parts[6].replace("\"", "") + "." + parts[7].replace("\"", "");
                ArrayList<String> line = new ArrayList<>(Arrays.asList(parts));
                line.remove(7);
                this.records.add(line);
            } else {
                this.records.add(Arrays.asList(parts));
            }
        }
        this.records.remove(0);
    }

    private String getCompany(List<String> lines) {
        String[] parts = lines.get(5).replace("\\", "/").split("/");
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < parts.length; i++) {
            builder.append(parts[i]).append(" ");
        }
        builder.replace(builder.indexOf("  "), builder.length() - 1, "");
        return builder.toString();
    }

    public void getReport() {
        Set<String> report = new TreeSet<>();
        for (List<String> line_1 : records) {
            double expense = 0;
            getCompany(line_1);
            for (List<String> line_2 : records) {
                if (getCompany(line_1).equals(getCompany(line_2))) {
                    expense += Double.parseDouble(line_2.get(7));
                }
            }
            report.add(getCompany(line_1) + " " + expense);
        }
        report.forEach(System.out::println);
    }
}
