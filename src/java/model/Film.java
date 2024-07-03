/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DAO;
import java.util.ArrayList;

/**
 *
 * @author FPT
 */
public class Film {

    private int IDFilm;
    private String name;
    private String time;
    private int year;
    private String imgPath;
    private String moviePath;
    private int age;
    private String Detail;
    private Country country;
    private String trailerPath;
    private boolean status;

    public Film() {
    }

    public Film(int IDFilm, String name, String time, int year, String imgPath, String moviePath, int age, String Detail, Country country, String trailerPath, boolean status) {
        this.IDFilm = IDFilm;
        this.name = name;
        this.time = time;
        this.year = year;
        this.imgPath = imgPath;
        this.moviePath = moviePath;
        this.age = age;
        this.Detail = Detail;
        this.country = country;
        this.trailerPath = trailerPath;
        this.status = status;
    }

    public int getIDFilm() {
        return IDFilm;
    }

    public void setIDFilm(int IDFilm) {
        this.IDFilm = IDFilm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getMoviePath() {
        return moviePath;
    }

    public void setMoviePath(String moviePath) {
        this.moviePath = moviePath;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String Detail) {
        this.Detail = Detail;
    }

    public Country getCountry() {
        return country;
    }

    public String getCountryName() {
        return country.getName();
    }

    public int getCountryId() {
        return country.getCountryID();
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getTrailerPath() {
        return trailerPath;
    }

    public void setTrailerPath(String trailerPath) {
        this.trailerPath = trailerPath;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getActor() {
        String allActor = "";
        DAO dao = new DAO();
        ArrayList<Actor> listActor = dao.getActorsByFilmId(getIDFilm());
        if (listActor.isEmpty()) {
            return allActor;
        }
        for (Actor a : listActor) {
            allActor += a.getActorName() + ", ";
        }
        if (!allActor.isEmpty()) {
            allActor = allActor.substring(0, allActor.length() - 2);
        }
        return allActor;
    }

    public String getGenres() {
        DAO dao = new DAO();
        String genres = "";
        ArrayList<Category> listCate = dao.getAllTagsByFilmID(getIDFilm());
        if (listCate.isEmpty()) {
            return genres;
        }
        genres = listCate.get(0).getCategoryName();
        return genres;
    }

    public String getTags() {
        String allTas = "";
        DAO dao = new DAO();
        ArrayList<Category> listCate = dao.getAllTagsByFilmID(getIDFilm());
        if (listCate.isEmpty()) {
            return allTas;
        }
        for (Category a : listCate) {
            allTas += a.getCategoryName() + ", ";
        }
        if (!allTas.isEmpty()) {
            allTas = allTas.substring(0, allTas.length() - 2);
        }
        return allTas;
    }

    public ArrayList<Film> getFilmSameCategory() {
        DAO dao = new DAO();
        ArrayList<Film> listFilmSameCategory = new ArrayList<>();
        ArrayList<Category> listCate = dao.getAllTagsByFilmID(getIDFilm());
        for (Category cate : listCate) {
            listFilmSameCategory.addAll(dao.getFilmByCategory("3", cate.getCategoryName()));
        }

        return listFilmSameCategory;
    }

    public boolean checkFilmInList(int idList) {
        DAO dao = new DAO();
        if (dao.checkFilmInListByIdListAndIdFilm(idList, IDFilm)) {
            return true;
        } else {
            return false;
        }

    }

    public int getLike() {
        DAO dao = new DAO();
        return dao.getLikeByIdFilm(IDFilm);
    }

    public boolean checkFilmInLike(int idUser) {
        DAO dao = new DAO();
        if (dao.checkFilmLikedByIdUserAndIdFilm(IDFilm, idUser)) {
            return true;
        } else {
            return false;
        }
    }
    
    public int getTotalView(){
        DAO dao = new DAO();
        return dao.getTotalViewByIdFilm(IDFilm);
    }
}
