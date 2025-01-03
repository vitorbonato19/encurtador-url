package dev.vitor.url.services;

import dev.vitor.url.dtos.UrlRequestDto;
import dev.vitor.url.dtos.UrlResponseDto;
import dev.vitor.url.entities.Url;
import dev.vitor.url.exceptions.UrlNotFoundException;
import dev.vitor.url.intefaces.UrlService;
import dev.vitor.url.mapper.UrlMapper;
import dev.vitor.url.repository.UrlRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    private final UrlMapper mapper;

    public UrlServiceImpl(UrlRepository urlRepository, UrlMapper mapper) {
        this.urlRepository = urlRepository;
        this.mapper = mapper;
    }

    @Override
    public UrlResponseDto createShortenerUrl(UrlRequestDto request) {

        var url = new Url();
        url.setDefaultUrl(request.getDefaultUrl());
        url.setCreatedAt(LocalDateTime.now());
        url.setExpireAt(LocalDateTime.now());
        url.setShortUrl(generateShortUrl());

        urlRepository.save(url);

        var response = mapper.entityToResponse(url);

        return response;
    }

    @Override
    public Url getDefaultUrl(UrlRequestDto requestDto) {
        var url = urlRepository
                .findByDefaultUrl(requestDto.getDefaultUrl())
                .orElseThrow(
                        () -> new UrlNotFoundException("Url not found, verify the request", HttpStatus.NOT_FOUND)
                );
        return url;
    }

    private String generateShortUrl() {
        return RandomStringUtils.randomAlphanumeric(5, 10);
    }
}
