import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Eliza {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        String elizaSays = "";
        ArrayList<String>listStrings = new ArrayList<>();
        Random rd = new Random();

        HashMap<String,String> replacements = new HashMap<>();
        replacements.put("i", "you");
        replacements.put("me", "you");
        replacements.put("my", "your");
        replacements.put("am", "are");
        //make hedges
        ArrayList<String>hedges = new ArrayList<>();
        hedges.add("Please tell me more");
        hedges.add("Many of my patients tell me the same thing");
        hedges.add("It is getting late, maybe we had better quit");
        //make qualifiers
        ArrayList<String>qualifiers = new ArrayList<>();
        qualifiers.add("Why do you say that");
        qualifiers.add("You seem to think that");
        qualifiers.add("So, you are concerned that");

        ArrayList<String>secretWords = new ArrayList<>();
        secretWords.add("pig");
        secretWords.add("caps");
        secretWords.add("red");

        ArrayList<String> chosenSecretWord = new ArrayList<>();

        System.out.println("Good day. What is your problem? ");

        do{
            System.out.print("Enter your response here or Q to quit: ");
            input = sc.nextLine();
            listStrings = new ArrayList<>();

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

            //Part 3
            int hedgeOrQualifier = 0;

            hedgeOrQualifier = rd.nextInt(2)+1;
            int choice = 0;
            choice = rd.nextInt(3);
            String temp = "";
            if(hedgeOrQualifier == 1){//Hedge chosen
                if(choice == 0){ // Please tell me more
                    temp += hedges.get(0);
                }else if(choice == 1) { // Many of my patients tell me the same thing
                    temp += hedges.get(1);
                }else if (choice == 2){ // It is getting late, maybe we had better quit
                    temp += hedges.get(2);
                }
//                temp += " " + elizaSays;
//                elizaSays = temp;
                elizaSays = temp;
            }if(hedgeOrQualifier == 2){//Qualifier chosen
                if(choice == 0){ //why do you say that
                    temp += qualifiers.get(0);

                }else if(choice == 1){//You seem to think that
                    temp += qualifiers.get(1);

                }else if(choice == 2) {//So, you are concerned that
                    temp += qualifiers.get(2);
                }
                temp += " " + elizaSays;
                elizaSays = temp;
            }

            //part 4

            if(input.equalsIgnoreCase("pig")){ // pig
                chosenSecretWord.add(secretWords.get(0));
                continue;
            } else if(input.equalsIgnoreCase("caps")){ // caps

            } else if(input.equalsIgnoreCase("red")){ // red

            }
                    for(String s:chosenSecretWord){
                        if(s.equalsIgnoreCase("pig")){
                            if(elizaSays.startsWith("a") || elizaSays.startsWith("e")||
                                    elizaSays.startsWith("i") || elizaSays.startsWith("o") ||
                                    elizaSays.startsWith("u") || elizaSays.startsWith("y"))
                        }
                    }

            System.out.println(elizaSays);

        }while(true);
    }
}
