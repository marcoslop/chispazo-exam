package com.tulotero.games.chispazo.rest;

import org.junit.Test;

import static io.restassured.RestAssured.when;
import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;

public class ChispazoResourceIT {

    @Test
    public void testNextOpenedDrawShouldReturnDraw1() throws Exception {
        when().
                get("/chispazo/rest/chispazo/draws/opened/next").
        then().
                statusCode(200).
                body("drawId", is(3));
    }

}