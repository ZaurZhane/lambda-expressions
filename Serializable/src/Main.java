import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {

        GameProgress firstGP = new GameProgress(100, 50, 10, 112);
        GameProgress secondGP = new GameProgress(90, 50, 12, 120);
        GameProgress thirdGP = new GameProgress(100, 70, 15, 130);

        saveGame("Games/SaveGames/firstGP.txt", firstGP);
        saveGame("Games/SaveGames/secondGP.txt", secondGP);
        saveGame("Games/SaveGames/thirdGP.txt", thirdGP);

        String[] filesPaths = {"Games/SaveGames/firstGP.txt", "Games/SaveGames/secondGP.txt", "Games/SaveGames/thirdGP.txt" };
        String zipPath = "Games/SaveGames/zip.zip";

        zipFiles(zipPath, filesPaths);

        openZip(zipPath, "Games/SaveGames/");

    }

    public static void saveGame(String path, GameProgress gameProgress) {

        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(gameProgress);

        } catch (IOException e) {
            System.out.print(e.getMessage());
        }

    }

    public static void zipFiles(String zipPath, String[] filesPaths) {

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zipPath))) {

            for (int i = 0; i < filesPaths.length; i++) {

                FileInputStream fis = new FileInputStream(filesPaths[i]);
                ZipEntry entry = new ZipEntry(filesPaths[i]);
                zout.putNextEntry(entry);

                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);

                zout.write(buffer);
                zout.closeEntry();
                fis.close();
            }

            File directory = new File("Games/SaveGames");

            for (File file : directory.listFiles()) {

                if (!file.getName().toLowerCase().contains(".zip")) {

                    try {
                        Files.delete(Paths.get(file.getAbsolutePath()));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

        } catch (IOException e) {
            System.out.print(e.getMessage());
        }

    }

    public static void openZip(String zipPath, String path) {

        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(zipPath))) {

            ZipEntry entry;
            String name;

            while ((entry = zin.getNextEntry()) != null) {

                name = entry.getName(); // получим название файла
                // распаковка

                FileOutputStream fout = new FileOutputStream(name);

                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }

                fout.flush();
                zin.closeEntry();
                fout.close();

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        GameProgress gameProgress = openProgress(path);

        System.out.print(gameProgress.toString());
    }

    public static GameProgress openProgress(String path) {

        GameProgress gameProgress = null;

        try (FileInputStream fis = new FileInputStream(path + "firstGP.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            gameProgress = (GameProgress) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return gameProgress;
    }

}

