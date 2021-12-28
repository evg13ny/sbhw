import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Main {
    private static final String IMAGE_DESTINATION_FOLDER = "images";

    public static void main(String[] args) {
        String strUrl = "https://lenta.ru";

        try {
            Document doc = Jsoup
                    .connect(strUrl)
                    .userAgent("Mozilla/5.0")
                    .timeout(10 * 1000)
                    .get();

            Elements elements = doc.select("img");

            for (Element imageElement : elements) {
                String strImageUrl = imageElement.attr("abs:src");
                downloadImage(strImageUrl);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void downloadImage(String strImageUrl) {
        String strImageName = strImageUrl.substring(strImageUrl.lastIndexOf("/") + 1);
        System.out.println("Saving: " + strImageName + ", from: " + strImageUrl);

        try {
            URL urlImage = new URL(strImageUrl);
            InputStream in = urlImage.openStream();
            byte[] buffer = new byte[4096];
            int n;
            OutputStream os = new FileOutputStream(IMAGE_DESTINATION_FOLDER + "/" + strImageName);

            while ((n = in.read(buffer)) != -1) {
                os.write(buffer, 0, n);
            }

            os.close();
            System.out.println("Image saved");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
