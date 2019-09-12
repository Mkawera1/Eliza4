import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Eliza {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        String elizaSays = "";
        ArrayList<String>listStrings = new ArrayList<>();

        HashMap<String,String> replacements = new HashMap<>();
        replacements.put("i", "you");
        replacements.put("me", "you");
        replacements.put("my", "your");
        replacements.put("am", "are");

        System.out.println("Good day. What is your problem? ");

        do{
            System.out.print("Enter your response here or Q to quit: ");
            input = sc.nextLine();

            if (input.equalsIgnoreCase("Q") ||
                input.equalsIgnoreCase("I am feeling great")) {
                break;
            }

            for(String s: input.split(" ")){
                listStrings.add(s);
            }
            //System.out.println(listStrings.toString());

            for(int i=0; i< listStrings.size(); i++){
                String tempIndex = listStrings.get(i);
//
                if(tempIndex.equalsIgnoreCase("i")){
                    tempIndex = replacements.get("i");
                }else if(tempIndex.equalsIgnoreCase("me")){
                    tempIndex = replacements.get("me");
                }
                else if(tempIndex.equalsIgnoreCase("my")) {
                    tempIndex = replacements.get("my");
                }
                else if(tempIndex.equalsIgnoreCase("am")) {
                    tempIndex = replacements.get("am");
                }
                listStrings.set(i,tempIndex);
            }
            //System.out.println(listStrings.toString()); //comment out later

            String tempOutput = "";
            for(String s: listStrings){
                tempOutput += s + " ";
            }
            tempOutput.trim();
            elizaSays = tempOutput;
            System.out.println(elizaSays);
            listStrings = new ArrayList<>();
        }while(true);
    }
}
