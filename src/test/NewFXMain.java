/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import bean.Entree;
import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.controlsfx.dialog.Dialogs;
import test.view.AddArticleChp2Controller;
import test.view.AddArticlechp1Controller;
import test.view.ArticleViewController;
import test.view.ProjetEditDialogController;

/**
 *
 * @author i
 */
public class NewFXMain extends Application {

    Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Mon application");
        initRootLayout();

    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NewFXMain.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void showAddArticle1() {

        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NewFXMain.class.getResource("view/AddArticleChp1.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Nouveau article");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            // Set the person into the controller.
            AddArticlechp1Controller controller = loader.getController();
            controller.setDialogStage(dialogStage);

            // Show the dialog and wait until the user closes it
            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void showAddArticle2() {

        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NewFXMain.class.getResource("view/AddArticleChp2.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Nouveau article chp2");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            // Set the person into the controller.
            AddArticleChp2Controller controller = loader.getController();
            controller.setDialogStage(dialogStage);

            // Show the dialog and wait until the user closes it
            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void showProjetEditDialog() {

        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NewFXMain.class.getResource("view/ProjetEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Entree entree = new Entree();
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Nouveau projet");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            // Set the person into the controller.
            ProjetEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
        //controller.setEntree(entree);

            // Show the dialog and wait until the user closes it
            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public File getPersonFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(NewFXMain.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
