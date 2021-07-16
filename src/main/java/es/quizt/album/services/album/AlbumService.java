package es.quizt.album.services.album;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.quizt.album.entities.Album;
import es.quizt.album.respositories.AlbumRepository;
import es.quizt.album.services.album.dto.AlbumConsume;
import es.quizt.album.services.album.dto.AlbumResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Caching(evict = {
            @CacheEvict(value = "album", allEntries = true),
            @CacheEvict(value = "albums", allEntries = true)})
    public AlbumResponse save(AlbumConsume consume) {
        Album album = this.objectMapper.convertValue(consume, Album.class);
        this.albumRepository.save(album);
        return this.objectMapper.convertValue(album, AlbumResponse.class);
    }

    @Caching(evict = {
            @CacheEvict(value = "album", allEntries = true),
            @CacheEvict(value = "albums", allEntries = true)})
    public List<AlbumResponse> saveAll(List<AlbumConsume> consumes) {
        List<Album> albums = this.objectMapper.convertValue(consumes, new TypeReference<List<Album>>() {
        });
        return this.objectMapper.convertValue(this.albumRepository.saveAll(albums), new TypeReference<List<AlbumResponse>>() {
        });
    }

    @Cacheable("albums")
    public List<AlbumResponse> findByTitle(String title) {
        return this.objectMapper.convertValue(this.albumRepository.findByTitleContainingIgnoreCase(title), new TypeReference<List<AlbumResponse>>() {
        });
    }

    @Cacheable("album")
    public AlbumResponse findById(Long id) {
        return this.objectMapper.convertValue(
                this.albumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The album was not found")),
                AlbumResponse.class
        );
    }
}
