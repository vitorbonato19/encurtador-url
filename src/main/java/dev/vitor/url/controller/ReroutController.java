package dev.vitor.url.controller;

import dev.vitor.url.dtos.UrlRequestDto;
import dev.vitor.url.services.UrlServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class ReroutController {

    private UrlServiceImpl urlService;

    public ReroutController(UrlServiceImpl urlService) {
        this.urlService = urlService;
    }

    @GetMapping
    @RequestMapping("/{shortUrl}")
    public ResponseEntity<Void> rerout(@PathVariable("shortUrl") String shortUrl) {

        var obj = urlService.getDefaultUrl(shortUrl);
        var url = obj.getDefaultUrl();

        return ResponseEntity.status(302).location(URI.create(url)).build();
    }
}
