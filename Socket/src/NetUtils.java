import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by alex on 17.02.17.
 */
public class NetUtils {

    public static void load(String url, String dest)
            throws URISyntaxException, IOException {
        InputStream is = new URI(url).toURL().openStream();
        OutputStream os = new FileOutputStream(dest);

        byte[] buff = new byte[8000];
        int count = 0;

        while((count = is.read(buff)) != -1){
            os.write(buff, 0, count);
            os.flush();
        }

    }
}
