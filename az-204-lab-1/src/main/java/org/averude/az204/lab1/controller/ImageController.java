package org.averude.az204.lab1.controller;

import lombok.RequiredArgsConstructor;
import org.averude.az204.lab1.service.BlobStorageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final BlobStorageService blobStorageService;

    @GetMapping("/{imageName}")
    public ResponseEntity<?> getImage(@PathVariable String imageName) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE)
                .body(blobStorageService.getData(imageName));
    }
}
