package App;

import DAO.GoalsDAO;
import DAO.UserDao;
import Entity.User;
import java.util.Scanner;

public class Main {


    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {


        // TODO: 09.08.19 zrobić początek z informowaniem o konieczności dodania celów, pomyśleć nad zadaniami specjalnymi

        // TODO: 09.08.19 zaopatrzyć wyjątki: gdy złe hasło itp

        System.out.println("                                                 Nagrody za punkty ver 1.2");
        User user = feftchUser();
        ExerciseManagement.setCurrentUser(user);

        String stringTest = "ZALOGOWANY JAKO " + user.getName() + " AKTUALNA LICZBA PUNKTÓW " + user.getUser_points();

        printInfo(stringTest);
        System.out.println();

        mainMenu();
    }

    /**
     * Pobiera użytkownika na podstawie hasła
     **/
    public static User feftchUser() {

        String podajHasło = "PODAJ HASŁO";
        printInfo(podajHasło);
        String password = scan.nextLine().trim();

        return UserDao.getByPassword(password);

    }


    public static void mainMenu() {

        String mainMenu = "GŁÓWNE MENU";
        printInfo(mainMenu);
        System.out.println();

        int answer;
        do {

            String coChceszZrobić = "CO CHCESZ ZROBIĆ ?";
            printInfo(coChceszZrobić);
            System.out.println();
            System.out.println("               Wciśnij 1 aby dodać nowe zadanie");
            System.out.println("               Wciśnij 2 aby dodać nowy cel");
            System.out.println("               Wciśnij 3 aby zobaczyć swoje zadania");
            System.out.println("               Wciśnij 4 aby zobaczyć swoje cele");
            System.out.println("               Wciśnij 0 aby wyjść z programu");

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

                    ExerciseManagement.printMyExercises();
                    System.out.println();
                    break;

                case 4:

                    GoalsManagement.printMyGoals();
                    System.out.println();
                    break;
            }
        }
        while (answer != 0);


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
        ExerciseManagement.collectDataAndSave();


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

    /**
     * Metoda wyświetlająca nmapisyu w ładny sposób
     **/ // TODO: 10.08.19 przekształcić, żeby to ładnie wyglądało
    public static void printInfo(String input) {

        String stringTest;
        int stringLength;
        String str;

        if(input.contains("JAKO")){
            stringTest = "X        " + input + "       X";
            str = "X";
            stringLength = stringTest.length() -2 ;
        }
        else if(input.contains("CO")){
            stringTest = "             X        " + input + "       X";
            str = "             X";
            stringLength = stringTest.length() -15  ;
        }
        else {
            stringTest = "                X        " + input + "       X";
            str = "                X";
            stringLength = stringTest.length() -18  ;
        }
        str = printExternalLine(str, stringLength);
        System.out.println(str);
        System.out.println(stringTest);
        System.out.println(str);
        //System.out.println();
    }

    private static String printExternalLine(String str, int stringLength) {
        for (int i = 0; i <= stringLength; i++) {
            str += "X";
        }
        return str;
    }


}
