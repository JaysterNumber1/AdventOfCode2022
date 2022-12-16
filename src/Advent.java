import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Advent {

    private void Template() {
        try {
            File file = new File("Day1.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
            }
            reader.close();
        } catch (FileNotFoundException e) {
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

    private void Day1() {


        try {
            File file = new File("Day1.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                data = reader.nextLine();
                if (data.isEmpty()) {
                    if (testElf > elf1) {
                        elf3 = elf2;
                        elf2 = elf1;
                        elf1 = testElf;

                    } else if (testElf > elf2) {
                        elf3 = elf2;
                        elf2 = testElf;


                    } else if (testElf > elf3) {
                        elf3 = testElf;


                    }


                    testElf = 0;

                }
                if (!data.isEmpty()) {
                    testElf += Integer.valueOf(data);
                }

            }

            System.out.println(elf3);
            System.out.println(elf2);
            System.out.println(elf1);
            testElf = elf1 + elf2 + elf3;
            System.out.println(testElf);

            reader.close();
        } catch (FileNotFoundException e) {
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

    private void Day2() {
        //Day2 Variables


        try {
            File file = new File("Day2.txt");
            Scanner reader = new Scanner(file);
            String data;
            while (reader.hasNextLine()) {
                data = reader.nextLine();

                //Opponent Played:
                if (data.charAt(0) == oRock) {
                    opponentChoice = rock;

                } else if (data.charAt(0) == oPaper) {
                    opponentChoice = paper;

                } else if (data.charAt(0) == oScissors) {
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
                if (data.charAt(2) == l) {
                    if (opponentChoice == rock) {
                        playerChoice = scissors;
                    }
                    if (opponentChoice == paper) {
                        playerChoice = rock;
                    }
                    if (opponentChoice == scissors) {
                        playerChoice = paper;
                    }

                    System.out.println("LOSE ");
                    playerScore += lose + playerChoice;
                } else if (data.charAt(2) == d) {
                    System.out.println("DRAW ");

                    playerScore += opponentChoice + draw;
                } else if (data.charAt(2) == w) {
                    if (opponentChoice == rock) {
                        playerChoice = paper;
                    }
                    if (opponentChoice == paper) {
                        playerChoice = scissors;
                    }
                    if (opponentChoice == scissors) {
                        playerChoice = rock;
                    }
                    System.out.println("WIN ");

                    playerScore += win + playerChoice;
                }
                System.out.println(playerScore);
            }


            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error Occured");
            e.printStackTrace();
        }
    }


    //Day3 Vars
    char[] alphabet = {'0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    int sum;
    String badge = "";
    int l1;
    int l2;
    int l3;
    int stringCount;
    int add;

    private void Day3() {
        try {

            File file = new File("Day3.txt");
            Scanner read = new Scanner(file);


            int count = 0;

            while (read.hasNextLine()) {
                for (int i = 0; i < 3; i++) {

                    data = read.nextLine();
                    if (i == 0) {
                        l1 = data.length();

                    }
                    if (i == 1) {
                        l2 = data.length() + l1;

                    }
                    if (i == 2) {
                        l3 = data.length() + l2;

                    }
                    stringCount++;

                    badge += data;

                }


                for (int i = 0; i < l1; i++) {
                    for (int j = l1; j < l2; j++) {
                        for (int k = l2; k < l3; k++) {


                            if (badge.charAt(i) == badge.charAt(j) && badge.charAt(j) == badge.charAt(k)) {
                                //MATCH!

                                while (alphabet[count] != badge.charAt(k)) {

                                    count++;
                                }

                                if (add == 0) {
                                    sum += count;
                                    add++;
                                    System.out.println(sum + " " + count);
                                    System.out.println(stringCount);
                                    break;
                                }


                            }
                            if (add != 0) {
                                break;
                            }
                        }
                        if (add != 0) {
                            break;
                        }
                    }

                    if (add != 0) {
                        break;
                    }
                }
                add = 0;
                count = 0;
                l1 = 0;
                l2 = 0;
                l3 = 0;
                badge = "";


            }

            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error Occured");
            e.printStackTrace();
        }
    }

    //Day4 Vars
    ArrayList<Integer> r1 = new ArrayList<Integer>();
    ArrayList<Integer> r2 = new ArrayList<Integer>();
    int count;
    int contained;

    private void Day4() {
        try {
            File file = new File("AdventOfCode2022/Day4.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                data = reader.nextLine();


                while (data.charAt(count) != ',') {
                    //add up to the split
                    if (data.charAt(count + 1) != '-' && data.charAt(count) != '-' && data.charAt(count + 1) != ',') {
                        r1.add(Integer.valueOf(data.charAt(count) + "" + data.charAt(count + 1)));
                        count++;
                    } else if (data.charAt(count) != '-') {
                        r1.add(Integer.valueOf(data.charAt(count) + ""));
                    }


                    count++;
                }


                while (count != data.length()) {
                    if (data.charAt(count) == ',') {
                        count++;
                    }
                    //Finish the String
                    if (data.length() != count + 1 && data.charAt(count + 1) != '-' && data.charAt(count) != '-' && data.charAt(count + 1) != ',') {
                        r2.add(Integer.valueOf(data.charAt(count) + "" + data.charAt(count + 1)));
                        count++;
                    } else if (data.charAt(count) != '-') {
                        r2.add(Integer.valueOf(data.charAt(count) + ""));
                    }


                    count++;
                }

                /*
                Part 1
                if(r1.get(0)>=r2.get(0)&&r1.get(1)<=r2.get(1)||r1.get(0)<=r2.get(0)&&r1.get(1)>=r2.get(1)){
                    contained++;
                }

                 */
                //Part 2
                if (r1.get(0) >= r2.get(0) && r1.get(0) <= r2.get(1) || r1.get(1) <= r2.get(1) && r1.get(1) >= r2.get(0) || r1.get(0) <= r2.get(0) && r1.get(1) >= r2.get(1) || r2.get(0) <= r1.get(0) && r2.get(1) >= r1.get(1)) {
                    contained++;
                }


                r1.clear();
                r2.clear();

                System.out.println(contained);
                count = 0;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error Occured");
            e.printStackTrace();
        }
    }

    ArrayList<Character> stack1 = new ArrayList<Character>();
    ArrayList<Character> stack2 = new ArrayList<Character>();
    ArrayList<Character> stack3 = new ArrayList<Character>();
    ArrayList<Character> stack4 = new ArrayList<Character>();
    ArrayList<Character> stack5 = new ArrayList<Character>();
    ArrayList<Character> stack6 = new ArrayList<Character>();
    ArrayList<Character> stack7 = new ArrayList<Character>();
    ArrayList<Character> stack8 = new ArrayList<Character>();
    ArrayList<Character> stack9 = new ArrayList<Character>();
    ArrayList<Integer> move = new ArrayList<Integer>();
    ArrayList<Integer> from = new ArrayList<Integer>();
    ArrayList<Integer> to = new ArrayList<Integer>();
    ArrayList[] stack = {stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9};
    ArrayList[] moves = {move, from, to}

    int whitespace;


    int temp;

    private void Day5() {
        try {
            File file = new File("AdventOfCode2022/Day5.txt");
            Scanner reader = new Scanner(file);
            count = 0;

            while (reader.hasNextLine()) {
                data = reader.nextLine();

                while (count < data.length()) {


                    if (data.charAt(count) == ' ') {
                        whitespace++;

                    }

//Add next char to correct stack
                    if (data.charAt(count) == '[') {

                        if (whitespace + 1 == 1) {
                            stack[0].add(data.charAt(count + 1));
                        } else if (whitespace + 1 == 5) {
                            stack[1].add(data.charAt(count + 1));
                        } else if (whitespace + 1 == 9) {
                            stack[2].add(data.charAt(count + 1));
                        } else if (whitespace + 1 == 12) {
                            stack[3].add(data.charAt(count + 1));
                        } else if (whitespace + 1 == 15) {
                            stack[4].add(data.charAt(count + 1));
                        } else if (whitespace + 1 == 18) {
                            stack[5].add(data.charAt(count + 1));
                        } else if (whitespace + 1 == 21) {
                            stack[6].add(data.charAt(count + 1));
                        } else if (whitespace + 1 == 24) {
                            stack[7].add(data.charAt(count + 1));
                        } else if (whitespace + 1 == 27) {
                            stack[8].add(data.charAt(count + 1));
                        }


                        whitespace += 3;
                    }


                    if (data.charAt(0) == 'm') {

                        for (int i = 0; i < 2; i++) {


                            if (temp < data.length()) {
                                if (data.charAt(temp) == ' ' || data.charAt(temp) == 'm' || data.charAt(temp) == 'o' || data.charAt(temp) == 'v' || data.charAt(temp) == 'e' || data.charAt(temp) == 'f' || data.charAt(temp) == 'r' || data.charAt(temp) == 't') {
                                    //Not Int
                                    break;
                                } else {
                                    //Is Int


                                    if (move.indexOf(i)==) {
                                        if (data.charAt(temp + 1) != ' ') {
                                            move = Integer.valueOf(data.charAt(temp) + data.charAt(temp + 1) + "");
                                        } else {
                                            move = Integer.valueOf(data.charAt(temp) + "");
                                        }
                                    } else if (from == 0) {
                                        if (data.charAt(temp + 1) != ' ') {
                                            from = Integer.valueOf(data.charAt(temp) + data.charAt(temp + 1) + "");
                                        } else {
                                            from = Integer.valueOf(data.charAt(temp) + "");
                                        }
                                    } else {


                                        if (to == 0) {
                                            to = Integer.valueOf(data.charAt(temp) + "");

                                        } else {

                                            to = Integer.valueOf(data.charAt(temp) + data.charAt(temp + 1) + "");
                                        }
                                    }

                                }
                            }

                            temp++;


                        }

                    }


                    count++;

                }


                whitespace = 0;
                count = 0;
            }
//Flip List
            System.out.println(move);
            System.out.println(from);
            System.out.println(to);


            for (int i = 0; i < 8; i++) {
                Collections.reverse(stack[i]);
            }
//Print List To Check
            // System.out.println(stack1);
            // System.out.println(stack2);
            // System.out.println(stack3);
            // System.out.println(stack4);
            // System.out.println(stack5);
            // System.out.println(stack6);
            // System.out.println(stack7);
            // System.out.println(stack8);
            // System.out.println(stack9);


            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error Occured");
            e.printStackTrace();
        }


    }

    private char pop(List<Character> stack) {
        if (stack.isEmpty()) {
            System.out.println("EMPTY");
            return ' ';
        }
        char pop = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return pop;
    }

    private void push(List<Character> stack, char input) {
        if (stack.isEmpty()) {
            System.out.println("EMPTY");

        } else {
            stack.add(input);
        }
    }


    public static void main(String[] args) {


        new Advent().Day5();


    }

}
