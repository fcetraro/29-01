package com.example1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	public static final String requestJson = "{\"name\":\"foodName\",\"ingredients\":[{\"name\":\"Aceitunas negras\",\"weight\":1}," +
			"{\"name\":\"Aceitunas verdes\",\"weight\":1},{\"name\":\"Acelgas\",\"weight\":1},{\"name\":\"Ajos" +
			"\",\"weight\":1},{\"name\":\"Alcachofas\",\"weight\":1}]}";
	@Test
	void shouldGetFoodCalories() throws Exception {
		String url = "/food/calories";
		String expectedResult = "{\"name\":\"foodName\",\"calories\":747}";
		this.mockMvc.perform(post(url)
				.contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(expectedResult));
	}
	@Test
	void shouldGetIngredientsCalories() throws Exception {
		String expectedResult = "[{\"name\":\"Aceitunas negras\",\"calories\":349},{\"name\":\"Aceitunas verdes\"," +
				"\"calories\":132},{\"name\":\"Acelgas\",\"calories\":33},{\"name\":\"Ajos\",\"calories\":169},{\"na" +
				"me\":\"Alcachofas\",\"calories\":64}]";
		String url = "/food/ingredients/calories";
		this.mockMvc.perform(post(url)
				.contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(expectedResult));
	}
	@Test
	void shouldGetMaxCalories() throws Exception {
		String url = "/food/max";
		String expectedResult = "{\"name\":\"Aceitunas negras\",\"calories\":349}";
		this.mockMvc.perform(post(url)
				.contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(expectedResult));
	}
	@Test
	void shouldGetCharacters() throws Exception {
		String url = "/character/find/darth";
		String expectedResult = "[{\"name\":\"Darth Vader\",\"hair_color\":\"none\",\"skin_color\":\"white\",\"" +
				"eye_color\":\"yellow\",\"birth_year\":\"41.9BBY\",\"gender\":\"male\",\"homeworld\":\"Tatooine\",\"" +
				"species\":\"Human\",\"height\":202,\"mass\":136},{\"name\":\"Darth Maul\",\"hair_color\":\"none\"," +
				"\"skin_color\":\"red\",\"eye_color\":\"yellow\",\"birth_year\":\"54BBY\",\"gender\":\"male\",\"" +
				"homeworld\":\"Dathomir\",\"species\":\"Zabrak\",\"height\":175,\"mass\":80}]";
		this.mockMvc.perform(get(url))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(expectedResult));
	}
}
