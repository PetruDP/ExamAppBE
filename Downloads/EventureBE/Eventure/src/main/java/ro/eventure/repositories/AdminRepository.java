package ro.eventure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.eventure.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
