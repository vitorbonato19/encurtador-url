package dev.vitor.url.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "urls")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String defaultUrl;
    private String shortUrl;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime expireAt;

    public Url() {

    }

    public Url(long id, String defaultUrl, String shortUrl, LocalDateTime createdAt, LocalDateTime expireAt) {
        this.id = id;
        this.defaultUrl = defaultUrl;
        this.shortUrl = shortUrl;
        this.createdAt = createdAt;
        this.expireAt = expireAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        Url url = (Url) o;
        return id == url.id && defaultUrl.equals(url.defaultUrl) && shortUrl.equals(url.shortUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, defaultUrl, shortUrl, createdAt, expireAt);
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", defaultUrl='" + defaultUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", createdAt=" + createdAt +
                ", expireAt=" + expireAt +
                '}';
    }
}
