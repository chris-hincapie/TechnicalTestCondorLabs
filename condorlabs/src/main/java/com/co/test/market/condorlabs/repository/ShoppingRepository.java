package com.co.test.market.condorlabs.repository;

import com.co.test.market.condorlabs.domain.Shopping;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *Repository for the entity shopping
 * 
 * @author chris
 */
public interface ShoppingRepository extends JpaRepository<Shopping, Integer>{
    
    //Query to search for the pending products to buy in the marketplace (using JPQL)
    @Query("select sc from Shopping sc where sc.status = ?1 order by sc.id")
    List<Shopping> findAllByProducts(String statusPending);
}
