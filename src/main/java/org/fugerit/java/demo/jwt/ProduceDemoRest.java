package org.fugerit.java.demo.jwt;

import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.fugerit.java.emp.sm.service.ServiceMessage;
import org.fugerit.java.emp.sm.service.ServiceResponse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@ApplicationScoped
@Path("/produce")
@Slf4j
public class ProduceDemoRest {

    @RestClient
    ConsumerDemoClient consumerDemoClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/jwt/{nickname}")
    public Response jwt(  @PathParam("nickname") String nickname  ) {
        ProduceDemoResponse sr = new ProduceDemoResponse();
        Response res = null;
        try {
            String jwt = Jwt.issuer("https://demo.fugerit.org")
                    .upn("fugerit79")
                    .groups(new HashSet<>(Arrays.asList("User", "Demo")))
                    .claim( Claims.nickname.name(), nickname )
                    .sign();
            sr.setJwt( jwt );
            log.info( "jwt ok : {}", jwt );
            String authorization = "Bearer "+jwt;
            String consumeDemo = this.consumerDemoClient.jwt( authorization );
            sr.setConsumeDemo( consumeDemo );
            log.info( "consumeDemo ok : {}", consumeDemo );
            res = Response.ok().entity( sr ).build();
        } catch (Exception e) {
            sr.setErrors( List.of( new ServiceMessage( "500", ServiceMessage.SEVERITY_ERROR, "Errore : "+e.getMessage() ) ) );
            res = Response.status( Response.Status.INTERNAL_SERVER_ERROR ).entity( sr ).build();
            log.error( "Error : "+e, e );
        }
        return res;
    }

}
