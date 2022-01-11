package de.evoila.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class MockitoApplicationTests {

	@Autowired
	private OrderService orderService;

	@MockBean
	private ProductService productService;

	@Test
	void contextLoads() {
	}

	@Test
	public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
		Mockito.when(productService.getProductName()).thenReturn("Mock Product Name");
		String testName = orderService.getProductName();
		Assertions.assertEquals("Mock Product Name", testName);
	}

}
