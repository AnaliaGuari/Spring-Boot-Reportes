package dia29.apiproduct.service;

import java.util.List;

import dia29.apiproduct.model.Product;

public interface IProductService {
    
    List<Product> getAll();
	boolean save(Product p);
	boolean delete(long code);
	boolean update(Product bd);
}
