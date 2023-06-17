package com.airline.service;

import com.airline.dto.userDto.request.UserDtoCreateRequest;
import com.airline.dto.userDto.request.UserDtoPassword;
import com.airline.dto.userDto.request.UserDtoUpdate;
import com.airline.dto.userDto.response.UserDtoResponse;
import com.airline.dto.userDto.response.UserDtoResponseDetail;
import com.airline.entity.Role;
import com.airline.payload.response.checkEmailPassword;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDtoResponse> findAll();
    List<UserDtoResponse> getUsersByFullName(String fullName);

    UserDtoResponseDetail getUserById(Long customerId);
    Page<UserDtoResponse> getUsers(Pageable pageable);
    Optional<UserDtoResponse> findById(Long id);
    checkEmailPassword save(UserDtoCreateRequest userDtoCreateRequest);
    Boolean remove(Long id);
    Boolean updateSimple(String email, UserDtoUpdate userDtoUpdate);
    Boolean updatePassword (String email, UserDtoPassword userDtoPassword);
    Boolean active(Long id);
    UserDtoResponse getUserByEmail(String email);
    Boolean updateAddRole(Long id, Role role);
    Boolean updateRemoveRole(Long userId, Role role);
    List<String> getRoleByUserName(String userName);
}
