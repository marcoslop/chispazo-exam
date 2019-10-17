package com.tulotero.games.chispazo;

import com.tulotero.games.chispazo.beans.ChispazoDraw;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

public class ChispazoDrawServiceTest {

    ChispazoDrawService service;

    @Mock
    ChispazoDrawStore store;

    ChispazoDraw draw1;
    ChispazoDraw draw2;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        service = new ChispazoDrawService();
        service.store = store;

        draw1 = givenDraw(1L);
        draw2 = givenDraw(2L);
        doReturn(asList(draw1, draw2)).when(store).getDraws();
    }

    @Test
    public void getDraw_idFound() {
        Optional<ChispazoDraw> drawOpt = service.getDraw(draw1.getDrawId());

        assertThat(drawOpt.isPresent(), is(true));
        assertThat(drawOpt.get().getDrawId(), is(draw1.getDrawId()));
    }

    @Test
    public void getDraw_idNotFound() {
        Optional<ChispazoDraw> drawOpt = service.getDraw(10L);

        assertThat(drawOpt.isPresent(), is(false));
    }

    private ChispazoDraw givenDraw(Long drawId){
        return ChispazoDraw.finished(
                drawId,
                new DateTime().minusDays(1).toDate(),
                asList(5, 10, 15, 20, 25),
                null
        );
    }
}