package com.hubio.integration.services.address.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public interface AddressLookupService {

    @POST
    @Path("/search")
    @Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
    AbstractSearchAddressResponse search(SearchRequest searchRequest);

    @POST
    @Path("/resolve")
    @Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
    AbstractResolveAddressResponse resolve(ResolveRequest resolveRequest);
}
