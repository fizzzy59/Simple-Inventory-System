/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author hafizhi.z
 */
public class Inventory {

    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int id = 0, option = 0, itemQty;
        String username, password, itemName;
        boolean login = false;
        ArrayList <worker> user = registeredUser();
        ArrayList <item> stock = registeredItem();

        while(option != -1) {
            System.out.println();
            System.out.println("Welcome to Inventory Management System");
            System.out.println();
            mainMenu();
            option = input.nextInt();
            if(option == 1) {
                System.out.println("****************************");
                System.out.println("Enter your :-");
                System.out.print("Username : ");
                username = input.next();
                System.out.print("Password : ");
                password = input.next();
                for (int i = 0; i < user.size(); i++) {
                    if (user.get(i).getUsername().equals(username) && user.get(i).getPassword().equals(password)) {
                        login = true;
                    }
                }
                if(login == true) {
                    System.out.println("****************************");
                    System.out.println("-----Successfully Login-----");
                    while(option != 3) {
                        secondMenu();
                        option = input.nextInt();
                        if(option == 1) {
                            while(option != 5) {
                                thirdMenu();
                                option = input.nextInt();
                                if(option == 1) {
                                    while(option != 3) { 
                                        fourthMenu();
                                        option = input.nextInt();
                                        if(option == 1) {
                                            System.out.println("****************************");
                                            System.out.print("Item's Name     : ");
                                            itemName = input.next();
                                            System.out.print("Item's Quantity : ");
                                            itemQty = input.nextInt();
                                            if(checkExistedItem(stock, itemName) == false) {
                                                    int n = stock.get(stock.size() - 1).getId();
                                                    stock.add(new item(n+1,itemName,itemQty));
                                                    System.out.println("****************************");
                                                    System.out.println("---Successfully created !---");
                                                }
                                                else {
                                                    System.out.println("****************************");
                                                    System.out.println("-------Already exist !------");
                                                }
                                        }
                                        else if(option == 2) {
                                            System.out.println("****************************");
                                            System.out.println("--------List of Items-------");
                                            for (int i = 0; i < stock.size(); i++) {
                                                stock.get(i).display();
                                            }
                                            System.out.println("***********Delete***********");
                                            System.out.print("Item's Name     : ");
                                            itemName = input.next();
                                            if(checkExistedItem(stock, itemName) == true) {
                                                stock.remove(getItemIndex(stock, itemName));
                                                System.out.println("****************************");
                                                System.out.println("---Successfully deleted !---");
                                            }
                                            else {
                                                System.out.println("****************************");
                                                System.out.println("------Item Not Found !-------");
                                            }
                                        }
                                    }

                                }
                                else if(option == 2) {
                                    while(option != 3) {
                                        fifthMenu();
                                        option = input.nextInt();
                                        if(option == 1) {
                                            System.out.println("*************In************");
                                            System.out.print("Item's Name        : ");
                                            itemName = input.next();
                                            if(checkExistedItem(stock, itemName) == true) {
                                                System.out.println("Current Quantity   : "+stock.get(getItemIndex(stock, itemName)).getQuantity());
                                                System.out.print("How Much to Add    : ");
                                                itemQty = input.nextInt();
                                                int newitemQty = stock.get(getItemIndex(stock, itemName)).quantityAdd(itemQty);
                                                stock.get(getItemIndex(stock, itemName)).setQuantity(newitemQty);
                                                System.out.println("****************************");
                                                System.out.println("---Successfully Changed !---");
                                            }
                                            else {
                                                System.out.println("****************************");
                                                System.out.println("------Item Not Found !-----");
                                            }
                                        }
                                        else if(option == 2) {
                                            System.out.println("*************Out************");
                                            System.out.print("Item's Name       : ");
                                            itemName = input.next();
                                            if(checkExistedItem(stock, itemName) == true) {
                                                System.out.println("Current Quantity  : "+stock.get(getItemIndex(stock, itemName)).getQuantity());
                                                System.out.print("How Much to Minus : ");
                                                itemQty = input.nextInt();
                                                int newitemQty = stock.get(getItemIndex(stock, itemName)).quantityMinus(itemQty);
                                                stock.get(getItemIndex(stock, itemName)).setQuantity(newitemQty);
                                                System.out.println("****************************");
                                                System.out.println("---Successfully Changed !---");
                                            }
                                            else {
                                                System.out.println("****************************");
                                                System.out.println("------Item Not Found !-----");
                                            }
                                        } 
                                    }
                                }
                                else if(option == 3) {
                                    System.out.println("****************************");
                                    System.out.println("--------List of Items-------");
                                    for (int i = 0; i < stock.size(); i++) {
                                        stock.get(i).display();
                                    }
                                    System.out.println("***********Update***********");
                                    System.out.print("Current Name : ");
                                    itemName = input.next();
                                    if(checkExistedItem(stock, itemName) == true) {
                                        System.out.print("New Name     : ");
                                        String newItemName = input.next();
                                        stock.get(getItemIndex(stock, itemName)).setName(newItemName);
                                        System.out.println("****************************");
                                        System.out.println("---Successfully Updated !---");
                                    }
                                    else {
                                        System.out.println("****************************");
                                        System.out.println("------Item Not Found !-----");
                                    }
                                }
                                else if(option == 4) {
                                    System.out.println("****************************");
                                    System.out.println("--------List of Items-------");
                                    for (int i = 0; i < stock.size(); i++) {
                                        stock.get(i).display();
                                    }
                                }
                            }
                        }
                        else if(option == 2) {
                            System.out.println("****************************");
                            System.out.println("Update your :-");
                            System.out.print("Password : ");
                            password = input.next();
                            for (int i = 0; i < user.size(); i++) {
                                if (user.get(i).getUsername().equals(username)) {
                                    id = user.get(i).getId();
                                }
                            }
                            user.get(id-1).setPassword(password);
                            System.out.println("****************************");
                            System.out.println("---Successfully Updated !---");
                        }
                    }
                }
                else {
                    System.out.println("****************************");
                    System.out.println("--Wrong username/password !--");
                }
                
                login = false;
                
            }
            else if(option == 2) {
                System.out.println("****************************");
                System.out.println("Create your :-");
                System.out.print("Username : ");
                username = input.next();
                System.out.print("Password : ");
                password = input.next();
                
                if(checkExistedUser(user,username) == false) {
                    int n = user.get(user.size() - 1).getId();
                    user.add(new worker(n+1,username,password));
                    System.out.println("****************************");
                    System.out.println("---Successfully created !---");
                }
                else {
                    System.out.println("****************************");
                    System.out.println("-------Already exist !------");
                }
            }
            else if(option == 3)
                 option = -1;
        }
        
    }
    
    public static void mainMenu() {
        System.out.println("****************************");
        System.out.println("1 . Login");
        System.out.println("2 . Register");
        System.out.println("3 . Exit");
        System.out.println("****************************");
        System.out.print("Choose : ");
    }
    
    public static void secondMenu() {
        System.out.println("****************************");
        System.out.println("1 . Manage items");
        System.out.println("2 . Update password");
        System.out.println("3 . Logout");
        System.out.println("****************************");
        System.out.print("Choose : ");
    }
    
    public static void thirdMenu() {
        System.out.println("****************************");
        System.out.println("1 . Create/Delete item");
        System.out.println("2 . Manage item quantity");
        System.out.println("3 . Update item name");
        System.out.println("4 . Display list of items");
        System.out.println("5 . Back");
        System.out.println("****************************");
        System.out.print("Choose : ");
    }
    
    public static void fourthMenu() {
        System.out.println("****************************");
        System.out.println("1 . Create");
        System.out.println("2 . Delete");
        System.out.println("3 . Back");
        System.out.println("****************************");
        System.out.print("Choose : ");
    }
    
    public static void fifthMenu() {
        System.out.println("****************************");
        System.out.println("1 . In");
        System.out.println("2 . Out");
        System.out.println("3 . Back");
        System.out.println("****************************");
        System.out.print("Choose : ");
    }
    
    public static ArrayList<worker> registeredUser() {
        ArrayList <worker> user = new ArrayList<worker>();
        user.add(new worker(1,"user1","user1"));
        user.add(new worker(2,"user2","user2"));
        return user;
    }
    
    public static ArrayList<item> registeredItem() {
        ArrayList <item> stock = new ArrayList<item>();
        stock.add(new item(1,"Motherboard",30));
        stock.add(new item(2,"Mouse",10));
        stock.add(new item(3,"Keyboard",35));
        stock.add(new item(4,"Monitor",15));
        return stock;
    }
    
    public static boolean checkExistedUser(ArrayList<worker> user, String username) {
        boolean condition = false;
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getUsername().equals(username)) {
                condition = true;
            }
        }        
        return condition;
    }
    
     public static boolean checkExistedItem(ArrayList<item> stock, String itemName) {
        boolean condition = false;
        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i).getName().equals(itemName)) {
                condition = true;
            }
        }        
        return condition;
    }
     
     public static int getItemIndex(ArrayList<item> stock, String itemName) {
        int index = 0;
        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i).getName().equals(itemName)) {
                index = i;
            }
        }        
        return index;
    }
}
