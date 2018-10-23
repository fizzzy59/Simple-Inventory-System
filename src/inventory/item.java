/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

/**
 *
 * @author hafizhi.z
 */
public class item {
    
    int id, quantity;
    String name;

    public item(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public int quantityAdd(int quantity) {
        return (this.quantity + quantity);
    }
    
    public int quantityMinus(int quantity) {
        return (this.quantity - quantity);
    }
    
    public void display() {
        System.out.println("****************************");
        System.out.println("ID       : "+id);
        System.out.println("Name     : "+name);
        System.out.println("Quantity : "+quantity);
        System.out.println("****************************");
    }
}
