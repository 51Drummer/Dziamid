package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
       private final Scanner fileScanner;
       public PersonScannerAdapter (Scanner fileScanner){

           this.fileScanner = fileScanner;
       }

        @Override
        public Person read() throws IOException {

           String line = fileScanner.nextLine();
           String[] listOfWords = line.split("\\s");
           Date date = new Date();

           String firstName = listOfWords[1];
           String middleName = listOfWords[2];
           String lastName = listOfWords[0];

           date.setDate(Integer.parseInt(listOfWords[3]));
           date.setMonth(Integer.parseInt(listOfWords[4])-1);
           date.setYear(Integer.parseInt(listOfWords[5])-1900);

           Person person = new Person(firstName,middleName,lastName,date);
           return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
