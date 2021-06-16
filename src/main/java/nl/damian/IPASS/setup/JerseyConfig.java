package nl.damian.IPASS.setup;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("restservices")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        packages("nl.damian.IPASS.webservices");
    }
}
