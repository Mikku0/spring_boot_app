package org.example;

public class App {
    public static void main(String[] args) {
        App main = new App();
        int result = main.Calc(5, 10);

        System.out.println(result);
    }
    public int Calc(int x, int y) {
        return x + y;
    }
}
