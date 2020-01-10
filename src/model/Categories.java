package model;

import java.util.ArrayList;
import java.util.List;

public class Categories {
    private List<String> genre;
    private List<String> artist;
    private List<String> years;

    public Categories(){
        this.genre = new ArrayList<String>();
        make_genre();
        this.artist = new ArrayList<String>();

    }
    private void make_genre(){
        this.genre.add("classical");
        this.genre.add("country");
        this.genre.add("90s");
        this.genre.add("jazz");
        this.genre.add("80s");
        this.genre.add("pop");
        this.genre.add("metal");
        this.genre.add("rock");
        this.genre.add("punk");
        this.genre.add("rap");
        this.genre.add("blues");
        this.genre.add("hip hop");
        this.genre.add("romantic");
    }
    private void make_artist(){
        this.artist.add("Taylor Swift");
        this.artist.add("Coldplay");
        this.artist.add("Lady GaGa");
        this.artist.add("The Beatles");
        this.artist.add("Rihanna");
        this.artist.add("Alicia Keys");
        this.artist.add("Metallica");
        this.artist.add("Jennifer Lopez");
        this.artist.add("Nirvana");
        this.artist.add("The Killers");
        this.artist.add("Justin Timberlake");
        this.artist.add("Bob Marley");
        this.artist.add("Maroon 5");
        this.artist.add("Enrique Iglesias");
        this.artist.add("Led Zeppelin");
        this.artist.add("Shakira");
        this.artist.add("Bob Dylan");
        this.artist.add("Britney Spears");
        this.artist.add("Avril Lavigne");
        this.artist.add("Matisyahu");
        this.artist.add("Eminem");
        this.artist.add("Chris Brown");
        this.artist.add("Michael Jackson");
        this.artist.add("Madonna");
        this.artist.add("Usher");
        this.artist.add("Pink Floyd");
        this.artist.add("Kanye West");
        this.artist.add("Pharrell Williams");

    }
}








