package dia29.apiproduct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dia29.apiproduct.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long>{
    
}
