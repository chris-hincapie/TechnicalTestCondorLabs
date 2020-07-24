package com.co.test.market.condorlabs.service;

import com.co.test.market.condorlabs.domain.Product;
import com.co.test.market.condorlabs.domain.Shopping;
import java.util.List;
import com.co.test.market.condorlabs.repository.ShoppingRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *service for manipulating the Shopping object
 * 
 * @author chris
 */
@Service
public class ShoppingService {

    private final static String STATUS_PENDING = "PENDING_TO_PURCHASE";
    private final static String PURCHASE = "PURCHASE";

    private final ShoppingRepository shoppingRepository;

    public ShoppingService(ShoppingRepository shoppingRepository) {
        this.shoppingRepository = shoppingRepository;
    }

    public List<Shopping> findAllByProducts() {
        return shoppingRepository.findAllByProducts(STATUS_PENDING);
    }

    public Shopping addToCart(Product addProduct) {
        Shopping newShop = new Shopping();
        newShop.setProduct(addProduct);
        newShop.setStatus(STATUS_PENDING);
        return shoppingRepository.save(newShop);
    }
    
    //service that buys all products in pending status for purchase
    public void buyShoppingCart() {
        List<Shopping> listShopping = findAllByProducts();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date date = new Date();
        for (Shopping shopping : listShopping) {
            shopping.setStatus(PURCHASE);
            shopping.setDateShopping(dateFormat.format(date));
            shoppingRepository.save(shopping);
        }
    }

    public Shopping searchShoppingById(Integer shoppingId) {
        return shoppingRepository.getOne(shoppingId);
    }

    public void deleteShoppingExisting(Shopping shoppingDel) {
        shoppingRepository.delete(shoppingDel);
    }

}
