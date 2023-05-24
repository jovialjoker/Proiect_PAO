package Utils.CSVUtils;

import java.io.*;
import java.text.*;
import java.util.*;

public class CSVWriter {
    public static void Write(String numeActiune) throws IOException {
        Date timestamp = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestampString = dateFormat.format(timestamp);
        FileWriter fileWriter = new FileWriter("audit.csv", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("%s,%s\n", numeActiune, timestampString);
        printWriter.close();
    }
}