package com.example.blog.service.impl;

import com.example.blog.models.Role;
import com.example.blog.models.User;
import com.example.blog.repository.RoleRepository;
import com.example.blog.repository.UserRepository;
import com.example.blog.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

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
        Role role = Role.builder()
                .Id(1L)
                .Name("ADMIN")
                .build();
        User user = User.builder()
                .role(role)
                .build();
        user.setPassword("Hello World");
        Mockito.when(roleRepository.findById(1L)).thenReturn(Optional.ofNullable(role));
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
        User byuserName = userService.findByUserName(userName);
        Mockito.verify(userRepository, Mockito.times(1)).findByuserName(userName);
        Assertions.assertThat(user).isEqualToComparingFieldByField(byuserName);
    }
}