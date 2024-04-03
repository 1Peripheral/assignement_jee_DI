# README.md

Ce projet démontre la mise en œuvre de différentes techniques d'injection de dépendances dans une application Java, en utilisant des interfaces et des implémentations, ainsi que le framework Spring.

## Partie 1 : Mise en œuvre des interfaces et des implémentations

1. **Création de l'interface IDao avec une méthode getDate**

    ```java
    public interface IDao {
        Date getDate();
    }
    ```

2. **Création d'une implémentation de l'interface IDao**

    ```java
    public class DaoImplV2 implements IDao {
        public Date getDate() {
            // Implémentation de la méthode pour obtenir la date
            return new Date();
        }
    }
    ```

3. **Création de l'interface IMetier avec une méthode calcul**

    ```java
    public interface IMetier {
        int calcul();
    }
    ```

4. **Création d'une implémentation de l'interface IMetier en utilisant le couplage faible**

    ```java
    public class MetierImpl implements IMetier {
        private IDao dao;

        public MetierImpl(IDao dao) {
            this.dao = dao;
        }

        public int calcul() {
            // Implémentation de la méthode de calcul
            Date date = dao.getDate();
            // Logique de calcul utilisant la date
            return 42; // Valeur de calcul arbitraire
        }
    }
    ```

## Partie 2 : Injection des dépendances

5. **Injection des dépendances :**

    a. Par instanciation statique
    ```java
    public class Presentation {
        public static void main(String[] args) {
            IDao dao = new DaoImplV2();
            MetierImpl metier = new MetierImpl(dao);

            System.out.println(metier.calcul());
        }
    }
    ```

    b. Par instanciation dynamique
    ```java
    import metier.IMetier;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.annotation.AnnotationConfigApplicationContext;

    public class Presentation2 {
        public static void main(String[] args) {
            ApplicationContext context = new AnnotationConfigApplicationContext("ext", "metier");
            IMetier metier = context.getBean(IMetier.class);

            System.out.println(metier.calcul());
        }
    }
    ```

    c. En utilisant le Framework Spring

       - Version XML
       ```java
       import metier.IMetier;
       import org.springframework.context.ApplicationContext;
       import org.springframework.context.support.ClassPathXmlApplicationContext;

       public class Presentation3 {
           public static void main(String[] args) {
               ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
               IMetier metier = (IMetier) context.getBean("metier");
               System.out.println(metier.calcul());
           }
       }
       ```

       - Version annotations
       ```java
       // Voir la classe Presentation2 pour l'exemple d'utilisation des annotations avec Spring
       ```

Pour plus de détails sur les différentes parties de ce projet, veuillez vous référer au code source correspondant dans les fichiers Java fournis.
