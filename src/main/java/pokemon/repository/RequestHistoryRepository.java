package pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pokemon.entity.RequestHistory;

@Repository
public interface RequestHistoryRepository extends JpaRepository<RequestHistory, Long> {

}
