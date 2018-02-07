package com.orange.onapbss.converter.serviceorder;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.onapbss.exception.Technical;
import com.orange.onapbss.exception.TechnicalException;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.xml.crypto.dsig.TransformException;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.charset.Charset;

@Service("serviceOrderRequestGenerator")
public class ServiceOrderRequestGeneratorImpl implements ServiceOrderRequestGenerator {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ServiceOrderRequestGeneratorImpl.class);


    private Transformer transformerXmlToJson;

    @PostConstruct
    private void initialize() {
        transformerXmlToJson = new Transformer("/xsl/productOrder-to-serviceOrder.xsl", "serviceOrderCompleted.json");

    }


    @Override
    public void writeDocument(String document, OutputStream outputStream) {
        try {
            outputStream.write(document.getBytes(Charset.forName("UTF-8")));
        } catch (IOException e) {

            throw new TechnicalException(Technical.GENERIC,
                    "Unable to write document for api id=" + document);
        }
    }


    @Override
    public void writeMinimizedJson(String jsonDocument, OutputStream outputStream) {

        ObjectMapper mapper = new ObjectMapper(new JsonFactory());
        JsonNode jsonNodeTree;
        try {
            jsonNodeTree = new ObjectMapper().readTree(jsonDocument);
            mapper.writeValue(outputStream, jsonNodeTree);
        } catch (Exception e) {
            final String errorMessage = "Unable to produce json content";
            LOGGER.error(errorMessage, e);
            throw new TechnicalException(Technical.GENERIC, errorMessage);
        }

    }

    @Override
    public void writeMinimizedJson(ByteArrayOutputStream jsonOutPutStream, OutputStream outputStream) {

        // Get json as String
        String jsonDocument;
        try {
            jsonDocument = jsonOutPutStream.toString("UTF-8");
            this.writeMinimizedJson(jsonDocument, outputStream);
        } catch (UnsupportedEncodingException e) {
            final String errorMessage = "Unable to produce json content";
            LOGGER.error(errorMessage, e);
            throw new TechnicalException(Technical.GENERIC, errorMessage);
        }


    }

    public void writeServiceOrderRequest(JsonNode resource, OutputStream output) {
        final JSONObject jsonObject = new JSONObject(resource.toString());
        LOGGER.info("resource "+resource.toString());
        String xml = "<productorder>" + XML.toString(jsonObject) + "</productorder>";
        xml = xml.replaceAll("@", "meta");
        StreamSource streamSource = createStreamSource(xml);
        try {
            transformerXmlToJson.run(streamSource, output);

        } catch (TransformException e) {
            final String errorMessage = "Unable to produce json content";
            LOGGER.error(errorMessage, e);
            throw new TechnicalException(Technical.GENERIC, errorMessage);
        }

    }


    private StreamSource createStreamSource(String resource) {

        return new StreamSource(new StringReader(resource));
    }

}
