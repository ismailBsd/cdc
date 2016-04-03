/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.ArticleChp1;
import bean.Consomation;
import bean.ConsomationItem;
import bean.CorpDetat;
import bean.Post;
import bean.PostAplusEleme;
import bean.PostSolidaire;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author kamal
 */
public class ConsomationService {
    
    
    CorpDetatService coprCorpDetatService = new CorpDetatService();
    PostSolidaireService postSolidaireService = new PostSolidaireService();
    PostAplusElemeService postAplusElemeService = new PostAplusElemeService();
    
    public ObservableList<CorpDetat> getCorp_from_consomationXls(List<Consomation> consomations) {

        List<CorpDetat> corpDetats = new ArrayList<>();
        for (Consomation loadconsomation : consomations) {
            corpDetats.add(loadconsomation.getCorpDetat());
        }
        
        return CorpDetatService.listToObservable(corpDetats);

    }

    public List<Consomation> get_consomationComplet(List<Consomation> consomationp) throws SQLException {
        List<Consomation> consomations = consomationp;
        for (Consomation loadconsomation : consomations) {
            CorpDetat corpDetat = coprCorpDetatService.find(loadconsomation.getCorpDetat());
            if (corpDetat != null) {
                for (ConsomationItem loadconsoItem : loadconsomation.getConsomationItems()) {
                    // ncaste le post et nfayndi8 ,puis nlasa9 lprix ta3 lpost li f lDB l had lost d consomation  
                    PostAplusEleme loadPostAp = postAplusElemeService.castPostToPostApluselem(loadconsoItem.getPost());
                    PostAplusEleme post = postAplusElemeService.find(loadPostAp);

                    if (post != null) {
                        loadconsoItem.setPost(post);
                        corpDetat.getPostepluselemes().add(post);
                        loadconsomation.setCorpDetat(corpDetat);
                        loadconsoItem.getPost().setCorpdetat(corpDetat);

                    }
                    //
                    PostSolidaire loadPostSo = postSolidaireService.castPostToPostSolidair(loadconsoItem.getPost());
                    PostSolidaire post2 = postSolidaireService.find(loadPostSo);

                    if (post2 != null) {
                        loadconsoItem.setPost(post2);
                        corpDetat.getPostsolidairs().add(post2);
                        loadconsoItem.getPost().setCorpdetat(corpDetat);

                    }
                }
                loadconsomation.setCorpDetat(corpDetat);
            }
        }
        return consomations;
    }

    private List<Post> getPostNot_In_baseDtata(List<Post> corpdetatexelposts) throws SQLException {

        List<Post> postsna9sin = new ArrayList<>();// post kynin f lfil excel o makaynich f lbase d donne
        List<PostSolidaire> postSolidaires = postSolidaireService.finAll();
        List<PostAplusEleme> postAplusElemes = postAplusElemeService.finAll();
        for (Post loadpostexel : corpdetatexelposts) {
            int flag = 0;
            for (PostAplusEleme loadpostAplusEleme1 : postAplusElemes) {
                if (loadpostexel.getTitre().equalsIgnoreCase(loadpostAplusEleme1.getTitre())) {
                    flag = 1;
                }
            }
            for (PostSolidaire loadpostSolidaire : postSolidaires) {
                if (loadpostexel.getTitre().equalsIgnoreCase(loadpostSolidaire.getTitre())) {
                    flag = 1;
                }
            }
            if (flag != 1) {
                postsna9sin.add(loadpostexel);
            }

        }

        return postsna9sin;

    }

    public List<CorpDetat> getCorp_Not_in_Basedata(List<CorpDetat> corpDetatsEXels) throws SQLException {
        List<CorpDetat> corpDetatsBases = coprCorpDetatService.finAll();
        List<CorpDetat> corpDetatsNa9saa = new ArrayList<>();

        for (CorpDetat loadcorpDetatexel : corpDetatsEXels) {
            int flag = 0;
            for (CorpDetat loadcorpDetatBase : corpDetatsBases) {

                if (loadcorpDetatexel.getTitre().equalsIgnoreCase(loadcorpDetatBase.getTitre())) {
                    //  corpDetatsNa9saa.add(loadcorpDetatexel);
                    flag = 1;
                    List<Post> postsNa9ssin = getPostNot_In_baseDtata(loadcorpDetatexel.getPosts());//NCOMparer les post dyl had
                    //lcopr m3ales post li f lbasee donne   

                    if (postsNa9ssin.size() > 0) {
                        System.out.println("ana dkhlt lik l postna9ssin ");
                        CorpDetat corp = new CorpDetat(loadcorpDetatexel.getTitre());

                        corp.setPosts(postsNa9ssin);
                        corpDetatsNa9saa.add(corp);
                    }
                }

            }
            if (flag != 1) {
                corpDetatsNa9saa.add(loadcorpDetatexel);
                coprCorpDetatService.save(loadcorpDetatexel);
            }
        }
        if (corpDetatsNa9saa != null) {
            return corpDetatsNa9saa;
        }
        return null;
    }
    public static ObservableList<Consomation>listToObservable(List<Consomation> list) {
    ObservableList<Consomation>list1=FXCollections.observableArrayList();
    for(Consomation obj:list){
        list1.add(obj);
    }
    return list1;
}
    
}
