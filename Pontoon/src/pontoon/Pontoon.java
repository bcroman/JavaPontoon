package pontoon;
import java.util.Scanner;

public class Pontoon {
    
    // start keyboard
    static Scanner kboard = new Scanner(System.in);

    // main body
    public static void main(String[] args) {
        //variables
        String choice;
        int card1;
        int card2;
        int newCard;
        int mainTotal = 0;
        int houseTotal;
        int cardsDrawn[] = new int[10];
        int cardCount =3;
        boolean mainResult;
        boolean mainBusted;
        
        //house number function
        houseTotal = houseNum();
        
        //generate a random num for cards between 1 and 10
        card1 = getRandomNum();
        cardsDrawn[1] = card1;
        card2 = getRandomNum();
        cardsDrawn[2] = card2;
        
        //call calcTotal function
        mainTotal = calcTotal(card1,card2);
        
        //Display Crads
        System.out.println("You have drawn "+card1+" and "+card2);
        
        //display mesage and user input
        System.out.println("Do you wish to drwan another card? (y/n)");
        choice = kboard.next();
        
        //ask user for another card
        while (choice.equalsIgnoreCase("y")){           
            newCard = getRandomNum();
            cardsDrawn[cardCount] = newCard;
            cardCount = cardCount +1;
            mainTotal = mainTotal + newCard;
            System.out.println("You have drawn a "+newCard);
            
            //check to see the total is over 21
            mainBusted = busted(mainTotal);
            
            if (mainBusted == true){
                System.out.println("Busted your cards total of "+mainTotal+" which is ovre 21");
                break;
            }
            
            System.out.println("Do you wish to drwan another card? (y/n)");
            choice = kboard.next();            
        }
        
        // call getResult function
        mainResult = getResult(mainTotal,houseTotal);
        
        //display result
        if (mainResult == true){
            System.out.println("You have won with a total of "+mainTotal);
        }
        
        else{
            System.out.println("You have lost with "+mainTotal);
        }
        
        System.out.println("The house got "+houseTotal);
        
        System.out.print("Cards drawn: ");
        
        for (int i = 1; i < 10; i++) {
            if (cardsDrawn[i] != 0){
                if (i == 1){
                    System.out.print(cardsDrawn[i]);
                }
                else{
                    System.out.print(","+cardsDrawn[i]);
                }
            }
        }
        System.out.println();
        
    }
    
    //generate a random num function
    public static int getRandomNum(){
        int value= 0;
        value = (int)(Math.random()*10);
        return value;
    }
    
    // total function to add two numbers
    public static int calcTotal(int card1, int card2){
        int total= 0; //set sub variables
        total = card1+card2; // add variables
        return total; // reture value to main
    }
    
    // get resutlt true/false function
    public static boolean getResult(int total, int houseTotal){
        boolean funResult;
        
        if (total > houseTotal && total <= 21){
            funResult = true;
        }
        
        // if the total is out of the range then display a message
        else{
            funResult = false;
        }
        
        return funResult; // reture variable to main
    }
    
    public static boolean busted(int total){
        boolean subBuested = false;
        if (total > 21){
            subBuested = true;
        }
        return subBuested; 
    }
    
    public static int houseNum(){
        int houseTotal = 0;
        
        while(houseTotal < 17){
            int newCard = getRandomNum();
            houseTotal = houseTotal + newCard;
        }
        
        return houseTotal;
    }
        
 
}
