package es.quizt.album.services.resourcesprovider;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.quizt.album.services.resourcesprovider.dto.AlbumSync;
import es.quizt.album.services.resourcesprovider.dto.PhotoSync;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@SpringBootTest()
class ResourceProviderServiceTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ResourceProviderFromTypicode resourceProviderService;

    @Test
    void getAlbums() throws InterruptedException, IOException, URISyntaxException {
        List<AlbumSync> albums = this.resourceProviderService.getAlbums();
        AssertionErrors.assertNotEquals("The list of albums is empty", albums.size(), 0);
    }

    @Test
    void getPhotos() throws InterruptedException, IOException, URISyntaxException {
        List<PhotoSync> albums = this.resourceProviderService.getPhotos();
        AssertionErrors.assertNotEquals("The list of photos is empty", albums.size(), 0);
    }
}