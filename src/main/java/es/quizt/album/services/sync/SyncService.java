package es.quizt.album.services.sync;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.quizt.album.services.album.AlbumService;
import es.quizt.album.services.album.dto.AlbumConsume;
import es.quizt.album.services.album.dto.AlbumResponse;
import es.quizt.album.services.photo.PhotoService;
import es.quizt.album.services.photo.dto.PhotoConsume;
import es.quizt.album.services.resourcesprovider.ResourceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SyncService {

    ResourceProvider resourcesProvider;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private ObjectMapper objectMapper;

    public void sync(ResourceProvider resourcesProvider) {
        this.resourcesProvider = resourcesProvider;
        this.syncAlbums();
        this.syncPhotos();
    }

    private void syncAlbums() {
        try {
            this.albumService.saveAll(
                    this.objectMapper.convertValue(this.resourcesProvider.getAlbums(), new TypeReference<List<AlbumConsume>>() {
                    })
            );
            /*
            this.resourcesProvider.getAlbums().stream()
                    .map((var album) -> objectMapper.convertValue(album, AlbumConsume.class))
                    .forEach((var album) -> this.albumService.save(album));
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void syncPhotos() {
        try {
            this.photoService.saveAll(
                    this.objectMapper.convertValue(this.resourcesProvider.getPhotos(), new TypeReference<List<PhotoConsume>>() {
                    })
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
