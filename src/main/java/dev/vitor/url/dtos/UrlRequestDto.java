package dev.vitor.url.dtos;

import java.util.Objects;

public class UrlRequestDto {

    private String defaultUrl;

    public UrlRequestDto() {

    }

    public UrlRequestDto(String defaultUrl) {
        this.defaultUrl = defaultUrl;
    }

    public String getDefaultUrl() {
        return defaultUrl;
    }

    public void setDefaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlRequestDto that = (UrlRequestDto) o;
        return Objects.equals(defaultUrl, that.defaultUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultUrl);
    }
}
