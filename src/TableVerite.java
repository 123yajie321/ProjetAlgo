import java.util.ArrayList;
import java.util.ArrayList;

public class TableVerite {



    ArrayList<Boolean> decomposition(int n)
    {
        ArrayList<Boolean> result=new ArrayList<Boolean>();
        String binaire = Integer.toBinaryString(n);

         for (int i=binaire.length()-1;i>=0;i--){
             char c=binaire.charAt(i);
               if (c=='0')
                    result.add(false);
               else
                    result.add(true);

         }
        return result;
    }


    ArrayList<Boolean> completion(ArrayList<Boolean> arr, int n) {
         int difference=arr.size()-n;
         if(difference>0) {
             ArrayList<Boolean> result=new ArrayList<Boolean>();
             for (int i=0;i<n;i++){
                 result.add(arr.get(i));
             }
             return result;

         }else {
             ArrayList<Boolean> result= (ArrayList<Boolean>) arr.clone();
              for(int i=0;i<-difference;i++){
                  result.add(false);
              }
              return  result;
         }


    }

    ArrayList<Boolean>  table(int x,int n){
       return  completion(decomposition(x),n);
    }

    public static void main(String[] args){
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

            

    }


}
