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
public class worker {
    
    int id;
    String username, password;

    public worker(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
 
}
