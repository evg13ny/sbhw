import java.io.File;
import java.text.DecimalFormat;

public class FileUtils {

    public static long calculateFolderSize(String path) {
//        return org.apache.commons.io.FileUtils.sizeOfDirectory(new File(path));

        long length = 0;
        File folder = new File(path);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    length += file.length();
                } else {
                    length += calculateFolderSize(String.valueOf(file));
                }
            }
        }

        return length;
    }

    public static String readableFormat(long size) {
//        return org.apache.commons.io.FileUtils.byteCountToDisplaySize(size);

        String[] units = new String[]{"б", "Кб", "Мб", "Гб", "Тб"};
        int unitIndex = (int) (Math.log10(size) / 3);
        double unitValue = 1 << (unitIndex * 10);

        return new DecimalFormat("#,##0.#")
                .format(size / unitValue) + " "
                + units[unitIndex];
    }
}
