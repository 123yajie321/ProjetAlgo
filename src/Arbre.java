import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public interface Arbre {


   public Arbre cons_arbre(ArrayList<Boolean>table_verite);
   public int getHauteur();
   public String getLuka();
   public String luka();
   public Arbre compression(HashMap<String,Arbre> list,Arbre a);
   public Arbre getFg();
   public Arbre getFd();
   //public Resultat verifier_descendant(Arbre a);
   public void dot_aux(LinkedHashSet<String> graph);
   //public String dot_aux();// fonction pour obtenir les arcs
   public void  dot(LinkedHashSet<String> graph);// fonction pour produire le ficher
   public int getId();
   public void setFg(Arbre a);
   public void setFd(Arbre a);
   public Boolean getValeur();//reourner la valeur de la Feuille
   public  Arbre compression_bdd(Arbre a);
   public  int countNbNoeud(HashSet<Arbre> noeuds);
  // public  void compression_bdd();



}
