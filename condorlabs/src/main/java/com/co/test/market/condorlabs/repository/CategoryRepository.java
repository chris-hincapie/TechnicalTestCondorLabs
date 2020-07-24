package com.co.test.market.condorlabs.repository;

import com.co.test.market.condorlabs.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *Repository for the entity category
 * @author chris
 */
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
}
