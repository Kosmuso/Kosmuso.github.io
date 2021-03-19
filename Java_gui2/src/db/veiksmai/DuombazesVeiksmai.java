package db.veiksmai;

import db.entities.Vartotojas;

import java.sql.*;

public class DuombazesVeiksmai
{
    public static Connection sukurtiDuombaze() throws SQLException
    {
        String dbServeris = "jdbc:mysql://localhost:3306/";
        String dbPav = "gui_app_db";
        String dbLogin = "root";
        String dbPsw = "";
        return DriverManager.getConnection(dbServeris + dbPav, dbLogin, dbPsw);
    }


    public static int palygintiVartDuomenis (Connection jungtis, Vartotojas v1) throws SQLException
    {
        String sqlRastiVart = "SELECT * FROM vartotojai WHERE login=?";

        PreparedStatement prepSt = jungtis.prepareStatement(sqlRastiVart);
        prepSt.setString(1, v1.getLogin());
        ResultSet gautiVartotojai = prepSt.executeQuery();

        int kiekVartotoju = 0;
        Vartotojas v2 = new Vartotojas();
        while (gautiVartotojai.next())
        {
            v2.setLogin(gautiVartotojai.getString("login"));
            v2.setPsw(gautiVartotojai.getString("psw"));
            kiekVartotoju++;

        }

        if (kiekVartotoju > 0)
        {
            if (v2.getPsw().equals(v1.getPsw()))
            {
                System.out.println("Prisijungeme");
                return 1;
            }
            else
            {
                System.out.println("netinka psw");
                return 3;
            }
        }
        else
        {
            System.out.println("nera tokio vartotojo");
            return 2;
        }
    }

    public static void sukurtiNaujaVart (Connection jungtis, Vartotojas v1) throws SQLException
    {
        String sqlIdetiNaujaVart = "INSERT INTO vartotojai (login, psw) VALUES (?, ?)";

        PreparedStatement prepSt = jungtis.prepareStatement(sqlIdetiNaujaVart);
        prepSt.setString(1, v1.getLogin());
        prepSt.setString(2, v1.getPsw());

        prepSt.executeUpdate();
    }

}
