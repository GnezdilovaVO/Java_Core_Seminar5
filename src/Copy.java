import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Copy {
    static void backupDir(String nameDir) {
        Path currDir = Path.of(nameDir);
        Path backupDir = Path.of("./backup");
        System.out.println(backupDir);
        try{
            Files.createDirectories(backupDir);
            File[] files = currDir.toFile().listFiles();
            if (files != null) {
                for (File file: files) {
                    Path sourceFilePath = file.toPath();
                    Path backupFilePath = backupDir.resolve(file.getName());
                    Files.copy(sourceFilePath, backupFilePath, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Backup is ready for " + file.getName());
                }
                System.out.println("Backup is ready");
            } else System.out.println(nameDir + " is Empty");
        } catch (IOException e) {
            e.getMessage();
            System.out.println("Error" + e.getMessage());
        }
    }
}
