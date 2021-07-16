package es.quizt.album.respositories;

import es.quizt.album.entities.Album;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Long> {
    List<Album> findByTitleContainingIgnoreCase(String title);
}
