/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Pricing;
import model.User;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import model.Actor;
import model.Category;
import model.Country;
import model.Film;
import model.Order;

/**
 *
 * @author FPT
 */
public class DAO extends DBContext {

//ok
    public boolean checkLogin(String userName, String passWord) {
        String sql = "SELECT TOP (1000) [IdUser]\n"
                + "      ,[Email]\n"
                + "      ,[Gender]\n"
                + "      ,[DateOfBirth]\n"
                + "      ,[Password]\n"
                + "      ,[Name]\n"
                + "      ,[Role]\n"
                + "      ,[Status]\n"
                + "  FROM [Netflix193].[dbo].[User]\n"
                + "  WHERE Email = ? AND Password = ?";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, passWord);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
//ok

    public boolean checkEmailExits(String email) {
        String sql = "select * from [User]\n"
                + "where Email = ?";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
//ok

    public boolean createAccount(String userName, String passWord) {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([Email]\n"
                + "           ,[Gender]\n"
                + "           ,[DateOfBirth]\n"
                + "           ,[Password]\n"
                + "           ,[Name]\n"
                + "           ,[Role]\n"
                + "           ,[Status])\n"
                + "     VALUES\n"
                + "           (?,null,null,?,'User Netflix',1,1)";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, passWord);
            DAO dao = new DAO();
            int rowsAffected;
            if (dao.checkEmailExits(userName)) {
                return false;
            } else {
                rowsAffected = statement.executeUpdate();
            }
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
//ok

    public boolean changePassWord(String email, String newPassWord) {
        String sql = "UPDATE [User]\n"
                + "SET Password = ?\n"
                + "WHERE Email = ?";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, newPassWord);
            statement.setString(2, email);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
//ok

    public ArrayList<Pricing> getAllPricing() {
        ArrayList<Pricing> pricingList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Pricing";
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Pricing pri = new Pricing();
                pri.setPricingID(rs.getInt("ID"));
                pri.setPricingName(rs.getString("Name"));
                pri.setPrice(rs.getInt("Price"));
                pri.setResolution(rs.getString("Resolution"));
                pri.setDescribe(rs.getString("Description"));
                pricingList.add(pri);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return pricingList;
    }
//ok

    public User getUserByEmail(String email) {
        User user = null;
        try {
            String sql = "SELECT TOP (1000) [IdUser]\n"
                    + "      ,[Email]\n"
                    + "      ,[Gender]\n"
                    + "      ,[DateOfBirth]\n"
                    + "      ,[Password]\n"
                    + "      ,[Name]\n"
                    + "      ,[Role]\n"
                    + "      ,[Status]\n"
                    + "  FROM [Netflix193].[dbo].[User]\n"
                    + "  WHERE Email = ?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setIdUser(rs.getInt("IdUser"));
                user.setEmail(rs.getString("Email"));
                user.setName(rs.getString("Name"));
                user.setPassWord(rs.getString("Password"));
                user.setGender(rs.getBoolean("Gender"));
                user.setDateOfBirth(rs.getString("DateOfBirth"));
                user.setRole(rs.getInt("Role"));
                user.setStatus(rs.getBoolean("Status"));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
//ok

    public User getUserByIdUser(int idUser) {
        User user = null;
        try {
            String sql = "SELECT TOP (1000) [IdUser]\n"
                    + "      ,[Email]\n"
                    + "      ,[Gender]\n"
                    + "      ,[DateOfBirth]\n"
                    + "      ,[Password]\n"
                    + "      ,[Name]\n"
                    + "      ,[Role]\n"
                    + "      ,[Status]\n"
                    + "  FROM [Netflix193].[dbo].[User]\n"
                    + "  WHERE IdUser = ?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, idUser);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setIdUser(rs.getInt("IdUser"));
                user.setEmail(rs.getString("Email"));
                user.setName(rs.getString("Name"));
                user.setPassWord(rs.getString("Password"));
                user.setGender(rs.getBoolean("Gender"));
                user.setDateOfBirth(rs.getString("DateOfBirth"));
                user.setRole(rs.getInt("Role"));
                user.setStatus(rs.getBoolean("Status"));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Pricing getPricingById(int PricingID) {
        Pricing pri = null;
        try {
            String sql = "SELECT * FROM Pricing WHERE ID = ?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, PricingID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                pri = new Pricing();
                pri.setPricingID(rs.getInt("ID"));
                pri.setPricingName(rs.getString("Name"));
                pri.setPrice(rs.getInt("Price"));
                pri.setResolution(rs.getString("Resolution"));
                pri.setDescribe(rs.getString("Description"));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pri;
    }
//ok

    public void orderPricing(int idUser, int picingID) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        String sql = "INSERT INTO [dbo].[OrderDetail]\n"
                + "           ([IdCustomer]\n"
                + "           ,[OrderDate]\n"
                + "           ,[ID_Item]\n"
                + "           ,[total_Order])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";

        try {
            DAO dao = new DAO();
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, idUser);
            statement.setString(2, formattedDate);
            statement.setInt(3, picingID);
            statement.setInt(4, dao.getPricingById(picingID).getPrice());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
//ok

    public int getPricingIdByIdUser(int idUser) {
        int pricingID = 0;
        try {
            String sql = "SELECT MAX(o.ID_Item) AS MaxOrderID\n"
                    + "                    FROM [User] u\n"
                    + "                    INNER JOIN [OrderDetail] o ON o.IdCustomer = u.IdUser\n"
                    + "                    WHERE u.IdUser = ?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, idUser);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                pricingID = rs.getInt("MaxOrderID");
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            return pricingID;
        }
        return pricingID;
    }
//ok

    public boolean updateProfile(int idUser, String name, int gender, String dob) {
        String sql = "UPDATE [dbo].[User]\n"
                + "   SET [Gender] = ?\n"
                + "      ,[DateOfBirth] = ?\n"
                + "      ,[Name] = ?\n"
                + " WHERE IdUser = ?";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, gender);
            statement.setString(2, dob);
            statement.setString(3, name);
            statement.setInt(4, idUser);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
//ok

    public Film getFilmById(int IDFilm) {
        Film film = null;
        try {
            String sql = "select f.IDFilm, f.Name, f.Time, f.Year, f.ImgPath, f.MoviePath, f.Age, f.Detail, f.TrailerPath, f.CountryID, c.Name as countryName, f.Status\n"
                    + "from Film f\n"
                    + "inner join Country c on c.IdCountry = f.CountryID\n"
                    + "where f.IDFilm = ? and f.Status = 1";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, IDFilm);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                film = new Film();
                film.setIDFilm(rs.getInt("IDFilm"));
                film.setName(rs.getString("Name"));
                film.setTime(rs.getString("Time"));
                film.setYear(rs.getInt("Year"));
                film.setImgPath(rs.getString("ImgPath"));
                film.setMoviePath(rs.getString("MoviePath"));
                film.setAge(rs.getInt("Age"));
                film.setDetail(rs.getString("Detail"));
                film.setTrailerPath(rs.getString("TrailerPath"));

                Country country = new Country();
                country.setCountryID(rs.getInt("CountryID"));
                country.setName(rs.getString("countryName"));

                film.setCountry(country);
                film.setStatus(rs.getBoolean("Status"));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }
//ok

    public ArrayList<Film> getTopFilmByLike(int top) {
        ArrayList<Film> topFilm = new ArrayList<>();
        try {
            String sql = "SELECT top " + top + " f.IDFilm, f.Name, f.Time, f.Year, f.ImgPath, f.MoviePath, f.Age, f.Detail, f.TrailerPath, f.CountryID, c.Name as countryName, f.Status, count(f.IDFilm) AS totalLike\n"
                    + "from Film f\n"
                    + "inner join Country c on c.IdCountry = f.CountryID\n"
                    + "inner join [LIKE] l on l.IDFilm = f.IDFilm\n"
                    + "where f.Status = 1\n"
                    + "group by f.IDFilm, f.Name, f.Time, f.Year, f.ImgPath, f.MoviePath, f.Age, f.Detail, f.TrailerPath, f.CountryID, c.Name, f.Status\n"
                    + "order by totalLike DESC";
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setIDFilm(rs.getInt("IDFilm"));
                film.setName(rs.getString("Name"));
                film.setTime(rs.getString("Time"));
                film.setYear(rs.getInt("Year"));
                film.setImgPath(rs.getString("ImgPath"));
                film.setMoviePath(rs.getString("MoviePath"));
                film.setAge(rs.getInt("Age"));
                film.setDetail(rs.getString("Detail"));
                film.setTrailerPath(rs.getString("TrailerPath"));

                Country country = new Country();
                country.setCountryID(rs.getInt("CountryID"));
                country.setName(rs.getString("countryName"));

                film.setCountry(country);
                film.setStatus(rs.getBoolean("Status"));
                topFilm.add(film);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topFilm;
    }
//ok

    public ArrayList<Film> getFilmByCountry(String top, String country) {
        ArrayList<Film> listFilmByCountry = new ArrayList<>();
        try {
            String sql = "";
            if (top == null) {
                sql = "SELECT f.IDFilm, f.Name, f.Time, f.Year, f.ImgPath, f.MoviePath, f.Age, f.Detail, f.TrailerPath, f.CountryID, c.Name as countryName, f.Status\n"
                        + "from Film f\n"
                        + "inner join Country c on c.IdCountry = f.CountryID\n"
                        + "where c.Name LIKE '%" + country + "%' and f.Status = 1\n"
                        + "ORDER BY c.Name ASC";
            } else if (Integer.parseInt(top) >= 1) {
                sql = "SELECT top " + top + " f.IDFilm, f.Name, f.Time, f.Year, f.ImgPath, f.MoviePath, f.Age, f.Detail, f.TrailerPath, f.CountryID, c.Name as countryName, f.Status\n"
                        + "from Film f\n"
                        + "inner join Country c on c.IdCountry = f.CountryID\n"
                        + "where c.Name LIKE '%" + country + "%' and f.Status = 1\n"
                        + "ORDER BY c.Name ASC";
            }
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setIDFilm(rs.getInt("IDFilm"));
                film.setName(rs.getString("Name"));
                film.setTime(rs.getString("Time"));
                film.setYear(rs.getInt("Year"));
                film.setImgPath(rs.getString("ImgPath"));
                film.setMoviePath(rs.getString("MoviePath"));
                film.setAge(rs.getInt("Age"));
                film.setDetail(rs.getString("Detail"));
                film.setTrailerPath(rs.getString("TrailerPath"));

                Country coun = new Country();
                coun.setCountryID(rs.getInt("CountryID"));
                coun.setName(rs.getString("countryName"));

                film.setCountry(coun);
                film.setStatus(rs.getBoolean("Status"));
                listFilmByCountry.add(film);
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listFilmByCountry;
    }
//ok

    public ArrayList<Actor> getActorsByFilmId(int IDFilm) {
        ArrayList<Actor> actors = new ArrayList<>();
        try {
            String sql = "Select a.ActorID, a.Name\n"
                    + "from Film f\n"
                    + "inner join FilmActor fa on fa.IDFilm = f.IDFilm\n"
                    + "inner join Actor a on fa.ActorID = a.ActorID\n"
                    + "where f.IDFilm =?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, IDFilm);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Actor actor = new Actor();
                actor.setActorID(rs.getInt("ActorID"));
                actor.setActorName(rs.getString("Name"));
                actors.add(actor);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }
//ok

    public ArrayList<Category> getAllTagsByFilmID(int IDFilm) {
        ArrayList<Category> categoryList = new ArrayList<>();
        try {
            String sql = "select c.CategoryID, c.Name\n"
                    + "from Film f\n"
                    + "inner join FilmCategory fc on fc.IDFilm = f.IDFilm\n"
                    + "inner join Category c on c.CategoryID = fc.CategoryID\n"
                    + "where f.IDFilm = ?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, IDFilm);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category cate = new Category();
                cate.setCategoryID(rs.getInt("CategoryID"));
                cate.setCategoryName(rs.getString("Name"));
                categoryList.add(cate);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }
//ok

    public ArrayList<Film> getFilmByCategory(String top, String categoryName) {
        ArrayList<Film> listFilmByCategory = new ArrayList<>();
        try {
            String sql = "";
            if (top == null) {
                sql = "select f.IDFilm, f.Name, f.Time, f.Year, f.ImgPath, f.MoviePath, f.Age, f.Detail, f.TrailerPath, f.CountryID, cc.Name as countryName, f.Status\n"
                        + "from Film f\n"
                        + "inner join Country cc on cc.IdCountry = f.CountryID\n"
                        + "inner join FilmCategory fc on fc.IDFilm = f.IDFilm\n"
                        + "inner join Category c on c.CategoryID = fc.CategoryID\n"
                        + "where c.Name LIKE '%" + categoryName + "%' and f.Status = 1\n"
                        + "Order by f.Name ASC";
            } else {
                sql = "select top " + top + " f.IDFilm, f.Name, f.Time, f.Year, f.ImgPath, f.MoviePath, f.Age, f.Detail, f.TrailerPath, f.CountryID, cc.Name as countryName, f.Status\n"
                        + "from Film f\n"
                        + "inner join Country cc on cc.IdCountry = f.CountryID\n"
                        + "inner join FilmCategory fc on fc.IDFilm = f.IDFilm\n"
                        + "inner join Category c on c.CategoryID = fc.CategoryID\n"
                        + "where c.Name LIKE '%" + categoryName + "%' and f.Status = 1\n"
                        + "Order by f.Name ASC";

            }
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setIDFilm(rs.getInt("IDFilm"));
                film.setName(rs.getString("Name"));
                film.setTime(rs.getString("Time"));
                film.setYear(rs.getInt("Year"));
                film.setImgPath(rs.getString("ImgPath"));
                film.setMoviePath(rs.getString("MoviePath"));
                film.setAge(rs.getInt("Age"));
                film.setDetail(rs.getString("Detail"));
                film.setTrailerPath(rs.getString("TrailerPath"));

                Country coun = new Country();
                coun.setCountryID(rs.getInt("CountryID"));
                coun.setName(rs.getString("countryName"));

                film.setCountry(coun);
                film.setStatus(rs.getBoolean("Status"));
                listFilmByCategory.add(film);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFilmByCategory;
    }
//ok

    public ArrayList<Film> getFilmByName(String top, String name) {
        ArrayList<Film> listFilmByName = new ArrayList<>();
        try {
            String sql = "";
            if (top == null) {
                sql = "select f.IDFilm, f.Name, f.Time, f.Year, f.ImgPath, f.MoviePath, f.Age, f.Detail, f.TrailerPath, f.CountryID, cc.Name as countryName, f.Status\n"
                        + "from Film f\n"
                        + "inner join Country cc on cc.IdCountry = f.CountryID\n"
                        + "where f.Name LIKE '%" + name + "%' and f.Status = 1\n"
                        + "Order by f.Name ASC";
            } else {
                sql = "select top " + top + " f.IDFilm, f.Name, f.Time, f.Year, f.ImgPath, f.MoviePath, f.Age, f.Detail, f.TrailerPath, f.CountryID, cc.Name as countryName, f.Status\n"
                        + "from Film f\n"
                        + "inner join Country cc on cc.IdCountry = f.CountryID\n"
                        + "where f.Name LIKE '%" + name + "%' and f.Status = 1\n"
                        + "Order by f.Name ASC";
            }
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setIDFilm(rs.getInt("IDFilm"));
                film.setName(rs.getString("Name"));
                film.setTime(rs.getString("Time"));
                film.setYear(rs.getInt("Year"));
                film.setImgPath(rs.getString("ImgPath"));
                film.setMoviePath(rs.getString("MoviePath"));
                film.setAge(rs.getInt("Age"));
                film.setDetail(rs.getString("Detail"));
                film.setTrailerPath(rs.getString("TrailerPath"));

                Country coun = new Country();
                coun.setCountryID(rs.getInt("CountryID"));
                coun.setName(rs.getString("countryName"));

                film.setCountry(coun);
                film.setStatus(rs.getBoolean("Status"));
                listFilmByName.add(film);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFilmByName;
    }
//ok

    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> listCategory = new ArrayList<>();
        try {
            String sql = "select * from Category";
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category cate = new Category();
                cate.setCategoryID(rs.getInt("CategoryID"));
                cate.setCategoryName(rs.getString("Name"));
                listCategory.add(cate);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCategory;
    }

    public void createFavouriteList(int idUser) {
        String sql = "INSERT INTO [dbo].[FavouriteList]\n"
                + "           ([IdUser])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, idUser);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
//ok

    public ArrayList<Film> getListFilmFavourite(int idUser) {
        ArrayList<Film> listFilm = new ArrayList<>();
        try {
            String sql = "select f.IDFilm, f.Name, f.Time, f.Year, f.ImgPath, f.MoviePath, f.Age, f.Detail, f.TrailerPath, f.CountryID, cc.Name as countryName, f.Status\n"
                    + "                   from [User] u\n"
                    + "                   inner join FavouriteList fl on fl.IdUser = u.IdUser\n"
                    + "                   inner join FavouriteFilm ff on ff.ListID = fl.ListID\n"
                    + "                   inner join Film f on f.IDFilm = ff.IDFilm\n"
                    + "                   inner join Country cc on cc.IdCountry = f.CountryID\n"
                    + "                   where u.IdUser = ? and f.Status = 1";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, idUser);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setIDFilm(rs.getInt("IDFilm"));
                film.setName(rs.getString("Name"));
                film.setTime(rs.getString("Time"));
                film.setYear(rs.getInt("Year"));
                film.setImgPath(rs.getString("ImgPath"));
                film.setMoviePath(rs.getString("MoviePath"));
                film.setAge(rs.getInt("Age"));
                film.setDetail(rs.getString("Detail"));
                film.setTrailerPath(rs.getString("TrailerPath"));

                Country coun = new Country();
                coun.setCountryID(rs.getInt("CountryID"));
                coun.setName(rs.getString("countryName"));

                film.setCountry(coun);
                film.setStatus(rs.getBoolean("Status"));
                listFilm.add(film);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFilm;
    }

    public ArrayList<Film> getListFilmLikedByIdUser(int idUser) {
        ArrayList<Film> listFilmLiked = new ArrayList<>();
        try {
            String sql = "select f.IDFilm, f.Name, f.Time, f.Year, f.ImgPath, f.MoviePath, f.Age, f.Detail, f.TrailerPath, f.CountryID, cc.Name as countryName, f.Status, l.IdUser\n"
                    + "from Film f\n"
                    + "inner join Country cc on cc.IdCountry = f.CountryID\n"
                    + "inner join [LIKE] l on l.IDFilm = f.IDFilm\n"
                    + "inner join [User] u on u.IdUser = l.IdUser\n"
                    + "where u.IdUser = ? and f.Status = 1\n"
                    + "group by f.IDFilm, f.Name, f.Time, f.Year, f.ImgPath, f.MoviePath, f.Age, f.Detail, f.TrailerPath, f.CountryID, cc.Name, f.Status, l.IdUser";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, idUser);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setIDFilm(rs.getInt("IDFilm"));
                film.setName(rs.getString("Name"));
                film.setTime(rs.getString("Time"));
                film.setYear(rs.getInt("Year"));
                film.setImgPath(rs.getString("ImgPath"));
                film.setMoviePath(rs.getString("MoviePath"));
                film.setAge(rs.getInt("Age"));
                film.setDetail(rs.getString("Detail"));
                film.setTrailerPath(rs.getString("TrailerPath"));

                Country coun = new Country();
                coun.setCountryID(rs.getInt("CountryID"));
                coun.setName(rs.getString("countryName"));

                film.setCountry(coun);
                film.setStatus(rs.getBoolean("Status"));
                listFilmLiked.add(film);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFilmLiked;
    }

    //ok
    public int getListIdByIdUser(int idUser) {
        String sql = "SELECT ListID FROM FavouriteList WHERE IdUser = ?";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, idUser);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("ListID");
            } else {
                return -1;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
    }

    //ok
    public boolean insertFilmToFavourite(int idList, int FilmID) {
        String sql = "INSERT INTO FavouriteFilm values \n"
                + "(?,?)";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, idList);
            statement.setInt(2, FilmID);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean insertFilmToHistoryWatch(int FilmID, int idUser) {
        String sql;
        DAO dao = new DAO();
        if (dao.exitFilmWatch(FilmID, idUser)) {
            sql = "UPDATE [dbo].[Watch]\n"
                    + "   SET [DateTime] = ?\n"
                    + " WHERE IDFilm = ? and IdUser = ?";
        } else {
            sql = "INSERT INTO [dbo].[Watch]\n"
                    + "           ([IDFilm]\n"
                    + "           ,[IdUser]\n"
                    + "           ,[DateTime])\n"
                    + "     VALUES\n"
                    + "           (?,?,?)";
        }
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            String formattedDateTime = currentDateTime.format(formatter);
            if (dao.exitFilmWatch(FilmID, idUser)) {
                statement.setString(1, formattedDateTime);
                statement.setInt(2, FilmID);
                statement.setInt(3, idUser);
            } else {
                statement.setInt(1, FilmID);
                statement.setInt(2, idUser);
                statement.setString(3, formattedDateTime);
            }
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean exitFilmWatch(int idFilm, int idUser) {
        String sql = "Select * from Watch\n"
                + "where IDFilm = ? and IdUser = ?";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, idFilm);
            statement.setInt(2, idUser);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean addLiketoFilm(int FilmID, int idUser) {
        String sql = "INSERT INTO [dbo].[LIKE]\n"
                + "           ([IDFilm]\n"
                + "           ,[IdUser])\n"
                + "     VALUES\n"
                + "           (?,?)";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, FilmID);
            statement.setInt(2, idUser);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean unLikeFilm(int FilmID, int idUser) {
        String sql = "delete from [LIKE] \n"
                + "where IDFilm = ? and IdUser = ?";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, FilmID);
            statement.setInt(2, idUser);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    //ok
    public boolean deleteFilmToFavourite(int idList, int FilmID) {
        String sql = "delete from FavouriteFilm \n"
                + "where ListID = ? and IDFilm = ?";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, idList);
            statement.setInt(2, FilmID);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    //ok
    public boolean checkFilmInListByIdListAndIdFilm(int idList, int FilmID) {
        String sql = "SELECT * FROM FavouriteFilm WHERE ListID = ? AND IDFilm = ?";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, idList);
            statement.setInt(2, FilmID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkFilmLikedByIdUserAndIdFilm(int FilmID, int idUser) {
        String sql = "select * from [LIKE]\n"
                + "where IDFilm = ? and IdUser = ?";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, FilmID);
            statement.setInt(2, idUser);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //ok
    public int getTotalOder(String star, String end) {
        String sql;
        try {
            if (star == null && end == null) {
                sql = "SELECT count(OrderID) AS TotalOrders\n"
                        + "FROM [OrderDetail] o\n"
                        + "inner join Pricing p on p.ID = o.ID_Item";
            } else {
                sql = "SELECT count(OrderID) AS TotalOrders\n"
                        + "FROM [OrderDetail] o\n"
                        + "inner join Pricing p on p.ID = o.ID_Item\n"
                        + "where o.OrderDate >= ? and o.OrderDate <= ?";
            }
            PreparedStatement statement = connect.prepareStatement(sql);

            if (star != null && end != null) {
                statement.setString(1, star);
                statement.setString(2, end);
            }

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("TotalOrders");
            } else {
                return -1;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
    }

    //ok
    public int getTotalSale(String star, String end) {
        String sql;
        try {
            if (star == null && end == null) {
                sql = "SELECT Sum(p.Price) AS TotalSales\n"
                        + "from [OrderDetail] o\n"
                        + "inner join Pricing p on p.ID = o.ID_Item";
            } else {
                sql = "SELECT Sum(p.Price) AS TotalSales\n"
                        + "from [OrderDetail] o\n"
                        + "inner join Pricing p on p.ID = o.ID_Item\n"
                        + "where o.OrderDate >= ? and o.OrderDate <= ?";
            }

            PreparedStatement statement = connect.prepareStatement(sql);

            if (star != null && end != null) {
                statement.setString(1, star);
                statement.setString(2, end);
            }

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("TotalSales");
            } else {
                return -1;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
    }

    //ok
    public ArrayList<Order> getListOrder(int top) {
        ArrayList<Order> listOrder = new ArrayList<>();
        try {
            String sql = "select top " + top + " o.OrderID, u.Email, o.OrderDate, p.Name, o.total_Order\n"
                    + "from [OrderDetail] o\n"
                    + "inner join Pricing p on p.ID = o.ID_Item\n"
                    + "inner join [User] u on u.IdUser = o.IdCustomer\n"
                    + "ORder by o.OrderDate DESC";
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order ord = new Order();
                ord.setOrderID(rs.getInt("OrderID"));
                ord.setEmailCustomer(rs.getString("Email"));
                ord.setDate(rs.getString("OrderDate"));
                ord.setNamePricing(rs.getString("Name"));
                ord.setTotalOrder(rs.getInt("total_Order"));
                listOrder.add(ord);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOrder;
    }

    //ok
    public ArrayList<Order> getListOrderByEmail(String email) {
        ArrayList<Order> listOrder = new ArrayList<>();
        try {
            String sql = "select  o.OrderID, u.Email, o.OrderDate, p.Name, o.total_Order\n"
                    + "from [OrderDetail] o\n"
                    + "inner join Pricing p on p.ID = o.ID_Item\n"
                    + "inner join [User] u on u.IdUser = o.IdCustomer\n"
                    + "where u.Email LIKE '%" + email + "%'\n"
                    + "ORder by o.OrderDate DESC";
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order ord = new Order();
                ord.setOrderID(rs.getInt("OrderID"));
                ord.setEmailCustomer(rs.getString("Email"));
                ord.setDate(rs.getString("OrderDate"));
                ord.setNamePricing(rs.getString("Name"));
                ord.setTotalOrder(rs.getInt("total_Order"));
                listOrder.add(ord);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOrder;
    }

    //ok
    public ArrayList<Film> getAllFilm(String top) {
        ArrayList<Film> listFilm = new ArrayList<>();
        try {
            String sql = "";
            if (top == null) {
                sql = "SELECT f.IDFilm, f.Name, f.Time, f.Year, f.ImgPath, f.MoviePath, f.Age, f.Detail, f.TrailerPath, f.CountryID, cc.Name as countryName, f.Status\n"
                        + "FROM Film f\n"
                        + "inner join Country cc on cc.IdCountry = f.CountryID";
            } else {
                sql = "SELECT top " + top + " f.IDFilm, f.Name, f.Time, f.Year, f.ImgPath, f.MoviePath, f.Age, f.Detail, f.TrailerPath, f.CountryID, cc.Name as countryName, f.Status\n"
                        + "FROM Film f\n"
                        + "inner join Country cc on cc.IdCountry = f.CountryID";
            }
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setIDFilm(rs.getInt("IDFilm"));
                film.setName(rs.getString("Name"));
                film.setTime(rs.getString("Time"));
                film.setYear(rs.getInt("Year"));
                film.setImgPath(rs.getString("ImgPath"));
                film.setMoviePath(rs.getString("MoviePath"));
                film.setAge(rs.getInt("Age"));
                film.setDetail(rs.getString("Detail"));
                film.setTrailerPath(rs.getString("TrailerPath"));

                Country country = new Country();
                country.setCountryID(rs.getInt("CountryID"));
                country.setName(rs.getString("countryName"));

                film.setCountry(country);
                film.setStatus(rs.getBoolean("Status"));
                listFilm.add(film);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFilm;
    }

    public int getLikeByIdFilm(int idFilm) {
        int totalLike = 0;
        try {
            String sql = "SELECT  f.IDFilm, count(f.IDFilm) AS totalLike\n"
                    + "from Film f\n"
                    + "inner join Country c on c.IdCountry = f.CountryID\n"
                    + "inner join [LIKE] l on l.IDFilm = f.IDFilm\n"
                    + "where f.IDFilm = ?\n"
                    + "group by f.IDFilm";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, idFilm);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                totalLike = rs.getInt("totalLike");
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            return totalLike;
        }
        return totalLike;
    }

    public int getTotalViewByIdFilm(int idFilm) {
        int totalView = 0;
        try {
            String sql = "select count(IDFilm) AS TotalView\n"
                    + "from Watch\n"
                    + "where IDFilm = ?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, idFilm);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                totalView = rs.getInt("TotalView");
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            return totalView;
        }
        return totalView;
    }

    public int maxIdFilm() {
        int maxId = 1;
        try {
            String sql = "select max(IDFilm) as MaxIdFilm\n"
                    + "from Film";
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                maxId = rs.getInt("MaxIdFilm");
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            return maxId;
        }
        return maxId;
    }

    public ArrayList<Film> getHistoryFilm(int idUser) {
        ArrayList<Film> listHistory = new ArrayList<>();
        try {
            String sql = "select f.IDFilm, f.Name, f.Time, f.Year, f.ImgPath, f.MoviePath, f.Age, f.Detail, f.TrailerPath, f.CountryID, c.Name as countryName, f.Status, w.DateTime\n"
                    + "from Film f\n"
                    + "inner join Country c on c.IdCountry = f.CountryID\n"
                    + "inner join Watch w on w.IDFilm = f.IDFilm\n"
                    + "inner join [User] u on u.IdUser = w.IdUser\n"
                    + "where u.IdUser = ?\n"
                    + "order by w.DateTime DESC";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, idUser);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setIDFilm(rs.getInt("IDFilm"));
                film.setName(rs.getString("Name"));
                film.setTime(rs.getString("Time"));
                film.setYear(rs.getInt("Year"));
                film.setImgPath(rs.getString("ImgPath"));
                film.setMoviePath(rs.getString("MoviePath"));
                film.setAge(rs.getInt("Age"));
                film.setDetail(rs.getString("Detail"));
                film.setTrailerPath(rs.getString("TrailerPath"));

                Country coun = new Country();
                coun.setCountryID(rs.getInt("CountryID"));
                coun.setName(rs.getString("countryName"));

                film.setCountry(coun);
                film.setStatus(rs.getBoolean("Status"));
                listHistory.add(film);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHistory;
    }

    //ok
    public ArrayList<Country> getAllCountry() {
        ArrayList<Country> listCountry = new ArrayList<>();
        try {
            String sql = "select * from Country";
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Country country = new Country();
                country.setCountryID(rs.getInt("IdCountry"));
                country.setName(rs.getString("Name"));
                listCountry.add(country);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCountry;
    }

    public boolean addFilm(Film newFilm) {
        String sql = "INSERT INTO [dbo].[Film]\n"
                + "           ([Name]\n"
                + "           ,[Time]\n"
                + "           ,[Year]\n"
                + "           ,[ImgPath]\n"
                + "           ,[MoviePath]\n"
                + "           ,[Age]\n"
                + "           ,[Detail]\n"
                + "           ,[TrailerPath]\n"
                + "           ,[CountryID]\n"
                + "           ,[Status])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, newFilm.getName());
            statement.setString(2, newFilm.getTime());
            statement.setInt(3, newFilm.getYear());
            statement.setString(4, newFilm.getImgPath());
            statement.setString(5, newFilm.getMoviePath());
            statement.setInt(6, newFilm.getAge());
            statement.setString(7, newFilm.getDetail());
            statement.setString(8, newFilm.getTrailerPath());
            statement.setInt(9, newFilm.getCountry().getCountryID());
            statement.setInt(10, 1);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateFilm(Film newFilm, int idFilm) {
        String sql = "UPDATE [dbo].[Film]\n"
                + "   SET [Name] = ?\n"
                + "      ,[Time] = ?\n"
                + "      ,[Year] = ?\n"
                + "      ,[ImgPath] = ?\n"
                + "      ,[MoviePath] = ?\n"
                + "      ,[Age] = ?\n"
                + "      ,[Detail] = ?\n"
                + "      ,[TrailerPath] = ?\n"
                + "      ,[CountryID] = ?\n"
                + "      ,[Status] = ?\n"
                + " WHERE IDFilm = ?";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, newFilm.getName());
            statement.setString(2, newFilm.getTime());
            statement.setInt(3, newFilm.getYear());
            statement.setString(4, newFilm.getImgPath());
            statement.setString(5, newFilm.getMoviePath());
            statement.setInt(6, newFilm.getAge());
            statement.setString(7, newFilm.getDetail());
            statement.setString(8, newFilm.getTrailerPath());
            statement.setInt(9, newFilm.getCountry().getCountryID());
            statement.setInt(10, 1);
            statement.setInt(11, idFilm);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean createAccountAdmin(String userName, String passWord) {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([Email]\n"
                + "           ,[Gender]\n"
                + "           ,[DateOfBirth]\n"
                + "           ,[Password]\n"
                + "           ,[Name]\n"
                + "           ,[Role]\n"
                + "           ,[Status])\n"
                + "     VALUES\n"
                + "           (?,null,null,?,'Admin Netflix',2,1)";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, passWord);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    //ok
    public ArrayList<User> getListUser(int top) {
        ArrayList<User> listUser = new ArrayList<>();
        try {
            String sql = "SELECT top " + top + " [IdUser]\n"
                    + "      ,[Email]\n"
                    + "      ,[Gender]\n"
                    + "      ,[DateOfBirth]\n"
                    + "      ,[Password]\n"
                    + "      ,[Name]\n"
                    + "      ,[Role]\n"
                    + "      ,[Status]\n"
                    + "  FROM [dbo].[User]\n";
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getInt("IdUser"));
                user.setEmail(rs.getString("Email"));
                user.setName(rs.getString("Name"));
                user.setPassWord(rs.getString("Password"));
                user.setGender(rs.getBoolean("Gender"));
                user.setDateOfBirth(rs.getString("DateOfBirth"));
                user.setRole(rs.getInt("Role"));
                user.setStatus(rs.getBoolean("Status"));
                listUser.add(user);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUser;
    }

    //ok
    public ArrayList<User> getListUserByName(String name) {
        ArrayList<User> listUser = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [dbo].[User]\n"
                    + "where Email LIKE '%" + name + "%'\n";
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getInt("IdUser"));
                user.setEmail(rs.getString("Email"));
                user.setName(rs.getString("Name"));
                user.setPassWord(rs.getString("Password"));
                user.setGender(rs.getBoolean("Gender"));
                user.setDateOfBirth(rs.getString("DateOfBirth"));
                user.setRole(rs.getInt("Role"));
                user.setStatus(rs.getBoolean("Status"));
                listUser.add(user);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUser;
    }

    public void changeStatusUser(int status, int idUser) {
        String sql = "UPDATE [dbo].[User]\n"
                + "   SET [Status] = ?\n"
                + " WHERE IdUser = ?";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, status);
            statement.setInt(2, idUser);
            ResultSet rs = statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int totalAdmin() {
        String sql = "select count(IdUser) as TotalAdmin\n"
                + "from [User]\n"
                + "where [Role] = 2";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("TotalAdmin");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }

    }

    public boolean changeStatusFilm(int status, int idFIlm) {
        String sql = "UPDATE [dbo].[Film]\n"
                + "SET [Status] = ?\n"
                + "WHERE IDFilm = ?";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, status);
            statement.setInt(2, idFIlm);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updatePricing(String name, int price, String res, String des) {
        String sql = "UPDATE [dbo].[Pricing]\n"
                + "   SET [Name] = ?\n"
                + "      ,[Price] = ?\n"
                + "      ,[Resolution] = ?\n"
                + "      ,[Description] = ?\n"
                + " WHERE ID = 4";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, price);
            statement.setString(3, res);
            statement.setString(4, des);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public Film getFilmByIdAllStatus(int IDFilm) {
        Film film = null;
        try {
            String sql = "select f.IDFilm, f.Name, f.Time, f.Year, f.ImgPath, f.MoviePath, f.Age, f.Detail, f.TrailerPath, f.CountryID, c.Name as countryName, f.Status\n"
                    + "from Film f\n"
                    + "inner join Country c on c.IdCountry = f.CountryID\n"
                    + "where f.IDFilm = ?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, IDFilm);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                film = new Film();
                film.setIDFilm(rs.getInt("IDFilm"));
                film.setName(rs.getString("Name"));
                film.setTime(rs.getString("Time"));
                film.setYear(rs.getInt("Year"));
                film.setImgPath(rs.getString("ImgPath"));
                film.setMoviePath(rs.getString("MoviePath"));
                film.setAge(rs.getInt("Age"));
                film.setDetail(rs.getString("Detail"));
                film.setTrailerPath(rs.getString("TrailerPath"));

                Country country = new Country();
                country.setCountryID(rs.getInt("CountryID"));
                country.setName(rs.getString("countryName"));

                film.setCountry(country);
                film.setStatus(rs.getBoolean("Status"));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        Data data = new Data();
        System.out.println(dao.checkLogin("123", "123"));
    }
}
