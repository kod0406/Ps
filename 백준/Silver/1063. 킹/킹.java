import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k_x, k_y;
        int r_x, r_y;
        int repeat;

        String[] input = br.readLine().split(" ");
        k_x = input[0].charAt(0) - 65;
        k_y = Integer.parseInt(String.valueOf(input[0].charAt(1))) - 1;

        r_x = input[1].charAt(0) - 65;
        r_y = Integer.parseInt(String.valueOf(input[1].charAt(1))) - 1;

        repeat = Integer.parseInt(input[2]);

        for (int i = 0; i < repeat; i++) {
            String input_2 = br.readLine();
            if (input_2.equals("B")) {
                if (k_y > 0) {
                    if (k_x == r_x && k_y - 1 == r_y) {
                        if (r_y > 0) {
                            r_y--;
                            k_y--;
                        }
                    } else {
                        k_y--;
                    }
                }
            } else if (input_2.equals("T")) {
                if (k_y < 7) {
                    if (k_x == r_x && k_y + 1 == r_y) {
                        if (r_y < 7) {
                            r_y++;
                            k_y++;
                        }
                    } else {
                        k_y++;
                    }
                }
            } else if (input_2.equals("R")) {
                if (k_x < 7) {
                    if (k_y == r_y && k_x + 1 == r_x) {
                        if (r_x < 7) {
                            r_x++;
                            k_x++;
                        }
                    } else {
                        k_x++;
                    }
                }
            } else if (input_2.equals("L")) {
                if (k_x > 0) {
                    if (k_y == r_y && k_x - 1 == r_x) {
                        if (r_x > 0) {
                            r_x--;
                            k_x--;
                        }
                    } else {
                        k_x--;
                    }
                }
            } else if (input_2.equals("RT")) {
                if (k_x < 7 && k_y < 7) {
                    if (k_y + 1 == r_y && k_x + 1 == r_x) {
                        if (r_x < 7 && r_y < 7) {
                            r_x++;
                            r_y++;
                            k_x++;
                            k_y++;
                        }
                    } else {
                        k_x++;
                        k_y++;
                    }
                }
            } else if (input_2.equals("LT")) {
                if (k_x > 0 && k_y < 7) {
                    if (k_y + 1 == r_y && k_x - 1 == r_x) {
                        if (r_x > 0 && r_y < 7) {
                            r_x--;
                            r_y++;
                            k_x--;
                            k_y++;
                        }
                    } else {
                        k_x--;
                        k_y++;
                    }
                }
            } else if (input_2.equals("RB")) {
                if (k_x < 7 && k_y > 0) {
                    if (k_x + 1 == r_x && k_y - 1 == r_y) {
                        if (r_x < 7 && r_y > 0) {
                            r_x++;
                            r_y--;
                            k_x++;
                            k_y--;
                        }
                    } else {
                        k_x++;
                        k_y--;
                    }
                }
            } else if (input_2.equals("LB")) {
                if (k_x > 0 && k_y > 0) {
                    if (k_x - 1 == r_x && k_y - 1 == r_y) {
                        if (r_x > 0 && r_y > 0) {
                            r_x--;
                            r_y--;
                            k_x--;
                            k_y--;
                        }
                    } else {
                        k_x--;
                        k_y--;
                    }
                }
            }
        }

        bw.write((char) (k_x + 65) + String.valueOf(k_y + 1));
        bw.newLine();
        bw.write((char) (r_x + 65) + String.valueOf(r_y + 1));
        bw.flush();
    }
}
