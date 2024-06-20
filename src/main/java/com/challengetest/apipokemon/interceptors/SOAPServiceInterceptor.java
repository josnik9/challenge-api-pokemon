package com.challengetest.apipokemon.interceptors;

import com.challengetest.apipokemon.api.v1.usecases.bundaries.RequestBoundary;
import com.sun.xml.messaging.saaj.soap.ver1_1.BodyElement1_1Impl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.SoapBody;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;

import javax.xml.transform.dom.DOMSource;
import java.util.Date;

@Component
public class SOAPServiceInterceptor implements EndpointInterceptor {

    private static final String REGEX_IP = "^((25[0-5]|(2[0-4]|1[0-9]|[1-9]|)[0-9])(\\.(?!$)|$)){4}$";
    private static final String[] HEADERS_REQUEST = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"
    };

    private final RequestBoundary requestBoundary;

    public SOAPServiceInterceptor(RequestBoundary requestBoundary) {
        this.requestBoundary = requestBoundary;
    }

    @Override
    public boolean handleRequest(MessageContext messageContext, Object o) throws Exception {
        String ip = getClientIp();
        String actionName = getActionName(messageContext);
        saveRequest(ip, actionName);

        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object o) {
        return false;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object o) {
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object o, Exception e) {}

    private String getClientIp() throws Exception {
        HttpServletRequest request = getRequest();

        for (String header : HEADERS_REQUEST) {
            String ip = request.getHeader(header);
            if (StringUtils.hasLength(ip) && ip.matches(REGEX_IP)) {
                return ip;
            }
        }

        if (request.getRemoteAddr().matches(REGEX_IP)) {
            return request.getRemoteAddr();
        }

        throw new Exception("Something went wrong");
    }

    private HttpServletRequest getRequest() {
        TransportContext context = TransportContextHolder.getTransportContext();
        HttpServletConnection connection = (HttpServletConnection)context.getConnection();
        return connection.getHttpServletRequest();
    }

    private String getActionName(MessageContext messageContext) {
        SaajSoapMessage saajSoapMessage = (SaajSoapMessage) messageContext.getRequest();
        SoapBody soapBody =  saajSoapMessage.getSoapBody();
        DOMSource domSource = (DOMSource) soapBody.getPayloadSource();
        BodyElement1_1Impl bodyElement11 = (BodyElement1_1Impl) domSource.getNode();
        return bodyElement11.getElementQName().getLocalPart();
    }

    private void saveRequest(String ip, String actionName) {
        requestBoundary.save(ip, new Date(), actionName);
    }
}
