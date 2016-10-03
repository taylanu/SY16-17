/**
 * Created by taylanu on 6/21/2016.
 * Authored by DOberle
 */
public class Laser {
    private int row, col, dir;
    public static final int UP    = 0;
    public static final int RIGHT = 1;
    public static final int DOWN  = 2;
    public static final int LEFT  = 3;

    public Laser (char station)
    {
        if(station>='a' && station<='j')
        {
            row = 1;
            col = (int)(station-'a')+1;
            dir = DOWN;
        }
        else if(station>='A' && station<='J')
        {
            row = 10;
            col = (int)(station-'A')+1;
            dir = UP;
        }
        else if(station>='k' && station<='t')
        {
            row = (int)(station-'k')+1;
            col = 1;
            dir = RIGHT;
        }
        else   //if(station>='K' && station<='T')
        {
            row = (int)(station-'K')+1;
            col = 10;
            dir = LEFT;
        }
    }

//other Laser methods defined here
}

