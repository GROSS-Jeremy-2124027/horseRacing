import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Course extends Thread {
    private List<Cheval> chevauxDeCourse = new ArrayList<>();


    @Override
    public void run() {
        Scanner scannerNombreChevaux = new Scanner(System.in);

        System.out.println("Bonjour et bienvenue dans ce PMU de diiiingue !!!" + "\n" +
                    "Vous aller parier sur un chevaux. Tout d'abord, entrer le nombre de chevaux : " + "\n");

        int nombreChevaux = scannerNombreChevaux.nextInt();

        System.out.println("Vous aller assister à une course de " + nombreChevaux + " chevaux !");

    }

    public static void main(String[] args) {
        Course course = new Course();
        course.start();
    }
}
