package com.salomondev.persistence.mapper.impl;

import com.salomondev.domain.dto.UserDto;
import com.salomondev.persistence.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserMapperImplTest {

    @InjectMocks
    private UserMapperImpl userMapper;
    private UserDto userDtoMock;
    private UserEntity userEntityMock;

    @BeforeEach
    void setUp() {
        Date dateMock = new Date();
        userDtoMock = UserDto.builder()
                .userId(1L)
                .name("John")
                .lastName("Doe")
                .email("johndoe@mail.com")
                .phone(123456789L)
                .createdAt(dateMock)
                .updatedAt(dateMock)
                .build();

        userEntityMock = UserEntity.builder()
                .userId(1L)
                .name("John")
                .lastName("Doe")
                .email("johndoe@mail.com")
                .phone(123456789L)
                .createdAt(dateMock)
                .updatedAt(dateMock)
                .build();
    }

    @Test
    void toDto() {
        UserDto userDto = userMapper.toDto(userEntityMock);
        assertEquals(userDtoMock.getUserId(), userDto.getUserId());
        assertEquals(userDtoMock.getName(), userDto.getName());
        assertEquals(userDtoMock.getLastName(), userDto.getLastName());
        assertEquals(userDtoMock.getEmail(), userDto.getEmail());
        assertEquals(userDtoMock.getPhone(), userDto.getPhone());
        assertEquals(userDtoMock.getCreatedAt(), userDto.getCreatedAt());
        assertEquals(userDtoMock.getUpdatedAt(), userDto.getUpdatedAt());
    }

    @Test
    void toEntity() {
        UserEntity userEntity = userMapper.toEntity(userDtoMock);
        assertEquals(userEntityMock.getUserId(), userEntity.getUserId());
        assertEquals(userEntityMock.getName(), userEntity.getName());
        assertEquals(userEntityMock.getLastName(), userEntity.getLastName());
        assertEquals(userEntityMock.getEmail(), userEntity.getEmail());
        assertEquals(userEntityMock.getPhone(), userEntity.getPhone());
        assertEquals(userEntityMock.getCreatedAt(), userEntity.getCreatedAt());
        assertEquals(userEntityMock.getUpdatedAt(), userEntity.getUpdatedAt());

    }
}