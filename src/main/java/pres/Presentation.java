package pres;

import dao.DaoImpl;
import dao.IDao;
import ext.DaoImplV2;
import metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {
        IDao dao = new DaoImplV2();
        MetierImpl metier = new MetierImpl(dao);

        System.out.println(metier.calcul());
    }
}
