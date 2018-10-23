package com.orange.onapbss.serviceorder;

import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.orange.onapbss.exception.Technical;
import com.orange.onapbss.exception.TechnicalException;

@Service
public class ServiceOrderProcessor {


    @Value("${serviceorder.url}")
    private String url;

    @Value("${serviceorder.authorization}")
    private String authorization;

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ServiceOrderProcessor.class);


    public JSONObject postServiceOrder(byte[] stream) {
    	
        DefaultHttpClient httpClient = new DefaultHttpClient();

        LOGGER.info("service order url used: " + this.getUrl());
        try {

            HttpPost postRequest = new HttpPost(getUrl());
            postRequest.addHeader("content-type", "application/json");
            postRequest.addHeader("Authorization", authorization); 

            ByteArrayEntity b = new ByteArrayEntity(stream);
            postRequest.setEntity(b);
            HttpResponse response = httpClient.execute(postRequest);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode != 201) {
                LOGGER.warn("Unable to call service order " + getUrl() + ", return: " + statusCode + " " + response.getStatusLine().getReasonPhrase());
            }
            HttpEntity httpEntity = response.getEntity();
            JSONObject parse = parse(httpEntity);
            return parse;

        } catch (Exception e) {
            LOGGER.warn("Unable to call service order ");
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return null;
    }


    public JSONObject parse(HttpEntity httpEntity) {
        JSONParser parser = new JSONParser();
        Object obj;
        try {
            obj = parser.parse(new InputStreamReader(httpEntity.getContent()));
        } catch (IOException e) {
            throw new TechnicalException(Technical.GENERIC,
                    "Unable to read the service order response ");
        } catch (ParseException e) {
            throw new TechnicalException(Technical.GENERIC,
                    "Unable to read the service order response ");
        }

        return (JSONObject) obj;
    }


    public JSONObject getServiceOrder(String serviceOrderId) {
    	
        DefaultHttpClient httpClient = new DefaultHttpClient();

        try {

            LOGGER.info("service order url: "+ this.getUrl());
            String requestUrl = getUrl() + "/" + serviceOrderId;
            
            HttpGet getRequest = new HttpGet(requestUrl);
            getRequest.addHeader("accept", "application/json");
            getRequest.addHeader("Authorization", authorization);
            
            HttpResponse response = httpClient.execute(getRequest);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                LOGGER.warn("Unable to call service order " + getUrl() + ", return: " + statusCode + " " + response.getStatusLine().getReasonPhrase());
            }
            HttpEntity httpEntity = response.getEntity();
            JSONObject parse = parse(httpEntity);

            return parse;


        } catch (Exception e) {
            LOGGER.warn("Unable to call service order ");
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return null;
    }

    private String getUrl() {
        return url;
    }


}
