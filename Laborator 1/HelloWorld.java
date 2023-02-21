/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Miruna
 */
public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Hello World!");
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        int sum = 0;
        int result;
        result = n;
        result = result * 3;
        result = result + 0b10101;
        result = result + 0xFF;
        result = result * 6;
        while (result > 0 || sum > 9) {
            if (result == 0) {
                result = sum;
                sum = 0;
            }
            sum = sum + result % 10;
            result = result / 10;
        }
        result=sum;
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }

}
