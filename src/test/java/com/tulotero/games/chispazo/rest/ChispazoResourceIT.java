package com.tulotero.games.chispazo.rest;

import org.junit.Test;

import static io.restassured.RestAssured.when;
import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;

public class ChispazoResourceIT {

    @Test
    public void testGetInfoForDraw3ShouldReturnInfo() throws Exception {
        when().
                get("/tuloterogames/rest/chispazo/draws/{drawId}", 3L).
        then().
                statusCode(200).
                body("winningNumbers", is(asList(5, 8, 10, 15, 15)));

    }

}