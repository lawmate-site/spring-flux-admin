package site.lawmate.admin.admin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import site.lawmate.admin.admin.model.Admin;
import site.lawmate.admin.admin.model.AdminDto;
import site.lawmate.admin.admin.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@Slf4j
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/save")
    public ResponseEntity<Mono<Admin>> save(@RequestBody AdminDto adminDto) {
        log.info("adminDto: {}", adminDto.getUsername());
        return ResponseEntity.ok(adminService.save(adminDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Mono<Admin>> findById(@PathVariable String id) {
        return ResponseEntity.ok(adminService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Flux<Admin>> findAll() {
        return ResponseEntity.ok(adminService.findAll());
    }
    @PutMapping("/update")
    public ResponseEntity<Mono<Admin>> update(@RequestBody AdminDto adminDto) {
        return ResponseEntity.ok(adminService.update(adminDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable("id") String id) {
        return ResponseEntity.ok(adminService.delete(id));
    }

    @PutMapping("/permit/{id}")
    public ResponseEntity<Mono<String>> permit(@PathVariable("id") String id) {
        return ResponseEntity.ok(adminService.permit(id));
    }

    @PutMapping("/revoke/{id}")
    public ResponseEntity<Mono<String>> revoke(@PathVariable("id") String id) {
        return ResponseEntity.ok(adminService.revoke(id));
    }

}
