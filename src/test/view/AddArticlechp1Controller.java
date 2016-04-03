/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.view;

import bean.ArticleChp1;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ArticleChp1Service;

/**
 *
 * @author i
 */
public class AddArticlechp1Controller {
    Stage dialogStage;
 ArticleChp1Service articleChp1Service = new ArticleChp1Service();
    @FXML
   private TableView<ArticleChp1> articleChap1Table;
    @FXML
    private TableColumn<ArticleChp1, String> titre1Col;
    @FXML
    private TextField chp1Text;
     @FXML
    private Button button1;
     @FXML 
             TextArea txtarea;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage; //To change body of generated methods, choose Tools | Templates.
    }
    @FXML
    void initialize() throws SQLException{
       titre1Col.setCellValueFactory(
                cellData -> cellData.getValue().titreProperty());
        ObservableList<ArticleChp1> articleArticleChp1ss = ArticleChp1Service.listToObservable(articleChp1Service.finAll());
        
                articleChap1Table.setItems(articleArticleChp1ss);
    }
    @FXML
    void save() throws SQLException{
        ArticleChp1 chp1=new ArticleChp1();
        chp1.setTitre(chp1Text.getText());
        chp1.setContenu(txtarea.getText());
        chp1.setId(Integer.decode(chp1Text.getText()));
        articleChp1Service.save(chp1);
       articleChap1Table.getItems().add(chp1);
       
    }
}
