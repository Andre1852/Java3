package examplesNIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilesNIOExamples {
    public static void copyFile() {
        Path sourcePath = Paths.get("src.txt");
        Path destinationPath = Paths.get("dst.txt");
        try {
            Files.copy(sourcePath, destinationPath);
        } catch (FileAlreadyExistsException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getFiles(String dir) {
        List<String> fileNames = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : directoryStream) {
                fileNames.add(path.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileNames;
    }

    public static void main(String[] args) {

        getFilesWithFilters();
    }

    public static void getFilesWithFilters() {
        Path directoryPath = Paths.get("Y:\\Работа\\GB\\java3\\Исходники 3. Java Core. Профессиональный уровень. Средства ввода-вывода", "1.txt");

        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                long size = Files.readAttributes(entry, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS).size();
                long milis = new Date().getTime();

                boolean isSizeEvenNumber = size % 2 == 0;
                boolean isTheTimeRight = milis % 2 == 0;

                return isTheTimeRight && isSizeEvenNumber;
            }
        };

        if (Files.isDirectory(directoryPath)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath, filter)) {
                for (Path path : stream) {
                    System.out.println(path);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void makeDir() {
        Path path = Paths.get("/data");
        try {
            Path newDir = Files.createDirectory(path);
        } catch (FileAlreadyExistsException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void moveFile() {
        Path sourcePath = Paths.get("src.txt");
        Path destinationPath = Paths.get("dst.txt");
        try {
            Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void normalizePath() {
        String originalPath = "C:\\data\\projects\\a-project\\..\\another-project";
        Path path1 = Paths.get(originalPath);
        System.out.println("path = " + path1);
        Path path2 = path1.normalize();
        System.out.println("path = " + path2);
    }

    public static void overwriteFile() {
        Path sourcePath = Paths.get("src.txt");
        Path destinationPath = Paths.get("dst.txt");
        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (FileAlreadyExistsException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void pathExample() {
        Path path = Paths.get("C:\\myfile.txt");
    }
}
