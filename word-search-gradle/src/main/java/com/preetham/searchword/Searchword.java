package com.preetham.searchword;
import java.io.IOException;
import java.util.Scanner;
class SearchWord {
    //Main class
    public static void main(String[] args) throws IOException {

        System.out.println("enter word to be searched");
        Scanner sc = new Scanner(System.in); //Take input from the user
        String input = sc.next();
        Word w=new Word(input);//creating instance of the word class
        w.wordFind();
    }
}