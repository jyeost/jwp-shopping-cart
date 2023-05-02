package cart.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cart.dto.ProductRequestDto;
import cart.service.AdminService;

@RestController
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/products")
    public ResponseEntity<Void> addProduct(@Valid @RequestBody ProductRequestDto productRequestDto) {
        int id = adminService.addProduct(productRequestDto);
        return ResponseEntity.created(URI.create("/products/" + id)).build();
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Void> updateProduct(@Valid @RequestBody ProductRequestDto productRequestDto,
        @PathVariable int id) {
        adminService.updateProduct(productRequestDto, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        adminService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
