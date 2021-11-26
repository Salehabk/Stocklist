package com.qa.stocklist.test.integrationtesting;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.stocklist.entity.Item;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:item-data.sql"})
@ActiveProfiles(profiles = "test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)

public class ItemControllerTest {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper jsonifier;



	@Test
public void testCreate() throws Exception {
		Item testItem = new Item(1,"Flour", "InStock", 5);
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/createItem");
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(this.jsonifier.writeValueAsString(testItem));
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(this.jsonifier.writeValueAsString(testItem));
		
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);

}

	@Test
public void testUpdate() throws Exception {
		Item testItem = new Item(1,"Butter", "InStock", 3);
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT, "/update/1");
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(this.jsonifier.writeValueAsString(testItem));
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(this.jsonifier.writeValueAsString(testItem));
		
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);

}
	
	@Test
public void testReadAll() throws Exception {
		Item testItem = new Item(1,"Butter", "InStock", 3);
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "/readAll");
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(this.jsonifier.writeValueAsString(testItem));
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(this.jsonifier.writeValueAsString(testItem));
		
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);

}

	@Test
public void testReadById() throws Exception {
		Item testItem = new Item(1,"flour", "InStock", 5);
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "/readByID/1");
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(this.jsonifier.writeValueAsString(testItem));
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isContinue();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(this.jsonifier.writeValueAsString(testItem));
		
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);

}

	@Test
public void testDeleteById() throws Exception {
		Item testItem = new Item(1,"flour", "InStock", 5);
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/deleteItem/1");
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(this.jsonifier.writeValueAsString(testItem));
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(this.jsonifier.writeValueAsString(testItem));
		
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);

}
	
}
