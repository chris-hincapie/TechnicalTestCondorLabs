package com.co.test.market.condorlabs.service;

import com.co.test.market.condorlabs.domain.Product;
import com.co.test.market.condorlabs.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *service for manipulating the Product object
 * 
 * @author chris
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findListProducts() {
        return productRepository.findListProducts();
    }

    public List<Product> findProductsByCategory(Integer idCategory) {
        return productRepository.findProductsByCategory(idCategory);
    }

    public List<Product> findByNameProductContaining(String nameProduct) {
        return productRepository.findByNameContaining(nameProduct);
    }
    
    public Product saveProdructNew(Product productNew){
        return productRepository.save(productNew);
    } 
    
    public void deleteProductExisting(Product productDel){
        productRepository.delete(productDel);
    }
    public Product searchProductById(Integer idProduct){
        return productRepository.getOne(idProduct);
    }
}
