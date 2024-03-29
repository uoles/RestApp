package ru.uoles.proj.rest;

import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.uoles.proj.model.Entity;
import ru.uoles.proj.service.PaymentService;
import ru.uoles.proj.util.ObjectConverter;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(JUnitPlatform.class)
@DisplayName("Тестирование контроллера")
class RestControllerTest {

    @InjectMocks
    private final RestController restController = new RestController();

    @Mock
    private PaymentService paymentService;

    @BeforeEach()
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Вызов метода getEntities")
    void getEntitiesTest() {
        List<Entity> expected = new ArrayList<>();
        expected.add(new Entity(1L, "TEST"));

        Mockito.doReturn(expected).when(paymentService).getEntities("TestParam");
        Response response = restController.getEntities("TestParam");

        assertNotNull(response.getEntity());
        assertEquals(ObjectConverter.toJson(expected), response.getEntity());
    }
}