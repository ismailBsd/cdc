/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.view;

import bean.ArticleChp1;
import bean.ArticleChp2;
import bean.Bordereau;
import bean.Consomation;
import bean.CorpDetat;
import controler.Session;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.ArticleChp1Service;
import service.ArticleChp2Service;
import service.BordereauService;
import service.ConsomationService;
import service.Read_Write_File;

/**
 *
 * @author i
 */
public class ArticleViewController {

    private Stage dialogStage;
    BordereauService bordereauService = new BordereauService();
    ConsomationService consomationService = new ConsomationService();
    ArticleChp1Service articleChp1Service = new ArticleChp1Service();
    ArticleChp2Service articleChp2Service = new ArticleChp2Service();
    Read_Write_File rite_File = new Read_Write_File();

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    @FXML
    private TableColumn<ArticleChp1, Boolean> articleChap1Col;
    @FXML
    private TableColumn<ArticleChp2, Boolean> articleChap2Col;
    @FXML
    private TableView<ArticleChp1> articleChap1Table;
    @FXML
    private TableView<ArticleChp2> articleChap2Table;
    @FXML
    private TableColumn<ArticleChp1, String> titre1Col;
    @FXML
    private TableColumn<ArticleChp2, String> titre2Col;

    @FXML
    private void terminer() {

    }
    @FXML
    Button infoButton;

    @FXML
    private void buttonChap1() {
        choixChap1();
    }

    @FXML
    private void buttonChap2() {
        choixChap2();
    }

    @FXML
    private void buttonChap3() throws Exception {
        
        close();
    }
    List<ArticleChp1> listChap1 = new ArrayList<>();
    List<ArticleChp2> listChap2 = new ArrayList<>();

    private void choixChap1() {
        //List<ArticleChp1> listChap1 = new ArrayList<>();
        System.out.println(" les articles coches");

        for (ArticleChp1 chap1 : articleChap1Table.getItems()) {
            if (chap1.isC() == true) {
                listChap1.add(chap1);
            }

        }
        for (ArticleChp1 chap1 : listChap1) {
            System.out.println(chap1.getTitre());
        }
        //  return listChap1;
    }

    private void choixChap2() {
        //List<ArticleChp1> listChap1 = new ArrayList<>();
        System.out.println(" les articles coches");

        for (ArticleChp2 chap2 : articleChap2Table.getItems()) {
            System.out.println(chap2.isC());
            if (chap2.isC() == true) {
                listChap2.add(chap2);
            }

        }
        for (ArticleChp2 chap2 : listChap2) {
            System.out.println(chap2.getTitre());
        }
        //  return listChap1;
    }

    @FXML
    private void close() throws Exception {

        List<Bordereau> bordereaus = bordereauService.rmplairBordereux((List<Consomation>) Session.getAttribut("consomations"));
        List<CorpDetat> copDetats = consomationService.getCorp_from_consomationXls((List<Consomation>) Session.getAttribut("consomations"));
        //  List<CorpDetat> corpDetats
        rite_File.SetDOCX_DT(bordereaus, copDetats, listChap1, listChap2);
        System.out.println("ana hna");
    }

    @FXML

    private void initialize() throws SQLException {
        ObservableList<ArticleChp1> articleArticleChp1ss = ArticleChp1Service.listToObservable(articleChp1Service.finAll());
        ObservableList<ArticleChp2> articleArticleChp2ss = ArticleChp2Service.listToObservable(articleChp2Service.finAll());
        titre1Col.setCellValueFactory(
                cellData -> cellData.getValue().titreProperty());
        titre2Col.setCellValueFactory(
                cellData -> cellData.getValue().titreProperty());

        articleChap1Col.setCellValueFactory(new PropertyValueFactory<ArticleChp1, Boolean>("c"));
        articleChap1Col.setCellFactory(CheckBoxTableCell.forTableColumn(articleChap1Col));
        articleChap1Col.setEditable(true);
        articleChap1Table.setEditable(true);
        articleChap2Col.setCellValueFactory(new PropertyValueFactory<ArticleChp2, Boolean>("c"));
        articleChap2Col.setCellFactory(CheckBoxTableCell.forTableColumn(articleChap2Col));
        articleChap2Col.setEditable(true);
        articleChap2Table.setEditable(true);
        articleChap1Table.setItems(articleArticleChp1ss);
        articleChap2Table.setItems(articleArticleChp2ss);

    }
}
