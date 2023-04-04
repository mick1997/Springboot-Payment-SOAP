package com.snva.soap.payments.endpoints;

import com.snva.xml.user.User;
import com.snva.xml.user.UserDetailsRequest;
import com.snva.xml.user.UserDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    private static final String USER_NAMESPACE_URI = "http://snva.com/xml/user";

    @PayloadRoot(namespace = USER_NAMESPACE_URI, localPart = "userDetailsRequest")
    @ResponsePayload
    public UserDetailsResponse getUser (@RequestPayload UserDetailsRequest userDetailsRequest ) {
        UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
        User user = new User();
        user.setFirstName(userDetailsRequest.getFirstName());
        user.setLastName("Test");
        user.setContact("123456789");
        user.setAge(32);
        userDetailsResponse.setUser(user);
        return  userDetailsResponse;
    }
}
