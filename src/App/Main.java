package App;

import DAO.ExerciseDAO;
import DAO.GoalsDAO;
import DAO.UserDao;
import Entity.Exercise;
import Entity.Goals;
import Entity.User;
import Entity.Usergroup;
import Services.DbService;
import Services.DbServicePFP;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Main.currentUser = currentUser;
    }

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        /// TODO: 09.08.19 dodać do repozytorium gita,
        // TODO: 09.08.19 exerciseManagement
        // TODO: 09.08.19 zrobić początek z informowaniem o konieczności dodania celów, pomyśleć nad zadaniami specjalnymi
        // TODO: 09.08.19 uruchomić i pokazać dzieciom pierwszą działającą wersję
        // TODO: 09.08.19 zaopatrzyć wyjątki: gdy złe hasło itp


      //  System.out.println(ExerciseManagement.goalExistsInDb(9));
        //feftchUser();
        //  UserGroupManagement.addNewGroup();
//
//        Usergroup byId = UserGroupManagement.getById(5);
//        System.out.println(byId);
//
//        Usergroup byName = UserGroupManagement.getByName("USEr");
//        System.out.println(byName);

        // UserManagement.addToDb();

//        User currentUser = feftchUser();
//
//        System.out.println("ZALOGOWANY JAKO: " + "\n"  + currentUser);

//        User kot = UserDao.getByPassword("kot");
//
//        kot.setUser_points(73);
//
//        kot.setName("zosiaczek");
//
//        UserDao.updateInDb(kot);

//        String cel = "mój cel to mindstorm. Chcę go dostać bo jest super i będzie mi się nim fajnie budowało".trim();
//
//        System.out.println(cel.length());
//
//      GoalsManagement.addToDb();

        //GoalsManagement.addColumn();
//        System.out.println(UserDao.getByPassword("kot"));
//        System.out.println(UserDao.getById(1));
//        System.out.println();
//        List<User> allUsers = UserDao.getAllUsers();
//        for(User u: allUsers){
//            System.out.println(u);
//        }

//        String qu = "select * from goals;";
//
//        List<String[]> data = null;
//        try {
//            data = DbService.getData(qu, null,"prize_for_points");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println("DATA +"  +data.size());
//        for(String[] s: data){
//            System.out.println(Arrays.toString(s));
//        }

//        while (true){
//            System.out.println("PRAWDA");
//        }


//        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
////
//        User userId1 = UserDao.getById(1);  //pobieramy usera
//
//     // UserManagement.updateInDb();
//        UserManagement.addToDb(0,0);

        // Goals goal1 = new Goals();

//        List<User> allUsers = UserDao.getAllUsers();
//        for(User u : allUsers){
//            System.out.println(u);
//        }

        // UserManagement.modifyColumn();

        //  UserManagement.addToDb(0,0);

//        Goals byId = GoalsDAO.getById(1);
//        System.out.println(byId);

//        List<Goals> allGoals = GoalsDAO.getAllGoals();
//        for (Goals g : allGoals) {
//            System.out.println(g);
//        }


//        User userId2 = UserDao.getById(1);
//        User userId3 = UserDao.getById(2);
//
//        //System.out.println(userId1);
//
//        Exercise ex1 = new Exercise();
//        ex1.setDescription("zadanie z dodaniem punktów 10 ");
//        ex1.setCreated(date);
//        ex1.setSpecial(0);
//        ex1.setSpecial_id(3);
//        ex1.setExe_points(10);
//        ex1.setUser(userId1);
//
//
//
//
//        ExerciseDAO exDAO = new ExerciseDAO();
//
//        exDAO.setCurrentUser(ex1,userId1);
//
//        System.out.println("CURRENT USER: " + exDAO.getCurrentUser());

        User user = feftchUser();
        setCurrentUser(user);                       //ustawia currentUser w tych klasach
        ExerciseManagement.setCurrentUser(user);


        // String stringTest ="         X        ZALOGOWANY JAKO " + user.getName() + "       X";
        String stringTest = "         X        ZALOGOWANY JAKO " + user.getName() + " AKTUALNA LICZBA PUNKTÓW " + user.getUser_points() + "       X";

        // System.out.println("         X        AKTUALNA LICZBA PUNKTÓW " + user.getUser_points() + " XX");
        //  System.out.println("         X        AKTUALNA LICZBA PUNKTÓW " + user.getUser_points() + " XX" + "\n" +
        //                   "         X");


        String str = "         X";
        for (int i = 0; i < stringTest.length() - 10; i++) {
            str += "X";
        }
        System.out.println(str);
        str = "         X";

        System.out.println(stringTest);
        for (int i = 0; i < stringTest.length() - 10; i++) {
            str += "X";
        }
        System.out.println(str);
