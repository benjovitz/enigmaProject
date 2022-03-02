package com.company;

import java.util.Scanner;

public class Main {
    Scanner keyboard = new Scanner(System.in);
    char[] alphabet = " ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅ ABCDEFGHIJKLMNOPQRSTUVXYZÆØÅ".toCharArray();

    public static void main(String[] args) {

	Main obj=new Main();
    obj.execute();
    }
    public void execute(){
        Scanner keyboard = new Scanner(System.in);
        mainMenu();


    }

    //menu vælger
    //hoved menu,men hviken krypterings stil
    public void mainMenu(){
        System.out.println("Main menu, what encryption type is it?");
        System.out.println("1: Caesar cipher");
        caesarMenu();

    }
    //caesar menu
    public void caesarMenu(){
        System.out.println("do you wanna encrypt or decrypt?");

        //encrypt
        System.out.println("What is the message?");
        String message = keyboard.nextLine();
        System.out.println("What is your shift value?");
        int shift= keyboard.nextInt();
        caesarEncryption(message, shift);

        //decrypt -//-

    }
    //tilbage til hovede menu
    //krypter eller dekrypter

    //string modtager
    /*public String messageReciever (String message){
        caesarEncryption(message);
        return message;
        }*/



    //krypter
    public void caesarEncryption(String message,int shifvalue){
        for (int i = 0; i <message.length()-1; i++) {
            char letter;
            char letterEncrypted;
            int number;
            letter =message.charAt(i);
            number=letterToNumber(letter);
            letterEncrypted=numberToLetter(number+shifvalue);
            System.out.print(letterEncrypted);
        }
    }
//dekrypter
public void caesarDecryption(String message){
    for (int i = 0; i <message.length() ; i++) {
        char letter;
        int number;
        letter =message.charAt(i);
        number=letterToNumber(letter);
        numberToLetter(number-3);
        System.out.print(numberToLetter(number-3));
    }
}
    //alfabet

    //number2letter
    public char numberToLetter(int number){
        char letter = alphabet[number];
        return letter;
    }

    //letter2number
    public int letterToNumber(char letter) {
        letter = Character.toUpperCase(letter);
        int number=-1;
        for (int i = 30; i < alphabet.length; i++) {
            if(alphabet[i]==letter){
                return i;

            }
        }

        return number;
    }
}

