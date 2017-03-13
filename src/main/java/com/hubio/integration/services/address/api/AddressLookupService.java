package com.hubio.integration.services.address.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Saradhi on 09/09/2016.
 */
public interface AddressLookupService {

    @POST
    @Path("/search")
    @Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
    AbstractAddressLookupResponse search(SearchRequest searchRequest);

    @GET
    @Path("/resolve/{id}")
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
    AbstractAddressLookupResponse resolve(@PathParam("id") String id);
}
