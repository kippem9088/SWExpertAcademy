package D3;

import java.util.Scanner;

public class No5603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int test_case;

        for (test_case = 1;  test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] haystacks = new int[N];
            int sum = 0;

            for (int n = 0; n < N; n++) {
                haystacks[n] = sc.nextInt();
                sum += haystacks[n];
            }

            int average = sum / N;
            int result = 0;

            for (int n = 0; n < N; n++) {
                if (haystacks[n] > average) {
                    result += (haystacks[n] - average);
                }
            }

            System.out.println(String.format("#%d %d", test_case, result));
        }
    }
}
