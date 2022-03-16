package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    public static void  main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new File("config.txt"));
        //lecture de la première ligne du fichier config.txt
        String daoClassName = scanner.nextLine();
        // chercher la class si elle existe ou pas, si elle existe il va charger le bytecode en mémoire
        Class cDao = Class.forName(daoClassName);
        //crée un objet de type cet class
        IDao dao = (IDao) cDao.newInstance();

        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.newInstance();

        //injection
        Method method = cMetier.getMethod("setDao", IDao.class);
        //metier.setDao(Dao);
        method.invoke(metier,dao);

        System.out.println(metier.calcul());


    }
}
