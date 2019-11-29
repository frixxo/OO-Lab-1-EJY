package Fuctionality;

import java.util.Random;

public class RegNrGenerator implements IDGenerator{
    private static int RegNrKey = 0;
    Random r = new Random(RegNrKey);

    public String generate() {
        r=new Random(RegNrKey);
        RegNrKey--;
        return  (char) (r.nextInt(26) + 'a') + "" + (char) (r.nextInt(26) + 'a') + "" + (char) (r.nextInt(26) + 'a') + " " + r.nextInt(10) + "" + r.nextInt(10) + "" + r.nextInt(10);
    }
}