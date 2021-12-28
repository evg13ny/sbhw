import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        // TODO: write code copy content of sourceDirectory to destinationDirectory

        File sourceDir = new File(sourceDirectory);
        File destDir = new File(destinationDirectory);

        copyDirectory(sourceDir, destDir);
    }

    private static void copyDirectory(File sourceDir, File destDir) throws IOException {
        if (!destDir.exists()) {
            destDir.mkdir();
        }

        for (String f : sourceDir.list()) {
            File source = new File(sourceDir, f);
            File destination = new File(destDir, f);

            if (source.isDirectory()) {
                copyDirectory(source, destination);
            } else {
                copyFile(source, destination);
            }
        }
    }

    private static void copyFile(File sourceFile, File destinationFile) throws IOException {
        FileInputStream input = new FileInputStream(sourceFile);
        FileOutputStream output = new FileOutputStream(destinationFile);

        byte[] buf = new byte[1024];
        int bytesRead;

        while ((bytesRead = input.read(buf)) > 0) {
            output.write(buf, 0, bytesRead);
        }

        input.close();
        output.close();
    }
}
