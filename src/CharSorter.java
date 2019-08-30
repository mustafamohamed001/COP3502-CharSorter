//Mustafa Mohamed - Project 2

import java.util.*;

public class CharSorter {

    // *************************** MAIN ***************************
    public static void main(String[] args) {

        //Variables for method
        String stringToSort;                            //String to insert userInput
        boolean breakLoop = true;                       //Boolean to break loop
        int menuSorter = 0;                             //Switch from menu method

        Scanner userInput = new Scanner(System.in);     //Scanner variable

        System.out.println("Welcome to Character Sorter Program");
        System.out.println("Please input a string to be sorted");
        stringToSort = userInput.nextLine();

        while (breakLoop) {
            menuSorter = menu();                        //Read in input from menu method and run through switch

            if (menuSorter == 1) {
                alphabeticalSort(stringToSort);         //Send string into method
            } else if (menuSorter == 2) {
                frequencySort(stringToSort);
            } else if (menuSorter == 3) {
                charTypes(stringToSort);
            } else if (menuSorter == 4) {
                System.out.println("Charter Sorter Exited Successfully");
                breakLoop = false;
            } else if (menuSorter < 0 || menuSorter > 4) {
                System.out.println("Error, bad input, please enter a number 1-4"); //Integer value not between 1-4 error handling
            }
        }
    }

    // *************************** MENU ***************************
    public static int menu() {

        //Variables for this method
        Scanner userInput = new Scanner(System.in);      //Scanner to read choice in menu
        int menuChoice = 0;


        //Try and Catch to handle exceptions
        try {
            System.out.println();
            System.out.println("1. Display character frequencies alphabetically");
            System.out.println("2. Display sorted frequencies");
            System.out.println("3. Show Types of character frequencies");
            System.out.println("4. Exit");
            menuChoice = userInput.nextInt();
            System.out.println();
        } catch (Exception excpt) {
            System.out.println("Error, bad input, please enter a number 1-4"); //Non integer value error handling
        }
        return menuChoice;
    }

    // *************************** ALPHABETICAL SORT ***************************
    public static void alphabeticalSort(String toSort) {

        //Variables for method
        int counter0 = 0;
        int firstChar = 32;         //First Alphanumeric character
        int temp = 0;               //Used to add up frequency

        //String to char array
        char[] array = new char[toSort.length()];
        while (counter0 < toSort.length()) {
            array[counter0] = toSort.charAt(counter0);
            counter0++;
        }

        counter0 = 0;                                       //Reset counter from previous loop
        //counter
        while (firstChar <= 126) {                          //Cycles through all characters
            while (counter0 < array.length) {
                if ((char) firstChar == array[counter0]) {  //If character matches character at point in array
                    temp++;                                 //Add if two characters match
                }
                counter0++;
            }
            if (temp > 0) {                                 // Actual output
                System.out.println((char) firstChar + " freq: " + temp);
            }
            temp = 0;
            counter0 = 0;
            firstChar++;
        }
    }

    // *************************** FREQUENCY SORT ***************************
    public static void frequencySort(String toSort) {
        //Variables for method

        //Counters
        int counter0 = 0;
        int charSave = 0;
        int numSave = 0;
        int x = 0; //A temporary counter
        int y = 0;

        int firstChar = 32;     //First Alphanumeric character
        int[][] sorter = new int[toSort.length()][toSort.length()];
        int[][] temp = new int[2][2];

        //String to char array
        char[] array = new char[toSort.length()];
        while (counter0 < toSort.length()) {
            array[counter0] = toSort.charAt(counter0);
            counter0++;
        }

        counter0 = 0;                                       //Reset counter from previous loop
        //counter
        while (firstChar <= 126) {                          //Cycles through all characters
            while (counter0 < array.length) {

                if ((char)firstChar == array[counter0]) {  //If character matches character at point in array
                    x = x + 1;                             //Add if two characters match

                }
                counter0++;
            }

            //Saves information to array sorter
            if (x >= 1){                                    //what array looks like. ex:
                    sorter[charSave][numSave] = firstChar;  // (char)    (freq)
                    sorter[charSave][numSave + 1] = x;      //  A           1
                    charSave++;                             //  B           2
                    if(x > y){  //used for output reference
                        y = x;
                    }
                    x = 0;
            }
            counter0 = 0;
            firstChar++;
        }
        charSave = 0; //resets array to 0

        System.out.println("The sorted by frequency characters are: ");
        System.out.println();

        //In plain text: while y is the biggest frequency and equals the frequency of a char, then
        //output that char with its frequency. After that, check for next frequency of next chars.
        while (y > 0){
            while (charSave < sorter.length){
                if (y == sorter[charSave][numSave + 1]){
                    System.out.println((char)sorter[charSave][numSave] + " freq: " + sorter[charSave][numSave + 1]);
                }
                charSave++;
            }
            y--;
            charSave = 0;
        }
    }


    // *************************** CHARACTER TYPE SORT ***************************
    public static void charTypes(String toSort) {
        //Variables for method
        int counter0 = 0;
        int firstChar = 32; //First Alphanumeric character

        int textChar = 0;
        int numChar = 0;
        int whiteChar = 0;
        int symbolChar = 0;

        //String to char array
        char[] array = new char[toSort.length()];
        while (counter0 < toSort.length()) {
            array[counter0] = toSort.charAt(counter0);
            counter0++;
        }

        counter0 = 0;                   //Reset counter from previous loop
        while (firstChar <= 126) {      //Cycles through all characters
            while (counter0 < array.length) {
                if ((char) firstChar == array[counter0]) { //If character matches character at point in array

                    //Sorts char into category

                    if ((char) firstChar >= 'A' && (char) firstChar <= 'Z') {
                        textChar++;
                    }
                    else if ((char) firstChar >= 'a' && (char) firstChar <= 'z') {
                        textChar++;
                    }
                    else if ((char) firstChar >= '0' && (char) firstChar <= '9') {
                        numChar++;
                    }
                    else if ((char) firstChar == ' ') {
                        whiteChar++;
                    }
                    else if ((char) firstChar >= '!' && (char) firstChar <= '/') {
                        symbolChar++;
                    }
                    else if ((char) firstChar >= ':' && (char) firstChar <= '@') {
                        symbolChar++;
                    }
                    else if ((char) firstChar >= '[' && (char) firstChar <= '`') {
                        symbolChar++;
                    }
                    else if ((char) firstChar >= '{' && (char) firstChar <= '~') {
                        symbolChar++;
                    }
                }
                counter0++;
            }
            counter0 = 0;
            firstChar++;
        }
        System.out.println("Textual Character count: " + textChar);
        System.out.println("Numerical Character count: " + numChar);
        System.out.println("WhiteSpace Character count: " + whiteChar);
        System.out.println("Symbol Character count: " + symbolChar);
    }
}

