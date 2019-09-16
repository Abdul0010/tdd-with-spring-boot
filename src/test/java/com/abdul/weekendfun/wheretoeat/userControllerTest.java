package com.abdul.weekendfun.wheretoeat;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author by AbdulQader
 * on 16/9/2019.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(userController.class)
public class userControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;
    @Autowired private ObjectMapper mapper;

    @Test
    public void getUser_ShouldReturnUser() throws Exception {

        given(userService.findUser(anyString())).willReturn(new User("abdul","student","Yemen"));
        mockMvc.perform(MockMvcRequestBuilders.get("/user/abdul"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("abdul"))
                .andExpect(jsonPath("userType").value("student"));
    }
    @Test
    public void createUser_ShouldReurn200Status() throws Exception {
        User user=new User("abdul","student","Yemen");
        String json = mapper.writeValueAsString(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        verify(userService,times(1)).save(user);
    }

    @Test
    public void getUser_notFound()throws Exception{
        given(userService.findUser(anyString())).willThrow(new UserNotFoundException());
        mockMvc.perform(MockMvcRequestBuilders.get("/user/abdul"))
                .andExpect(status().isNotFound());
    }
}
