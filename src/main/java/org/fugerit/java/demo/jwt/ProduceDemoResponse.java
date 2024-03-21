package org.fugerit.java.demo.jwt;


import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import org.fugerit.java.emp.sm.service.ServiceResponse;

@RegisterForReflection
public class ProduceDemoResponse extends ServiceResponse {

    @Getter @Setter
    private String jwt;

    @Getter @Setter
    private String consumeDemo;

}
