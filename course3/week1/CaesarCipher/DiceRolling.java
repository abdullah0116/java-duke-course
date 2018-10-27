import java.util.Random;

public class DiceRolling {  
    public void simulate(int rolls) {
        Random rand = new Random();
        int[] counts = new int[13];
        
        for (int i = 0; i < rolls; i++) {
            int d1 = rand.nextInt(6) + 1;
            int d2 = rand.nextInt(6) + 1;
            System.out.println("roll is: " + d1 + "+" + d2 +" = " + (d1 +d2));
            counts[d1+d2] +=1;
        }
        for (int i = 2; i <= 12; i++) {
            System.out.println("counter: " + i + "'s=\t" + counts[i] + "\t" + 100.0 * counts[i]/rolls);
        }
    }
}
