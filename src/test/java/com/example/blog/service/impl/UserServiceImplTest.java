package com.example.blog.service.impl;

import com.example.blog.models.User;
import com.example.blog.repository.RoleRepository;
import com.example.blog.repository.UserRepository;
import com.example.blog.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@DisplayName("Тесты на сервис пользователя")
class UserServiceImplTest {
    private final UserService userService;

    private BCryptPasswordEncoder bCryptPasswordEncoder = Mockito.mock(BCryptPasswordEncoder.class);

    private RoleRepository roleRepository = Mockito.mock(RoleRepository.class);;

    private UserRepository userRepository = Mockito.mock(UserRepository.class);;

    UserServiceImplTest() {
        this.userService = new UserServiceImpl(bCryptPasswordEncoder, roleRepository, userRepository);
    }

    @Test
    @DisplayName("Проврка сохранения пользователя")
    void save() {
        User user = new User();
        user.setPassword("Hello World");
        Mockito.when(bCryptPasswordEncoder.encode(user.getPassword())).thenReturn("Super string");

        userService.save(user);

        Mockito.verify(userRepository, Mockito.times(1))
                .save(user);
    }

    @Test
    @DisplayName("Проврка поиска пользователя")
    void findByuserName() {
        User user = new User();
        user.setId(1L);
        user.setUserName("name");
        user.setPassword("password");
        String userName = "Hello world";
        Mockito.when(userRepository.findByuserName(userName)).thenReturn(user);
        User byuserName = userService.findByuserName(userName);
        Mockito.verify(userRepository, Mockito.times(1)).findByuserName(userName);
        Assertions.assertThat(user).isEqualToComparingFieldByField(byuserName);
    }
}