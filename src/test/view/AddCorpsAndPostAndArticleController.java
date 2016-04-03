/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.view;
import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.dialog.Dialogs;
import test.NewFXMain;

/**
 *
 * @author i
 */
public class AddCorpsAndPostAndArticleController {
 NewFXMain newFXMain=new NewFXMain();
    // Reference to the main application

    public void setNewFXMain(NewFXMain newFXMain) {
        this.newFXMain = newFXMain;
    }
      /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param newFXMain
     */
   
}
