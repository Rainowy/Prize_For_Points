package App;

import DAO.GoalsDAO;
import Entity.Goals;

import java.util.List;
import java.util.Scanner;

public class GoalsManagement {
    private static Scanner scan = new Scanner(System.in);
    static java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

    public static void addToDb(){



        System.out.println("Wprowadź nazwę swojego celu na który chciałbyś przeznaczyć punkty z zadań");
        String goalName = scan.nextLine();

        System.out.println("Wprowadź opis celu: W 3 krótkich zdaniach opisz dlaczego chciałbyś przeznaczyć punkty z zadań na ten cel. Opis nie może być krótszy niż 50 znaków");

        String description;
        do{
             description = scan.nextLine();
             if(description.trim().length()< 50){
                 System.out.println("Opis celu jest za krótki, musi zawierać minimum 50 znaków a wpisałeś " + description.trim().length() + " znaków");
             }
        }
        while(description.trim().length() < 50);

        Goals newGoal = new Goals();
        newGoal.setName(goalName);
        newGoal.setDescription(description);
        newGoal.setCreated(date);

        System.out.println("                 NOWY CEL ZOSTAŁ DODANY!");

        GoalsDAO.save(newGoal);


    }

    public static void printMyGoals() {
        /**Pobiera id, opis i liczbę punktów z celów dodanych przez użytkownika i wyświetla**/

        String myGoals = "MOJE CELE";
        Main.printInfo(myGoals);
        System.out.println();
        List<String[]> data2 = GoalsDAO.getBasicGoalsBasedOnUserId(ExerciseManagement.getCurrentUser().getId());
        for (String[] s : data2) {
            if (Integer.valueOf(s[0]) < 10) {
                System.out.println("id " + " " + s[0] + " PUNKTY: " + s[2] + "      UTWORZONO: " + s[3] + "      NAZWA: " + s[1]);
            } else {
                System.out.println("id " + s[0] + " PUNKTY: " + s[2] + "      UTWORZONO: " + s[3] + "      NAZWA: " + s[1]);
            }
        }
    }

    public static void addColumn(){

        System.out.println("Wpisz nazwę kolumny do dodania");

        String addColumn = scan.nextLine();

        System.out.println("Wpisz typ tabeli(int, varchar itp.) i ew. dodatkowe parametry");

        String addType = scan.nextLine();

        GoalsDAO.addColumn(addColumn,addType);

    }

}
