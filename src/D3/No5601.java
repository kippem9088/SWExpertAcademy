package D3;

import java.util.Scanner;

public class No5601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int test_case;

        for (test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            System.out.print(String.format("#%d ", test_case));

            for (int n = 0; n < N; n++) {
                System.out.print(String.format("1/%d ", N));
            }

            System.out.print("\n");
        }
    }
}
