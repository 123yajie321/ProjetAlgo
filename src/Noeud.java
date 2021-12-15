import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Noeud implements Arbre{



    Arbre fg;
    Arbre fd;
    int hauteur;
    String luka;
    int id;// distiquer les neoud pour faire la graphe
    static int id_courant=1;
    static int id_graph=1;

    Noeud(Arbre fg,Arbre fd,int hauteur,int id ){
       this.fg=fg;
       this.fd=fd;
       this.hauteur=hauteur;
       this.id=id;

    }

    Noeud(){


    }

    @Override
    public Arbre cons_arbre(ArrayList<Boolean> table_verite) {
        Queue<Arbre> queue = new LinkedList<Arbre>();
         for(int i=0;i<table_verite.size();i++ ){
             Feuille f=new Feuille(table_verite.get(i),id_courant);
             id_courant++;
              System.out.println(f.getValeur());
                queue.add(f);
         }

        int size = queue.size();
        for (int i = 1; i <= size - 1; i++) {
            Arbre arbre1 = queue.poll();
            Arbre arbre2 = queue.poll();
            Noeud arbre=new Noeud(arbre1,arbre2,arbre1.getHauteur()+1,id_courant) ;
            id_courant++;
            queue.add(arbre);
        }

        Arbre arbrefinal= queue.poll();
        return arbrefinal;


    }

    @Override
    public String luka() {
        String lukafg=this.fg.luka();
        String lukafd=this.fd.luka();
        this.luka="(x"+this.hauteur+lukafg+lukafd+")";
        return this.luka;
    }





 public Arbre compression(HashMap<String,Arbre> list,Arbre a) {

     Arbre arbre=list.get(a.getLuka());
     if(arbre==null) {
         list.put(a.getLuka(), a);
         if(a instanceof Noeud){
             a.setFg(compression(list,a.getFg()));
             a.setFd(compression(list,a.getFd()));
         }
         return a;
     }else {

         return arbre;

     }

 }
/*public Arbre compression(HashMap<String,Arbre> list,Arbre a) {

    Arbre arbre=list.get(a.getLuka());
    if(a instanceof Noeud) {
        Arbre tmpG = compression(list, a.getFg());
        Arbre tmpD = compression(list, a.getFd());


        if(arbre==null) {
            a.setFg(tmpG);
            a.setFd(tmpD);
            list.put(a.getLuka(), a);
            return a;
            }
        else{
                   return arbre;
        }
    }
    else{

        if(arbre==null) {
            list.put(a.getLuka(), a);
            return a;

        }
        else return arbre;

    }


}*/



   /* @Override
    public void dot_aux(LinkedHashSet<String> graph) {
            graph.add(this.id  + " [label=\"x"+this.hauteur+ "\"];\n");
        if(this.fd instanceof Noeud) {
            graph.add(this.fg.getId()  + " [label=\"x"+this.fg.getHauteur()+ "\"];\n");
            graph.add(this.fd.getId()  + " [label=\"x"+this.fd.getHauteur()+ "\"];\n");
            graph.add(this.id + " -- " + this.fg.getId()  + " [style=dashed] ; \n");
            graph.add(this.id + " -- " + this.fd.getId()  + "  ; \n");
            this.fg.dot_aux(graph);
            this.fd.dot_aux(graph);
        }

        else {
            graph.add(this.fg.getId()  + " [label=\""+this.fg.getValeur()+ "\"];\n");
            graph.add(this.fd.getId()  + " [label=\""+this.fd.getValeur()+ "\"];\n");
            graph.add(this.id +" -- " +  this.fg.getId()  + " [style=dashed] ; \n");
            graph.add(this.id +" -- "  + this.fd.getId()  +"  ; \n");
        }

    }*/

    @Override
    public void dot_aux(LinkedHashSet<String> graph) {
        graph.add(this.id  + " [label=\"x"+this.hauteur+ "\"];\n");

        if(this.fg instanceof Feuille){
            graph.add(this.fg.getId()  + " [label=\""+this.fg.getValeur()+ "\"];\n");
            graph.add(this.id +" -- " +  this.fg.getId()  + " [style=dashed] ; \n");

        }
        if(this.fd instanceof Feuille){
            graph.add(this.fd.getId()  + " [label=\""+this.fd.getValeur()+ "\"];\n");
            graph.add(this.id +" -- "  + this.fd.getId()  +"  ; \n");
        }
        if(this.fg instanceof Noeud) {
            graph.add(this.fg.getId()  + " [label=\"x"+this.fg.getHauteur()+ "\"];\n");
            graph.add(this.id + " -- " + this.fg.getId()  + " [style=dashed] ; \n");
            this.fg.dot_aux(graph);

        }
        if(this.fd instanceof Noeud){
            graph.add(this.fd.getId()  + " [label=\"x"+this.fd.getHauteur()+ "\"];\n");
            graph.add(this.id + " -- " + this.fd.getId()  + "  ; \n");
            this.fd.dot_aux(graph);

        }





    }






 /*   public String dot_aux() {

        return this.id+" -- "+this.fg.getId()+" [style=dashed] ; \n"
                +this.id+" -- "+this.fd.getId()+" ; \n"+
                this.fg.dot_aux()+this.fd.dot_aux();



    }
*/
    @Override
   /* public void dot(HashSet<String> graph) {
        graph="graph{\n"+graph+"}";
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("drawgraph.txt"));
            out.write(graph);
            out.close();
            System.out.println("drawgraph a été creé");
        } catch (IOException e) {
        }

    }*/

    public void dot(LinkedHashSet<String> graph) {

        String result = String.join("", graph);
        result= "graph{\n" + result + "}";
        try {
            int id=id_graph;
            id_graph++;
            BufferedWriter out = new BufferedWriter(new FileWriter("drawgraph"+id+".txt"));
            out.write(result);
            out.close();
            System.out.println("drawgraph a été creé");
        } catch (IOException e) {
        }
    }


    @Override
    public int getHauteur() {
        return hauteur;
    }

    @Override
    public String getLuka() {
        return luka;
    }

    public Arbre getFg(){
        return this.fg;
    }

    public Arbre getFd(){
        return this.fd;
    }



    @Override
    public int getId(){
        return this.id;
    }

    @Override
    public void setFg(Arbre a) {
        this.fg=a;
    }

    @Override
    public void setFd(Arbre a) {
        this.fd=a;
    }

    @Override
    public Boolean getValeur() {
        return null;
    }

   /* @Override
    public Arbre compression_bdd(Arbre a) {
        if (a instanceof Feuille){
            return a;
        }else {
            if (a.getFd() instanceof Feuille && a.getFg().getValeur()==a.getFd().getValeur()){
                return a.getFd();
            }
            a.setFg(compression_bdd(a.getFg()));
            a.setFd(compression_bdd(a.getFd()));

            return a;

        }


    }*/

    @Override
    public Arbre compression_bdd(Arbre a) {
        if (a instanceof Feuille){
            return a;
        }else {
                a.setFg(compression_bdd(a.getFg()));
                a.setFd(compression_bdd(a.getFd()));

            if (/*a.getFd() instanceof Feuille &&*/ a.getFg().getId()==a.getFd().getId()){
                return a.getFd();
            }

            return a;

        }


    }









    @Override
    public int countNbNoeud(HashSet<Arbre>noeuds) {
         noeuds.add(this);
        if (this.fg!=null){
            this.fg.countNbNoeud(noeuds);

        }
        if (this.fd!=null){
            this.fd.countNbNoeud(noeuds);

        }

        return noeuds.size();
    }



    /*@Override
    public Arbre compression_bdd( Arbre a) {
        Arbre grand_fils =a.getFg().getFg();
        if(grand_fils instanceof Noeud){
           a.setFg(compression_bdd(a.getFg()));
           a.setFg(compression_bdd(a.getFg()));
        }else {
            Arbre grand_fils1 =a.getFg().getFg();
            Arbre grand_fils2=a

        }

        if(this.fg.getFg() instanceof Feuille && )
    }*/


}
