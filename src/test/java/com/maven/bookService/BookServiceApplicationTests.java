package com.maven.bookService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceApplicationTests {



    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    public void verifyCreateUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/create-user/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"firstName\":\"Rush4\",\n" +
                        "\"lastName\":\"Shah1\",\n" +
                        "\"emailAddress\":\"ru1sh@yahoo.com\"\n" +
                        "}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andDo(print());
    }

    @Test
    public void verifyAddBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/add-book/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"title\":\"the Scala\",\n" +
                        "\"isbn\":\"test\",\n" +
                        "\"cost\":100,\n" +
                        "\"quantity\":5\n" +
                        "}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.inventoryId").exists())
                .andDo(print());
    }

    @Test
    public void verifyAddPurchase() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/new-purchase/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"id\":2,\n" +
                        "\"inventoryId\":2,\n" +
                        "\"quantity\":1\n" +
                        "}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.purchaseId").exists())
                .andDo(print());
    }

    @Test
    public void verifyGetUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/get-user?id=2").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(2)).andDo(print());
    }


}
