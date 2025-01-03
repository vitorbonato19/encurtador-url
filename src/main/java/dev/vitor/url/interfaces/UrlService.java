package dev.vitor.url.interfaces;

import dev.vitor.url.dtos.UrlRequestDto;
import dev.vitor.url.dtos.UrlResponseDto;
import dev.vitor.url.entities.Url;

public interface UrlService {

    UrlResponseDto createShortenerUrl(UrlRequestDto defaultUrl);
    Url getDefaultUrl(String shortUrl);
}
