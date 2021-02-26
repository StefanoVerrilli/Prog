package Database;


import Model.ParkModel.Park;
import Model.UserModel.*;


import java.sql.*;
import java.util.ArrayList;


public class GenericDb {

    public static final String JDBC_DRIVER = "org.sqlite.JDBC"; //Inizializzazione dei driver necessari e del collegamento al db
    public static final String DATABASE_URL = "jdbc:sqlite:DB.sqlite";
    private static GenericDb istance = null;

    private void GenericDb() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        Connection conn = this.connect();               //Prima Connessione al db;
        Statement statement = conn.createStatement();
        //Creazione dello statement necessario per effettuare la formattazione della query

        try {
            String sqlCreate = "CREATE TABLE IF NOT EXISTS CLIENT (ID integer," +
                    "PASSWORD varchar(30),NAME varchar(30),SURNAME varchar(30)," +                                     //Creazione Della tabella Utente
                    "MAIL varchar(30),PERSONAL_ID varchar(30),TELEPHONE varchar(30),PRIMARY KEY (ID));";
            statement.execute(sqlCreate);
            String sqlCreate1 = "CREATE TABLE IF NOT EXISTS PARK(ID integer,NAME varchar(30)," +
                    "STREET varchar(30),CAPACITY integer (30),LATITUDE float(5,2),LONGITUDE float(5,2),PRIMARY KEY (ID));";
            statement.execute(sqlCreate1);
            sqlCreate = "CREATE TABLE IF NOT EXISTS CAR(ID varchar(30),CAR_NAME varchar(30)," +
                    "BRAND varchar(30),CAR_PLATE varchar(30),COLOR varchar(30), SEATS integer ,PRIMARY KEY(ID), FOREIGN KEY(ID) REFERENCES PARK(ID)); ";
            statement.execute(sqlCreate);
            /*sqlCreate = "CREATE TABLE IF NOT EXISTS Car(Targa varchar(30),ParkID integer," +
                    "Modello varchar(30),Marca varchar(30),FOREIGN KEY(Modello) REFERENCES CarModel(Modello)" +
                    "PRIMARY KEY (Targa),FOREIGN KEY(ParkID) REFERENCES Park(ParkID))";
            statement.execute(sqlCreate);*/
           /* sqlCreate = "CREATE TABLE IF NOT EXISTS Rent(Targa varchar(30)," +
                    "USERID integer,Orario date, FOREIGN KEY(Targa) REFERENCES CAR(Targa)," +
                    "FOREIGN KEY(USERID) REFERENCES Client(USERID), PRIMARY KEY (Targa,USERID,Orario))";*/
            statement.execute(sqlCreate);
            //sqlCreate = "CREATE TABLE IF NOT EXISTS Carta(Numero)"

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

    }

    public static synchronized GenericDb getIstance() {
        if (istance == null) {
            istance = new GenericDb();
        }

        return istance;
    }

    //Perche' sto main? Ma che minchia ne so il costruttore non fa la creazione
    //della tabella se non faccio chiamare sto main al Main iniziale
    //Penso sia ok cosi' poi boh, funge
    public void main() throws SQLException, ClassNotFoundException {
        GenericDb();

    }


    //Funzione per la connessione al db, richiamata da InsertClient, QueryClient
    //e GetClients. Se ve lo chiedete, si serve
    private Connection connect() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DATABASE_URL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    //Interroga il db fornendo la lista degli utenti presenti sul db
    //Momentaneamente utilizzata solo per funzioni di test ma in futuro
    //Pienamente utilizzabile

