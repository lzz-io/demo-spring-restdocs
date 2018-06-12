package com.example.demo;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
// @SpringBootTest
@WebMvcTest(UserController.class)
@AutoConfigureRestDocs
public class UserControllerTest {

	@Rule
	public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
				.apply(documentationConfiguration(this.restDocumentation)).build();
	}

	@Test
	public void testIndex() throws Exception {
		this.mockMvc.perform(get("/user/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andDo(document("user"));
	}

	@Test
	public void testShow() throws Exception {
		this.mockMvc.perform(get("/user/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andDo(document("user-show"));
	}

	@Test
	public void testEdit() throws Exception {
		this.mockMvc.perform(put("/user/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andDo(document("user-edit"));
	}

}
