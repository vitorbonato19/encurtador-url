package dev.vitor.url.dtos;

import java.time.LocalDateTime;
import java.util.Objects;

public class UrlResponseDto {

    private String defaultUrl;
    private String shortUrl;
    private LocalDateTime createdAt;
    private LocalDateTime expireAt;

    public UrlResponseDto() {

    }

    public UrlResponseDto(String defaultUrl, String shortUrl, LocalDateTime createdAt, LocalDateTime expireAt) {
        this.defaultUrl = defaultUrl;
        this.shortUrl = shortUrl;
        this.createdAt = createdAt;
        this.expireAt = expireAt;
    }

    public String getDefaultUrl() {
        return defaultUrl;
    }

    public void setDefaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalDateTime expireAt) {
        this.expireAt = expireAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlResponseDto that = (UrlResponseDto) o;
        return Objects.equals(defaultUrl, that.defaultUrl) && Objects.equals(shortUrl, that.shortUrl) && Objects.equals(createdAt, that.createdAt) && Objects.equals(expireAt, that.expireAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultUrl, shortUrl, createdAt, expireAt);
    }
}
