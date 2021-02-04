import java.util.Arrays;    
public class try_and_catch{
    public static void main(String[] args){
            int [] array = new int[3];
    try{
            for(int i=0;i<4;i++){
                array[i] = i;
            }
        }
        catch (Exception e){ //Example how you can check two or many exception 
                                //you can have...
            System.out.println(e);
        }
        catch (ArrayIndexOutOfBoundException e){
        System.out.println(Array.toStrings(array));
        }
    }
}