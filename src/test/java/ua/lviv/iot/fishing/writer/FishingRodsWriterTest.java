package ua.lviv.iot.fishing.writer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.fishing.manager.BaseFishingRodManagerTest;
import ua.lviv.iot.fishing.model.AbstractFishingRod;

public class FishingRodsWriterTest extends BaseFishingRodManagerTest {

    @Test
    public void testWriteToFile() throws IOException {
        try (Writer fileWriter = new FileWriter("Path.csv")) {
            FishingRodsWriter writer = new FishingRodsWriter();
            writer.setCsvWriter(fileWriter);
            writer.writeToFile(fishingRods);
        }
    }

    @Test
    public void testUsingString() throws IOException {
        try (Writer csvWriter = new StringWriter()) {
            FishingRodsWriter writer = new FishingRodsWriter();
            writer.setCsvWriter(csvWriter);
            writer.writeToFile(fishingRods);
            String expectedString = "";
            for (AbstractFishingRod rod : fishingRods) {
                expectedString += rod.getHeaders() + ", " + rod.toCSV() + "\r\n";
            }
            assertEquals(expectedString, writer.toString());
        }
    }

}