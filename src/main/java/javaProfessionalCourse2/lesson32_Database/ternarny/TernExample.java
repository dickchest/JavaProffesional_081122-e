package javaProfessionalCourse2.lesson32_Database.ternarny;

public class TernExample {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        int z = 0;

        if (x > y) {
            z = x - y;
        } else {
            z = y - x;
        }

        /*
        условие ? выражение 1 : выражение 2
         */
        int z2 = (x > y) ? z - y : y - x;

        System.out.println(z);
        System.out.println(z2);

        int max = (x > y) ? x : y;
        System.out.println(max);

        int a = -5;
        int absolutValue = (a>0) ? a : -a;
        System.out.println(absolutValue);
    }
}
