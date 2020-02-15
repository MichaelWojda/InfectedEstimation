package pl.mw.infectionspread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mw.infectionspread.model.Data;
import pl.mw.infectionspread.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
