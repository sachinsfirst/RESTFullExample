package com.mkyong.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.mkyong.rest.Model.Visitor;
import com.mkyong.rest.service.VisitorService;

@Path("/registry/visitors")
public class VisitorController {

	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Visitor> getVisitorList() {
		return new VisitorService().getVisitorList();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Visitor getVisitor(@PathParam("id") int id) {
		return new VisitorService().getVisitorById(id);
	}

	@POST
	@Path("/add")
	@Consumes("application/json")
	public Response createProductInJSON(Visitor visitor) {
		new VisitorService().addVisitor(visitor);
		String result = visitor.getName() + " Added Successfully !";
		return Response.status(201).entity(result).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public Response deleteVisitor(@PathParam("id") int id) {
		new VisitorService().deleteVisitorById(id);
		String result = "Visitor Deleted Successfully !";
		return Response.status(201).entity(result).build();
	}

}
