package com.github.darogina.beer30.controller.api.v1;

import com.github.darogina.beer30.AbstractCrudServiceTest;
import com.github.darogina.beer30.model.api.v1.Author;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AuthorAPIv1ControllerIT extends AbstractCrudServiceTest {

    private static final String URL = "/api/v1/author";

    @Test
    public void createTest() throws Exception {
        Author author = new Author();
        author.setName("Author Name");

        ResultActions result = create(URL, author);

        result.andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON_UTF_8))
                .andExpect(jsonPath("$.name").value(author.getName()));
    }
}
