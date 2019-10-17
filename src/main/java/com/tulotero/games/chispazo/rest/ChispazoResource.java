package com.tulotero.games.chispazo.rest;

import com.tulotero.games.beans.PrizeInfo;
import com.tulotero.games.chispazo.ChispazoDrawService;
import com.tulotero.games.chispazo.ChispazoPrizeCalculator;
import com.tulotero.games.chispazo.beans.ChispazoBet;
import com.tulotero.games.chispazo.beans.ChispazoDraw;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/chispazo")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/Chispazo", description = "Chispazo Game API")
public class ChispazoResource {

    @Inject
    ChispazoDrawService drawService;

    @Inject
    ChispazoPrizeCalculator prizeCalculator;

    @Path("/draws/{drawId}")
    @GET
    @ApiOperation(value = "Returns information about a Chispazo Draw",
            response = ChispazoDraw.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok. Information with the Chispazo Draw"),
            @ApiResponse(code = 404, message = "No Chispazo found for the Id passed as argument"),
    })
    public Response getDrawInfo(@PathParam("drawId") Long drawId){
        Optional<ChispazoDraw> drawOpt = drawService.getDraw(drawId);
        if (drawOpt.isPresent()){
            return createResponseDraw(drawOpt.get());
        }else{
            return createResponseNotFound();
        }
    }

    @Path("/draws/{drawId}/prize")
    @POST
    @ApiOperation(value = "Check the prize of a Bet for a draw.",
            notes = "The bet and the draw id is sended. The prize is returned",
            response = PrizeInfo.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Information with the prize for this bet is returned"),
            @ApiResponse(code = 404, message = "No Chispazo found for the Id passed as argument"),
    })
    public Response calculatePrizeInfo(@PathParam("drawId") Long drawId,
                                        ChispazoBet bet){
        throw new UnsupportedOperationException("To be developed following the tests in ChispazoResourceTest");
    }

    private Response createResponseDraw(ChispazoDraw draw) {
        return Response.status(Response.Status.OK)
                .entity(draw)
                .build();
    }

    private Response createResponseNotFound() {
        return Response.status(Response.Status.NOT_FOUND)
                .build();
    }

}
