package test.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import org.controlsfx.dialog.Dialogs;
import test.NewFXMain;



/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * @author Marco Jakob
 */
public class RootLayoutController {
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
   
    

    /**
     * Creates an empty address book.
     */
    @FXML
    private void handleNew() {
//        mainApp.getPersonData().clear();
//        mainApp.setPersonFilePath(null);
        
            // Load root layout from fxml file.
         
         newFXMain.showProjetEditDialog();
    }
   
@FXML
private void handleNewArticle1(){
    newFXMain.showAddArticle1();
}
@FXML
private void handleNewArticle2(){
    newFXMain.showAddArticle2();
}
    @FXML
    private void handleSaveAs() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"Word files (*.docx)", "*.docx");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showSaveDialog(newFXMain.getPrimaryStage());

		if (file != null) {
			// Make sure it has the correct extension
			if (!file.getPath().endsWith(".docx")) {
				file = new File(file.getPath() + ".docx");
			}
			
		}
	}
    
    /**
     * Opens the birthday statistics.
     */
  

    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
		Dialogs.create()
	        .title("Auteur")
	        .masthead("About")
	        .message("Boussaid Ismail Berriga Kamal Benchalh Youssef")
	        .showInformation();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}