package org.fugerit.java.demo.jwt;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/consume")
@RegisterRestClient(configKey = "consumer-api")
public interface ConsumerDemoClient {

    @GET
    @Path("/jwt")
    String jwt( @HeaderParam("Authorization") String authorization );

}
