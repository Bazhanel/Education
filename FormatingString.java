import java.util.*;

public class FormatingString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str  = in.nextLine();
        int strLength = str.length();
        String tmp="";
        String signs= "!?.,;:";
        String res="";
        // Добавляем пробелы после знаков препинания
        for (int i=0; i< strLength; i++){
            tmp += str.charAt(i);

            if (signs.indexOf(str.charAt(i)) >=0)
                tmp += " ";
        }
        //Разбиваем строку на подстроки
        for (String val : tmp.split(" ")){
            if (val.length()>0 && signs.indexOf(val) <0)
                res += " " + val;

            if (signs.indexOf(val) >=0)
                res += val;
        }
        System.out.print(res.trim());
    }
}