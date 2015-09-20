package com.evolve.restserver;

import com.evolve.restserver.resources.UnixCommandResource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;

public class ServerBaseplate extends org.restlet.Application {

    private static Logger logger = LogManager.getLogger(ServerBaseplate.class);

    public static final String ROOT_URI = "file:///c:/PROGRAMMING/GitMDServer/MarketDataServer/WebRoot/content";

    private static final int PORT = 9001;

    public void startServer() throws Exception {
        logger.info("Starting Application ...");

        final Component component = new Component();
        component.getServers().add(Protocol.HTTP, PORT);
        component.getClients().add(Protocol.FILE);

        // Create an application
        Application application = new Application() {
            @Override
            public Restlet createInboundRoot() {
                return new Directory(getContext(), ROOT_URI);
            }
        };

        component.getDefaultHost().attach(application);

        final String contextRoot = "/api";
        component.getDefaultHost().attach(contextRoot, this);

        component.start();

        logger.info("Rest Server Started");
        logger.info("URL: http://localhost:9001");
    }

    @Override
    public Restlet createInboundRoot() {
        return createTheRouter();
    }

    private Router createTheRouter() {
        Router router = new Router(getContext());

        router.attach("/unix", UnixCommandResource.class);

        return router;
    }

}
