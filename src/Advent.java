<<<<<<< Updated upstream
import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Advent {

    private void Template(){
        try {
            File file = new File("Day1.txt");
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()) {
            }
            reader.close();
            }
        catch (FileNotFoundException e ){
                System.out.println("Error Occured");
                e.printStackTrace();
            }
        }




    //Day1 Variables
    int testElf;
    int elf1;
    int elf2;
    int elf3;
    String data;
=======
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
>>>>>>> Stashed changes


<<<<<<< Updated upstream
        try{
        File file = new File("Day1.txt");
        Scanner reader = new Scanner(file);

        while(reader.hasNextLine()) {
             data = reader.nextLine();
            if(data.isEmpty()){
                if(testElf > elf1) {
                    elf3 = elf2;
                    elf2 = elf1;
                    elf1 = testElf;

                } else  if(testElf>elf2){
                    elf3=elf2;
                    elf2 = testElf;


                } else if(testElf>elf3){
                    elf3=testElf;


                }



                testElf = 0;

            }
            if(!data.isEmpty()){
                testElf +=Integer.valueOf(data);
            }

        }

            System.out.println(elf3);
            System.out.println(elf2);
            System.out.println(elf1);
            testElf=elf1+elf2+elf3;
            System.out.println(testElf);

            reader.close();
        }
        catch (FileNotFoundException e ){
            System.out.println("Error Occured");
            e.printStackTrace();
            }
        }

        //DAY 2 VARS

    char oRock = 'A';
    char oPaper = 'B';
    char oScissors = 'C';

    /* PART 1 VARS
    char pRock = 'X';
    char pPaper = 'Y';
    char pScissors = 'Z';
     */

    char l = 'X';
    char d = 'Y';
    char w = 'Z';

    int rock = 1;
    int paper = 2;
    int scissors = 3;

    int lose = 0;
    int draw = 3;
    int win = 6;

    int playerChoice;
    int opponentChoice;

    int playerScore;

    private void Day2(){
            //Day2 Variables


            try{
                File file = new File("Day2.txt");
                Scanner reader = new Scanner(file);
                String data;
                while (reader.hasNextLine()){
                    data = reader.nextLine();

                    //Opponent Played:
                    if(data.charAt(0) == oRock){
                        opponentChoice = rock;

                    }
                    else if(data.charAt(0) == oPaper){
                        opponentChoice = paper;

                    }
                    else if(data.charAt(0) == oScissors){
                        opponentChoice = scissors;

                    }
                /* PART 1
                    if(data.charAt(2)==pRock){
                        playerChoice = rock;
                    }
                    else if(data.charAt(2)==pPaper){
                        playerChoice = paper;
                    }
                    else if(data.charAt(2)==pScissors){
                        playerChoice = scissors;
                    }

                    if(playerChoice == opponentChoice){
                        //DRAW
                        playerScore += playerChoice+3;
                    }
                    if(playerChoice-1 == opponentChoice||playerChoice+2 ==opponentChoice){
                        //WIN
                        playerScore += playerChoice+6;
                    }
                    if(playerChoice+1 == opponentChoice || playerChoice-2 == opponentChoice){
                        //LOSE
                        playerScore += playerChoice;
                    }


                 */
                    if(data.charAt(2) == l){
                        if(opponentChoice == rock){
                            playerChoice = scissors;
                        }
                        if(opponentChoice == paper){
                            playerChoice = rock;
                        }
                        if(opponentChoice == scissors){
                            playerChoice = paper;
                        }

                        System.out.println("LOSE ");
                        playerScore+=lose+playerChoice;
                    }
                    else if(data.charAt(2) == d){
                        System.out.println("DRAW ");

                        playerScore += opponentChoice+draw;
                    }
                    else if(data.charAt(2) == w){
                        if(opponentChoice == rock){
                            playerChoice = paper;
                        }
                        if(opponentChoice == paper){
                            playerChoice = scissors;
                        }
                        if(opponentChoice == scissors){
                            playerChoice = rock;
                        }
                        System.out.println("WIN ");

                        playerScore += win+playerChoice;
                    }
                    System.out.println(playerScore);
                }



                reader.close();
            }
            catch (FileNotFoundException e ){
                System.out.println("Error Occured");
                e.printStackTrace();
            }
        }


    //Day3 Vars
    char[] alphabet = {'0','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    int sum;
    String badge = "";
    int l1;
    int l2;
    int l3;
    int stringCount;
    int add;
    private void Day3(){
        try {

            File file = new File("Day3.txt");
            Scanner read = new Scanner(file);


            int count = 0;

            while(read.hasNextLine()){
                for (int i = 0; i < 3; i++) {

                    data = read.nextLine();
                    if(i ==0){
                        l1 = data.length();

                    }
                    if(i ==1){
                        l2 = data.length()+l1;

                    }
                    if(i ==2){
                        l3 = data.length()+l2;

                    }
                    stringCount++;

                    badge += data;

                }


                for (int i = 0; i < l1; i++) {
                    for (int j = l1; j < l2; j++) {
                        for (int k = l2; k < l3; k++) {


                        if(badge.charAt(i) == badge.charAt(j) && badge.charAt(j)== badge.charAt(k)) {
                            //MATCH!

                            while (alphabet[count] != badge.charAt(k)) {

                                count++;
                            }

                            if(add ==0) {
                                sum += count;
                                add++;
                                System.out.println(sum+" "+count);
                                System.out.println(stringCount);
                                break;
                            }




                        }
                            if(add!=0){
                                break;
                            }
                        }
                        if(add!=0){
                            break;
                        }
                    }

                    if(add!=0){
                        break;
                    }
                }
                add=0;
                count = 0;
                l1= 0;
                l2 =0;
                l3=0;
                badge = "";



            }

            read.close();
        }
        catch (FileNotFoundException e ){
            System.out.println("Error Occured");
            e.printStackTrace();
        }
=======
public class Advent {

    private void Day1(){
        File puzzle = new File("AdventOfCode2022/Day1.txt");
        Scanner reader = null;
        try {
            reader = new Scanner(puzzle);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(reader.hasNextLine()){
            String data = reader.nextLine();
            System.out.println(data);
        }
>>>>>>> Stashed changes
    }

    //Day4 Vars
    int[] r1;
    int[] r2;
    int count;

    private void Day4(){
        try {
            File file = new File("Day4.txt");
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()) {
                data = reader.nextLine();
                String charCheck = data;

                while (charCheck.charAt(count)!=','){
                    //add up to the split

                    r1[count] = Integer.parseInt(data);

                    System.out.println(r1);
                    count++;
                }

                count =0;
                while(count!=data.length()){
                    //Finish the String


                    count++;
                }

                count = 0;
            }
            reader.close();
        }
        catch (FileNotFoundException e ){
            System.out.println("Error Occured");
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
<<<<<<< Updated upstream

        new Advent().Day4();
=======
        new Advent().Day1();
>>>>>>> Stashed changes
    }

}
