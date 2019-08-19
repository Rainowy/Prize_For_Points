package App;

import DAO.ExerciseDAO;
import DAO.GoalsDAO;
import Entity.Exercise;
import Entity.Goals;
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

    public static void addToDb() {

        System.out.println("Dodaj nowe zadanie, na początku wprowadź opis tego co zrobiłeś: ");

        String description = scan.nextLine();

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

        System.out.println("Wpisz liczbę punktów za to zadanie ");
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Musisz wpisać cyfry");
        }
        int points = scan.nextInt();
        scan.nextLine();
        System.out.println("Przyporządkuj zadanie do swojego celu, punkty z zadania będą sumowane w wybranym celu");
        System.out.println();
        System.out.println("Wybierz NUMER ID celu lub wciśnij 0 aby dodać nowy");


//        List<Goals> allGoals = GoalsDAO.getAllGoals();
//        for (Goals g : allGoals) {
//            System.out.println(g);
//        }

        // TODO: 10.08.19 WYCIĄGNĄĆ TO DO METODY I WSTAWIĆ DO GOALS MANAGEMENT 
        /**Pobiera id, opis i liczbę punktów z celów dodanych przez użytkownika i wyświetla**/
        String mojeCele = "MOJE CELE";
        Main.printInfo(mojeCele);
        List<String[]> data2 = GoalsDAO.getBasicGoalsBasedOnUserId(getCurrentUser().getId());
        for (String[] s : data2) {
            if (Integer.valueOf(s[0]) < 10) {
                System.out.println("id " + " " + s[0] + " PUNKTY: " + s[2] + "      UTWORZONO: " + s[3] + "      NAZWA: " + s[1]);
            } else {
                System.out.println("id " + s[0] + " PUNKTY: " + s[2] + "      UTWORZONO: " + s[3] + "      NAZWA: " + s[1]);
            }

        }
        System.out.println();
        // TODO: 10.08.19

        // TODO: 09.08.19 jeśli nie występuje w bazie, to wywali błąd, zabezpieczyć go
        //int goals_id =0;
        int goalIdFromInput;
        do {
            while (!scan.hasNextInt()) {
                scan.next();
                System.out.println("Musisz wpisać cyfry");
            }
            goalIdFromInput = scan.nextInt();
            //goals_id =scan.nextInt();
            // scan.nextLine();
//            if( goalIdFromInput != 0){
//                goals_id = scan.nextInt();
//            }
//            else{
//                GoalsManagement.addToDb();
            if ((!goalExistsInDb(goalIdFromInput)) && goalIdFromInput != 0) {
                System.out.println("Cel o podanym Id nie istnieje w bazie danych, wprowadź poprawne Id celu");
            }
//
//
        }

        while ((!goalExistsInDb(goalIdFromInput)) && goalIdFromInput != 0);      // TODO: 09.08.19 walidacja czy id isnieje w bazie

        if (goalIdFromInput == 0) {

            GoalsManagement.addToDb();
            goalIdFromInput = GoalsDAO.getNewGoalId();
        }
//        if(goalIdFromInput ==0) {
//            GoalsManagement.addToDb();
//        }
//        else {
//            goalIdFromInput = GoalsDAO.getNewGoalId();
//
//        }


        System.out.println("NEW GOAL IDeeeeeeeeeeooooooooooo " + goalIdFromInput);

        ExerciseDAO exDAO = new ExerciseDAO();
        Exercise newExercise = new Exercise();
        newExercise.setDescription(description);
        newExercise.setCreated(date);
        newExercise.setExe_points(points);
        newExercise.setUser(currentUser);
        newExercise.setGoal(GoalsDAO.getById(goalIdFromInput));
// TODO: 16.08.19 sprawdzić czemu się to wywala i nie uzupełńia punktów
        exDAO.setCurrentUser(newExercise, currentUser);

        GoalsDAO.updateUser_Points_InDb(newExercise.getExe_points(), newExercise.getGoal().getId());


    }

    /**
     * Metoda sprawdza czy cel istnieje w bazie
     **/
    public static boolean goalExistsInDb(int goalIdFromInput) {

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

}
