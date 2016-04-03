package test.view;

import bean.Consomation;
import bean.Entree;
import controler.Session;
import javafx.collections.ObservableList;
import java.io.File;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import service.ConsomationService;
import service.Read_Write_File;
import test.NewFXMain;



/**
 * Dialog to edit details of a person.
 * 
 * @author Ismail Boussaid
 */
public class ProjetEditDialogController {

    @FXML
    private TextField nDEnregistrement;
    @FXML
    private TextField dateDEnregistrement;
    @FXML
    private TextField versionDuProjet;
    @FXML
    private TextField designationDuProjet;
    @FXML
    private TextField sigle;
    @FXML
    private TextField delai;


    private Stage dialogStage;
    private Entree entree;
    private boolean okClicked = false;
    Read_Write_File xlxsSerivce = new Read_Write_File();
    private NewFXMain newFXMain;
    
    public void setNewFXMain(NewFXMain newFXMain) {
        this.newFXMain = newFXMain;
    }
   

        
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the entree to be edited in the dialog.
     * 
     * @param entree
     */
    public void setEntree(Entree entree) {
        this.entree = entree;

        //nDEnregistrement.setText(""+entree.getnDEnregistrement());
        //DateDEnregistrement.setText(DateUtil.format(entree.getDateDEnregistrement()));
   //     DateDEnregistrement.setPromptText("dd.mm.yyyy");
        //versionDuProjet.setText(""+entree.getVersionDuProjet());
        //designationDuProjet.setText(entree.getDesignationDuProjet());
       // sigle.setText(entree.getSigle());
      //  delai.setText(DateUtil.format(entree.getDelai()));
        //delai.setPromptText("dd.mm.yyyy");
    }

    
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    @SuppressWarnings("empty-statement")
    private void handleOk() {
        if (isInputValid()) {
            //entree.setnDEnregistrement(Integer.parseInt(nDEnregistrement.getText()));
            //entree.setDateDEnregistrement(DateUtil.parse(DateDEnregistrement.getText()));
            //entree.setVersionDuProjet(Integer.parseInt(versionDuProjet.getText()));
            //entree.setDesignationDuProjet(designationDuProjet.getText());
            //entree.setSigle(sigle.getText());
            //entree.setDelai(DateUtil.parse(delai.getText()));

            okClicked = true;
            File file =loadDt();
            System.out.println(file.exists());
             //createDq();
             try {
                 ObservableList<Consomation> consomations= FXCollections.observableArrayList();
                consomations = ConsomationService.listToObservable(xlxsSerivce.Read_Fil_XLSX(file));
                Session.setAttribut(consomations, "consomations");
            } catch (IOException ex) {
                
            }
            dialogStage.close();
            showCompareView();
        }}
        public void showCompareView() {
          
         try {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(NewFXMain.class.getResource("view/ComparView.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
       
        // Create the dialog Stage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Comparer les corps d'etats et les postes avec ceux de la base de donnees");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(this.dialogStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
      ComparViewController  controller=loader.getController();
         controller.setDialogStage(dialogStage);
        dialogStage.show();
    } catch (IOException e) {
        e.printStackTrace();
        
    }
    
    }
     private File loadDt(){
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "Excel files (*.xlsx)", "*.xlsx");
        fileChooser.getExtensionFilters().add(extFilter);
        

        // Show save file dialog
        File file = fileChooser.showOpenDialog(dialogStage);

        return file;
        
    }
    private void createDq(){
            FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"Word files (*.docx)", "*.docx");
		fileChooser.getExtensionFilters().add(extFilter);

                fileChooser.setTitle("DQ");
		// Show save file dialog
                fileChooser.showSaveDialog(dialogStage);
		File file =  fileChooser.showSaveDialog(dialogStage);
		if (file != null) {
			// Make sure it has the correct extension
			if (!file.getPath().endsWith(".docx")) {
				file = new File(file.getPath() + ".docx");
                        }
		}
               
        }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nDEnregistrement.getText() == null || nDEnregistrement.getText().length() == 0) {
            errorMessage += "vous n'avez pas insere le n°d'enregistrement!\n"; 
        }else {
            
            try {
                Integer.parseInt(nDEnregistrement.getText());
            } catch (NumberFormatException e) {
                errorMessage += "le n°d'enregistrement est non valide (doit etre un entier)!\n"; 
            }
        }
//        if (dateDEnregistrement.getText() == null || dateDEnregistrement.getText().length() == 0) {
//            errorMessage += "veuillez inserer la date d'enregistrement!\n"; 
//        }else {
//            if (!DateUtil.validDate(dateDEnregistrement.getText())) {
//                errorMessage += "date d'enregistrement non valide. utilisez le format dd.mm.yyyy!\n";
//            }
//        }
        if (versionDuProjet.getText() == null || versionDuProjet.getText().length() == 0) {
            errorMessage += "vous n'avez pas insere la version du projet!\n"; 
        }else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(versionDuProjet.getText());
            } catch (NumberFormatException e) {
                errorMessage += "version de projet non valide (doit etre un entier)!\n"; 
            }
        }

        if (designationDuProjet.getText() == null || designationDuProjet.getText().length() == 0) {
            errorMessage += "vous n'avez pas insere la designation du projet!\n"; 
        } 

        if (sigle.getText() == null || sigle.getText().length() == 0) {
            errorMessage += "vous avez oublie le sigle du service demandeur!\n"; 
        }

//        if (delai.getText() == null || delai.getText().length() == 0) {
//            errorMessage += "vous n'avez pas inserer le delai!\n";
//        } else {
//            if (!DateUtil.validDate(delai.getText())) {
//                errorMessage += "pas de delai valide. utilisez le format dd.mm.yyyy!\n";
//            }
//        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
        	Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("Error Dialog");
alert.setHeaderText("Look, an Error Dialog");
alert.setContentText(errorMessage);

alert.showAndWait();
            return false;
        }
    }
}