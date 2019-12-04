package Fuctionality.IDGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegNrGenerator implements IDGenerator{
    private static int RegNrKey = -19200;
    private StringBuilder str;
    private Random r=new Random();

    public String generate() {
            str=new StringBuilder();
            setSeed();
        for(int x=0;x<3;x++){
            //setSeed();
            str.append((char) r.nextInt(26)+'a');
        }
        str.append(" ");
        for(int x=0;x<3;x++){
            //setSeed();
            str.append( r.nextInt(10));
        }
        return str.toString();
    }
    private void setSeed(){
        r.setSeed(RegNrKey);
        RegNrKey++;
    }

}