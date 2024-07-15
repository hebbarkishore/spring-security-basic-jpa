package com.security.spring.example.config.restclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;
  
import java.io.IOException;
import java.nio.charset.Charset;
 
/**
 * 
 * @author hebbaki - Kishore Hebbar
 *
 */ 

public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {
      
    private final Logger log = LoggerFactory.getLogger(this.getClass());
  
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException 
    {
        logRequest(request, body);
        //log.info("inside the intercept about the execute");
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        //log.info("completed the intercept");
 
        //Add optional additional headers
        //response.getHeaders().add("headerName", "VALUE");
 
        return response;
    }
  
    private void logRequest(HttpRequest request, byte[] body) throws IOException 
    {
        //if (log.isDebugEnabled()) 
        {
            log.info("===========================request begin================================================");
            log.info("Request URI         : {}", request.getURI());
            log.info("Request Method      : {}", request.getMethod());
            log.info("Request Headers     : {}", request.getHeaders());
            log.info("Request body: {}", new String(body, "UTF-8"));
            log.info("==========================request end================================================");
        }
    }
  
    private void logResponse(ClientHttpResponse response) throws IOException 
    {
        //if (log.isDebugEnabled()) 
        {
            log.info("============================response begin==========================================");
            log.info("Response Status code  : {}", response.getStatusCode());
            log.info("Response Status text  : {}", response.getStatusText());
            log.info("Response Headers      : {}", response.getHeaders());
            log.info("Response body: {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
            log.info("=======================response end=================================================");
        }
    }
}