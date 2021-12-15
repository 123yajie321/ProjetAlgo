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




}
