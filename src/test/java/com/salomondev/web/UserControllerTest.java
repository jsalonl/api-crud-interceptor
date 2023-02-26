package com.salomondev.web;

import com.salomondev.domain.dto.UserDto;
import com.salomondev.domain.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService service;

    @InjectMocks
    private UserController controller;

    private UserDto userDtoMock;
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

        userDtoListMock = List.of(userDtoMock);
    }

    @Test
    void findAll() {
        when(service.findAll()).thenReturn(userDtoListMock);
        List<UserDto> userDtoList = controller.findAll();
        assertEquals(userDtoListMock, userDtoList);
    }

    @Test
    void findById() {
        when(service.findById(1L)).thenReturn(userDtoMock);
        UserDto userDto = controller.findById(1L);
        assertEquals(userDtoMock, userDto);
    }

    @Test
    void save() {
        when(service.save(userDtoMock)).thenReturn(userDtoMock);
        UserDto userDto = controller.save(userDtoMock);
        assertEquals(userDtoMock, userDto);
    }

    @Test
    void update() {
        when(service.update(userDtoMock)).thenReturn(userDtoMock);
        UserDto userDto = controller.update(userDtoMock);
        assertEquals(userDtoMock, userDto);
    }

    @Test
    void delete() {
        controller.delete(1L);
        verify(service).delete(1L);
    }
}