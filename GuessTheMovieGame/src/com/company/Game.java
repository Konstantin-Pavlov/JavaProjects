package com.company;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public void filmsHistogram(String films[]){
        System.out.println("title\t\t\tnumber of letters\tHistogram");
        for (String i: films) {
            String film = i;
            System.out.printf("\n%12s %5d \t\t\t\t\t", i, i.length() );
            for ( int j = 0; j < film.length(); j++){
                if (j == film.length()-1){
                    System.out.print("_");
                    continue;
                }
                System.out.print("_" + " ");
            }
        }
    }

    public void printFilms(String films[]){
        System.out.println("\n");
        for (String i: films) {
            System.out.println(i);
        }

    }

    public boolean openString(String s){
        if (s.isEmpty())
            return false;
        else
            return true;
    }

    public  String wordToUnderscore(String word){
        for (int i = 0; i < word.length(); i++) {
            word = word.replace(word.charAt(i), '_');
        }
        return word;
    }

    public String pickRandomFilm(String films[]){
        Random f = new Random();
        String film = films[f.nextInt(films.length)];
        return film;
    }

    public void guessTheFilmGame(String film){
        String originalFilm = film;
        char[] wrongLetters = new char[30];
        int wrongGuesses = 0;

        //System.out.println(film);
        film = wordToUnderscore(film);
        //System.out.println(film);

        Scanner s = new Scanner(System.in);
        StringBuilder tempFilm = new StringBuilder(film);
        //StringBuffer tempFilm = new StringBuffer(thisFilm);

        System.out.print("enter the letter: ");
        String c = s.nextLine();
        char q = c.charAt(0);

        while (true) {


            if (originalFilm.indexOf(q) == -1) {
                wrongGuesses++;
                System.out.println("no " + q + " in " + originalFilm);


                boolean b = true;
                for (int i = 0; i < wrongLetters.length; i++){
                    if(wrongLetters[i] == q ) {
                        System.out.println("you have already entered this letter: " + q);
                        --wrongGuesses;
                        b = false;
                        break;
                    }
                }

                System.out.println("wrong guesses: " + wrongGuesses);
                if (b)
                    wrongLetters[wrongGuesses-1] = q;

                System.out.print("wrong letters: ");
                for (int i = 0; i < wrongLetters.length; i++){
                    System.out.print(wrongLetters[i] + " ");
                }

            } else  {
                for (int i = 0; i < tempFilm.length(); i++) {
                    if (originalFilm.charAt(i) == q) {
                        //System.out.print("yes!");
                        tempFilm.setCharAt(i, q);
                    }
                }
            }

            String strTempFilm = tempFilm.toString();
            if (strTempFilm.equals(originalFilm)) {
                System.out.println("it's " + strTempFilm);
                System.out.println("correct!");
                break;
            }

            //System.out.println("\n" + originalFilm + "\n" + tempFilm);
            System.out.println("\n" + tempFilm);

            System.out.print("\nenter the letter: ");
            c = s.nextLine();
            q = c.charAt(0);

        }
    }
}



