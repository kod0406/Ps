import java.io.*;
import java.util.*;

class Balloon {
    int number;
    int value;

    Balloon(int number, int value) {
        this.number = number;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Deque<Balloon> deque = new ArrayDeque<>();
        String[] inputs = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            deque.addLast(new Balloon(i + 1, Integer.parseInt(inputs[i])));
        }

        while (!deque.isEmpty()) {
            Balloon current = deque.pollFirst();
            System.out.print(current.number + " ");
            if (deque.isEmpty()) break;
            int steps = current.value;
            if (steps > 0) {
                for (int i = 0; i < steps - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                steps = Math.abs(steps);
                for (int i = 0; i < steps; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
    }
}