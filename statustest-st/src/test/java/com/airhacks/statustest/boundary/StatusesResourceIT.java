/*
 */
package com.airhacks.statustest.boundary;

import com.airhacks.rulz.jaxrsclient.JAXRSClientProvider;
import static com.airhacks.rulz.jaxrsclient.JAXRSClientProvider.buildWithURI;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Rule;
import org.junit.Test;
import static com.airhacks.rulz.jaxrsclient.HttpMatchers.statusCode;

/**
 *
 * @author airhacks.com
 */
public class StatusesResourceIT {

    static final String STATUS_HEADER_PARAM = "status";

    @Rule
    public JAXRSClientProvider client = buildWithURI("http://localhost:8080/statustest/resources/statuses");

    @Test
    public void get() {
        int expected = 205;

        Response response = client.target().
                request().
                header(STATUS_HEADER_PARAM, expected).
                get();
        assertThat(response.getStatus(), is(expected));

        expected = 203;
        response = client.target().
                request().
                header(STATUS_HEADER_PARAM, expected).
                get();
        assertThat(response, is(statusCode(expected)));
    }

    @Test
    public void post() {
        int expected = 205;

        Response response = client.target().
                request().
                header(STATUS_HEADER_PARAM, expected).
                post(Entity.text(""));
        assertThat(response.getStatus(), is(expected));

        expected = 203;
        response = client.target().
                request().
                header(STATUS_HEADER_PARAM, expected).
                post(Entity.text(""));
        assertThat(response, is(statusCode(expected)));
    }

    @Test
    public void put() {
        int expected = 205;

        Response response = client.target().
                request().
                header(STATUS_HEADER_PARAM, expected).
                put(Entity.text(""));
        assertThat(response.getStatus(), is(expected));

        expected = 203;
        response = client.target().
                request().
                header(STATUS_HEADER_PARAM, expected).
                put(Entity.text(""));
        assertThat(response, is(statusCode(expected)));
    }

    @Test
    public void delete() {
        int expected = 205;

        Response response = client.target().
                request().
                header(STATUS_HEADER_PARAM, expected).
                delete();
        assertThat(response, is(statusCode(expected)));

        expected = 203;
        response = client.target().
                request().
                header(STATUS_HEADER_PARAM, expected).
                delete();
        assertThat(response, is(statusCode(expected)));
    }

    @Test
    public void options() {
        int expected = 205;

        Response response = client.target().
                request().
                header(STATUS_HEADER_PARAM, expected).
                options();
        assertThat(response, is(statusCode(expected)));

        expected = 203;
        response = client.target().
                request().
                header(STATUS_HEADER_PARAM, expected).
                options();
        assertThat(response, is(statusCode(expected)));
    }

}
