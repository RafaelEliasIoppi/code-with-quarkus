package org.acme;

import jarkata.json.bind.annotation.JsonbProperty;
import jarkata.ws.rs.*;
import jarkata.ws.rs.core.MediaType;
import jarkata.ws.rs.core.Response;

@path("/conversionKnotToKm"/{value}")
public class ConversionKnotToKm {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertKnotToKm(@PathParam("value") float knots) {
        float km = knots * 1.852f;
        return Response.ok(new ConversionResult(value, km)).build();
    }

    public static class ConversionResult {
        @JsonbProperty("value")
        public float value;

        @JsonbProperty("km")
        public float km;

        public ConversionResult(float value, float km) {
            this.value = value;            
            this.km = km;
        }
    }
}


