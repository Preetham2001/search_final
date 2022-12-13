package com.preetham.searchword;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class Word {

    String input;
    //constructor
    public Word(String input) {
        this.input=input;
    }

    void wordFind() throws IOException {


        File[] f1 = new File("C:/Users/preet/word-search-gradle/src/main/resources").listFiles();
        //loop to read and find matched words all the available files in the above path
        for (File file : f1) {

            if (file.isFile()) {
                BufferedReader inputStream=null;
                String line;
                //try catch block
                try {
                    inputStream=new BufferedReader(new FileReader(file));
                }catch (IOException e){

                }
                String[] words;

                String s;

                int count = 0;//count variable which holds the number of times the word occured

                while ((s = inputStream.readLine()) != null) {

                    words = s.split(" ");//split the sentence based on blank spaces
                    //loop to find the lines which contains the occurence of the input given
                    for (String word : words) {
                        word = word.replaceAll("[^a-zA-Z]", "");
                        if (word.equals(this.input)) {
                            String res = Arrays.toString(words).replace(",", "")//comma's replacement
                                    .replace("[", "")//left bracket replacement
                                    .replace("]", "")//right bracket replacement
                                    .trim();//remove white spaces
                            String[] a = res.split("\\.");
                            int l = a.length;
                            for (String value : a) {
                                boolean c = value.contains(this.input);
                                if (c) {

                                    System.out.println("The paragraph is:");

                                    System.out.println(value + "\n");
                                    count++;
                                }
                            }
                        }
                    }


                }
                if (count != 0) {
                    System.out.println("The word appeared for" + " " + count + " " + "times in the file");
                    System.out.println("-----------------------------------------------");
                } else {

                    System.out.println("The word is not present in the file");
                }
            }
        }

    }
}

