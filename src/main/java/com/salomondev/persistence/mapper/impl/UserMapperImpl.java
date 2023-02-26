package com.salomondev.persistence.mapper.impl;

import com.salomondev.domain.dto.UserDto;
import com.salomondev.persistence.entity.UserEntity;
import com.salomondev.persistence.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserMapperImpl implements UserMapper {

    /**
     * Converts UserEntity to UserDto
     *
     * @param entity UserEntity
     * @return UserDto
     * @author Joan Nieto
     */
    @Override
    public UserDto toDto(UserEntity entity) {
        return UserDto.builder()
                .userId(entity.getUserId())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    /**
     * Converts UserDto to UserEntity
     *
     * @param dto UserDto
     * @return UserEntity
     * @author Joan Nieto
     */
    @Override
    public UserEntity toEntity(UserDto dto) {
        return UserEntity.builder()
                .userId(dto.getUserId())
                .name(dto.getName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
    }
}
