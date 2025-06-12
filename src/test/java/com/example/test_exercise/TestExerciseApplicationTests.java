package com.example.test_exercise;

import com.example.test_exercise.controller.CalcolatriceController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@ActiveProfiles(value = "dev")
@AutoConfigureMockMvc
class TestExerciseApplicationTests {

	@Autowired
	private CalcolatriceController calcolatriceController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void sumTest() throws Exception{
		this.mockMvc.perform(get("/api/calcolatrice/sum")
				.param("a", "4")
				.param("b", "2"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("6"));
	}

	@Test
	public void subTest() throws Exception{
		this.mockMvc.perform(get("/api/calcolatrice/sub")
						.param("a", "4")
						.param("b", "2"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("2"));
	}

	@Test
	public void multipTest() throws Exception{
		this.mockMvc.perform(get("/api/calcolatrice/multip")
						.param("a", "4")
						.param("b", "2"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("8"));
	}

	@Test
	public void divTest() throws Exception{
		this.mockMvc.perform(get("/api/calcolatrice/div")
						.param("a", "4.0")
						.param("b", "2.0"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("2.0"));
	}

	@Test
	public void divByZeroTest() throws Exception {
		mockMvc.perform(get("/api/calcolatrice/div")
						.param("numeratore", "4.0")
						.param("denominatore", "0.0"))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}
}