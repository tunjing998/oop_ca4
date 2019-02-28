/**
 * OOP Feb 2019
 * This App demonstrates the use of a Data Access Object (DAO)
 * to separate Business logic from Database specific logic.
 * It uses DAOs, Data Transfer Objects (DTOs), and
 * a DaoInterface to define a contract between Business Objects
 * and DAOs.
 *
 * "Use a Data Access Object (DAO) to abstract and encapsulate all
 * access to the data source. The DAO manages the connection with
 * the data source to obtain and store data" Ref: oracle.com
 *
 * Here we use one DAO per database table.
 *
 * Use the SQL script included with this project to create the
 * required MySQL user_database and user table
 */
package BusinessObjects;

import DTOs.Movie;
import Daos.MySqlMovieDao;
import Exceptions.DaoException;
import Daos.MovieDaoInterface;
import javax.json.JsonObject;
import java.util.List;
import java.util.Scanner;

public class MainApp
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        MovieDaoInterface IUserDao = new MySqlMovieDao();
        try
        {
            System.out.println("Please input the command in Following Style");
            System.out.println("COMMAND ID VALUE");
            String input = scan.nextLine();
            String command = input.substring(0,input.indexOf(" "));
            String arg = input.substring(input.indexOf(" ")+1);
            switch (command)
            {
                case "FINDBYGENRE":
                    List<Movie> movies = IUserDao.findMoviesGenre(arg);
                    printAll(movies);
            }
        } catch (DaoException e)
        {
        }

    }
    public static <T> void printAll(List<T> object)
    {
        for(T o : object)
        {
            System.out.println(o.toString());
        }
    }
}
