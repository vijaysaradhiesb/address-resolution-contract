package com.hubio.integration.services.address.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public interface AddressLookupService {

    @POST
    @Path("/search")
    @Consumes({MediaType.TEXT_XML})
    @Produces({MediaType.TEXT_XML})
    AbstractSearchAddressResponse search(SearchRequest searchRequest);

    @POST
    @Path("/resolve")
    @Consumes({MediaType.TEXT_XML})
    @Produces({MediaType.TEXT_XML})
    AbstractResolveAddressResponse resolve(ResolveRequest resolveRequest);

    @GET
    @Path("/search/{countryCode}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    AbstractSearchAddressResponse search(@PathParam("countryCode") String countryCode, @QueryParam("searchTerm") String searchTerm, @QueryParam("partialAddressId") String partialAddressId);

    @GET
    @Path("/resolve/{addressId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    AbstractResolveAddressResponse resolve(@PathParam("addressId") String addressId);
}
