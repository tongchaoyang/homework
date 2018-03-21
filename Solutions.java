package homework;

import java.time.Duration;
import java.time.LocalTime;

public class Solutions {
    public static int genSequence(int s) {
        int r = 0;
        assert s > 0;
        if (s == 1)
            return 1;
        
        do {
            r++;
            if (s % 2 == 0) {
                s /= 2;
            }
            else {
                s = 3 * s + 1;
            }
        } while (s > 1);
        r++;
        return r;
    }
    
    public static int genSequence2(int s) {
        int r = 0;
        assert s > 0;
        if (s == 1)
            return 1;
        if (s % 2 == 0) {
            return 1 + genSequence2(s/2);
        }
        else {
            return 1 + genSequence2(3 * s + 1);
        }
    }
    
    public static void main(String[] args) {
        int m = 0;
        LocalTime t1 = LocalTime.now();
        for (int i = 1; i < 4; i++) {
            int l;
            if (args.length > 0)
                l = genSequence(i);
            else 
                l = genSequence2(i);
            //System.out.println("length = " + l);
            if (l > m)
                m = l;
        }
        LocalTime t2 = LocalTime.now();
        Duration d = Duration.between(t1, t2);
        System.out.println("Max length is " + m + " in " + d.toMillis() + "ms");
    }
}
