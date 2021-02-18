package com.tulotero.games.chispazo.rest;

import com.tulotero.games.beans.PrizeInfo;
import com.tulotero.games.beans.ScrutinyPrize;
import com.tulotero.games.chispazo.ChispazoDrawService;
import com.tulotero.games.chispazo.prizes.ChispazoPrizeCalculator;
import com.tulotero.games.chispazo.beans.ChispazoBet;
import com.tulotero.games.chispazo.beans.ChispazoDraw;
import com.tulotero.games.chispazo.beans.ChispazoPrizeCheck;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;

import java.util.Optional;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ChispazoResourceTest {

    ChispazoResource resource;

    @Mock
    ChispazoDrawService drawService;

    @Mock
    ChispazoPrizeCalculator prizeCalculator;

    private static Long DRAW_ID = 1L;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        resource = new ChispazoResource();
        resource.drawService = drawService;
        resource.prizeCalculator = prizeCalculator;
    }

    @Test
    public void getGetDrawInfo_shouldReturnOkIfDrawIsFound() throws Exception {
        ChispazoDraw draw = givenDraw(DRAW_ID);
        when(drawService.getDraw(DRAW_ID)).thenReturn(Optional.of(draw));

        Response response = resource.getDrawInfo(DRAW_ID);

        assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));
        assertThat(response.getEntity(), is(draw));
    }

    @Test
    public void getGetDrawInfo_shouldNotFoundIfDrawIsNotFound() throws Exception {
        when(drawService.getDraw(DRAW_ID)).thenReturn(Optional.empty());

        Response response = resource.getDrawInfo(DRAW_ID);

        assertThat(response.getStatus(), is(Response.Status.NOT_FOUND.getStatusCode()));
    }

    @Test
    public void calculatePrizeInfo_shouldReturnPrizeOk() throws Exception {
        ChispazoBet bet = givenBet();
        ChispazoDraw draw = givenDraw(DRAW_ID);
        when(drawService.getDraw(DRAW_ID)).thenReturn(Optional.of(draw));
        ChispazoPrizeCheck prizeCheck = new ChispazoPrizeCheck(bet, draw);
        PrizeInfo prizeInfo = new PrizeInfo(10D, asList(1,2,3));
        when(prizeCalculator.calculatePrize(prizeCheck)).thenReturn(prizeInfo);

        Response response = resource.calculatePrizeInfo(DRAW_ID, bet);

        assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));
        assertThat(response.getEntity(), is(prizeInfo));
        verify(prizeCalculator).calculatePrize(prizeCheck);
    }

    @Test
    public void calculatePrizeInfo_shouldReturnNotFoundIfDrawNotExists() throws Exception {
        ChispazoBet bet = givenBet();
        when(drawService.getDraw(DRAW_ID)).thenReturn(Optional.empty());

        Response response = resource.calculatePrizeInfo(DRAW_ID, bet);

        assertThat(response.getStatus(), is(Response.Status.NOT_FOUND.getStatusCode()));
    }

    private ChispazoDraw givenDraw(Long drawId){
        return ChispazoDraw.finished(
                drawId,
                new DateTime().minusDays(1).toDate(),
                asList(5, 10, 15, 20, 25),
                asList(
                        new ScrutinyPrize(5, 1000000D),
                        new ScrutinyPrize(4, 100000D),
                        new ScrutinyPrize(3, 1000D),
                        new ScrutinyPrize(2, 10D),
                        new ScrutinyPrize(1, 1D)
                )
        );
    }

    private ChispazoBet givenBet(){
        return new ChispazoBet(
                asList(1,2,3,4,5)
        );
    }
}