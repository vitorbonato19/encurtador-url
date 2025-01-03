package dev.vitor.url.mapper;

import dev.vitor.url.dtos.UrlRequestDto;
import dev.vitor.url.dtos.UrlResponseDto;
import dev.vitor.url.entities.Url;

import java.time.LocalDateTime;

public class UrlMapper {

    public Url toEntity(UrlRequestDto request) {

        Url url = new Url();
        url.setDefaultUrl(request.getDefaultUrl());
        url.setExpireAt(LocalDateTime.now());
        url.setCreatedAt(LocalDateTime.now());

        return url;
    }

    public UrlResponseDto entityToResponse(Url url) {

        var response = new UrlResponseDto();
        response.setShortUrl(url.getShortUrl());
        response.setDefaultUrl(url.getDefaultUrl());
        response.setCreatedAt(url.getCreatedAt());
        response.setExpireAt(url.getExpireAt());

        return response;
    }

}
