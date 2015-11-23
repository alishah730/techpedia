package com.techpedia.usermanagement.service.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserManagementServiceExceptionMapper implements ExceptionMapper<UserManagementServiceException> 
{
	@Override
	public Response toResponse(UserManagementServiceException exception) 
	{
		return Response.ok().status(200).entity(exception.toString()).type("application/json").build();

	}
}
