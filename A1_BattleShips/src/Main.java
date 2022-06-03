import java.util.Scanner;

public class Main {
    public static String playerShipPosition[][] = new String[10][10];
    public static String compShipPosition[][] = new String[10][10];
    public static int playerShipCount;
    public static int compShipCount;
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        // Opening text and make ocean map
        System.out.println("**** Welcome to Battle Ships Game! ****");
        System.out.println("Right now, the sea is empty.");
        oceanMap();

        playerDeployShip();
        compDeployShip();

        do{
            playerTurn();
            compTurn();
        }while(!gameOver());
    }
    public static void oceanMap(){
        // Top X Coordinate
        System.out.print("  ");
        for(int i = 0; i < 10; i++)
            System.out.print(i);
        System.out.println();

        // Y coordinate and ocean area
        for(int i = 0; i < playerShipPosition.length; i++) {
            for (int j = 0; j < playerShipPosition[i].length; j++) {
                playerShipPosition[i][j] = " ";
                if (j == 0)
                    System.out.print(i + "|" + playerShipPosition[i][j]);
                else if (j == playerShipPosition[i].length - 1)
                    System.out.print(playerShipPosition[i][j] + "|" + i);
                else
                    System.out.print(playerShipPosition[i][j]);
            }
            System.out.println();
        }

        // Bottom X Coordinate
        System.out.print("  ");
        for(int i = 0; i < 10; i++)
            System.out.print(i);
        System.out.println();
    }

    public static void printOcean(){
        System.out.println();
        // X Coordinate
        System.out.print("  ");
        for(int i = 0; i < 10; i++)
            System.out.print(i);
        System.out.println();

        // Y Coordinate, Ocean Area, and Ship Position
        for(int x = 0; x < playerShipPosition.length; x++) {
            System.out.print(x + "|");

            for (int y = 0; y < playerShipPosition[x].length; y++){
                System.out.print(playerShipPosition[y][x]);
            }

            System.out.println("|" + x);
        }

        // Bottom X Coordinate
        System.out.print("  ");
        for(int i = 0; i < 10; i++)
            System.out.print(i);
        System.out.println();
    }

    public static void playerDeployShip() {
        // Deploy Player's Ships
        for (int i = 0; i < 5; i++) {
            // Input X coordinate
            System.out.print("Enter X coordinate for your " + (i + 1) + ". ship: ");
            int x = input.nextInt();

            // Input Y coordinate
            System.out.print("Enter Y coordinate for your " + (i + 1) + ". ship: ");
            int y = input.nextInt();

            // If X and Y Greater Than Equal To 0 and Less than 10, and No Ship On That Coordinate
            if ((x >= 0 && x < 10) && (y >= 0 && y < 10) && (playerShipPosition[x][y] == " ")) {
                playerShipPosition[x][y] = "@";

            // If There Is Ship On That Corrdinate
            } else if ((x >= 0 && x < 10) && (y >= 0 && y < 10) && playerShipPosition[x][y] == "@") {
                System.out.println("You can't place two or more ships on the same location");
                i--;

            // If Ship Coordinate Is Outside The Ocean Area
            } else if ((x < 0 || x >= 5) || (y < 0 || y >= 5)) {
                System.out.println("You can't place ships outside the 10 by 10 grid");
                i--;
            }
        }
        // Call shipDeploy Method To Show The Ocean With Player Ships
        printOcean();
    }

    public static void compDeployShip(){
        // Assign Computer Position to " "
        for (int i = 0; i < playerShipPosition.length; i++){
            for (int j = 0; j < playerShipPosition[i].length; j++){
                compShipPosition[i][j] = " ";
            }
        }
        System.out.println("Computer is Deploying Ships...");
        for (int i = 0; i < 5; i++){
            int x = (int)(Math.random() * 10);
            int y = (int)(Math.random() * 10);
            if((x >= 0 && x < 10) && (y >= 0 && y < 10) && (playerShipPosition[x][y] == " "))
            {
                compShipPosition[x][y] = "2";
                System.out.println((i+1) + ". ship DEPLOYED");
            }else{
                i--;
            }
        }
    }

    public static void playerTurn(){
        System.out.println();
        System.out.println("YOUR TURN");

        // User Input to Guess the Computer's ship Coordinate
        System.out.print("Enter X coordinate: ");
        int x = input.nextInt();
        while ((x < 0) || (x > 9)){
            System.out.println("You just can input 0-9!");
            System.out.print("Enter X coordinate: ");
            x = input.nextInt();
        }

        System.out.print("Enter Y coordinate: ");
        int y = input.nextInt();
        while ((y < 0) || (y > 9)){
            System.out.println("You just can input 0-9!");
            System.out.print("Enter Y coordinate: ");
            y = input.nextInt();
        }

        // If player guess computer's ship coordinate correctly
        if(compShipPosition[x][y] == "2"){
            System.out.println("Boom! You sunk the ship!");
            compShipPosition[x][y] = " ";
            playerShipPosition[x][y] = "!";
        // If player entered own ship coordinates
        }else if(playerShipPosition[x][y] == "@"){
            System.out.println("Oh no, you sunk your own ship :(");
            playerShipPosition[x][y] = "x";
        // If player entered empty coordinate (miss)
        }else{
            System.out.println("Sorry, you missed");
        }
    }

    public static void compTurn(){
        playerShipCount = 0;
        compShipCount = 0;
        System.out.println("COMPUTER'S TURN");

        // Random Computer Input to Guess Player's Coordinates
        int x = (int)(Math.random() * 10);
        int y = (int)(Math.random() * 10);

        // If Computer Guess Player's Ship Correctly
        if(playerShipPosition[x][y] == "@"){
            System.out.println("The Computer sunk one of your ship!");
            playerShipPosition[x][y] = "x";
        // If Computer entered own ship coordinates
        }else if(compShipPosition[x][y] == "2"){
            System.out.println("The Computer sunk one of its own ship");
            playerShipPosition[x][y] = "!";
            compShipPosition[x][y] = " ";
        // If Computer entered empty coordinate (miss)
        }else{
            System.out.println("Computer missed");
        }

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (playerShipPosition[i][j] == "@"){
                    ++playerShipCount;
                } else if (compShipPosition[i][j] == "2") {
                    ++compShipCount;
                }else {
                    continue;
                }
            }
        }

        printOcean();

        System.out.println();
        // Print Player and Computer's Ships;
        System.out.println("Your Ships: " + playerShipCount + " | Computer Ships: " + compShipCount);
    }

    public static boolean gameOver(){
        // check if computer's ship is empty or not
        if (compShipCount == 0){
            System.out.println("Hooray! you win the battle");
            return true;
        }else if(playerShipCount == 0){
            System.out.println("Game Over! You Lost.");
            return true;
        }else {
            return false;
        }
    }
}
