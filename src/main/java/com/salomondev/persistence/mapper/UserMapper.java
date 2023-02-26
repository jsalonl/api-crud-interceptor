package com.salomondev.persistence.mapper;

import com.salomondev.domain.dto.UserDto;
import com.salomondev.persistence.entity.UserEntity;

public interface UserMapper {
    UserDto toDto(UserEntity entity);
    UserEntity toEntity(UserDto dto);
}
