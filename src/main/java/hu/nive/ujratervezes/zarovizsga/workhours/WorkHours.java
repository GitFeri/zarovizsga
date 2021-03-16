package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {

    private Boolean firstLine = true;
    private int minHours = 0;
    private String nameAndDateOfMinHours;

    public String minWork(String file) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
            readAndProcessLines(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return nameAndDateOfMinHours;
    }

    private void readAndProcessLines(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            processLine(line);
        }
    }

    private void processLine(String line) {
        String[] splitedLine = line.split(",");
        int hour = Integer.parseInt(splitedLine[1]);
        if (firstLine || hour < minHours) {
            firstLine = false;
            minHours = hour;
            nameAndDateOfMinHours = splitedLine[0] + ": " + splitedLine[2];
        }
    }
}
