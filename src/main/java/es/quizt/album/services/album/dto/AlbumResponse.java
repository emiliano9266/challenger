package es.quizt.album.services.album.dto;

import es.quizt.album.services.photo.dto.PhotoResponse;

import java.util.List;

public class AlbumResponse {
    private Long userId;
    private Long id;
    private String title;
    private List<PhotoResponse> photos;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PhotoResponse> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoResponse> photos) {
        this.photos = photos;
    }
}
