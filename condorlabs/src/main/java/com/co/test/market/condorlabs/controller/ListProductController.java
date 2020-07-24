package com.co.test.market.condorlabs.controller;

import com.co.test.market.condorlabs.domain.Product;
import com.co.test.market.condorlabs.service.ProductService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
Controller that has grouped the different searches and the sample of all the products that you have in BD
 * 
 * @author chris
 */
@Controller
public class ListProductController {
    
    private final ProductService productService;

    public ListProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @RequestMapping("/")
    public String listOfProducts (Model model1){
        
        List<Product> listProductsFeatured =  productService.findListProducts();
        model1.addAttribute("products",listProductsFeatured);
        return "listproducts";
    }
    
    @RequestMapping("/search")
    public String busquedaVideojuegoPorNombre(@RequestParam("q") String name, Model model2){
        List<Product> listProducts = productService.findByNameProductContaining(name);
        model2.addAttribute("products",listProducts);
        return "listproducts";
    }
    
    @RequestMapping("/productsbycategory")
    public String listarVideojuegoPorDistribuidor(int categoryId, Model model3){
        List<Product> productsfiltered = productService.findProductsByCategory(categoryId);
        model3.addAttribute("products",productsfiltered);
        return "listproducts";
    }
}
