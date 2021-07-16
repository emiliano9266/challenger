package es.quizt.album.services.resourcesprovider;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.quizt.album.services.resourcesprovider.dto.AlbumSync;
import es.quizt.album.services.resourcesprovider.dto.PhotoSync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class ResourceProviderFromTypicode implements ResourceProvider {

    @Autowired
    private ObjectMapper objectMapper;

    private static final RestTemplate restTemplate = new RestTemplate();

    public List<AlbumSync> getAlbums() throws URISyntaxException, IOException, InterruptedException {
        ResponseEntity<List<AlbumSync>> response = restTemplate.exchange(
                "https://jsonplaceholder.typicode.com/albums",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<AlbumSync>>() {
                });

        return response.getBody();
    }

    public List<PhotoSync> getPhotos() throws URISyntaxException, IOException, InterruptedException {
        ResponseEntity<List<PhotoSync>> response = restTemplate.exchange(
                "https://jsonplaceholder.typicode.com/photos",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PhotoSync>>() {
                });

        return response.getBody();
    }
}
