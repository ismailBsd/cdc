/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.view;

import bean.CorpDetat;
import bean.Post;
import bean.PostAplusEleme;
import bean.PostSolidaire;
import controler.Session;
import helper.CorpDetatHelper;
import helper.PostHelper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.scene.Group;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.ConsomationService;
import service.CorpDetatService;
import service.PostAplusElemeService;
import service.PostSolidaireService;
import service.Read_Write_File;
import service.BordereauService;
import test.NewFXMain;

/**
 *
 * @author i
 */
public class AddCorpsAndPostController {
         private Stage dialogStage; 
         Read_Write_File ReadWriteService = new Read_Write_File();
     ConsomationService consomationService=new ConsomationService();
    PostSolidaireService postSolidaireService = new PostSolidaireService();
    PostAplusElemeService postAplusElemeService = new PostAplusElemeService();
    CorpDetatService corpDetatService = new CorpDetatService();
    BordereauService borService=new BordereauService();
    // object helper
    CorpDetatHelper corpDetatHelper = null;


    // les varialbe global
    CorpDetat selectedCorpdetat = null;
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
     @FXML
    private TableView<CorpDetat> corpDetatTable;
    @FXML
    private TableColumn<CorpDetat, String> titreCorpsDEtatColumn;
    @FXML
    private TableView<Post> postTable;
    @FXML
    private TableColumn<Post, String> titrePostColonne;
    @FXML
    private RadioButton radioButton1;
    @FXML
    private RadioButton radioButton2;
    @FXML
    private TextField txtField;
    @FXML
    private TextField txtField1;
    @FXML
    private TextArea txtArea ;
    private final ToggleGroup buttonGroup = new ToggleGroup();
    @FXML
    private void initialize() throws SQLException {
      txtField.setEditable(false);
        titreCorpsDEtatColumn.setCellValueFactory(
        		cellData -> cellData.getValue().titreProperty());

        ObservableList<CorpDetat> corpsDEtats = CorpDetatService.listToObservable((List<CorpDetat>) Session.getAttribut("corpDetatsAajouter")) ;
      corpDetatTable.setItems(corpsDEtats);
      corpDetatTable.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
          try {
              showCorpDetatDetails(newValue);
          } catch (SQLException ex) {
              
          }
      });
      radioButton1.setToggleGroup(buttonGroup); 
      radioButton2.setToggleGroup(buttonGroup); 
      radioButton1.setSelected(true);
       buttonGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
        if (buttonGroup.getSelectedToggle() != null) {
          System.out.println(buttonGroup.getSelectedToggle().getUserData().toString());
        }
      }
    });
   
    }
    public void showCorpDetatDetails(CorpDetat etat) throws SQLException{
       selectedCorpdetat=etat;
       CorpDetat selectedcorpdetaInBD = corpDetatService.find(selectedCorpdetat);
            selectedCorpdetat.setId(selectedcorpdetaInBD.getId());
       List <Post>posts= etat.getPosts();
       
       titrePostColonne.setCellValueFactory(
        		cellData -> cellData.getValue().titreProperty());
       postTable.setItems(Post.listToObservable(posts)); 
       postTable.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> die(newValue));//fonction die hommage au mot allemand
       
   }
    private void die(Post post){
     
        txtField.setText(post.getTitre());
    }
    @FXML
    private void handleButton1(){
    Post post =getParams();
    if(radioButton1.isSelected()){
          try {
                PostSolidaire postSolidaire = postSolidaireService.castPostToPostSolidair(post);
                postSolidaireService.save(postSolidaire);
               Post.listToObservable (selectedCorpdetat.getPosts()).remove(post);
                 postTable.getSelectionModel().clearSelection();
                setVoidView();
                Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information Dialog");
alert.setHeaderText("Look, an Information Dialog");
alert.setContentText( "le post :" + post.getTitre() + "the post is corectly insred");

alert.showAndWait();
               
            } catch (SQLException ex) {
                System.out.println("errreur");
            }
        } else {//ila kan post aplusierelemant
            try {
                PostAplusEleme postaplusEleme =postAplusElemeService.castPostToPostApluselem(post);
                postAplusElemeService.save(postaplusEleme);
               Post.listToObservable (selectedCorpdetat.getPosts()).remove(post);
            postTable.getSelectionModel().clearSelection();
              
                setVoidView();
                Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information Dialog");
alert.setHeaderText("Look, an Information Dialog");
alert.setContentText( "le post :" + post.getTitre() + "the post is corectly insred");

alert.showAndWait();
                
               
            } catch (SQLException ex) {
                System.out.println("errur");
            }
        }
                              
    }
     private void setVoidView() {
        txtArea.setText("");
        txtField1.setText("");
        txtField.setText("");
    }

    private Post getParams(){
         Post post = new Post();
        post.setTitre(txtField.getText());
        post.setDescription(txtArea.getText());
        post.setPrix(new Double(txtField1.getText()));
        post.setCorpdetat(selectedCorpdetat);
        return post;
    }
    @FXML
    private void moveToCocher() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(NewFXMain.class.getResource("view/ArticleView.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
       
        // Create the dialog Stage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("cocher les articles");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(this.dialogStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
         ArticleViewController controller=loader.getController();
         controller.setDialogStage(dialogStage);
         this.dialogStage.close();
        dialogStage.show();
    }
}
