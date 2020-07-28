package mashup.backend.myeonvely.items.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items, Long> {
    List<Items> findAllByUser(Long userId);
//    Page<Items> findAllByUsersId(Long userId, Pageable pageable);
}
