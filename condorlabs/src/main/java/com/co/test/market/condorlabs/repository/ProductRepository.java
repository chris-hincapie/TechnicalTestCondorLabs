package com.co.test.market.condorlabs.repository;

import com.co.test.market.condorlabs.domain.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *Repository for the entity Product
 * 
 * @author chris
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{
    
    //Query to search all products ordered by name (using JPQL)
    @Query("from Product pr order by pr.name")
    List<Product> findListProducts();
    
    //Query to search all products that have the same category ordered by name (using JPQL)
    @Query("from Product pr where pr.category.id = ?1 "
            + "order by pr.name")
    List<Product> findProductsByCategory (Integer idCategory);
    
    //method to search for products that contain the search word(using Query Methodd)
    List<Product> findByNameContaining(String nameProduct);
}
