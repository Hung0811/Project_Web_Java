/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class ErrorBookDTO {
    private String errorBookID, errorBookName, errorAuthor, errorQuantity, errorPrice, errorLinkImage, errorPublicDate;

    public ErrorBookDTO() {
    }

    public ErrorBookDTO(String errorBookID, String errorBookName, String errorAuthor, String errorQuantity, String errorPrice, String errorLinkImage, String errorPublicDate) {
        this.errorBookID = errorBookID;
        this.errorBookName = errorBookName;
        this.errorAuthor = errorAuthor;
        this.errorQuantity = errorQuantity;
        this.errorPrice = errorPrice;
        this.errorLinkImage = errorLinkImage;
        this.errorPublicDate = errorPublicDate;
    }

    public String getErrorBookID() {
        return errorBookID;
    }

    public void setErrorBookID(String errorBookID) {
        this.errorBookID = errorBookID;
    }

    public String getErrorBookName() {
        return errorBookName;
    }

    public void setErrorBookName(String errorBookName) {
        this.errorBookName = errorBookName;
    }

    public String getErrorAuthor() {
        return errorAuthor;
    }

    public void setErrorAuthor(String errorAuthor) {
        this.errorAuthor = errorAuthor;
    }

    public String getErrorQuantity() {
        return errorQuantity;
    }

    public void setErrorQuantity(String errorQuantity) {
        this.errorQuantity = errorQuantity;
    }

    public String getErrorPrice() {
        return errorPrice;
    }

    public void setErrorPrice(String errorPrice) {
        this.errorPrice = errorPrice;
    }

    public String getErrorLinkImage() {
        return errorLinkImage;
    }

    public void setErrorLinkImage(String errorLinkImage) {
        this.errorLinkImage = errorLinkImage;
    }

    public String getErrorPublicDate() {
        return errorPublicDate;
    }

    public void setErrorPublicDate(String errorPublicDate) {
        this.errorPublicDate = errorPublicDate;
    }

    
    
    
}
