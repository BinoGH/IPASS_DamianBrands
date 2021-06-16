package nl.damian.IPASS.persistence;

import nl.damian.IPASS.Classes.Gebruiker;
import reactor.core.scheduler.Schedulers;
import reactor.netty.http.HttpResources;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.Duration;

@WebListener
public class PersistenceListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Gebruiker.createGebruiker("mail@mail", "pinguin", true);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Schedulers.shutdownNow();
        HttpResources.disposeLoopsAndConnectionsLater(Duration.ZERO, Duration.ZERO).block();
    }
}
