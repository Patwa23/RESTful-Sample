package com.navprayas.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	// Matrix Param - http://localhost:8080/messenger/webapi/injectdemo/annotations;param=value
	// Query Param  - http://localhost:8080/messenger/webapi/injectdemo/annotations?param=value
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param")String matrixParam,
											@HeaderParam("customHeaderValue")String header,
											@HeaderParam("authSessionId")String sessionId,
											@CookieParam("cookiesName")String cookies){
		return "Matrix Param :"+matrixParam+",Custom Header Param :"+header+",Auth Session Id :"+sessionId+",Cookies Name :"+cookies;
	}
	
	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo,@Context HttpHeaders header){
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = header.getCookies().toString();
		return "Path :"+path+",Cookies :"+cookies;
	}

}