    public void getCLients() {
        String sqlSelect = "SELECT * FROM Client;";
        try (Connection conn = this.connect();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlSelect)) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("ID") + resultSet.getString("PASSWORD"));
            }
            conn.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Necessaria per l' inserimento dei client in fase di registrazione
    //Passandogli il tipo di model e il modello concreto provvedera' ad
    //effettuare la query al db

    //To-do: Prendere in input un model non i campi singoli;

    public void insertClients(Client client) throws SQLException {
        String next = GetNext();
        String sqlSelect = " INSERT INTO CLIENT (ID,PASSWORD,MAIL,PERSONAL_ID,NAME,SURNAME,TELEPHONE) VALUES (?,?,?,?,?,?,?);";
        try (Connection conn = this.connect();
             PreparedStatement s = conn.prepareStatement(sqlSelect)) {
            s.setInt(1, Integer.parseInt(next));
            s.setString(2, client.getPassword());
            s.setString(3, client.getEmail());
            s.setString(4, client.getPersonalId());
            s.setString(5, client.getName());
            s.setString(6, client.getSurname());
            s.setString(7, client.getTelephoneNumber());
            client.setId(next);
            if (this.GetEmail(client.getEmail(), conn)) {
                s.executeUpdate();
                client.setState(true);
            } else
                client.setState(false);
            conn.close();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public boolean GetEmail(String mail, Connection conn) {
        Boolean bool = false;
        String sqlSelect = "SELECT COUNT(*) FROM CLIENT WHERE MAIL=?;";
        try {
            PreparedStatement s = conn.prepareStatement(sqlSelect);
            s.setString(1, (mail));
            ResultSet result = s.executeQuery();
            if (result.getInt("COUNT(*)") > 0) {
                return false;
            } else
                return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return false;
    }

    //Necessario per la ricerca di uno specifico utente in fase di login
    //Permette di ricercare nel db un utente che abbia Password e UserId
    //Coincidenti con quelli inseriti nei campi comilabili

    public void loginClient(Client userModel) {
        String sqlSelect = "SELECT PASSWORD,ID,MAIL,PERSONAL_ID,NAME,SURNAME,TELEPHONE FROM Client WHERE ID=? AND Password=?;";
        try {
            Connection conn = this.connect();
            PreparedStatement s = conn.prepareStatement(sqlSelect);
            s.setString(1, (String.valueOf(userModel.getId())));
            s.setString(2, userModel.getPassword());
            ResultSet result = s.executeQuery();

            if (result.next()) {
                userModel.setName(result.getString("NAME"));
                userModel.setEmail(result.getString("MAIL"));
                userModel.setSurname(result.getString("SURNAME"));
                userModel.setPersonalId(result.getString("PERSONAL_ID"));
                userModel.setTelephoneNumber(result.getString("TELEPHONE"));
                userModel.setState(true);
            }
            conn.close();

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public void loginOperator(Operator operatorModel) throws SQLException {
        String sqlSelect = "SELECT * FROM OPERATOR WHERE ID=? AND PASSWORD=?;";
        try {
            Connection conn = this.connect();
            PreparedStatement s = conn.prepareStatement(sqlSelect);
            s.setString(1, operatorModel.getId());
            s.setString(2, operatorModel.getPassword());
            ResultSet result = s.executeQuery();

            if (result.next()) {
                operatorModel.setState(true);
            }
            conn.close();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public void loginAdmin(Admin adminModel) throws SQLException {
        String sqlSelect = "SELECT * FROM ADMIN WHERE ID=? AND PASSWORD=?;";
        try {
            Connection conn = this.connect();
            PreparedStatement s = conn.prepareStatement(sqlSelect);
            s.setString(1, adminModel.getId());
            s.setString(2, adminModel.getPassword());
            ResultSet result = s.executeQuery();

            if (result.next()) {
                adminModel.setState(true);
            }
            conn.close();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public void loginIncidentManager(IncidentManager incidentManager) throws SQLException {
        String sqlSelect = "SELECT * FROM INCIDENT_MANAGER WHERE ID=? AND PASSWORD=?;";
        try {
            Connection conn = this.connect();
            PreparedStatement s = conn.prepareStatement(sqlSelect);
            s.setString(1, incidentManager.getId());
            s.setString(2, incidentManager.getPassword());
            ResultSet result = s.executeQuery();

            if (result.next()) {
                incidentManager.setState(true);
            }
            conn.close();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }


    public String GetNext() {
        String SqlNext = "SELECT max(substring(ID,4,40)) FROM CLIENT;";
        try (Connection conn = this.connect();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(SqlNext)) {
            if (resultSet.getString("max(substring(ID,4,40))") == null) {
                return "3330";
            }
            if (resultSet.next()) {
                Integer result = resultSet.getInt("max(substring(ID,4,40))");
                result++;
                String Convertion = "333" + String.valueOf(result);
                return Convertion;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return "0";
    }

    public ArrayList<Park> getParkings() throws SQLException {
        String sqlPark = "SELECT * FROM PARK;";
        try (Connection conn = this.connect();
             Statement statement = conn.createStatement();
             ResultSet result = statement.executeQuery(sqlPark)) {
            ArrayList<Park> parks = new ArrayList<Park>();
            while (result.next()) {
                Park park = new Park(result.getString("NAME"), result.getInt("ID"), result.getString("STREET"), result.getInt("CAPACITY"),
                        result.getInt("LATITUDE"), result.getInt("LONGITUDE"));
                parks.add(park);
            }
            return parks;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<Park>();
    }


//Ringrazio Francesco Pollastro che mi ha dato l' ispirazione in questa
//fredda notte d'inverno. Firmato Stefano Verrilli 01.38 24 Feb 2021

}