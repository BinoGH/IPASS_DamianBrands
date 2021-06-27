package nl.damian.IPASS.persistence;

import nl.damian.IPASS.domein.Gebruiker;
import reactor.core.scheduler.Schedulers;
import reactor.netty.http.HttpResources;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.Duration;

@WebListener
public class PersistenceListener implements ServletContextListener {
    PersistenceManager persistenceManager = new PersistenceManager();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Gebruiker.createGebruiker("admin@mail", "eend", true);
        Gebruiker.createGebruiker("user@mail", "pinguin", false);
        Gebruiker.createGebruiker("user2@mail", "dolfijn", false);
        try{
            persistenceManager.loadBlobba();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try{
            persistenceManager.saveBlobba();

        }catch (Exception e){
            e.printStackTrace();
        }
        Schedulers.shutdownNow();
        HttpResources.disposeLoopsAndConnectionsLater(Duration.ZERO, Duration.ZERO).block();
    }
}
