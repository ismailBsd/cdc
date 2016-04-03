/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.view;

import bean.ArticleChp2;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ArticleChp2Service;

/**
 *
 * @author i
 */
public class AddArticleChp2Controller {
    Stage dialogStage;
    ArticleChp2Service articleChp2Service = new ArticleChp2Service();
 @FXML
      private TableView<ArticleChp2> articleChap2Table;
 @FXML
    private TableColumn<ArticleChp2, String> titre2Col;
    @FXML
    private TextField TextArticle;
     @FXML
    private Button button1;
     @FXML 
             TextArea txtarea;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage; //To change body of generated methods, choose Tools | Templates.
    }
    @FXML
    void initialize() throws SQLException{
    ObservableList<ArticleChp2> articleArticleChp2ss = ArticleChp2Service.listToObservable(articleChp2Service.finAll());
    titre2Col.setCellValueFactory(
                cellData -> cellData.getValue().titreProperty());
     articleChap2Table.setItems(articleArticleChp2ss);
}
    
    @FXML
    void save() throws SQLException{
        ArticleChp2 chp2=new ArticleChp2();
        chp2.setTitre(TextArticle.getText());
        chp2.setContenu(txtarea.getText());
        chp2.setId(10);
        articleChp2Service.save(chp2);
        articleChap2Table.getItems().add(chp2);
       
    }
}
