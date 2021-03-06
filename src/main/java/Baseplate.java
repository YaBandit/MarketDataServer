import com.evolve.config.ConfigLoader;
import com.evolve.data.DataManager;
import com.evolve.restserver.ServerBaseplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Baseplate {

    private static Logger logger = LogManager.getLogger(Baseplate.class);
    private static final ServerBaseplate serverBaseplate = new ServerBaseplate();
    private static final ConfigLoader configLoader = new ConfigLoader();
    private static DataManager dataManager;

    public static void main(String[] args) {



        logger.debug("Starting MDServer");

        dataManager = DataManager.getINSTANCE();
        /*
        try {
            configLoader.loadConfig("src/main/Config");
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
