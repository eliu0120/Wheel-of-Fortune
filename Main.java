import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String phrase = "", response = "";
        int round = 0, numPlayers = 0, player = 0, action = 0;
        boolean c = false;
        Scanner userInput = new Scanner(System.in);
        Phrase[] aP = new Phrase[4];
        aP[0] = new Phrase("A penny saved is a penny earned.");
        aP[1] = new Phrase("jklmao");

        // Intro Phase
        System.out.println("Welcome to 'Wheel of Fortune!'" + "\nWould you like to choose your own phrases?(y/n)");

        System.out.println("How many players are competing?");
        response = userInput.next();
        numPlayers = new Integer(response);

        Player[] pa = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter player " + (i + 1) + "'s name.");
            pa[i] = new Player();
            pa[i].setName(userInput.next());
            pa[i].setPlayerNumber(new Integer(i + 1));
        }
        player = new Integer(1);

        // start of rounds
        while (round < 4) {
            Wheel w = new Wheel();
            int value = 0;
            boolean turn = true;
            System.out.println("The phrase is shown.");
            while (aP[round].condition()) {
                System.out.println(aP[round].toStringF());
                for (int i = 0; i < numPlayers; i++) {
                    if (pa[i].getPlayerNumber() == player) {
                        turn = true;
                        System.out.println(pa[i].getName() + "'s turn.");
                        value = w.spinWheel(pa[i]);
                        if (value > 0)
                            System.out.println("The value is: " + value);
                        else if (value == -1) {
                            System.out.println("Bankrupt!");
                            turn = false;
                        } else if (value == 0) {
                            System.out.println("Skip a turn!");
                            turn = false;
                        }
                    }
                }
                // if player counter increases past the number of actual players
                if (player > numPlayers)
                    player = 1;

                System.out.println(
                        "Choose what you would like to do:\n" + "1. Buy a vowel\n2. Guess a consonant\n3. Solve");
                action = new Integer(userInput.next());
                while (turn) {
                    if (action == 1) {
                        System.out.println("Enter the vowel.");
                        response = userInput.next();
                        if ((response.compareTo("a") == 0 || response.compareTo("e") == 0
                                || response.compareTo("i") == 0 || response.compareTo("o") == 0
                                || response.compareTo("u") == 0) && aP[round].guess(response)) {
                            aP[round].times(response);
                            pa[player - 1].buyVowel();
                        } else if (!aP[round].guess(response)) {
                            player++;
                        } else
                            System.out.println("Not a vowel.");

                    } else if (action == 2) {
                        System.out.println("Enter the consonant.");
                        response = userInput.next();
                        if (response.compareTo("a") == 0 || response.compareTo("e") == 0 || response.compareTo("i") == 0
                                || response.compareTo("o") == 0 || response.compareTo("u") == 0
                                || response.length() > 1) {
                            System.out.println("Invalid answer.");
                        } else {
                            if (aP[round].guess(response)) {
                                pa[player - 1].setBal(pa[player - 1].getBal() + value);
                            } else
                                player++;
                        }
                    }

                    else if (action == 3) {
                        System.out.println("Enter your guess.");
                        response = userInput.nextLine();
                        response = userInput.nextLine();
                        if (response.toUpperCase().compareTo(aP[round].toStringT().toUpperCase()) == 0) {
                            pa[player - 1].setBal(pa[player - 1].getBal() + 1000);
                            aP[round].setfContent();
                        } else {
                            player++;
                        }
                    } else {
                        System.out.println("Only enter '1', '2', or '3'.");
                    }
                } // end phrase while
            }

            System.out.println("Here are the standings.");
            for (int i = 0; i < numPlayers; i++) {
                System.out.println(pa[i].getName() + ": $" + pa[i].getBal());
            }
            round++;
        }

    }// end Normal rounds
}
