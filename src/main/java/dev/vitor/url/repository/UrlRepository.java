package dev.vitor.url.repository;

import dev.vitor.url.dtos.UrlRequestDto;
import dev.vitor.url.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    Optional<Url> findByShortUrl(String url);
}
