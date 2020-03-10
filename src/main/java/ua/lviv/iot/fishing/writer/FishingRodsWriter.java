package ua.lviv.iot.fishing.writer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import ua.lviv.iot.fishing.model.AbstractFishingRod;

public class FishingRodsWriter {

    private Writer csvWriter;

    public void setCsvWriter(Writer csvWriter) {
        this.csvWriter = csvWriter;
    }

    public void writeToFile(List<AbstractFishingRod> rods) throws IOException {
        String textToWrite;
        for (AbstractFishingRod rod : rods) {
            textToWrite = rod.getHeaders() + ", " + rod.toCSV() + "\r\n";
            csvWriter.write(textToWrite);
        }
    }

    public String toString() {
        return csvWriter.toString();
    }
}