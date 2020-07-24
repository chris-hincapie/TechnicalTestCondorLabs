package com.co.test.market.condorlabs.controller;

import com.co.test.market.condorlabs.domain.Product;
import com.co.test.market.condorlabs.service.CategoryService;
import com.co.test.market.condorlabs.service.ProductService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *Controller containing the CRUD of the products
 * 
 * @author chris
 */
@Controller
public class ProductsCRUDController {
    
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductsCRUDController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/products")
    public String listProductsCRUD (Model model){
        
        List<Product> listProducts =  productService.findListProducts();
        model.addAttribute("products",listProducts);
        return "products";
    }
    
    @RequestMapping("/products/searchproducts")
    public String searchProdutctsTable(@RequestParam("p") String name, Model model1){
        List<Product> listProducts = productService.findByNameProductContaining(name);
        model1.addAttribute("products",listProducts);
        return "products";
    }
    
    @RequestMapping("/products/create")
    public String fromProduct(Model model2){
        model2.addAttribute("categories", categoryService.findAllCategories());
        model2.addAttribute("product", new Product());
        return "fromproduct";
    }
    
    @PostMapping("/products/save")
    public String saveProduct(Product productCreate){
        productService.saveProdructNew(productCreate);
        return "redirect:/products";
    }
    
    @RequestMapping("/products/modify")
    public String fromProductUpdate(@RequestParam("m") Integer idProd, Model model3){
        Product productUpdate = productService.searchProductById(idProd);
        model3.addAttribute("categories", categoryService.findAllCategories());
        model3.addAttribute("productUpd",productUpdate);
        return "fromproductupdate";
    }
    
    @PostMapping("/products/update")
    public String modifyProduct(Product modifyProduct){
        System.out.println("dato de objeto: "+modifyProduct.toString());
        productService.saveProdructNew(modifyProduct);
        return "redirect:/products";
    }
    
    @RequestMapping(value = "/products/delete", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam(name = "productId") Integer productId) {
        Product productDelete = productService.searchProductById(productId);
        productService.deleteProductExisting(productDelete);
        return "redirect:/products";
    }
    
    @RequestMapping("/productdetail")
    public String listProductsCRUD (@RequestParam("pd") Integer idProd,Model model4){
        
        Product Product =  productService.searchProductById(idProd);
        model4.addAttribute("productDetail",Product);
        return "productdetail";
    }
}
