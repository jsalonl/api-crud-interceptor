package com.salomondev.domain.service.impl;

import com.salomondev.domain.dto.UserDto;
import com.salomondev.exception.ApiRestException;
import com.salomondev.persistence.entity.UserEntity;
import com.salomondev.persistence.mapper.UserMapper;
import com.salomondev.persistence.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository repository;

    @Mock
    private UserMapper mapper;

    @InjectMocks
    private UserServiceImpl service;

    private UserDto userDtoMock;
    private UserDto userDtoNullMock;
    private UserEntity userEntityMock;
    private List<UserEntity> userEntityListMock;
    private List<UserDto> userDtoListMock;


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

        userDtoNullMock = UserDto.builder()
                .userId(1L)
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

        userDtoListMock = List.of(userDtoMock);
        userEntityListMock = List.of(userEntityMock);
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(userEntityListMock);
        when(mapper.toDto(userEntityMock)).thenReturn(userDtoMock);
        List<UserEntity> userEntityListMock = repository.findAll();
        List<UserDto> userDtoListMock = new ArrayList<>(userEntityListMock).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        List<UserDto> userDtoList = service.findAll();
        assertEquals(userDtoListMock, userDtoList);
    }

    @Test
    void findById() {
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(userEntityMock));
        when(mapper.toDto(userEntityMock)).thenReturn(userDtoMock);
        UserDto userDto = service.findById(1L);
        assertEquals(userDtoMock, userDto);
    }

    @Test
    void findById_WithException() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ApiRestException.class, () -> service.findById(1L));
    }

    @Test
    void save() {
        when(mapper.toEntity(userDtoMock)).thenReturn(userEntityMock);
        when(repository.save(userEntityMock)).thenReturn(userEntityMock);
        when(mapper.toDto(userEntityMock)).thenReturn(userDtoMock);
        UserDto userDto = service.save(userDtoMock);
        assertEquals(userDtoMock, userDto);
    }

    @Test
    void update() {
       when(repository.findById(1L)).thenReturn(Optional.ofNullable(userEntityMock));
       when(repository.save(userEntityMock)).thenReturn(userEntityMock);
       when(mapper.toDto(userEntityMock)).thenReturn(userDtoMock);
       UserDto userDto = service.update(userDtoMock);
         assertEquals(userDtoMock, userDto);

    }

    @Test
    void update_WithoutDataForUpdate() {
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(userEntityMock));
        when(repository.save(userEntityMock)).thenReturn(userEntityMock);
        when(mapper.toDto(userEntityMock)).thenReturn(userDtoMock);
        UserDto userDto = service.update(userDtoNullMock);
        assertEquals(userDtoMock, userDto);

    }

    @Test
    void update_WithException() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ApiRestException.class, () -> service.update(userDtoMock));
    }

    @Test
    void delete() {
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(userEntityMock));
        service.delete(1L);
        verify(repository).deleteById(1L);
    }

    @Test
    void delete_WithException() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ApiRestException.class, () -> service.delete(1L));
    }
}