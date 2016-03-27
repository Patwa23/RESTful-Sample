package com.navprayas.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.navprayas.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errMsg=new ErrorMessage(ex.getMessage(), 404, "Testing for Data Not Found Exception Mapper");
		return Response.status(Status.NOT_FOUND)
				       .entity(errMsg)
					   .build();
	}

}
