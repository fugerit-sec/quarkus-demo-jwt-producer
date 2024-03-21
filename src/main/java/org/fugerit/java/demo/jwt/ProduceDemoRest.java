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
import org.fugerit.java.emp.sm.service.ServiceMessage;
import org.fugerit.java.emp.sm.service.ServiceResponse;

import java.util.List;

@ApplicationScoped
@Path("/produce")
@Slf4j
public class ProduceDemoRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/jwt/{claimKey}/{claimValue}")
    public Response jwt( @PathParam("claimKey") String claimKey, @PathParam("claimValue") String claimValue  ) {
        ProduceDemoResponse sr = new ProduceDemoResponse();
        Response res = null;
        try {
            JwtClaimsBuilder builder1 = Jwt.claims();
            builder1.claim( claimKey, claimValue ).issuer("https://demo.fugerit.org");
            String jwt = builder1.sign();
            sr.setJwt( jwt );
            res = Response.ok().entity( sr ).build();
        } catch (Exception e) {
            sr.setErrors( List.of( new ServiceMessage( "500", ServiceMessage.SEVERITY_ERROR, "Errore : "+e.getMessage() ) ) );
            res = Response.status( Response.Status.INTERNAL_SERVER_ERROR ).entity( sr ).build();
            log.error( "Error : "+e, e );
        }
        return res;
    }

}
