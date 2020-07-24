package com.co.test.market.condorlabs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Domain for shopping entity
 * 
 * @author chris
 */
@Table(name = "shopping")
@Entity
public class Shopping {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
            
    @ManyToOne 
    private Product product;
    
    @Column(name = "date_shopping")
    private String dateShopping;
            
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        if (product != null) {
            return product;
        } else {
            return new Product();
        }
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDateShopping() {
        return dateShopping;
    }

    public void setDateShopping(String dateShopping) {
        this.dateShopping = dateShopping;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Shopping{" + "id=" + id + ", product=" + product + ", dateShopping=" + dateShopping + ", status=" + status + '}';
    }
}
