package br.com.felipe.resource;

import br.com.felipe.dto.CreateExpenseRequest;
import br.com.felipe.service.ExpenseService;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/expenses")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExpenseResource {

        @Inject
        ExpenseService service;

        @POST
        public Response create(
                        @Valid CreateExpenseRequest request) {

                return Response
                                .status(201)
                                .entity(
                                                service.create(request))
                                .build();

        }

        @GET
        public Response list() {

                return Response.ok(
                                service.list()).build();

        }

        @GET
        @Path("/summary")
        public Response summary() {

                return Response.ok(
                                service.summary()).build();

        }

}