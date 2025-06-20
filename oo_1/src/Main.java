public class Main {
    public static void main(String[] args) {
        int[] grades = new int[3];
        grades[0] = 77;
        grades[1] = 88;
        grades[2] = 99;
        System.out.println(grades[1]);
        grades[1] = 100;
        System.out.println(grades[1]);

    }

    static int add(int x, int y) {
        int sum = x + y;
        return sum;
    }

}


