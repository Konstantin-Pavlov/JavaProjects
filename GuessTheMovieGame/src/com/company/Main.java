package com.company;
import java.util.Scanner;


public class Main {
    static String[] films = {"interstellar", "terminator", "predator", "ameli"};

    public static void main(String[] args) {

        Game game = new Game();
        //game.filmsHistogram(films);


        String xFilm = game.pickRandomFilm(films);
        String originalFilm = xFilm;
        game.guessTheFilmGame(xFilm);


    }
}
