package homework;

import java.time.Duration;
import java.time.LocalTime;

public class Solutions {
    public static int genSequence(int s) {
        int r = 0;
        assert s > 0;
        do {
            r++;
            if (s % 2 == 0) {
                s /= 2;
            }
            else {
                s = 3 * s + 1;
            }
        } while (s > 1);
        return r;
    }
    public static void main(String[] args) {
        int m = 0;
        LocalTime t1 = LocalTime.now();
        for (int i = 1; i < 1_000_000; i++) {
            int l = genSequence(i);
            if (l > m)
                m = l;
        }
        LocalTime t2 = LocalTime.now();
        Duration d = Duration.between(t1, t2);
        System.out.println("Max length is " + m + " in " + d.toMillis() + "ms");
    }
}
