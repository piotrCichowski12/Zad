import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        String sentence;
        do{
            System.out.println("Proszę podać ciąg znaków (Jeśli chcesz zakończyć wpisz End): ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            sentence = reader.readLine();
            if(sentence.length()>30){
                System.out.println(changeV2(sentence));
            }else
                System.out.println(change(sentence));
            System.out.println(sentenceChanger(sentence));
    }while(sentence.compareTo("End")!= 0);



    }
    private static String change(String value){
        String temp = new String();
        for(int i = 0; i< value.length();i++)
            temp += value.charAt(value.length()-i-1);
        return temp;
    }
    private static String changeV2(String value){
        char temp;
        int param;
        char[] valueTab = value.toCharArray();
        for (int i = 0; i < value.length()/2 ; i++) {
            temp = valueTab[i];
            param = value.length()-i-1;
            valueTab[i] = valueTab[param];
            valueTab[param] = temp;
        }
        value = String.valueOf(valueTab);

        return value;
    }
    private static String sentenceChanger(String value){

        int counter =0;
        for (int i = 0; i <value.length() ; i++)
            if(value.toCharArray()[i]==' ')
                counter++;
        String[] valueTab = new String[counter+1];
        counter=0;
        value += " ";
        for (int i = 0; i <value.length() ; i++) {
            if(valueTab[counter] == null)
                valueTab[counter] = "" ;
            valueTab[counter]+= value.toCharArray()[i];
            if (value.toCharArray()[i] == ' ' && valueTab[counter].length()>0)
                counter++;

        }
        value = "";
        for (int i = 0; i <valueTab.length ; i++)
            value += change(valueTab[i]);
        return value;
    }
}
