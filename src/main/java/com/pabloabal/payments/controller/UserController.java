package com.pabloabal.payments.controller;

import com.pabloabal.payments.dto.PaymentDTO;
import com.pabloabal.payments.dto.UserDTO;
import com.pabloabal.payments.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO request){
        var userDTO = this.userService.createUser(request);
        return ResponseEntity.ok().body(userDTO);
    }

    @GetMapping(path = "/{id}/payments")
    public ResponseEntity<List<PaymentDTO>> createUser(@PathVariable("id") Long id){
        var userDTO = this.userService.getPayments(id);
        return ResponseEntity.ok().body(userDTO);
    }
}
