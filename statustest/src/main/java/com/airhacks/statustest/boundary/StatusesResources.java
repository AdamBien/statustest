
package com.airhacks.statustest.boundary;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author airhacks.com
 */
@Path("statuses")
public class StatusesResources {

    private static final String STATUS_PARAM = "status";
    private static final String RESPONSE = "+";

    @GET
    @PUT
    @POST
    @DELETE
    @OPTIONS
    public Response get(@HeaderParam(STATUS_PARAM) int status) {
        return createResponse(status);
    }

    Response createResponse(int status) {
        return Response.
                status(status).
                entity(RESPONSE).
                build();
    }


}
