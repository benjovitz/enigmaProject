package com.company;

import java.util.Scanner;

public class Main {
    Scanner keyboard = new Scanner(System.in);
    char[] alphabet = " ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅ".toCharArray();
    //char[] alphabet = " ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅ ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅ".toCharArray();

    public static void main(String[] args) {

        Main obj = new Main();
        obj.mainMenu();
    }


    //hoved menu,men hviken krypterings stil
    public void mainMenu() {
        System.out.printf("\nMain menu, what encryption type is it?\n");
        System.out.println("1: Caesar cipher");
        System.out.println("3: exit");
        String answer = keyboard.nextLine();
        if (answer.equals("1")){
            caesarMenu();
        }else if (answer.equals("3")){
            System.out.println("thank you, goodbye");
        }


    }

    //caesar menu, om der skal krypteres eller dekrypteres
    public void caesarMenu() {
        System.out.println("do you wanna encrypt or decrypt?");
        System.out.println("1 for encrypt 2 for decrypt 3 for going back to the main menu");
        String answer = keyboard.nextLine();
        if (answer.equals("1")) {
            caesarEncryptMenu();
        } else if (answer.equals("2")) {
            caesarDecryptMenu();
        } else if (answer.equals("3")) {
            mainMenu();
        }
        mainMenu();
    }

    public void caesarEncryptMenu() {
        System.out.println("What is the message?");
        String message = keyboard.nextLine();
        System.out.println("What is your shift value?");
        int shift = keyboard.nextInt();
        caesarEncryption(message, shift);


    }

    public void caesarDecryptMenu() {
        System.out.println("What is the message?");
        String message = keyboard.nextLine();
        System.out.println("What is your shift value?");
        int shift = keyboard.nextInt();
        caesarDecryption(message,shift);


    }

    //string modtager
    /*public String messageReciever (String message){
        caesarEncryption(message);
        return message;
        }*/

//print

    //krypter mekanisme
    public void caesarEncryption(String message, int shiftvalue) {
        for (int i = 0; i < message.length(); i++) {
            char letter;
            char letterEncrypted;
            int number;
            letter = message.charAt(i);
            number = letterToNumber(letter);
            int shiftedValue = applyShift(number, shiftvalue);
            letterEncrypted = numberToLetter(shiftedValue);
            System.out.print(letterEncrypted);
        }
    }

    //dekrypter mekanisme
    public void caesarDecryption(String message, int shiftvalue) {
        for (int i = 0; i < message.length(); i++) {
            char letter;
            char letterEncrypted;
            int number;
            letter = message.charAt(i);
            number = letterToNumber(letter);
            int shiftedValue = applyShift(number, -shiftvalue);
            letterEncrypted = numberToLetter(shiftedValue);
            System.out.print(letterEncrypted);
        }
    }


    public char numberToLetter(int number) {
        char letter = alphabet[number];
        return letter;
    }


    public int letterToNumber(char letter) {
        letter = Character.toUpperCase(letter);
        int number = -1;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == letter) {
                return i;

            }
        }

        return number;
    }

    public int applyShift(int indexLetter, int shift) {
        int shifted = indexLetter + shift;
        if (shifted > 28) {
            shifted = shifted % alphabet.length + 1;
        } else if (shifted <= 0) {
            shifted += 28;
        }
        return shifted;
    }
}

