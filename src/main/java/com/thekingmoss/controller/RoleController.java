package com.thekingmoss.controller;

import com.thekingmoss.dto.role.RoleRequestDto;
import com.thekingmoss.dto.role.RoleResponseDto;
import com.thekingmoss.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService roleService;

    @PostMapping
    public ResponseEntity<RoleResponseDto> createRole(@RequestBody RoleRequestDto requestDto) {
        RoleResponseDto createdRole = roleService.createRole(requestDto);
        return ResponseEntity.ok(createdRole);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDto> getRoleById(@PathVariable Long id) {
        RoleResponseDto role = roleService.getRoleById(id);
        return ResponseEntity.ok(role);
    }

    @GetMapping
    public ResponseEntity<List<RoleResponseDto>> getAllRoles() {
        List<RoleResponseDto> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponseDto> updateRole(@PathVariable Long id, @RequestBody RoleRequestDto requestDto) {
        RoleResponseDto updatedRole = roleService.updateRole(id, requestDto);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
