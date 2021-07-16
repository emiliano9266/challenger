package es.quizt.album.services.album;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.quizt.album.respositories.AlbumRepository;
import es.quizt.album.services.album.dto.AlbumConsume;
import es.quizt.album.services.album.dto.AlbumResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest()
class AlbumServiceTest {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AlbumRepository albumRepository;

    @Test
    void save() {
        AlbumConsume consume = new AlbumConsume();
        consume.setId(1L);
        consume.setTitle("title");
        consume.setUserId(2L);

        AlbumResponse response = this.albumService.save(consume);
        assertEquals(response.getUserId(), 2L);
    }

    @Test
    void save_with_title_null() {
        AlbumConsume consume = new AlbumConsume();
        consume.setId(1L);
        consume.setUserId(2L);

        assertThrows(DataIntegrityViolationException.class, () -> {
            this.albumService.save(consume);
        });
    }
}