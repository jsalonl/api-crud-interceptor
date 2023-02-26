package com.salomondev.domain.service;

import com.salomondev.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto findById(Long id);
    UserDto save(UserDto userDto);
    UserDto update(UserDto userDto);
    void delete(Long id);
}
