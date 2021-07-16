package es.quizt.album.services.photo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.quizt.album.entities.Album;
import es.quizt.album.entities.Photo;
import es.quizt.album.respositories.AlbumRepository;
import es.quizt.album.respositories.PhotosRepository;
import es.quizt.album.services.album.dto.AlbumConsume;
import es.quizt.album.services.album.dto.AlbumResponse;
import es.quizt.album.services.photo.dto.PhotoConsume;
import es.quizt.album.services.photo.dto.PhotoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {
    @Autowired
    private PhotosRepository photosRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public PhotoResponse save(PhotoConsume consume) {
        Photo photo = this.objectMapper.convertValue(consume, Photo.class);
        this.photosRepository.save(photo);
        return this.objectMapper.convertValue(photo, PhotoResponse.class);
    }

    public List<PhotoResponse> saveAll(List<PhotoConsume> consumes) {
        List<Photo> photos = this.objectMapper.convertValue(consumes, new TypeReference<List<Photo>>() {
        });
        return this.objectMapper.convertValue(this.photosRepository.saveAll(photos), new TypeReference<List<PhotoResponse>>() {
        });
    }
}
