package dev.vitor.url.controller;

import dev.vitor.url.dtos.UrlRequestDto;
import dev.vitor.url.dtos.UrlResponseDto;
import dev.vitor.url.services.UrlServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlController {

    private final UrlServiceImpl urlService;

    public UrlController(UrlServiceImpl urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    @RequestMapping("/shorten-url")
    public ResponseEntity<UrlResponseDto> createShortUrl(@RequestBody UrlRequestDto requestDto) {
        var shortUrl = urlService.createShortenerUrl(requestDto);
        return ResponseEntity.status(200).body(shortUrl);
    }

}
