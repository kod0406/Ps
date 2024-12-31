import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 100개의 정수를 저장할 수 있는 배열 선언
        int[] numbers = new int[100];
        int count = 0;

        // 정수를 입력받음
        while (true) {
            int num = scanner.nextInt();  // 정수 입력 받기
            if (num == 0) {
                break;  // 0이 입력되면 종료
            }
            if (count < 100) {
                numbers[count] = num;  // 배열에 저장
                count++;
            }
        }

        // 입력된 정수를 가장 나중에 입력된 순서대로 한 줄로 출력
        for (int i = count - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");  // 값 사이에 공백을 두고 출력
        }

        scanner.close();
    }
}
