package es.quizt.album.controllers;

import es.quizt.album.services.album.AlbumService;
import es.quizt.album.services.album.dto.AlbumResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping()
    @Operation(summary = "Find albums by name")
    public ResponseEntity<List<AlbumResponse>> findByName(
            @RequestParam(name = "name", defaultValue = "", required = false) String name) {
        return ResponseEntity.ok(this.albumService.findByTitle(name));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find album by id")
    public ResponseEntity<AlbumResponse> findById(
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(this.albumService.findById(id));
    }
}

