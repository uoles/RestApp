package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.mkyong.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Path("/payment")
@Controller
public class RestController {

	@Autowired
	private PaymentService paymentService;

	@GET
	@Path("/mkyong")
	public Response savePayment() {
		String result = paymentService.savePayment();
		return Response.status(200).entity(result).build();
	}
}