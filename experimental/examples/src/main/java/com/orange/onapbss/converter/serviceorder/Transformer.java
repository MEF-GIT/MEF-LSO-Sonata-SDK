package com.orange.onapbss.converter.serviceorder;

import net.sf.saxon.lib.FeatureKeys;
import net.sf.saxon.s9api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.crypto.dsig.TransformException;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


public class Transformer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Transformer.class);

	private static final Processor PROCESSOR = new Processor(false);
	

	private XsltExecutable exec;
	
	public Transformer(String xslFileName, String outputFileName) {

		super();
		
		LOGGER.info("saxon version: " + PROCESSOR.getSaxonProductVersion());
		LOGGER.info("xslFileName: " + xslFileName);		
		LOGGER.info("outputFileName: " + outputFileName);

		// Processor
		if (LOGGER.isDebugEnabled()) {
			PROCESSOR.setConfigurationProperty(FeatureKeys.STANDARD_ERROR_OUTPUT_FILE,
					"saxon.log");
			PROCESSOR.setConfigurationProperty(FeatureKeys.VALIDATION_WARNINGS, true);
		}
		final URL url = getClass().getResource("/xsl/productOrder-to-serviceOrder.xsl");

		String xsltSystemId = url.toExternalForm();
		StreamSource xslSource = new StreamSource();
		xslSource.setSystemId(xsltSystemId);
		InputStream inputStream;
		try {
			inputStream = url.openStream();
			xslSource.setInputStream(inputStream);

			XsltCompiler comp = PROCESSOR.newXsltCompiler();
			this.exec = comp.compile(xslSource);

		}
		catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ExceptionInInitializerError(e);
		}
		catch (SaxonApiException ex) {
			LOGGER.error(ex.getMessage(), ex);
			throw new ExceptionInInitializerError(ex);
		}

	}

	public void run(StreamSource sourceStream, OutputStream outputStream)
			throws TransformException {

		try {

			Serializer out = PROCESSOR.newSerializer(outputStream);

			// source
			XdmNode source = PROCESSOR.newDocumentBuilder().build(sourceStream);

			// transformer
			XsltTransformer trans = this.exec.load();

			trans.setInitialContextNode(source);
			trans.setDestination(out);
			trans.transform();

		}
		catch (SaxonApiException ex) {
			LOGGER.warn("Unable to process transformation");
			throw new TransformException(ex);
		}
	}


}
