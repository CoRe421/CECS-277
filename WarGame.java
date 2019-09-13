import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * The game that is played.
 * @author Cory Reardon
 * @date 9/12/18
 */
public class WarGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to War!");
        printMenu();
        System.out.println("Please select an option.");
        int userChoice = input.nextInt();
        input.nextLine();
        while (userChoice != 2) {
            if (userChoice == 1) {
                startGameVsComputer(input);
            }
            printMenu();
            System.out.println("Please select an option.");
            userChoice = input.nextInt();
            input.nextLine();
        }
    }

    /**
     * Prints the menu.
     */
    public static void printMenu() {
        System.out.println("1. Start the game against the computer");
        System.out.println("2. Quit");
    }

    /**
     * Begins the game versus the computer.
     */
    public static void startGameVsComputer(Scanner input) {
        Deck gameDeck = createDeck();
        ArrayList<Card> player1 = splitDeck(gameDeck, 1);
        ArrayList<Card> player2 = splitDeck(gameDeck, 2);
        while (player1.size() > 0 && player2.size() > 0) {
            Card userCard = player1.get(player1.size() - 1);
            Card computerCard = player2.get(player2.size() - 1);
            System.out.println("Your card: " + userCard + " Computer's card: " + computerCard);
            int playerValue = userCard.getRank();
            int computerValue = computerCard.getRank();
            if (playerValue < computerValue) {
                System.out.println("Would you like to add another card? (y/n)");
                String addCard = input.nextLine().toLowerCase();
                if (addCard.equals("y")) {
                    Card newCard = player1.get(player1.size() - 2);
                    System.out.println("You draw: " + newCard);
                    playerValue += newCard.getRank();
                    if (playerValue <= computerValue) {
                        System.out.println("You win the round!");
                        player1.add(computerCard);
                        player2.remove(player2.size() - 1);
                    }
                    else {
                        System.out.println("You lose the round!");
                        player2.add(userCard);
                        player2.add(newCard);
                        player1.remove(player1.size() - 1);
                        player1.remove(player1.size() - 1);
                    }
                }
                else if (addCard.equals("n")) {
                    System.out.println("You lose the round!");
                    player2.add(userCard);
                    player1.remove(player1.size() - 1);
                }
            }
            else if (playerValue > computerValue) {
                System.out.println("Will the computer add another card?");
                if ((playerValue - computerValue) > 5) {
                    System.out.println("y");
                    Card newCard = player2.get(player2.size() - 2);
                    System.out.println("It draws: " + newCard);
                    computerValue += newCard.getRank();
                    if (computerValue <= playerValue) {
                        System.out.println("You lose the round!");
                        player2.add(userCard);
                        player1.remove(player1.size() - 1);
                    }
                    else {
                        System.out.println("You win the round!");
                        player1.add(computerCard);
                        player1.add(newCard);
                        player2.remove(player2.size() - 1);
                        player2.remove(player2.size() - 1);
                    }
                }
                else {
                    System.out.println("n");
                    System.out.println("You win the round!");
                    player1.add(computerCard);
                    player2.remove(player2.size() - 1);
                }
            }
            else {
                ArrayList<Card> warCards = new ArrayList<>();
                warCards.add(userCard);
                warCards.add(computerCard);
                player1.remove(player1.size() - 1);
                player2.remove(player2.size() - 1);
                while (userCard.getRank() == computerCard.getRank()) {
                    System.out.println("War!");
                    if (player1.size() == 1) {
                        userCard = player1.get(0);
                        System.out.println("Your card: " + userCard);
                    }
                    else if (player1.size() < 4) {
                        System.out.println("Your cards: ");
                        for (int i = 0; i < player1.size() - 1; i++) {
                            warCards.add(player1.get(player1.size() - 1));
                            player1.remove(player1.size() - 1);
                            System.out.println("[]");
                        }
                        userCard = player1.get(0);
                        System.out.println(userCard);
                    }
                    else {
                        System.out.println("Your cards: ");
                        for (int i = 0; i < 3; i++) {
                            warCards.add(player1.get(player1.size() - 1));
                            player1.remove(player1.size() - 1);
                            System.out.println("[]");
                        }
                        userCard = player1.get(player1.size() - 1);
                        System.out.println(userCard);
                    }
                    System.out.println();
                    if (player2.size() == 1) {
                        computerCard = player2.get(0);
                        System.out.println("The Computer's card: " + computerCard);
                    }
                    else if (player2.size() < 4) {
                        System.out.println("The Computer's cards: ");
                        for (int i = 0; i < player2.size() - 1; i++) {
                            warCards.add(player2.get(player2.size() - 1));
                            player2.remove(player2.size() - 1);
                            System.out.println("[]");
                        }
                        computerCard = player2.get(0);
                        System.out.println(computerCard);
                    }
                    else {
                        System.out.println("The Computer's cards: ");
                        for (int i = 0; i < 3; i++) {
                            warCards.add(player2.get(player2.size() - 1));
                            player2.remove(player2.size() - 1);
                            System.out.println("[]");
                        }
                        computerCard = player2.get(player2.size() - 1);
                        System.out.println(computerCard);
                    }
                    if (userCard.getRank() > computerCard.getRank()) {
                        System.out.println("You win!");
                        warCards.add(computerCard);
                        player2.remove(player2.size() - 1);
                        for (int i = 1; i <= warCards.size(); i++) {
                            player1.add(warCards.get(warCards.size() - i));
                        }
                    }
                    else if (computerCard.getRank() > userCard.getRank()) {
                        System.out.println("Computer wins!");
                        warCards.add(userCard);
                        player1.remove(player1.size() - 1);
                        for (int i = 1; i <= warCards.size(); i++) {
                            player2.add(warCards.get(warCards.size() - i));
                        }
                    }
                }
            }
            System.out.println("Your deck size: " + player1.size() + " Computer's deck size: " + player2.size());
            Collections.shuffle(player1);
            Collections.shuffle(player2);
            System.out.println("Press ENTER to proceed to next round.");
            input.nextLine();
        }
        if (player1.size() == 0) {
            System.out.println("You lose!");
        }
        else {
            System.out.println("Congratulations! You beat a simple machine!");
        }
    }

    private static Deck createDeck() {
        Deck gameDeck = new Deck();
        gameDeck.shuffleDeck();
        return gameDeck;
    }

    private static ArrayList<Card> splitDeck(Deck gameDeck, int player) {
        ArrayList<Card> playerDeck = new ArrayList<>();
        if (player == 1) {
            for (int i = 0; i < gameDeck.getSize() / 2; i++) {
                playerDeck.add(gameDeck.getCard(i));
            }
        } else {
            for (int i = gameDeck.getSize() / 2; i < gameDeck.getSize(); i++) {
                playerDeck.add(gameDeck.getCard(i));
            }
        }
        return playerDeck;
    }
}
