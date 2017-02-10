package com.tulotero.games.chispazo.rest;

import org.junit.Test;

import static io.restassured.RestAssured.when;
import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;

public class ChispazoResourceIT {

    @Test
    public void testGetInfoForDraw3ShouldReturnInfo() throws Exception {
        when().
                get("/chispazo/rest/chispazo/draws/{drawId}", 4L).
        then().
                statusCode(200).
                body("winningNumbers", is(asList(5, 8, 10, 15, 25)));

    }

    @Test
    public void testGetActiveDrawShouldReturnDraw1() throws Exception {
        when().
                get("/chispazo/rest/chispazo/draws/next").
        then().
                statusCode(200).
                body("drawId", is(2));
    }

}