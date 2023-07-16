import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        StringBuilder log = new StringBuilder();

        File scr = new File("Games", "src");

        if (!scr.exists()) {
            scr.mkdirs();
            log.append("В папке Games создан каталог src\n");
        }

        File res = new File("Games", "res");

        if (!res.exists()) {
            res.mkdirs();
            log.append("В папке Games создан каталог res\n");
        }

        File saveGames = new File("Games", "savegames");

        if (!saveGames.exists()) {
            saveGames.mkdirs();
            log.append("В папке Games создан каталог savegames\n");
        }

        File temp = new File("Games", "temp");

        if (!temp.exists()) {
            temp.mkdirs();
            log.append("В папке Games создан каталог temp\n");
        }

        File main = new File("Games/src", "main");

        if (!main.exists()) {
            main.mkdirs();
            log.append("В папке Games/src создан каталог main\n");
        }

        File test = new File("Games/src", "test");

        if (!test.exists()) {
            test.mkdirs();
            log.append("В папке Games/src создан каталог test\n");
        }

        File fileMain = new File("Games/src/main", "Main.java");

        try {
            fileMain.createNewFile();
            log.append("В папке Games/src/main создан файл Main.java\n");
        } catch (IOException e) {
            log.append(e.getMessage());
            throw  new RuntimeException(e);
        }

        File fileUtils = new File("Games/src/main", "Utils.java");

        try {
            fileUtils.createNewFile();
            log.append("В папке Games/src/main создан файл Utils.java\n");
        } catch (IOException e) {
            log.append(e.getMessage());
            throw  new RuntimeException(e);
        }

        File drawables = new File("Games/res", "drawables");

        if (!drawables.exists()) {
            drawables.mkdirs();
            log.append("В папке Games/res создан каталог drawables\n");
        }

        File vectors = new File("Games/res", "vectors");

        if (!vectors.exists()) {
            vectors.mkdirs();
            log.append("В папке Games/res создан каталог vectors\n");
        }

        File icons = new File("Games/res", "icons");

        if (!icons.exists()) {
            icons.mkdirs();
            log.append("В папке Games/res создан каталог icons\n");
        }

        File fileTemp= new File("Games/temp", "temp.txt");

        try {
            fileTemp.createNewFile();
            log.append("В папке Games/temp создан файл temp.txt\n");
        } catch (IOException e) {
            log.append(e.getMessage());
            throw  new RuntimeException(e);
        }

        try (FileWriter writer = new FileWriter("Games/temp/temp.txt", false)) {

            writer.write(log.toString());
            writer.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}