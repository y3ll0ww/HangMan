import java.util.Arrays;
import java.util.Scanner;

public class Functions {
    Scanner in = new Scanner(System.in);

    String word;
    char[] solution;
    char[] problem;

    int turn = 0;
    char[] savchars = new char[26];
    boolean earlierguess = false;

    int tries = 0;
    char[] life = new char[7];
    boolean guess = false;

    char[][] grid = new char[11][11];
    Screen graphics = new Screen();

    public void Start(String input){
        tries = 0;

        word = input.toUpperCase();
        solution = input.toCharArray();
        for(int i = 0; i < solution.length; i++){
            solution[i] = Character.toUpperCase(solution[i]);
        }
        problem = new char[solution.length];
        Arrays.fill(problem, '_');

        graphics.Start(life, grid);
        this.Progress();
    }

    public void Check(char input){
        input = Character.toUpperCase(input);

        for(int x = 0; x < savchars.length; x++){
            if(savchars[x] == input){
                earlierguess = true;
                break;
            } else {
                earlierguess = false;
            }
        }
        if(earlierguess){
            graphics.Visuals(grid, tries, life);
            System.out.println("\nYou've tried " + input + " already...\n");
            this.Progress();
        } else {
            savchars[turn] = input;
            turn += 1;

            for(int i = 0; i < solution.length; i++){
                if(input == solution[i]){
                    problem[i] = input;
                }
            }
            if(word.contains(Character.toString(input))){
                guess = true;
            } else {
                guess = false;
            }

            if(guess){
                graphics.Visuals(grid, tries, life);
                System.out.println("\nYou're guess " + input + " is in the word!");
                this.Progress();
            } else {
                tries += 1;
                graphics.Visuals(grid, tries, life);
                System.out.println("\nSorry, " + input + " is not in the word.");
                if(tries == 7){
                    System.out.println(problem);
                    System.out.print("\n\nOh no! You're dead!\n" +
                            "The right word was ");
                    System.out.print(solution);
                    System.out.print(".\nBetter luck next time...\n\n");
                    this.newGame();
                } else {
                    this.Progress();
                }
            }
        }
    }

    public void Check(String input){
        input = input.toUpperCase();
        if(input.equals(word)){
            graphics.Visuals(grid, tries, life);
            System.out.println("\nYou're guess " + input + " was right!\nYOU WON THE GAME!\n");
            this.newGame();
        } else {
            tries += 1;
            graphics.Visuals(grid, tries, life);
            System.out.println("\nSorry, " + input + " is not the right word...");
            this.Progress();
        }
    }

    public void Progress(){
        System.out.print(problem);
        if(Arrays.equals(solution, problem)){
            System.out.print(" was the word!\n\nYOU WON THE GAME!\n\n");
            this.newGame();
        } else {
            char c;
            System.out.print("\nYour guess: ");
            String nextguess = in.nextLine();
            boolean alphabetic = nextguess.chars().allMatch(Character::isLetter);
            while(!alphabetic){
                System.out.print("\nYou can only use letters.\nTry again: ");
                nextguess = in.nextLine();
                alphabetic = nextguess.chars().allMatch(Character::isLetter);
            }
            if(nextguess.length() == 1){
                c = nextguess.charAt(0);
                this.Check(c);
            } else {
                this.Check(nextguess);
            }
        }
    }

    public void newGame(){
        String yn = "x";
        System.out.print("Do you want to play another game? ");
        while(!yn.equals("y") && !yn.equals("Y") && !yn.equals("n") && !yn.equals("N")){
            System.out.print("Y/N: ");
            yn = in.nextLine();
        }
        if(yn.equals("y") || yn.equals("Y")){
            graphics.Wipe(grid);
            System.out.println("\nAwesome! Here we go again!");
            Arrays.fill(savchars, '\u0000');
            this.Menu();
        } else if(yn.equals("n") || yn.equals("N")){
            System.out.println("\nThanks for playing!\nSigning off...");
        }
    }


// MODULES

    public void SinglePlayer(){
        System.out.println("\nSINGLE PLAYER.\n" +
                "We have generated a random word for you.\n\nGAME STARTED");
        WordList single = new WordList();
        this.Start(single.RandomWord());
    }

    public void MultiPlayer(){
        System.out.println("\nMULTIPLAYER.");
        System.out.print("Alright! Now type the world below and make sure nobody is watching!\n\n" +
                "Your word: ");
        String userWord = in.nextLine();
        boolean alphabetic = userWord.chars().allMatch(Character::isLetter);
        while(!alphabetic){
            System.out.print("\nYou can only use letters.\nTry another one: ");
            userWord = in.nextLine();
            alphabetic = userWord.chars().allMatch(Character::isLetter);
        }
        if(alphabetic){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                    "GAME STARTED");
            this.Start(userWord);
        }
    }

    public void Menu(){
        System.out.println("\nPress 1 for single player.\nPress 2 for multiplayer.");
        String modus = in.nextLine();

        while(!modus.equals("1") && !modus.equals("2")){
            System.out.println("Please choose a valid game mode (1 or 2): ");
            modus = in.nextLine();
        }
        if(modus.equals("1")){
            this.SinglePlayer();
        } else {
            this.MultiPlayer();
        }
    }

}
