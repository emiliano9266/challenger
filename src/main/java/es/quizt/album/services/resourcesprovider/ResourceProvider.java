package es.quizt.album.services.resourcesprovider;

import es.quizt.album.services.resourcesprovider.dto.AlbumSync;
import es.quizt.album.services.resourcesprovider.dto.PhotoSync;

import java.util.List;

public interface ResourceProvider {
    List<AlbumSync> getAlbums() throws Exception;
    List<PhotoSync> getPhotos() throws Exception;
}
