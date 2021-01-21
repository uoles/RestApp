package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.mkyong.model.Entity;
import com.mkyong.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Path("/payment")
@Controller
public class RestController {

	@Autowired
	private PaymentService paymentService;

	@GET
	@Path("/getEntities")
	public Response getEntities() {
		List<Entity> result = paymentService.getEntities();
		return Response.status(200).entity("ok").build();
	}
}