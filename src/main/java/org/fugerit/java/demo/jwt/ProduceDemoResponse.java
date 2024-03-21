package org.fugerit.java.demo.jwt;


import lombok.Getter;
import lombok.Setter;
import org.fugerit.java.emp.sm.service.ServiceResponse;

public class ProduceDemoResponse extends ServiceResponse {

    @Getter @Setter
    private String jwt;

    @Getter @Setter
    private String consumeDemo;

}
