package com.example.tp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public static List<Record> readCsv(String path) throws IOException {
        List<Record> records = new ArrayList<>();

        try (var lines = Files.lines(Path.of(path))) {
            lines.skip(1)
                 .forEach(line -> {
                     String[] parts = line.split(",");
                     if (parts.length == 3) {
                         int id = Integer.parseInt(parts[0].trim());
                         String name = parts[1].trim();
                         double score = Double.parseDouble(parts[2].trim());
                         records.add(new Record(id, name, score));
                     }
                 });
        }
        return records;
    }

    public static void writeCsv(List<Record> records, String path) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add("id,name,score");

        for (Record r : records) {
            lines.add(r.getId() + "," + r.getName() + "," + r.getScore());
        }

        Files.write(Path.of(path), lines);
    }
}
