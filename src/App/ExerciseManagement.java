package App;

import DAO.ExerciseDAO;
import DAO.GoalsDAO;
import Entity.Exercise;
import Entity.User;

import java.util.List;
import java.util.Scanner;

public class ExerciseManagement {

    static java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
    private static Scanner scan = new Scanner(System.in);
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        ExerciseManagement.currentUser = currentUser;
    }

    public static void collectDataAndSave() {
        /** Zbiera dane o nowym zadaniu i następnie dodaje do bazy **/

        String description = requestDescription();
        int points = requestPoints();

        System.out.println("Przyporządkuj zadanie do swojego celu, punkty z zadania będą sumowane w wybranym celu");
        System.out.println("Wybierz NUMER ID celu lub wciśnij 0 aby dodać nowy");
        System.out.println();
        //    System.out.println();
//    System.out.println("Czy jest to zadanie specjalne? ");
//    System.out.println("[t]ak");
//    System.out.println("[n]ie");
//    String answer;
//    do {
//        answer = scan.next();
//        System.out.println("Wpisz t lub n ");
//
//    }
//    while (!answer.equals("t") && !answer.equals("n"));
//    }
        // TODO: 09.08.19 zadanie specjalne jakaś relacja, wybieranie i dodawanie id
        GoalsManagement.printMyGoals();
        System.out.println();

        int goalIdFromInput = requestGoalId();

        saveToDb(description, points, goalIdFromInput);
    }

    public static String requestDescription() {

        System.out.println("Dodaj nowe zadanie, na początku wprowadź opis tego co zrobiłeś: ");
        String description = scan.nextLine();

        return description;
    }

    public static int requestPoints() {

        System.out.println("Wpisz liczbę punktów za to zadanie ");
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Musisz wpisać cyfry");
        }
        int points = scan.nextInt();
        scan.nextLine();

        return points;
    }

    public static int requestGoalId() {

        int goalIdFromInput = getGoalIdFromInput();
        if (goalIdFromInput == 0) {
            GoalsManagement.addToDb();
            goalIdFromInput = GoalsDAO.getNewGoalId();
        }
        return goalIdFromInput;
    }

    private static void saveToDb(String description, int points, int goalIdFromInput) {
        /** Z pobranych wcześniej danych tworzy obiekt i zapisuje do bazy **/

        ExerciseDAO exDAO = new ExerciseDAO();
        Exercise newExercise = new Exercise();
        newExercise.setDescription(description);
        newExercise.setCreated(date);
        newExercise.setExe_points(points);
        newExercise.setUser(currentUser);
        newExercise.setGoal(GoalsDAO.getById(goalIdFromInput));
        exDAO.setCurrentUser(newExercise, currentUser);
        GoalsDAO.updateUser_Points_InDb(newExercise.getExe_points(), newExercise.getGoal().getId());
    }

    private static int getGoalIdFromInput() {
        /** Sprawdza czy wprowadzony Id celu jest poprawny **/

        int goalIdFromInput;
        do {
            while (!scan.hasNextInt()) {
                scan.next();
                System.out.println("Musisz wpisać cyfry");
            }
            goalIdFromInput = scan.nextInt();
            if ((!goalExistsInDb(goalIdFromInput)) && goalIdFromInput != 0) {
                System.out.println("Cel o podanym Id nie istnieje w bazie danych, wprowadź poprawne Id celu");
            }
        }
        while ((!goalExistsInDb(goalIdFromInput)) && goalIdFromInput != 0);

        return goalIdFromInput;
    }

    public static boolean goalExistsInDb(int goalIdFromInput) {
        /** Metoda sprawdza czy cel istnieje w bazie  **/

        boolean goalExistsInDb = false;

        List<String[]> allGoalsId = GoalsDAO.getAllGoalsId();
        for (String[] goalIdinDb : allGoalsId) {
            if (goalIdFromInput == Integer.valueOf(goalIdinDb[0])) {
                goalExistsInDb = true;
                break;
            }
        }
        return goalExistsInDb;
    }

    public static void printMyExercises() {
        /**Pobiera id, opis i liczbę punktów z zadań dodanych przez użytkownika i wyświetla**/

        String myExercises = "MOJE ZADANIA";
        Main.printInfo(myExercises);
        System.out.println();
        List<String[]> data = ExerciseDAO.getBasicExerciseBasedOnUserId(getCurrentUser().getId());
        for (String[] s : data) {
            if (Integer.valueOf(s[0]) < 10) {
                //  System.out.println("id " + " " + s[0] + " PUNKTY: " + s[2] + "    UTWORZONO: " + s[3] + "    OPIS: " + s[1]);
                System.out.println("PUNKTY: " + s[2] + "    UTWORZONO: " + s[3] + "    OPIS: " + s[1]);
            } else {
                //System.out.println("id " + s[0] + " PUNKTY: " + s[2] + "    UTWORZONO: " + s[3] + "    OPIS: " + s[1]);
                System.out.println("PUNKTY: " + s[2] + "    UTWORZONO: " + s[3] + "    OPIS: " + s[1]);
            }
        }
    }
}
