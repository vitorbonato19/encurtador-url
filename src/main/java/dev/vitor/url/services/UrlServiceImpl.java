package dev.vitor.url.services;

import dev.vitor.url.dtos.UrlRequestDto;
import dev.vitor.url.dtos.UrlResponseDto;
import dev.vitor.url.entities.Url;
import dev.vitor.url.exceptions.UrlNotFoundException;
import dev.vitor.url.interfaces.UrlService;
import dev.vitor.url.mapper.UrlMapper;
import dev.vitor.url.repository.UrlRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    private final UrlMapper mapper;

    public UrlServiceImpl(UrlRepository urlRepository, UrlMapper mapper) {
        this.urlRepository = urlRepository;
        this.mapper = mapper;
    }

    @Override
    public UrlResponseDto createShortenerUrl(@NotNull UrlRequestDto request) {

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
    public Url getDefaultUrl(String shortUrl) {
        Optional<Url> url = urlRepository.findByShortUrl(shortUrl);
        if (url.isEmpty())
            throw new UrlNotFoundException
                    ("Url not found, verify the request",
                            HttpStatus.NOT_FOUND);
        return url.get();
    }

    private String generateShortUrl() {
        return RandomStringUtils.randomAlphanumeric(5, 10);
    }
}
