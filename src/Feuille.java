import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Feuille implements Arbre {

    Boolean valeur;
    String  luka;
    int id;

    public  Feuille(boolean value,int id){
        this.valeur=value;
        this.id=id;
    }

    @Override
    public Arbre cons_arbre(ArrayList<Boolean> table_verite) {
      return null;
    }

    @Override
    public int getHauteur() {
        return 0;
    }

    @Override
    public String getLuka() {
        return luka;
    }

    @Override
    public String luka() {
        if (this.valeur){
            this.luka="(True)";
            return "(True)";
        }

        else{
            this.luka="(False)";
            return "(False)";
        }
    }




    @Override
    public Arbre compression(HashMap<String,Arbre> list,Arbre a) {
        return null;
    }

    @Override
    public Arbre compression_bdd(Arbre a) {
        return null;
    }

    @Override
    public int countNbNoeud(HashSet<Arbre> neouds) {
        neouds.add(this);
        return neouds.size();
    }


    @Override
    public Arbre getFg() {
        return null;
    }

    @Override
    public Arbre getFd() {
        return null;
    }

    @Override
    public void dot_aux(LinkedHashSet<String> graph) {

    }

    @Override
    public void dot(LinkedHashSet<String> graph) {

    }




   /* @Override
    public String dot_aux() {
        return "";
    }*/




    public Boolean getValeur(){
        return this.valeur;
    }



    @Override
    public int getId(){
        return this.id;
    }

    @Override
    public void setFg(Arbre a) {

    }

    @Override
    public void setFd(Arbre a) {

    }
}
