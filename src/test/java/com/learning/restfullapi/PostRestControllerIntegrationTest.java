package com.learning.restfullapi;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.restfullapi.exceptions.PostNotFoundException;
import com.learning.restfullapi.model.Post;
import com.learning.restfullapi.repository.PostsRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// properties for internal database

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PostRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostsRepository repository;


    @Test
    public void testGetPostByIdWithStatus200() throws Exception {
        Post post = new Post();
        post.setNote("Note");
        post.setAuthor("CR");
        post.setId(1);

        when(repository.findById(1)).thenReturn(Optional.of(post));

        mvc.perform(get("/api/post/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.author").value("CR"))
                .andExpect(jsonPath("$.note").value("Note"));
    }

    @Test
    public void testGetPostByIdWithStatus404() throws Exception {
        mvc.perform(get("/api/post/36")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("There is no such post"));
    }

    @Test
    public void testGetAllPostsWithStatus404() throws Exception {
        List<Post> list = new ArrayList<>();
        list.add(new Post());
        list.add(new Post());

        when(repository.findAll()).thenReturn(list);

        mvc.perform(get("/api/post")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void testAddPostToRepositoryWithStatus200() throws Exception {
        Post post = new Post();
        post.setAuthor("postman");
        post.setNote("text");

        when(repository.save(any(Post.class))).thenReturn(post);

        mvc.perform(post("/api/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"author\":\"postman\",\"note\":\"text\"}"))
                .andExpect(status().is(200))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.author").value("postman"))
                .andExpect(jsonPath("$.note").value("text"));
    }

    @Test
    public void testAddPostToRepositoryWithInvalidData() throws Exception {
        mvc.perform(post("/api/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"author\":\"\",\"note\":\"text\"}"))
                .andExpect(status().is(406))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Not Valid Input"));
    }

    @Test
    public void testUpdatePostFromRepositoryWithStatus200() throws Exception {
        Post post = new Post();
        post.setAuthor("postman1");
        post.setNote("text2");
        post.setId(1);

        when(repository.findById(1)).thenReturn(Optional.of(post));
        when(repository.saveAndFlush(any(Post.class))).thenReturn(post);

        mvc.perform(put("/api/post/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"author\":\"postman1\",\"note\":\"text2\"}"))
                .andExpect(status().is(200))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.author").value("postman1"))
                .andExpect(jsonPath("$.note").value("text2"));

    }

    @Test
    public void testUpdatePostFromRepositoryWithStatus404() throws Exception {
        mvc.perform(put("/api/post/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"author\":\"postman1\",\"note\":\"text2\"}"))
                .andExpect(status().is(404))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("There is no such post"));

    }

    // almost the same as GET??
    @Test
    public void testDeletePostFromRepository() throws Exception {
        Post post = new Post();
        post.setNote("Note");
        post.setAuthor("CR");
        post.setId(1);

        when(repository.findById(1)).thenReturn(Optional.of(post));

        mvc.perform(delete("/api/post/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.author").value("CR"))
                .andExpect(jsonPath("$.note").value("Note"));
    }

    @Test
    public void testDeletePostFromRepositoryWithStatus404() throws Exception {
        mvc.perform(delete("/api/post/36")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("There is no such post"));
    }
}
