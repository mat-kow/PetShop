package pl.teo.petshop.service;

import org.springframework.security.core.context.SecurityContextHolder;
import pl.teo.petshop.dto.UserDetailsDto;
import pl.teo.petshop.dto.UserDto;
import pl.teo.petshop.entity.User;
import pl.teo.petshop.entity.UserDetails;

import java.util.List;

public interface UserService {
    static String getUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    void createNewUser(UserDto userDto);
    void changeActive(boolean active, Long id);
    List <UserDto> getAll();
    void setRole (Long id, String role);
    UserDto getCurrentUserDto();
    void save(UserDto user);
    void createDetails(UserDetailsDto userDetailsDto);
    UserDetailsDto getUserDetailsDto(UserDto userDto);
    void setDetailsForCurrentUser(UserDetailsDto userDetailsDto);
    UserDto mapUserToDto(User user);
    User mapDtoToUser (UserDto dto);
    UserDetailsDto mapUserDetailsToDto(UserDetails userDetails);
    UserDetails mapDtoToUserDetails(UserDetailsDto dto);
    boolean verify(long id, String uuid);
    }
