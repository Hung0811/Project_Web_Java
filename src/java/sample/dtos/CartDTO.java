/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class CartDTO {
    private HashMap<String, BookDTO> cart;

    public CartDTO() {
    }

    public CartDTO(HashMap<String, BookDTO> cart) {
        this.cart = cart;
    }

    public void add(BookDTO book){
        if(cart==null){
            cart=new HashMap<String, BookDTO>();
        }
        if(cart.containsKey(book.getId())){
            int number=cart.get(book.getId()).getQuantity()+1;
            book.setQuantity(number);
        }
        cart.put(book.getId(), book);
        
    }
  
    public void update(int amount, String bookID){
        BookDTO book=cart.get(bookID);
        book.setQuantity(amount);
        
        cart.put(bookID, book);
    }
    
    public void remove(String bookID){
        cart.remove(bookID);
    }
    
    public HashMap<String, BookDTO> getCart() {
        return cart;
    }

    public void setCart(HashMap<String, BookDTO> cart) {
        this.cart = cart;
    }
}
