/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

/**
 *
 * @author kamal
 */
public class ConsomationItem {
    private String id;
    private Post post=new Post();
    private int quanite ;
    private String unite;

    public ConsomationItem() {
    }

    public ConsomationItem(String id, int quanite, String unite) {
        this.id = id;
        this.quanite = quanite;
        this.unite = unite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getQuanite() {
        return quanite;
    }

    public void setQuanite(int quanite) {
        this.quanite = quanite;
    }

    public String  getUnite() {
        return unite;
    }

    public void setUnite(String  unite) {
        this.unite = unite;
    }

    @Override
    public String toString() {
        return "ConsomationItem{" + "id=" + id + ", post=" + post + ", quanite=" + quanite + ", unite=" + unite + '}';
    }
     
    
}
