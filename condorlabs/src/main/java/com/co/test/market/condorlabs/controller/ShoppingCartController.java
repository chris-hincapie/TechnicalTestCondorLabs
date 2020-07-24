package com.co.test.market.condorlabs.controller;

import com.co.test.market.condorlabs.domain.Shopping;
import com.co.test.market.condorlabs.service.ProductService;
import com.co.test.market.condorlabs.service.ShoppingService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
Controller that contains the handling of the shopping cart, the detail of each of the products
 * 
 * @author chris
 */
@Controller
public class ShoppingCartController {
    
    private final ProductService productService;
    private final ShoppingService shoppingService;

    public ShoppingCartController(ProductService productService, ShoppingService shoppingService) {
        this.productService = productService;
        this.shoppingService = shoppingService;
    }
     
    @RequestMapping("/shoppingcart")
    public String listProductsCart(Model model){
        
        List<Shopping> listProductsCart =  shoppingService.findAllByProducts();
        model.addAttribute("listProductsCart",listProductsCart);
        return "shoppingcart";
    }
    
    @RequestMapping(value = "/shoppingcart/addcart", method = RequestMethod.GET)
    public String addProductToShopping(@RequestParam("productId") Integer productId){
        shoppingService.addToCart(productService.searchProductById(productId));
        return "redirect:/";
    }
    
    @RequestMapping(value = "/shoppingcart/remove", method = RequestMethod.GET)
    public String removeProductFromCart(@RequestParam(name = "sId") Integer shoppingId) {
        Shopping shoppingDelete = shoppingService.searchShoppingById(shoppingId);
        shoppingService.deleteShoppingExisting(shoppingDelete);
        return "redirect:/shoppingcart";
    }
    
    @RequestMapping("/shoppingcart/buyCart")
    public String saveProducts(){
        shoppingService.buyShoppingCart();
        return "redirect:/";
    }
}
