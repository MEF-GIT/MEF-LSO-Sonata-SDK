package com.orange.soa.commons.resource.mapper;

import com.orange.soa.commons.exception.TechnicalException;
import com.orange.soa.commons.resource.mapper.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author maig7313
 */
@Provider
public class TechnicalMapper implements ExceptionMapper<TechnicalException> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(com.orange.soa.commons.resource.mapper.TechnicalMapper.class);

	@Override
	public Response toResponse(TechnicalException ex) {
		LOGGER.error(
				"Do not panic, this is a handled error, but you have to fix this",
				ex.getMessage());
		LOGGER.error(ex.getCode().toString());
		return ErrorResponse.build(ex);
	}

}
