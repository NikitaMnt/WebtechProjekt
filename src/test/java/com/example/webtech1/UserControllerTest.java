package com.example.webtech1;

import com.example.webtech1.UserBody;
import com.example.webtech1.UserService;
import com.example.webtech1.UserController;
import com.example.webtech1.ToDo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void getUsersTest() throws Exception {
        UserBody user = new UserBody();
        user.setUsername("testuser");
        List<UserBody> allUsers = Arrays.asList(user);

        given(userService.getUsers()).willReturn(allUsers);

        mvc.perform(get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'username': 'testuser'}]"));
    }

    @Test
    public void getUserTest() throws Exception {
        UserBody user = new UserBody();
        user.setUsername("testuser");

        given(userService.getUser(1L)).willReturn(user);

        mvc.perform(get("/users/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{'username': 'testuser'}"));
    }
}
