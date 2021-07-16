package es.quizt.album.services.sync;

import es.quizt.album.respositories.AlbumRepository;
import es.quizt.album.respositories.PhotosRepository;
import es.quizt.album.services.resourcesprovider.ResourceProviderFromTypicode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

import java.util.Collection;

@SpringBootTest()
class SyncServiceTest {

    @Autowired
    private SyncService syncService;

    @Autowired
    private ResourceProviderFromTypicode resourceProviderFromTypicode;

    @Autowired
    private PhotosRepository photosRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Test
    void sync() {
        this.syncService.sync(this.resourceProviderFromTypicode);
        AssertionErrors.assertNotEquals("The list of photos is empty", ((Collection<?>) this.photosRepository.findAll()).size(), 0);
        AssertionErrors.assertNotEquals("The list of albums is empty", ((Collection<?>) this.albumRepository.findAll()).size(), 0);
    }
}