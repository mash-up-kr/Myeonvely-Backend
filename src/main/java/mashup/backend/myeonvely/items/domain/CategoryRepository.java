package mashup.backend.myeonvely.items.domain;

import mashup.backend.myeonvely.users.domain.Devices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
