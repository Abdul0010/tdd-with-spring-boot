package com.abdul.weekendfun.wheretoeat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

/**
 * @Author by AbdulQader
 * on 16/9/2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImpTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;
    @Test
    public void getUser_ReturnUserDetails(){
        given(userRepository.findByName(anyString())).willReturn(java.util.Optional.of(new User("abdul", "student", "Yemen")));

        User user=userService.findUser("abdul");
        assertThat(user.getName()).isEqualTo("abdul");
        assertThat(user.getNationality()).isEqualTo("Yemen");


    }
    @Test
    public void getAllUserTest(){
        List<User> userList= new ArrayList<User>();
        userList.add(new User("abdul","student","Yemen"));
        userList.add(new User("Ali","employer","Yemen"));
        given(userRepository.findAll()).willReturn(userList);
        assertThat(userList.size()).isEqualTo(2);
      //  assertThat()

    }
    @Test
    public void update() {
        User user=new User("abdul","Student","Yemeni");
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);

    }
    @Test
    public void saveUserTest(){
        User user=new User("abdul","Student","Yemeni");
        given(userRepository.save(Mockito.any(User.class))).willReturn(user);
        assertThat(user).isEqualTo(userService.save(user));
    }

}