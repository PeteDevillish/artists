package pl.artists;

import javax.persistence.*;
import java.util.List;

//Stwórz projekt.
//1. Stwórz encje (korzystamy z hibernate): Artysta (imię, nazwisko) oraz Album (nazwa, artysta [relacja]).
// Sprawdź, czy hibernate (po ustawieniu odpowiedniej opcji) utworzy odpowiednią strukturę bazy danych.
//2. Stwórz serwlet obsługujący żądania wysłane pod ścieżkę artists.
// Dla metody GET, serwlet ustawi wartość atrybutowi "artists" żądania - listę artystów, uzyskaną za pomocą Dao (korzystamy z EntityDao utworzonego wcześniej).
// Następnie serwlet przekieruje obsługę żądania do dokumentu artists.jsp. Dokument artists.jsp (tworzymy taki) wyświetla listę artystów jako łańcuch znaków.
//3. Dokument artists.jsp generuje przy pomocy tagów z biblioteki JSTL tablicę artystów (z odpowiednimi nagłówkami i wierszami).
//4. Dokument artists.jsp ma przycisk, kierujący pod ścieżkę /edit-artist. Tworzymy serwlet obsługujący żądanie wysłane pod taką ścieżkę.
// Dla metody GET serwlet przekieruje obsługę żądania do dokumentu edit-artist.jsp. Dla metody POST serwlet utworzy artystę zgodnie z przekazanymi parametrami.
// Dokument edit-artist.jsp zawiera formularz do tworzenia artysty.
//5. Spraw, aby dokument artist.jsp w tabeli generował dla każdego artysty w wierszu dodatkową komórkę - link o treści edytuj.
// Link kieruje pod ścieżkę /edit-artist z parametrem url o nazwie id, którego wartością będzie id artysty.
// Serwlet obsługujący żądania wysłane pod ścieżkę /edit-artist, jeśli mamy parametr url o nazwie id, ustawie artybuty żądania - imię, nazwisko oraz id artysty.
// Dokument edit-artist.jsp w formularzy uwzględni te wartości (wyświetli w formularzu odpowiednie wartości).
// Przycisk zatwierdzający formularz powinien mieć wtedy tekst "Zatwierdź edycję".
// W formularzu powinno być dodatkowo ukryte pole (type="hidden") o nazwie id, oraz wartości - id edytowanego artysty. Obsłuż również odpowiednio żądanie edytujące artystę.
//Analogiczne zadania dla albumu
//6. Analogia do zadania 2.
//7. Analogia do zadania 3.
//8. Analogia do zadania 4 (artystów możemy wybrać z rozwijanej listy).
//9. Analogia do zadania 5.
@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;

    public Artist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Artist() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
