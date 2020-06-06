package pl.teo.petshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.teo.petshop.dto.UserDetailsDto;
import pl.teo.petshop.dto.UserDto;
import pl.teo.petshop.entity.User;
import pl.teo.petshop.entity.UserDetails;
import pl.teo.petshop.exception.UserNotFoundException;
import pl.teo.petshop.repository.UserDetailsRepository;
import pl.teo.petshop.repository.UserRepository;
import pl.teo.petshop.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DefaultUserService implements UserService {
    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DefaultUserService(UserRepository userRepository, PasswordEncoder passwordEncoder,UserDetailsRepository userDetailsRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public void createNewUser(UserDto userDto) {
        User user = mapDtoToUser(userDto);
        user.setActive(true);
        user.setRoles("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void changeActive(boolean active, Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setActive(active);
        userRepository.save(user);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(this::mapUserToDto).collect(Collectors.toList());
    }

    @Override
    public void setRole(Long id, String role) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setRoles(role);
        userRepository.save(user);
    }

    @Override
    public UserDto getCurrentUserDto() {
        User user = userRepository.findByUserNameIgnoreCase(UserService.getUserName()).orElseThrow(UserNotFoundException::new);
        return mapUserToDto(user);
    }

    @Override
    public void save(UserDto dto) {
        userRepository.save(mapDtoToUser(dto));
    }

    @Override
    public void createDetails(UserDetailsDto userDetailsDto) {
        UserDetails userDetails = mapDtoToUserDetails(userDetailsDto);
        userDetailsRepository.save(userDetails);
    }

    @Override
    public UserDetailsDto getUserDetailsDto(UserDto userDto) {
        if(userDto.getUserDetailsDto() == null) {
            return new UserDetailsDto();
        }
        return userDto.getUserDetailsDto();
    }

    @Override
    public void setDetailsForCurrentUser(UserDetailsDto userDetailsDto) {
        UserDetails userDetails = mapDtoToUserDetails(userDetailsDto);
        userDetailsRepository.save(userDetails);
        User user = getCurrentUser();
        if(user.getUserDetails() == null){
            user.setUserDetails(userDetails);
            userRepository.save(user);
        }
    }

    @Override
    public UserDetails mapDtoToUserDetails(UserDetailsDto dto){
        UserDetails userDetails = new UserDetails();
        userDetails.setPost(dto.getPost());
        userDetails.setPostCode(dto.getPostCode());
        userDetails.setAddress(dto.getAddress());
        userDetails.setLastName(dto.getLastName());
        userDetails.setFirstName(dto.getFirstName());
        userDetails.setId(dto.getId());
        return userDetails;
    }

    @Override
    public UserDetailsDto mapUserDetailsToDto(UserDetails userDetails){
        UserDetailsDto dto = new UserDetailsDto();
        dto.setPostCode(userDetails.getPostCode());
        dto.setPost(userDetails.getPost());
        dto.setLastName(userDetails.getLastName());
        dto.setFirstName(userDetails.getFirstName());
        dto.setAddress(userDetails.getAddress());
        dto.setId(userDetails.getId());
        return dto;
    }

    public UserDto mapUserToDto(User user){
        UserDto dto = new UserDto();
        dto.setEmail(user.getEmail());
        dto.setId(user.getId());
        dto.setPassword(user.getPassword());
        dto.setUserName(user.getUserName());
        dto.setRoles(user.getRoles());
        dto.setActive(user.isActive());
        if(user.getUserDetails() != null){
            dto.setUserDetailsDto(mapUserDetailsToDto(user.getUserDetails()));
        }
        return dto;
    }

    public User mapDtoToUser (UserDto dto){
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        if(dto.getId() != null){
            user.setId(dto.getId());
        }
        if (dto.getUserDetailsDto() != null) {
            user.setUserDetails(mapDtoToUserDetails(dto.getUserDetailsDto()));
        }
        if (dto.getRoles() != null) {
            user.setRoles(dto.getRoles());
        }
        if (dto.getId() != null) {
            user.setId(dto.getId());
        }
        if (dto.getActive() != null) {
            user.setActive(dto.getActive());
        }
        return user;
    }
    User getCurrentUser(){
        return userRepository.findByUserNameIgnoreCase(UserService.getUserName()).orElseThrow(UserNotFoundException::new);
    }
}
