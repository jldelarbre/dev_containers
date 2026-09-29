package com.example.doubleinput;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java -cp target/classes com.example.doubleinput.Main <number>");
            System.exit(1);
        }

        double input = Double.parseDouble(args[0]);
        System.out.println(doubleValue(input));
    }

    static double doubleValue(double input) {
        return input * 2;
    }
}