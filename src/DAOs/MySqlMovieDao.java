/**
 * Feb 2019
 *
 * Data Access Object (DAO) for User table with MySQL-specific code
 * This 'concrete' class implements the 'UserDaoInterface'.
 *
 * The DAO will contain the SQL query code to interact with the database,
 * so, the code here is specific to a particular database (e.g. MySQL or Oracle etc...)
 * No SQL queries will be used in the Business logic layer of code, thus, it
 * will be independent of the database specifics.
 *
 */
package Daos;

import DTOs.Movie;
import Exceptions.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlMovieDao extends MySqlDao implements MovieDaoInterface
{

    @Override
    public List<Movie> findAllMovies() throws DaoException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Movie> users = new ArrayList<>();

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM movies";
            ps = con.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("ID");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String director = rs.getString("director");
                String runtime = rs.getString("runtime");
                String plot = rs.getString("plot");
                String rating = rs.getString("rating");
                String format = rs.getString("format");
                int year = rs.getInt("year");
                String starring = rs.getString("starring");
                String barcode = rs.getString("barcode");
                String user_rating = rs.getString("user_rating");
                Movie u = new Movie(id, title, genre, director, runtime, plot, rating, format, year, starring, barcode, user_rating);

                users.add(u);

            }
        } catch (SQLException e)
        {
            throw new DaoException("findAllMovies() " + e.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllMovies() " + e.getMessage());
            }
        }
        return users;     // may be empty
    }

    @Override
    public Movie getMovieByName(String name) throws DaoException
    {
        Movie m = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

//            String query = "SELECT id,title FROM movies";
//            ps = con.prepareStatement(query);
//            int id = 0;
//            //Using a PreparedStatement to execute SQL...
//            rs = ps.executeQuery();
//            while (rs.next())
//            {
//                String title = rs.getString("title");
//
//                if (title.equals(name))
//                {
//                    id = rs.getInt("ID");
//                }
//
//            }
            String query = "SELECT * FROM movies WHERE title=" + name;
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String director = rs.getString("director");
                String runtime = rs.getString("runtime");
                String plot = rs.getString("plot");
                String rating = rs.getString("rating");
                String format = rs.getString("format");
                int year = rs.getInt("year");
                String starring = rs.getString("starring");
                String barcode = rs.getString("barcode");
                String user_rating = rs.getString("user_rating");
                m = new Movie(id, title, genre, director, runtime, plot, rating, format, year, starring, barcode, user_rating);

            }
        } catch (SQLException e)
        {
            throw new DaoException("getMovieByName() " + e.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllMovies() " + e.getMessage());
            }
        }
        return m;
    }

    @Override
    public List<Movie> findMoviesGenre(String tgenre) throws DaoException
    {
        Movie m = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Movie> toReturn = new ArrayList<>();
        String[] genreFind = tgenre.split(" ");
        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();
            String condition = "";
            for (int i = 0; i < genreFind.length; i++)
            {
                condition = condition +"`genre` LIKE '%" + genreFind[i] + "%'";
                if (i < genreFind.length - 1)
                {
                    condition += " AND ";
                }

            }
            String query = "SELECT * FROM `movies` WHERE " + condition + "";
            ps = con.prepareStatement(query);
            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next())
            {

                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String director = rs.getString("director");
                String runtime = rs.getString("runtime");
                String plot = rs.getString("plot");
                String rating = rs.getString("rating");
                String format = rs.getString("format");
                int year = rs.getInt("year");
                String starring = rs.getString("starring");
                String barcode = rs.getString("barcode");
                String user_rating = rs.getString("user_rating");
                m = new Movie(id, title, genre, director, runtime, plot, rating, format, year, starring, barcode, user_rating);
                toReturn.add(m);

            }

        } catch (SQLException e)
        {
            throw new DaoException("getMovieByGenre() " + e.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllMovies() " + e.getMessage());
            }
        }
        return toReturn;
    }

    @Override
    public List<Movie> getMovieByDirector(String name) throws DaoException
    {
        Movie m = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Movie> toReturn = new ArrayList<>();
        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM `movies` WHERE `director` LIKE '%" + name + "%'";
            ps = con.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next())
            {

                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String director = rs.getString("director");
                String runtime = rs.getString("runtime");
                String plot = rs.getString("plot");
                String rating = rs.getString("rating");
                String format = rs.getString("format");
                int year = rs.getInt("year");
                String starring = rs.getString("starring");
                String barcode = rs.getString("barcode");
                String user_rating = rs.getString("user_rating");
                m = new Movie(id, title, genre, director, runtime, plot, rating, format, year, starring, barcode, user_rating);
                toReturn.add(m);

            }

        } catch (SQLException e)
        {
            throw new DaoException("getMovieByGenre() " + e.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllMovies() " + e.getMessage());
            }
        }
        return toReturn;
    }

    @Override
    public List<Movie> getMovieByUserRating(double user_ratingg) throws DaoException
    {
        ArrayList<Movie> toReturn = new ArrayList<>();
        Movie m = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Integer> idList = new ArrayList<>();
        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "SELECT id,rating FROM movies";
            ps = con.prepareStatement(query);
            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next())
            {
                String rating = rs.getString("rating");
                if (!rating.equals("null") && !rating.equals("N/A"))
                {
                    double ratingDouble = Double.valueOf(rating);
                    if (ratingDouble > user_ratingg)
                    {
                        idList.add(rs.getInt("id"));
                    }
                }

            }
            for (int i : idList)
            {
                query = "SELECT * FROM movies WHERE id=" + i;
                ps = con.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String genre = rs.getString("genre");
                    String director = rs.getString("director");
                    String runtime = rs.getString("runtime");
                    String plot = rs.getString("plot");
                    String rating = rs.getString("rating");
                    String format = rs.getString("format");
                    int year = rs.getInt("year");
                    String starring = rs.getString("starring");
                    String barcode = rs.getString("barcode");
                    String user_rating = rs.getString("user_rating");
                    m = new Movie(id, title, genre, director, runtime, plot, rating, format, year, starring, barcode, user_rating);

                }
                toReturn.add(m);
            }
        } catch (SQLException e)
        {
            throw new DaoException("getMovieByName() " + e.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllMovies() " + e.getMessage());
            }
        }
        return toReturn;
    }

    @Override
    public Movie getMovieByBarCode(String barcodee) throws DaoException
    {
        Movie m = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {

            con = this.getConnection();
            String query = "SELECT * FROM movies WHERE barcode=" + barcodee;
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String director = rs.getString("director");
                String runtime = rs.getString("runtime");
                String plot = rs.getString("plot");
                String rating = rs.getString("rating");
                String format = rs.getString("format");
                int year = rs.getInt("year");
                String starring = rs.getString("starring");
                String barcode = rs.getString("barcode");
                String user_rating = rs.getString("user_rating");
                m = new Movie(id, title, genre, director, runtime, plot, rating, format, year, starring, barcode, user_rating);

            }
        } catch (SQLException e)
        {
            throw new DaoException("getMovieByName() " + e.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllMovies() " + e.getMessage());
            }
        }
        return m;
    }

    @Override
    public Movie getMovieById(int idd) throws DaoException
    {
        Movie m = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM movies WHERE id=" + idd;
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String director = rs.getString("director");
                String runtime = rs.getString("runtime");
                String plot = rs.getString("plot");
                String rating = rs.getString("rating");
                String format = rs.getString("format");
                int year = rs.getInt("year");
                String starring = rs.getString("starring");
                String barcode = rs.getString("barcode");
                String user_rating = rs.getString("user_rating");
                m = new Movie(id, title, genre, director, runtime, plot, rating, format, year, starring, barcode, user_rating);

            }
        } catch (SQLException e)
        {
            throw new DaoException("getMovieByName() " + e.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllMovies() " + e.getMessage());
            }
        }
        return m;
    }

    @Override
    public List<Movie> getMovieByStarring(String starringg) throws DaoException
    {
        Movie m = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Movie> toReturn = new ArrayList<>();
        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM `movies` WHERE `genre` LIKE '%" + starringg + "%'";
            ps = con.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next())
            {

                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String director = rs.getString("director");
                String runtime = rs.getString("runtime");
                String plot = rs.getString("plot");
                String rating = rs.getString("rating");
                String format = rs.getString("format");
                int year = rs.getInt("year");
                String starring = rs.getString("starring");
                String barcode = rs.getString("barcode");
                String user_rating = rs.getString("user_rating");
                m = new Movie(id, title, genre, director, runtime, plot, rating, format, year, starring, barcode, user_rating);
                toReturn.add(m);

            }

        } catch (SQLException e)
        {
            throw new DaoException("getMovieByGenre() " + e.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllMovies() " + e.getMessage());
            }
        }
        return toReturn;
    }

    @Override
    public List<Movie> getMovieByRunTime(int runtimee) throws DaoException
    {
        ArrayList<Movie> toReturn = new ArrayList<>();
        Movie m = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Integer> idList = new ArrayList<>();
        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "SELECT id,rating FROM movies";
            ps = con.prepareStatement(query);
            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next())
            {
                String runtimeToCheck = rs.getString("runtime");

                int runtimeFind = Integer.valueOf(runtimeToCheck.replace(" min", ""));
                if (runtimeFind > runtimee)
                {
                    idList.add(rs.getInt("id"));
                }

            }
            for (int i : idList)
            {
                query = "SELECT * FROM movies WHERE id=" + i;
                ps = con.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String genre = rs.getString("genre");
                    String director = rs.getString("director");
                    String runtime = rs.getString("runtime");
                    String plot = rs.getString("plot");
                    String rating = rs.getString("rating");
                    String format = rs.getString("format");
                    int year = rs.getInt("year");
                    String starring = rs.getString("starring");
                    String barcode = rs.getString("barcode");
                    String user_rating = rs.getString("user_rating");
                    m = new Movie(id, title, genre, director, runtime, plot, rating, format, year, starring, barcode, user_rating);

                }
                toReturn.add(m);
            }
        } catch (SQLException e)
        {
            throw new DaoException("getMovieByName() " + e.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllMovies() " + e.getMessage());
            }
        }
        return toReturn;
    }

    @Override
    public List<Movie> getMovieByRating(String ratingg) throws DaoException
    {
        List<Movie> toReturn = new ArrayList<>();
        Movie m = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {

            con = this.getConnection();
            String query = "SELECT * FROM movies WHERE rating=" + ratingg;
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String director = rs.getString("director");
                String runtime = rs.getString("runtime");
                String plot = rs.getString("plot");
                String rating = rs.getString("rating");
                String format = rs.getString("format");
                int year = rs.getInt("year");
                String starring = rs.getString("starring");
                String barcode = rs.getString("barcode");
                String user_rating = rs.getString("user_rating");
                m = new Movie(id, title, genre, director, runtime, plot, rating, format, year, starring, barcode, user_rating);

            }
            toReturn.add(m);
        } catch (SQLException e)
        {
            throw new DaoException("getMovieByName() " + e.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllMovies() " + e.getMessage());
            }
        }
        return toReturn;
    }

    @Override
    public boolean addMovie()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateMovie(int id, String field, String value)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteMovie(int id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
