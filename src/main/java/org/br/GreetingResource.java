package org.br;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/hello")
public class GreetingResource {

	@Inject
	Teste teste;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    	System.out.println(teste.retornaString());
        return "Hello from RESTEasy Reactive";
    }
}
