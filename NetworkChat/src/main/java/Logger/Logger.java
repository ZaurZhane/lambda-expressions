package Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {
    private File log;
    public Logger() {
        log = new File("./src/log.txt");
    }
    public void log(String message) {
        String Date = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss ").format(Calendar.getInstance().getTime());
        try{
            FileWriter writer = new FileWriter(log.getName(), true);
            writer.write(Date + " " + message + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getLog(){
        return log;
    }
}
