package es.quizt.album.respositories;

import es.quizt.album.entities.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotosRepository extends CrudRepository<Photo, Long> {
}
