package com.example.michael.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * to run, press  ctr + shift + f10
 * in the top right corner, on the dropdown menu that says MyClass with a
 * green arrow and hammer next to it, click on the down arrow then on the drop down menu click
 * "save 'MyClass' Configuration"
 * to run again, click the green arrow
 */
public class MyClass {
    public static void main(String args[]) {
        System.out.println("Hello, World!");

        //if you don't like my coding style, press Ctr + alt + l
        // and watch the magic

        new MyClass().dialog();
    }

    private void dialog() {
        String input = "";

        Prime prime = Prime.get();
        while (!input.equals("end")) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("give me a number, please");
                input = br.readLine();
                System.out.println("is " + input + " prime?");
				System.out.println(prime.isArgPrime(input));
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }


}
