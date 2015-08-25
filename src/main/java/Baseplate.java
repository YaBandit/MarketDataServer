import com.evolve.config.ConfigLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Baseplate {

    private static Logger logger = LogManager.getLogger(Baseplate.class);

    public static void main(String[] args) {

        logger.debug("Starting MDServer");

        try {
            ConfigLoader.loadConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
