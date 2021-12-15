import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        //Question 1 test for decomposition

        TableVerite tableVerite=new TableVerite();
        ArrayList<Boolean> result= tableVerite.decomposition(38);
        System.out.println("result for quesion 1.2");
        for(Boolean b1:result){
            System.out.println(b1);
        }

        ArrayList<Boolean>  result2=  tableVerite.completion(result,4);
        ArrayList<Boolean>  result3=tableVerite.completion(result,8);
        System.out.println("result for exemple1 of quesion 1.3");
        for(Boolean b1:result2){
            System.out.println(b1);
        }
        System.out.println("result for exemple2 of quesion 1.3");
        for(Boolean b1:result3){
            System.out.println(b1);
        }

        System.out.println("result for exemple1 of quesion 1.4");
        ArrayList<Boolean>  result4=tableVerite.table(38,4);
        for(Boolean b1:result4){
            System.out.println(b1);
        }
        System.out.println("result for exemple2 of quesion 1.4");
        ArrayList<Boolean>  result5=tableVerite.table(38,8);
        for(Boolean b1:result5){
            System.out.println(b1);
        }
        Arbre arbre=new Noeud();
        arbre=arbre.cons_arbre(result5);
        System.out.println("result for quesion 2.7  "+ arbre.luka());
        arbre=arbre.compression(new LinkedHashMap<String,Arbre>(),arbre);
        LinkedHashSet<String> graph=new LinkedHashSet<>() ;
        arbre.dot_aux(graph);
        arbre.dot(graph);

        arbre=arbre.compression_bdd(arbre);
        LinkedHashSet<String> graph2=new LinkedHashSet<>() ;
        arbre.dot_aux(graph2);
        arbre.dot(graph2);
        HashSet<Arbre>count=new HashSet<Arbre>();
        int nbNoeud= arbre.countNbNoeud(count);
        System.out.println("ROBDD a "+nbNoeud+ " Noeuds");

        //generer les ROBDD node count for 1 variable
       /* TableVerite t1=new TableVerite();
        String test1_var="";
        for(int i=0;i<4;i++){

            Arbre a=new Noeud();
            a=a.cons_arbre(t1.table(i,2));
            a.luka();
            a=a.compression(new LinkedHashMap<String,Arbre>(),a);
            a=a.compression_bdd(a);
            HashSet<Arbre>countnb=new HashSet<Arbre>();
            int nb= a.countNbNoeud(countnb);
            test1_var=test1_var+nb+",";
        }
        test1_var=test1_var.substring(0,test1_var.length()-1);
        BufferedWriter out = new BufferedWriter(new FileWriter("result_1_var.txt"));
        out.write(test1_var);
        out.close();
        System.out.println("le fichier result_1_var.txt a été creé");
*/


      /*  //generer les ROBDD node count for 2 variable
        TableVerite t2=new TableVerite();
        String test2_var="";
        for(int i=0;i<16;i++){

            Arbre a=new Noeud();
            a=a.cons_arbre(t2.table(i,4));
            a.luka();
            a=a.compression(new LinkedHashMap<String,Arbre>(),a);
            a=a.compression_bdd(a);
            HashSet<Arbre>countnb=new HashSet<Arbre>();
            int nb= a.countNbNoeud(countnb);
            test2_var=test2_var+nb+",";
            LinkedHashSet<String> graph3=new LinkedHashSet<>() ;
            a.dot_aux(graph3);
            a.dot(graph3);
        }
        test2_var=test2_var.substring(0,test2_var.length()-1);
        BufferedWriter out2 = new BufferedWriter(new FileWriter("result_2_var.txt"));
        out2.write(test2_var);
        out2.close();
        System.out.println("le fichier result_2_var.txt a été creé");



        //generer les ROBDD node count for 3 variable
        TableVerite t3=new TableVerite();
        String test3_var="";
        for(int i=0;i<256;i++){

            Arbre a=new Noeud();
            a=a.cons_arbre(t2.table(i,8));
            a.luka();
            a=a.compression(new LinkedHashMap<String,Arbre>(),a);
            a=a.compression_bdd(a);
            HashSet<Arbre>countnb=new HashSet<Arbre>();
            int nb= a.countNbNoeud(countnb);
            test3_var=test3_var+nb+",";

        }
        test3_var=test3_var.substring(0,test3_var.length()-1);
        BufferedWriter out3 = new BufferedWriter(new FileWriter("result_3_var.txt"));
        out3.write(test3_var);
        out3.close();
        System.out.println("le fichier result_3_var.txt a été creé");*/

        /*//generer les ROBDD node count for 4 variable
        TableVerite t4=new TableVerite();
        String test4_var="";
        for(int i=0;i<65536;i++){

            Arbre a=new Noeud();
            a=a.cons_arbre(t4.table(i,16));
            a.luka();
            a=a.compression(new LinkedHashMap<String,Arbre>(),a);
            a=a.compression_bdd(a);
            HashSet<Arbre>countnb=new HashSet<Arbre>();
            int nb= a.countNbNoeud(countnb);
            test4_var=test4_var+nb+",";

        }
        test4_var=test4_var.substring(0,test4_var.length()-1);
        BufferedWriter out4 = new BufferedWriter(new FileWriter("result_4_var.txt"));
        out4.write(test4_var);
        out4.close();
        System.out.println("le fichier result_4_var.txt a été creé");
*/

        //generer les ROBDD node count for 5 variable
        long startTime=System.currentTimeMillis();
        TableVerite t5=new TableVerite();
        String test5_var="";
        for( int i=0;i<400000000;i++){

            Arbre a=new Noeud();
            a=a.cons_arbre(t5.table(i,32));
            a.luka();
            a=a.compression(new LinkedHashMap<String,Arbre>(),a);
            a=a.compression_bdd(a);
            HashSet<Arbre>countnb=new HashSet<Arbre>();
            int nb= a.countNbNoeud(countnb);
            test5_var=test5_var+nb+",";

        }
        test5_var=test5_var.substring(0,test5_var.length()-1);
        long endTime=System.currentTimeMillis();
        System.out.println("compute： "+(endTime-startTime)+"ms");
        BufferedWriter out5 = new BufferedWriter(new FileWriter("result_5_var.txt"));
        out5.write(test5_var);
        out5.close();
        System.out.println("le fichier result_5_var.txt a été creé");


    }



}
