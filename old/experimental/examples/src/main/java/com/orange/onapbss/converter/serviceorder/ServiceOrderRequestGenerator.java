package com.orange.onapbss.converter.serviceorder;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public interface ServiceOrderRequestGenerator {


    /**
     * @param resource
     * @param outputStream
     */
    public void writeServiceOrderRequest(JsonNode resource, OutputStream outputStream);


    /**
     * @param jsonDocument
     * @param outputStream
     */
    public void writeDocument(String jsonDocument, OutputStream outputStream);


    public void writeMinimizedJson(String jsonDocument, OutputStream minimizedJsonOs);

    public void writeMinimizedJson(ByteArrayOutputStream jsonOs, OutputStream minimizedJsonOs);


}
