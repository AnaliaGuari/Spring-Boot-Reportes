package dia29.apiproduct.repositories;

import dia29.apiproduct.model.Clients;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IClientsRepository extends JpaRepository<Clients,Long>{
    
}
