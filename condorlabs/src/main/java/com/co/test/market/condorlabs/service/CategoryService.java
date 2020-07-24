package com.co.test.market.condorlabs.service;

import com.co.test.market.condorlabs.domain.Category;
import com.co.test.market.condorlabs.repository.CategoryRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *Service for manipulating the Category object
 * 
 * @author chris
 */
@Service
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    public List<Category> findAllCategories (){
        return categoryRepository.findAll();
    }
}
