package pl.teo.petshop.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.teo.petshop.dto.UserDetailsDto;
import pl.teo.petshop.dto.UserDto;
import pl.teo.petshop.entity.User;
import pl.teo.petshop.entity.UserDetails;
import pl.teo.petshop.repository.UserDetailsRepository;
import pl.teo.petshop.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultUserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserDetailsRepository userDetailsRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private DefaultUserService userService;

//    @Test
//    void should_set_fields_active_roles_when_creating_new_user(){
//        UserDto dto = new UserDto("name","pass", "q@q.q");
//        User user = new User("name","pass", "q@q.q");
//
//        when(userService.mapDtoToUser(dto)).thenReturn(user);
//        when(passwordEncoder.encode(anyString())).thenReturn("encodedPass");
//        when(userRepository.save(any(User.class))).thenReturn(user);
//
//        userService.createNewUser(dto);
//
//        assertEquals("encodedPass", user.getPassword());
//        assertTrue(user.getActive());
//        assertEquals("ROLE_USER", user.getRoles());
//    }

    @Test
    void should_map_dto_to_userDetails() {
        UserDetails entity = getUserDetails();
        UserDetailsDto dto = getUserDetailsDto();
        assertEquals(userService.mapDtoToUserDetails(dto), entity);

    }

    @Test
    void should_map_userDetails_to_dto() {
        UserDetails entity = getUserDetails();
        UserDetailsDto dto = getUserDetailsDto();
        assertEquals(userService.mapUserDetailsToDto(entity), dto);
    }

    @Test
    void should_map_user_to_dto() {
        User entity = getUser();
        UserDto dto = getUserDto();
        UserDto mapped = userService.mapUserToDto(entity);
        assertEquals(mapped, dto);

    }

    @Test
    void should_map_dto_to_user() {
        User entity = getUser();
        UserDto dto = getUserDto();
        User mapped = userService.mapDtoToUser(dto);
        assertEquals(mapped, entity);

    }

    private UserDetails getUserDetails(){
        UserDetails entity = new UserDetails();
        entity.setFirstName("John");
        entity.setId(125L);
        entity.setLastName("Kowalski");
        entity.setAddress("Legnicka 52a");
        entity.setPostCode("12-345");
        entity.setPost("Wrocław");
        return entity;
    }

    private UserDetailsDto getUserDetailsDto(){
        UserDetailsDto dto = new UserDetailsDto();
        dto.setFirstName("John");
        dto.setId(125L);
        dto.setLastName("Kowalski");
        dto.setAddress("Legnicka 52a");
        dto.setPostCode("12-345");
        dto.setPost("Wrocław");
        return dto;
    }

    private User getUser(){
        User entity = new User("name","pass","ROLE_USER",true, "q@q.q");
        entity.setId(456L);
        entity.setUserDetails(getUserDetails());
        return entity;
    }

    private UserDto getUserDto(){
        UserDto dto = new UserDto("name","pass","q@q.q",true, "ROLE_USER");
        dto.setId(456L);
        dto.setUserDetailsDto(getUserDetailsDto());
        return dto;
    }
}