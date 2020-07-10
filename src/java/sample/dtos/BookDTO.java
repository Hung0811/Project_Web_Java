/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class BookDTO {

    private String id, name, author;
    private int price, quantity;
    private Date datePublic;
    private String linkImage;

    public BookDTO() {
    }

    public BookDTO(String id, String name, String author, int price, int quantity, Date datePublic, String linkeImage) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.datePublic = datePublic;
        this.linkImage = linkeImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDatePublic() {
        return datePublic;
    }

    public void setDatePublic(Date datePublic) {
        this.datePublic = datePublic;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

}
