 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.ArticleChp1;
import bean.ArticleChp2;
import bean.Bordereau;
import bean.Consomation;
import bean.ConsomationItem;
import bean.CorpDetat;
import bean.Post;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;


/**
 *
 * @author kamal
 */
public class Read_Write_File {

    CorpDetatService coprCorpDetatService = new CorpDetatService();
    PostSolidaireService postSolidaireService = new PostSolidaireService();
    PostAplusElemeService postAplusElemeService = new PostAplusElemeService();
    ArticleChp1Service achp1Service = new ArticleChp1Service();
    ArticleChp2Service achp2Service = new ArticleChp2Service();
    ConsomationService consomationService = new ConsomationService();

    public static List<Consomation> Read_Fil_XLSX(File myFile) throws FileNotFoundException, IOException {
        List<CorpDetat> corpDetats = new ArrayList<CorpDetat>();
        List<Consomation> consomations = new ArrayList<Consomation>();
		
        FileInputStream fis = new FileInputStream(myFile);

        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);

        XSSFSheet mySheet = myWorkBook.getSheetAt(0);

        Iterator<Row> rowIterator = mySheet.iterator();

        Consomation consomation = null;
        CorpDetat corpDetat = null;
        ConsomationItem consomationItem = null;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (row.getRowNum() == 0) {// pour ne pas lire les  titres
                row = rowIterator.next();
            }

