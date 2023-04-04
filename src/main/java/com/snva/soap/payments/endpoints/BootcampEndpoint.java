package com.snva.soap.payments.endpoints;

import com.snva.ex.soap.xml.bootcamp.Bootcamp;
import com.snva.ex.soap.xml.bootcamp.GetBootcampRequest;
import com.snva.ex.soap.xml.bootcamp.GetBootcampResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BootcampEndpoint {

    private static final String BOOTCAMP_NAMESPACE_URI = "http://snva.com/ex/soap/xml/bootcamp";

    @PayloadRoot(namespace = BOOTCAMP_NAMESPACE_URI, localPart = "getBootcampRequest")
    @ResponsePayload
    public GetBootcampResponse getBootcamp(@RequestPayload GetBootcampRequest request) {
        GetBootcampResponse response = new GetBootcampResponse();
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setBootcampName(request.getBootcampName());
        bootcamp.setDetails("This is the best test data later we will connect mongodb here");
        bootcamp.setInstructor("Viet");
        response.setBootcamp(bootcamp);
        return response;
    }
}
