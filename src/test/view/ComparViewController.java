/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.view;

import bean.Consomation;
import bean.CorpDetat;
import bean.Post;
import bean.PostAplusEleme;
import bean.PostSolidaire;
import controler.Session;
import helper.CorpDetatHelper;
import helper.PostAplusElemeHelper;
import helper.PostHelper;
import helper.PostSolidaireHelper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.dialog.Dialogs;
import service.ConsomationService;
import service.CorpDetatService;
import service.PostAplusElemeService;
import service.PostSolidaireService;
import service.Read_Write_File;
import test.NewFXMain;

/**
 *
 * @author i
 */
public class ComparViewController {

    private Stage dialogStage;
    private ObservableList<CorpDetat> corpdetatConsomer;
    Read_Write_File xlxsSerivce = new Read_Write_File();
    ConsomationService consomationService = new ConsomationService();
    PostSolidaireService postSolidaireService = new PostSolidaireService();
    PostAplusElemeService postAplusElemeService = new PostAplusElemeService();
    CorpDetatService corpDetatService = new CorpDetatService();
    CorpDetat selectedCorpDetat = null;
    Post selectedPos = null;

    CorpDetat selectedCorpDetatTb3 = null;

    // object helper
    CorpDetatHelper corpDetatHelper = null;
    PostHelper postHelper = null;
    CorpDetatHelper corpDetatHelper2 = null;

    PostSolidaireHelper postSolidaireHelper = null;
    PostAplusElemeHelper postAplusElemeHelper = null;

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private TableView<CorpDetat> corpDetatTable;
    @FXML
    private TableView<Post> posteTable;
    @FXML
    private TableColumn<Post, String> titreColonne;
    @FXML
    private TableColumn<CorpDetat, String> titreColumn;
    @FXML
    private TextField corpDetatText;
    @FXML
    private TextField postText;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private TableView<CorpDetat> corpDetatDaoTable;
    @FXML
    private TableColumn<CorpDetat, String> titreCorpsDEtatColumn;
    @FXML
    private TableView<PostSolidaire> posteSolidaireTable;
    @FXML
    private TableColumn<PostSolidaire, String> titrePosteSolidaireColonne;

    @FXML
    private TableView<PostAplusEleme> posteAPlusElemTable;
    @FXML
    private TableColumn<PostAplusEleme, String> titrePostAplusElemeColonne;

    public ComparViewController() {
        this.corpdetatConsomer = FXCollections.observableArrayList();
    }

    public void showCorpDetatDetails(CorpDetat etat) {
        selectedCorpDetat = etat;
        postText.setText("");
        postText.setEditable(false);
        corpDetatText.setEditable(true);
        List<Post> posts = etat.getPosts();
        corpDetatText.setText(etat.getTitre());
        titreColonne.setCellValueFactory(
                cellData -> cellData.getValue().titreProperty());
        posteTable.setItems(Post.listToObservable(posts));
        posteTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> handlePost(newValue));
    }

    @FXML
    private void handleOk() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Are you ok with this?");
        Optional result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            selectedCorpDetat.setTitre(corpDetatText.getText());
            corpdetatConsomer.set(corpdetatConsomer.indexOf(selectedCorpDetat), selectedCorpDetat);
        }
    }

    @FXML
    private void initialize() throws SQLException {

        //corpdetatConsomer = xlxsService.getCorp_from_consomationXls(consomations);
        titreColumn.setCellValueFactory(
                cellData -> cellData.getValue().titreProperty());
        titreCorpsDEtatColumn.setCellValueFactory(
                cellData -> cellData.getValue().titreProperty());
        titrePosteSolidaireColonne.setCellValueFactory(
                cellData -> cellData.getValue().titreProperty());
        titrePostAplusElemeColonne.setCellValueFactory(
                cellData -> cellData.getValue().titreProperty());
        ObservableList<Consomation> consomations = (ObservableList<Consomation>) Session.getAttribut("consomations");
        ObservableList<CorpDetat> corpsDEtats = CorpDetatService.listToObservable(corpDetatService.finAll());
        ObservableList<PostSolidaire> postSolidaires = PostSolidaireService.listToObservable(postSolidaireService.finAll());
        ObservableList<PostAplusEleme> postAplusElemes = PostAplusElemeService.listToObservable(postAplusElemeService.finAll());
        corpDetatDaoTable.setItems(corpsDEtats);;
        posteSolidaireTable.setItems(postSolidaires);
        posteAPlusElemTable.setItems(postAplusElemes);
        corpdetatConsomer = consomationService.getCorp_from_consomationXls(consomations);
        corpDetatTable.setItems(corpdetatConsomer);
        corpDetatTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showCorpDetatDetails(newValue));

    }

    private void handlePost(Post post) {
        corpDetatText.setEditable(false);
        postText.setEditable(true);
        selectedPos = post;
        postText.setText(post.getTitre());
    }

    @FXML
    private void handlePostOk() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Are you ok with this?");
        Optional result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            selectedPos.setTitre(postText.getText());
            selectedCorpDetat.getPosts().set(selectedCorpDetat.getPosts().indexOf(selectedPos), selectedPos);
        }
    }

    @FXML
    private void suivant() {
        List<CorpDetat> corpDetatsAajouter;
        try {
            corpDetatsAajouter = consomationService.getCorp_Not_in_Basedata(corpdetatConsomer);
            Session.setAttribut(corpDetatsAajouter, "corpDetatsAajouter");
            System.out.println("for dyl copr a ajouter");
            for (CorpDetat corpDetatsAajouter1 : corpDetatsAajouter) {
                System.out.println(corpDetatsAajouter1.getTitre());
            }
        } catch (SQLException ex) {

        }
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NewFXMain.class.getResource("view/AddCorpsAndPost.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("ajouter les postes inexistants dans la base donnee");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.dialogStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            AddCorpsAndPostController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            this.dialogStage.close();
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
