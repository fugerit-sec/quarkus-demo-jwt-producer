package org.fugerit.java.demo.jwt;


import org.fugerit.java.emp.sm.service.ServiceResponse;

public class ProduceDemoResponse extends ServiceResponse {

    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
