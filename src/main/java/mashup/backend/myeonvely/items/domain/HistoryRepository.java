package mashup.backend.myeonvely.items.domain;

import mashup.backend.myeonvely.users.domain.Devices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
