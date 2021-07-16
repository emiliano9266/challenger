package es.quizt.album.services.sync;

import es.quizt.album.services.resourcesprovider.ResourceProviderFromTypicode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RunAfterSrpingStart {

    private static Logger logger = LoggerFactory.getLogger(RunAfterSrpingStart.class);

    @Autowired
    private SyncService syncService;

    @Autowired
    private ResourceProviderFromTypicode resourceProviderFromTypicode;

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterSpringStart() {
        logger.info("Atentition! We are synchronizing the resources, wait a seconds please");
        this.syncService.sync(this.resourceProviderFromTypicode);
        logger.info("The sync is ready, you can to use the api right now!! =)");
    }
}
