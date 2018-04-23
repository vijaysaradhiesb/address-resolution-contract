package com.integ.integration.services.address.api;

import com.integ.integration.services.contracts.common.GenericInternalServerException;
import org.apache.camel.Body;
import org.apache.camel.Header;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public interface AddressLookupService {

    @POST
    @Path("/search")
    @Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
    SearchResponse search(@Body SearchRequest searchRequest) throws BadRequestException, TimedOutException, GenericInternalServerException;

    @POST
    @Path("/resolve")
    @Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
    ResolutionResponse resolve(@Body ResolveRequest resolveRequest) throws BadRequestException, TimedOutException, AddressIdNotFoundException, GenericInternalServerException;

    @GET
    @Path("/search/{countryCode}")
    @Produces({MediaType.APPLICATION_JSON})
    SearchResponse search(@PathParam("countryCode") String countryCode, @QueryParam("searchTerm") String searchTerm, @QueryParam("partialAddressId") String partialAddressId) throws BadRequestException, TimedOutException;

    @GET
    @Path("/resolve")
    @Produces({MediaType.APPLICATION_JSON})
    ResolutionResponse resolve(@QueryParam("addressId") @Header("addressId") String addressId) throws BadRequestException, TimedOutException, AddressIdNotFoundException;
}
