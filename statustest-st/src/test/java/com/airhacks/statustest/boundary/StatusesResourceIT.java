/*
 */
package com.airhacks.statustest.boundary;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class StatusesResourceIT {

    static final String STATUS_HEADER_PARAM = "status";
    private WebTarget tut;

    @Before
    public void initClient() {
        this.tut = ClientBuilder.newClient().target("http://localhost:8080/statustest/resources/statuses");
    }


    @Test
    public void get() {
        int expected = 205;

        Response response = tut.
                request().
                header(STATUS_HEADER_PARAM, expected).
                get();
        assertThat(response.getStatus(), is(expected));

        expected = 203;
        response = tut.
                request().
                header(STATUS_HEADER_PARAM, expected).
                get();
        assertThat(response.getStatus(), is(expected));

    }

    @Test
    public void post() {
        int expected = 205;

        Response response = tut.
                request().
                header(STATUS_HEADER_PARAM, expected).
                post(Entity.text(""));
        assertThat(response.getStatus(), is(expected));

        expected = 203;
        response = tut.
                request().
                header(STATUS_HEADER_PARAM, expected).
                post(Entity.text(""));
        assertThat(response.getStatus(), is(expected));
    }

    @Test
    public void put() {
        int expected = 205;

        Response response = tut.
                request().
                header(STATUS_HEADER_PARAM, expected).
                put(Entity.text(""));
        assertThat(response.getStatus(), is(expected));

        expected = 203;
        response = tut.
                request().
                header(STATUS_HEADER_PARAM, expected).
                put(Entity.text(""));
        assertThat(response, is(expected));
    }

    @Test
    public void delete() {
        int expected = 205;

        Response response = tut.
                request().
                header(STATUS_HEADER_PARAM, expected).
                delete();
        assertThat(response, is(expected));

        expected = 203;
        response = tut.
                request().
                header(STATUS_HEADER_PARAM, expected).
                delete();
        assertThat(response, is(expected));
    }

    @Test
    public void options() {
        int expected = 205;

        Response response = tut.
                request().
                header(STATUS_HEADER_PARAM, expected).
                options();
        assertThat(response, is(expected));

        expected = 203;
        response = tut.
                request().
                header(STATUS_HEADER_PARAM, expected).
                options();
        assertThat(response, is(expected));
    }

}
