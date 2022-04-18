package leewonhoi.myshop.repository;

import leewonhoi.myshop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        em.persist(item);
    }

    public Optional<Item> findItem(Long itemId) {
        Item item = em.find(Item.class, itemId);
        return Optional.of(item);
    }

    public List<Item> findAllItem() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }

}
