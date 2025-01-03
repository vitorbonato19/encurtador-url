package dev.vitor.url.intefaces;

import dev.vitor.url.dtos.UrlRequestDto;
import dev.vitor.url.dtos.UrlResponseDto;
import dev.vitor.url.entities.Url;
import dev.vitor.url.repository.UrlRepository;

public interface UrlService {

    UrlResponseDto createShortenerUrl(UrlRequestDto defaultUrl);
    Url getDefaultUrl(UrlRequestDto requestDto);
}
