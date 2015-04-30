package fr.istic.tpjpaservlet.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.tpjpaservlet.domain.Heater;
import fr.istic.tpjpaservlet.domain.Home;

@Path("/hello")
public class SampleWebService {
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }

    @GET
    @Path("/home")
    @Produces(MediaType.APPLICATION_JSON)
    public Home getHome() {
        Home h = new Home();
        h.setAdresse("33,rue boulanger bat 508 35700");
        Heater h1 = new Heater();
        h1.setConso_equipment("500w");
        Heater h2 = new Heater();
        h2.setConso_equipment("600w");
        h.addDevice(h1);
        h.addDevice(h2);
        return h;
    }
}

