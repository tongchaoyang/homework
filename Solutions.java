package homework;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Solutions {
    public static int genSequence(int s) {
        assert s > 0;
        if (s == 1)
            return 1;
        
        int r = 0;
        do {
            r++;
            if (s % 2 == 0) {
                s /= 2;
            }
            else {
                s *= 3;
                s++;
            }
        } while (s > 1);
        r++;
        return r;
    }
    
    public static int genSequence2(int s) {
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
    
    static private Map<Integer, Integer> m = new HashMap<>();
    public static int genSequence3(int s) {
        assert s > 0;
        Integer i = m.get(s);
        if (i != null)
            return i;
        i = genSequence2(s);
        m.put(s, i);
        return i;
    }
    public static void main(String[] args) {
        int m = 0;
        final int MAXITEMS = 100000;
        LocalTime t1 = LocalTime.now();
        for (int i = 1; i < MAXITEMS; i++) {
            int l = genSequence(i);
            //System.out.println("length = " + l);
            if (l > m)
                m = l;
        }
        LocalTime t2 = LocalTime.now();
        Duration d = Duration.between(t1, t2);
        System.out.println("Max length is " + m + " in " + d.toMillis() + "ms");
        
        t1 = LocalTime.now();
        for (int i = 1; i < MAXITEMS; i++) {
            int l = genSequence2(i);
            //System.out.println("length = " + l);
            if (l > m)
                m = l;
        }
        t2 = LocalTime.now();
        d = Duration.between(t1, t2);
        System.out.println("Max length is " + m + " in " + d.toMillis() + "ms");
        
        t1 = LocalTime.now();
        for (int i = 1; i < MAXITEMS; i++) {
            int l = genSequence3(i);
            //System.out.println("length = " + l);
            if (l > m)
                m = l;
        }
        t2 = LocalTime.now();
        d = Duration.between(t1, t2);
        System.out.println("Max length is " + m + " in " + d.toMillis() + "ms");
        
        t1 = LocalTime.now();
        for (int i = 1; i < MAXITEMS; i++) {
            int l = genSequence3(i);
            //System.out.println("length = " + l);
            if (l > m)
                m = l;
        }
        t2 = LocalTime.now();
        d = Duration.between(t1, t2);
        System.out.println("Max length is " + m + " in " + d.toMillis() + "ms");
    }
}
