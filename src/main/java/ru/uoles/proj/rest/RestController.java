package ru.uoles.proj.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import ru.uoles.proj.model.Entity;
import ru.uoles.proj.service.PaymentService;
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

		String response = (result != null && !result.isEmpty()) ? result.get(0).getText() : "List is empty";
		return Response.status(200)
				.entity("Hello World from rest service! Response: " + response)
				.build();
	}
}