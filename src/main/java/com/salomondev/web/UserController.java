package com.salomondev.web;

import com.salomondev.domain.service.UserService;
import com.salomondev.domain.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @Operation(summary = "Trae todos los usuarios")
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<UserDto> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Trae un usuario por id")
    @Parameters(value = {
            @Parameter(name = "id", in = ParameterIn.PATH, description = "Id del usuario", required = true)
    })
    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @Operation(summary = "Guarda un usuario")
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public UserDto save(@RequestBody UserDto userDto) {
        return service.save(userDto);
    }

    @Operation(summary = "Actualiza un usuario")
    @PutMapping
    @ResponseStatus(value = HttpStatus.OK)
    public UserDto update(@RequestBody UserDto userDto) {
        return service.update(userDto);
    }

    @Operation(summary = "Elimina un usuario")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
