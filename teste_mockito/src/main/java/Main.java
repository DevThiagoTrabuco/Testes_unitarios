import models.ClasseA;
import models.ClasseB;

public class Main {
    public static void main(String[] args) {
        ClasseB classeB = new ClasseB();
        ClasseA classeA = new ClasseA(classeB);
        System.out.println(classeA.somarValores());
    }
}
