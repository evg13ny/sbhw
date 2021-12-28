import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Main {
    private static StationIndex stationIndexReadWeb = new StationIndex();
    private static StationIndex stationIndexReadFile = new StationIndex();

    public static void main(String[] args) {
        String path = "src\\main\\resources\\map.json";

        try {
            Document doc = Jsoup.parse(new File("src\\main\\resources\\metro.html"), "utf-8");
            parseLines(doc);
            parseConnections(doc);
            JSONObject jsonObject = createJson();
            writeJson2File(jsonObject, path);
            readJSON(path);

            for (Line line : stationIndexReadFile.getLines()) {
                System.out.println(line.getName() + ", число станций - " + line.getStations().size());
            }
            System.out.println("Количество переходов - " + stationIndexReadWeb.getConnections().size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void parseLines(Document doc) {
        Elements lines = doc.select("span.js-metro-line");
        lines.forEach(parseLine -> {
            Line line = new Line(parseLine.text(), parseLine.attr("data-line"));
            Elements stations = doc.select("[data-line=" + line.getNumber() + "] span.name");
            stations.forEach(station -> line.addStation(new Station(line.getNumber(), station.text())));
            stationIndexReadWeb.addLine(line);
        });
    }

    private static void parseConnections(Document doc) {
        Elements connections = doc.select("[title^='переход']");
        connections.forEach(parseConnection -> {
            String station = parseConnection.attr("title");
            station = station.replaceAll("^.+«", "").replaceAll("».+$", "");
            String line = parseConnection.attr("class").replaceAll("^.+ln-", "");
            stationIndexReadWeb.addConnection(new Connection(station, line));
        });
    }

    private static JSONObject createJson() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArrayLines = new JSONArray();
        JSONArray jsonConnections = new JSONArray();

        for (Line line : stationIndexReadWeb.getLines()) {
            Map<String, String> lineNumberName = new TreeMap<>();
            lineNumberName.put("number", line.getNumber());
            lineNumberName.put("name", line.getName());
            jsonArrayLines.add(lineNumberName);
        }

        stationIndexReadWeb.getConnections().forEach(connection -> {
            JSONObject jsonConnection = new JSONObject();
            jsonConnection.put(connection.getStation(), connection.getLine());
            jsonConnections.add(jsonConnection);
        });

        jsonObject.put("stations", stationIndexReadWeb.getStations());
        jsonObject.put("lines", jsonArrayLines);
        jsonObject.put("connections", jsonConnections);

        return jsonObject;
    }

    private static void createFile(String path) {
        File file = new File(path);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void writeJson2File(JSONObject jsonObject, String path) {
        createFile(path);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(gson.toJson(jsonObject));
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void readJSON(String path) {
        JSONParser parser = new JSONParser();

        try {
            FileReader fileReader = new FileReader(path);
            JSONObject jsonObject = (JSONObject) parser.parse(fileReader);
            JSONArray jsonArrayLines = (JSONArray) jsonObject.get("lines");
            JSONObject jsonObjectStations = (JSONObject) jsonObject.get("stations");

            jsonArrayLines.forEach(lines -> {
                JSONObject jsonObjectLine = (JSONObject) lines;
                stationIndexReadFile.addLine(new Line((String) jsonObjectLine.get("name"), (String) jsonObjectLine.get("number")));
            });

            jsonObjectStations.keySet().forEach(lines -> {
                Line line = stationIndexReadFile.getLine((String) lines);

                if (!line.getNumber().equals("-1")) {
                    JSONArray jsonArrayStations = (JSONArray) jsonObjectStations.get(lines);
                    jsonArrayStations.forEach(station -> line.addStation(new Station((String) station, line.getNumber())));
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
