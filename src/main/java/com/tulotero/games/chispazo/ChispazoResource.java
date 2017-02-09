package com.tulotero.games.chispazo;

import com.tulotero.games.chispazo.beans.ChispazoBet;
import com.tulotero.games.chispazo.beans.ChispazoDraw;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/chispazo")
@Produces(MediaType.APPLICATION_JSON)
public class ChispazoResource {

    @Inject
    ChispazoDrawService drawService;

    @Inject
    ChispazoPrizeCalculator prizeCalculator;

    @Path("/draw/{drawId}")
    @GET
    public Response getDrawInfo(@PathParam("drawId") Long drawId){
        Optional<ChispazoDraw> drawOpt = drawService.getDraw(drawId);
        if (drawOpt.isPresent()){
            return Response.status(Response.Status.OK)
                    .entity(drawOpt.get())
                    .build();
        }else{
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
    }

    @Path("/draw/{drawId}/prize")
    @POST
    public Response calculatePrizeInfo(@PathParam("drawId") Long drawId,
                                        ChispazoBet bet){
        throw new UnsupportedOperationException("To be developed following the tests in ChispazoResourceTest");
    }

}
