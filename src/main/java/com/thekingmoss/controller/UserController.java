package com.thekingmoss.controller;

import com.thekingmoss.dto.user.ClientRequestDto;
import com.thekingmoss.dto.user.ClientResponseDto;
import com.thekingmoss.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final IClientService clientService;

    @PostMapping
    public ResponseEntity<ClientResponseDto> createUser(@RequestBody ClientRequestDto requestDto) {
        ClientResponseDto createdUser = clientService.createClient(requestDto);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> getUserById(@PathVariable Long id) {
        ClientResponseDto user = clientService.getClientById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getAllUsers() {
        List<ClientResponseDto> users = clientService.getAllClients();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDto> updateUser(@PathVariable Long id, @RequestBody ClientRequestDto requestDto) {
        ClientResponseDto updatedUser = clientService.updateClient(id, requestDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