//        System.out.println();
//        String stringTest2 ="         X        AKTUALNA LICZBA PUNKTÓW " + user.getUser_points() + "       X";
//
//        String str2 = "         X";
//        for (int i = 0; i < stringTest2.length()-10; i++) {
//            str2 += "X";
//        }
//        System.out.println(str2);
//        str2 = "         X";
//
//        System.out.println(stringTest2);
//        for (int i = 0; i < stringTest2.length()-10; i++) {
//            str2 += "X";
//        }
//        System.out.println(str2);

        //checkGoals();
        System.out.println();
        mainMenu();


    }

    /**
     * Pobiera użytkownika na podstawie hasła
     **/
    public static User feftchUser() {

        System.out.println("         XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("         X        PODAJ HASŁO        X");
        System.out.println("         XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        String password = scan.nextLine().trim();

        return UserDao.getByPassword(password);

    }


    public static void mainMenu() {
        /**Wyświetla napis menu **/
        String stringTest = "         X        GŁÓWNE MENU       X";

        String str = "         X";
        for (int i = 0; i < stringTest.length() - 10; i++) {
            str += "X";
        }
        System.out.println(str);
        str = "         X";

        System.out.println(stringTest);
        for (int i = 0; i < stringTest.length() - 10; i++) {
            str += "X";
        }
        System.out.println(str);
        System.out.println();
        /** **********************/


        int answer;

        do {

            System.out.println("        Jakie działanie chcesz wykonać ?");
            System.out.println();
            System.out.println("Wciśnij 1 aby dodać nowe zadanie");
            System.out.println("Wciśnij 2 aby dodać nowy cel");
            System.out.println("Wciśnij 3 aby zobaczyć swoje zadania");
            System.out.println("Wciśnij 4 aby zobaczyć swoje cele");
            System.out.println("Wciśnij 0 aby wyjść z programu");

            while (!scan.hasNext()) {
                scan.next();
                System.out.println("Wprowadź tylko cyfry w podanym zakresie");
            }

            answer = scan.nextInt();
            scan.nextLine();
            if (answer != 1 && answer != 2 && answer != 3 && answer != 4) {
                System.out.println("Wprowadź tylko cyfry w podanym zakresie");
            }
            switch (answer) {
                case 1:
                    addNewExercise();

                    break;
                case 2:
                    GoalsManagement.addToDb();
                    break;
                case 3:
//                    List<String[]> data = GoalsDAO.getAllFromGoalsBasedOnUserId(currentUser.getId());
//                    for (String[] s : data) {
//                        System.out.println(Arrays.toString(s));
//                    }
                    /**Pobiera id, opis i liczbę punktów z zadań dodanych przez użytkownika i wyświetla**/
                    String mojeZadania = "MOJE ZADANIA";
                    printInfo(mojeZadania);
                    List<String[]> data = ExerciseDAO.getBasicExerciseBasedOnUserId(getCurrentUser().getId());
                    for(String[] s : data){
                        if (Integer.valueOf(s[0])<10) {
                            System.out.println("id " + " " + s[0] + " PUNKTY: " + s[2] + " OPIS: " + s[1]);
                        }
                        else{
                            System.out.println("id "+s[0] + " PUNKTY: " + s[2] + " OPIS: " + s[1]);
                        }
                    }
                    System.out.println();
                    break;
                case 4:
                    // TODO: 16.08.19 zmodyfikować żeby pobierało listę wszystkich celów  lub celu przyporządkowanego do id = połączyć q do wielu z userem ale lepiej będzie dodać kolumnę z user id i w niej będzi zapisywany current user
                    /**Pobiera id, opis i liczbę punktów z celów dodanych przez użytkownika i wyświetla**/
                    String mojeCele = "MOJE CELE";
                    printInfo(mojeCele);
                    List<String[]> data2 = GoalsDAO.getBasicGoalsBasedOnUserId(getCurrentUser().getId());
                    for(String[] s : data2){
                        if(Integer.valueOf(s[0]) < 10) {
                            System.out.println("id " + " " + s[0] + " PUNKTY: " + s[2] + "      UTWORZONO: " + s[3] + "      NAZWA: " + s[1]);
                        }
                        else{
                            System.out.println("id " + s[0] + " PUNKTY: " + s[2] + "      UTWORZONO: " + s[3] + "      NAZWA: " + s[1]);
                        }

                    }
                    System.out.println();

                    break;

            }

        }
        while (answer !=0);




    }

    public static void addNewExercise() {

        // checkGoals();
        /**Zanim doda nowe zadanie, sprawdza czy użytkownik ustawił cele**/
        if (GoalsDAO.getAllGoals().size() == 0) {  //pobiera listę wszystkich zadań i sprawdza wielkość, jeśli 0 = należy jakieś dodać

            System.out.println("Nie masz dodanych żadnych celów. Zanim dodasz zadanie, dodaj cel na który będziesz zbierał punkty z zadań");
            System.out.println();
            GoalsManagement.addToDb();
            System.out.println();
            System.out.println("Dodano CEL, teraz możesz dodać ZADANIE ");
            System.out.println();
        }
        ExerciseManagement.addToDb();



    }


    /**
     * Sprawdza czy są dodane cele, jeśli nie to kieruje do metody z dodawaniem
     **/
    public static void checkGoals() {

//        if (GoalsDAO.getFromGoalsBasedOnUserId(currentUser.getId()).size() == 0) {
//            System.out.println("Nie masz dodanych żadnych celów. Zanim dodasz zadanie, dodaj cel na który będziesz zbierał punkty z zadań");
//            System.out.println();
//            GoalsManagement.addToDb();
//            System.out.println();
//            System.out.println("Dodano CEL, teraz możesz dodać ZADANIE ");
//        }
//        System.out.println("         XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        System.out.println("         X        CELE WSZYSTKICH UŻYTKOWNIKÓW        X");
//        System.out.println("         XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        System.out.println();
//        List<Goals> allGoals = GoalsDAO.getAllGoals();
//        for (Goals g : allGoals) {
//            System.out.println(g);
//        }


    }

    /** Metoda wyświetlająca nmapisyu w ładny sposób **/ // TODO: 10.08.19 przekształcić, żeby to ładnie wyglądało
    public static void printInfo(String input) {
        /**Wyświetla napis menu **/
        String stringTest = "         X        "+input+"       X";

        String str = "         X";
        for (int i = 0; i < stringTest.length() - 10; i++) {
            str += "X";
        }
        System.out.println(str);
        str = "         X";

        System.out.println(stringTest);
        for (int i = 0; i < stringTest.length() - 10; i++) {
            str += "X";
        }
        System.out.println(str);
        System.out.println();
        /** **********************/}


}
