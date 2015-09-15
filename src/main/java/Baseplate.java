import com.evolve.config.ConfigLoader;
import com.evolve.restserver.ServerBaseplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Baseplate {

    private static Logger logger = LogManager.getLogger(Baseplate.class);

    private static final ServerBaseplate serverBaseplate = new ServerBaseplate();

    public static void main(String[] args) {

        logger.debug("Starting MDServer");

        /*
        try {
            ConfigLoader.loadConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        try {
            serverBaseplate.startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
