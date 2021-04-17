package ru.uoles.proj.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.uoles.proj.model.Entity;
import ru.uoles.proj.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.uoles.proj.util.ObjectConverter;

import java.util.List;

@Path("/payment")
@Controller
public class RestController {

	@Autowired
	private PaymentService paymentService;

	@GET
	@Path("/getEntities/{param}")
	public Response getEntities(@PathParam("param") String param) {
		System.out.println("Request getEntities: " + param);

		List<Entity> result = paymentService.getEntities(param);
		String response = ObjectConverter.toJson(result);

		return Response.status(200)
				.entity(response)
				.build();
	}
}