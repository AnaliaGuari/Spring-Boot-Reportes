package dia29.apiproduct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dia29.apiproduct.model.Product;
import dia29.apiproduct.repositories.IProductRepository;

public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productR;

    @Override
    public boolean delete(long code) {
        if (productR.existsById(code)) {
            productR.deleteById(code);
            return true;
        } else
            return false;
    }

    @Override
    public List<Product> getAll() {
        return productR.findAll();

    }

    @Override
    public boolean save(Product p) {
       if(productR.existsById(p.getCode()))
             return false;
        else{
            productR.save(p);
            return true;
        }
    }

    @Override
    public boolean update(Product bd) {
        if (productR.existsById(bd.getCode())) {
            productR.save(bd);
            return true;
        } else
            return false;
    }

}
