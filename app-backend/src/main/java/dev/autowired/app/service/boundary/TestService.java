package dev.autowired.app.service.boundary;

import dev.autowired.app.service.entity.Offer;
import lombok.extern.slf4j.Slf4j;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Stateless
public class TestService {

    @PersistenceContext
    private EntityManager entityManager;

    public Offer save() {
//        Offer offer = new Offer().setMessage("hehehe");
//        entityManager.persist(offer);
        log.error("fdsgfsdg");
        log.info("efsgfsegs");
        log.warn("teta");
        return new Offer();
    }
}