            int lascellNum = row.getLastCellNum();
            int firstcellNum = row.getFirstCellNum();
            System.out.println("first cell num" + firstcellNum + "  last cell num" + lascellNum);
            if (lascellNum < 3) {
                if (row.getRowNum() > 1) {
                    //corpDetats.add(corpDetat);

                    consomations.add(consomation);
                    corpDetat = null;
                    System.out.println("if dyal row celll");
                }
                consomation = new Consomation();
                consomation.setId((int) row.getCell(firstcellNum).getNumericCellValue());
                corpDetat = new CorpDetat();
                corpDetat.setTitre(row.getCell(firstcellNum + 1).getStringCellValue());

            } else {
                Post post = new Post();
                consomationItem = new ConsomationItem();

                for (int i = firstcellNum; i < lascellNum; i++) {
                    Cell cell = row.getCell(i);

                    switch (i) {
                        case 0:
                            System.out.println("num de consomation item" + cell.getStringCellValue());
                            consomationItem.setId(cell.getStringCellValue());
                            break;
                        case 1:
                            System.out.println("cell " + i + ":" + cell.getStringCellValue());
                            post.setTitre(cell.getStringCellValue());
                            break;
                        case 2:
                            consomationItem.setUnite(cell.getStringCellValue());
                            break;
                        case 3:
                            System.out.println("cell " + i + ":" + cell.getCellType());
                            consomationItem.setQuanite((int) cell.getNumericCellValue());
                            break;

                    }
                }
                if (post != null) {
                    post.setCorpdetat(corpDetat);
                    consomationItem.setPost(post);
                    post.setCorpdetat(corpDetat);
                    corpDetat.getPosts().add(post);
                    consomation.getConsomationItems().add(consomationItem);
                    consomation.setCorpDetat(corpDetat);

                }
            }

        }

        consomations.add(consomation);
        // pour le dernier corp makydkholch l row li tab30

        return consomations;
    }

    public void SetDOCX_DT(List<Bordereau> bordereaus, List<CorpDetat> corpDetats,List<ArticleChp1> articlechp1s,List<ArticleChp2> articlechp2s) throws Exception {
       

        //    XWPFDocument document = new XWPFDocument(); //creete a new documment 
        XWPFDocument doc = new XWPFDocument();

        //FileInputStream is = new FileInputStream("D:\\a.jpg"); 
      
       
        
       // doc.addPictureData(IOUtils.toByteArray(fs), doc.PICTURE_TYPE_JPEG);
        
      //doc.create(id,doc.getNextPicNameNumber(doc.PICTURE_TYPE_JPEG), 64, 64);
        XWPFParagraph para2 = doc.createParagraph();
        para2.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = para2.createRun();
        run.setBold(true);
        run.setFontSize(40);
        
        
        // run.addPicture(pic, doc.PICTURE_TYPE_JPEG, "3", 0, 0);
         
         
         
       // run.addPicture(fs, doc.PICTURE_TYPE_JPEG, blipId, 100, 100);
      //  run.addPicture(is,2, "kamal", 20, 20);
         //run.addPicture(IOUtils.toByteArray(is), doc.PICTURE_TYPE_JPEG);
        run.setText("\n \t Descriptif technique  \n ");
          
        // pour article d projet
        XWPFParagraph para3 = doc.createParagraph();
        // para2.setAlignment(ParagraphAlignment.CENTER);
        run = para3.createRun();
        run.setText(" I- article de votre projet :");
        run.setFontSize(18);
        run.setBold(true);

        XWPFParagraph para4 = doc.createParagraph();// pour les article chp 1
        run = para4.createRun();
        run.setText("    I-1 article chapitre1   :   \n");
        run.setFontSize(14);
        run.setBold(true);
        run.addBreak();

        int i = 1;
        for (ArticleChp1 loadarticlechp1 : articlechp1s) {// kan3amar text1 dyal articlchp1
            run = para4.createRun();
            run.setText("      " + i + ")- " + loadarticlechp1.getTitre());
            run.addBreak();
            i++;
        }
        XWPFParagraph para5 = doc.createParagraph();   // pour les articles chp2
        run = para5.createRun();
        run.setText("    I-2 article chapitre2   :   \n");
        run.setFontSize(14);
        run.setBold(true);
        run.addBreak();
        i = 1;
        for (ArticleChp2 loadarticlechp2 : articlechp2s) {// text2 dyla articlechp2
            run = para5.createRun();
            run.setText("       " + i + ")- " + loadarticlechp2.getTitre());
            run.addBreak();
            i++;
        }

        // corpdetat de projet
        XWPFParagraph para6 = doc.createParagraph();
        // para2.setAlignment(ParagraphAlignment.CENTER);
        run = para6.createRun();
        run.setText("\t II- corps d’état :");
        run.setFontSize(18);
        run.setBold(true);
        run.addBreak();
      //  run.setColor("#999");
        
        i = 1;
        // bouclage pourles coprs et posts dyal kola corps 
        for (CorpDetat loaDetat : corpDetats) {
            run = para6.createRun();
            run.setText("       II-" + i + "- " + loaDetat.getTitre() + "  : ");
            run.setFontSize(16);
            
            run.addBreak();

            int j = 1;
            for (Post loadpost : loaDetat.getPosts()) {
                run = para6.createRun();
                run.setText("                 "+ i + "-" + j + ")  " + loadpost.getTitre() + " ");
                run.addBreak();
                j++;
            }
            i++;
        }

        
        
        
        
        
        
        
        // 
       // bordeauraux
         XWPFParagraph para = doc.createParagraph();
        
         run = para.createRun();
         run.setBold(true);
         run.setFontSize(18);
         run.setText("     bordereau de prix ");
         run.addBreak();
         run = para.createRun();
        

         //Creates a table 
         XWPFTable tab = doc.createTable();
         tab.setWidth(500);

         tab.setCellMargins(50, 200, 50, 200);

         XWPFTableRow row1 = tab.getRow(0);

         row1.getCell(0).setText("designation");
         row1.getCell(0).setColor("FF9900");

         row1.addNewTableCell().setText("Unite");
         row1.getCell(1).setColor("FF9900");

         row1.addNewTableCell().setText("Quantite");
         row1.getCell(2).setColor("FF9900");

         row1.addNewTableCell().setText("prix");
         row1.getCell(3).setColor("FF9900");

         row1.addNewTableCell().setText("montant");
         row1.getCell(4).setColor("FF9900");
         i = 1;
         for (Bordereau loadbordereau : bordereaus) {

         XWPFTableRow loadRow = null;
         loadRow = tab.createRow();

         loadRow.getCell(0).setText(loadbordereau.getDesignation() + "");
         loadRow.getCell(1).setText(loadbordereau.getUnite());
         if (loadbordereau.getQuanite() == 0) {
         loadRow.getCell(2).setText("");

         } else {
         loadRow.getCell(2).setText(loadbordereau.getQuanite() + "");
         }
         if (loadbordereau.getPrix() == 0) {
         } else {
         loadRow.getCell(3).setText(loadbordereau.getPrix() + "");
         }
         if (loadbordereau.getMontant() == 0.0) {
         } else {
         loadRow.getCell(4).setText(loadbordereau.getMontant() + "");
         }

         }

         XWPFTableRow row3 = null;
         row3 = tab.createRow();
         row3.getCell(0).setText("TVA");
         row3.getCell(0).setColor("FF9900");

         XWPFTableRow row4 = null;
         row4 = tab.createRow();
         row4.getCell(0).setText("HTTC");
         row4.getCell(0).setColor("FF9900");
         
        try {
            doc.write(new FileOutputStream("D:\\test2.docx"));
            // InputStream pica = new FileInputStream("D:\\test2.docx");
            //FileInputStream fis = new FileInputStream("D:\\test2.docx");
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File("D:\\test2.docx"));
            }
        } catch (IOException ex) {
           
        }

    }

}
