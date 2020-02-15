package pl.mw.infectionspread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mw.infectionspread.model.Data;

@Repository
public interface DataRepository extends JpaRepository<Data,Integer> {
}
