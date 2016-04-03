/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Objects;

/**
 *
 * @author kamal
 */
public class PostAplusEleme extends Post{

    public PostAplusEleme() {
    }

    public PostAplusEleme(int id, String titre, String description) {
        super(id, titre, description);
    }

    public PostAplusEleme(int id, String titre, String description, double prix) {
        super(id, titre, description, prix);
    }

    

    
}
