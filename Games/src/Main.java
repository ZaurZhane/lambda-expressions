import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> directoryList = new ArrayList<>();
        directoryList.add("Games/src");
        directoryList.add("Games/res");
        directoryList.add("Games/savegames");
        directoryList.add("Games/temp");
        directoryList.add("Games/src/main");
        directoryList.add("Games/src/test");
        directoryList.add("Games/res/drawables");
        directoryList.add("Games/res/vectors");
        directoryList.add("Games/res/icons");

        ArrayList<String> fileList = new ArrayList<>();
        fileList.add("Games/src/Main.java");
        fileList.add("Games/src/main/Utils.java");
        fileList.add("Games/temp/temp.txt");

        StringBuilder log = new StringBuilder();

        for (int i = 0; i < directoryList.size(); i++) {
            makeDirectory(directoryList.get(i), log);
        }

        for (int i = 0; i < fileList.size(); i++) {
            createNewFile(fileList.get(i), log);
        }

        try (FileWriter writer = new FileWriter("Games/temp/temp.txt", false)) {

            writer.write(log.toString());
            writer.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static File makeDirectory(String directoryPath, StringBuilder log) {

        File dir = new File(directoryPath);

        try {
            if (!dir.exists()) {
                dir.mkdirs();
                log.append("Cоздан каталог " + directoryPath + "\n");
            }
        } catch (Exception e) {
            log.append("Файл не создан " + directoryPath + " " + e.getMessage());
        }

        return dir;

    }

    public static File createNewFile(String filePath, StringBuilder log) {

        File file = new File(filePath);

        try {
            file.createNewFile();
            log.append("Cоздан файл " + filePath + "\n");
        } catch (IOException e) {
            log.append("Файл не создан " + filePath + " " + e.getMessage());
        }

        return file;

    }

}
