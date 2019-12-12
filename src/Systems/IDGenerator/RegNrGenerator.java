package Systems.IDGenerator;

import java.util.Random;

public class RegNrGenerator implements IDGenerator{
    private static int RegNrKey=11859;
    private StringBuilder str;
    private Random r=new Random();

    public String generate() {
            str=new StringBuilder();
            setSeed();
        for(int x=0;x<3;x++){
            //setSeed();
            char a=(char)(r.nextInt(26)+'a');
            str.append(a);
        }
        str.append(" ");
        for(int x=0;x<3;x++){
            //setSeed();
            str.append( r.nextInt(10));
        }
        return str.toString();
    }
    private void setSeed(){
        RegNrKey--;
        r.setSeed(RegNrKey);
    }

}