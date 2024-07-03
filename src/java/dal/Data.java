/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.HashSet;
import model.Film;

/**
 *
 * @author FPT
 */
public class Data {
    ArrayList<Film> listFilmSlide;

    public Data() {
    }

    public Data(ArrayList<Film> listFilmSlide) {
        this.listFilmSlide = listFilmSlide;
    }
    
    public static ArrayList<Film> listFilmSlide() {
        ArrayList<Film> listFilmSlide = new ArrayList<>();
        DAO dao = new DAO();
        listFilmSlide.add(dao.getFilmById(1));
        listFilmSlide.add(dao.getFilmById(2));
        listFilmSlide.add(dao.getFilmById(3));
        return listFilmSlide;
    }
    
    public void removeDuplicates(ArrayList<Film> films) {
        HashSet<Integer> ids = new HashSet<>();
        ArrayList<Film> result = new ArrayList<>();

        for (Film film : films) {
            if (!ids.contains(film.getIDFilm())) {
                ids.add(film.getIDFilm());
                result.add(film);
            }
        }
        films.clear();
        films.addAll(result);
    }
}
