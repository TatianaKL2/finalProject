package kg.megacom.Final.Project.repositories;

import kg.megacom.Final.Project.models.entities.Days;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaysRepository extends JpaRepository<Days, Long> {
}
