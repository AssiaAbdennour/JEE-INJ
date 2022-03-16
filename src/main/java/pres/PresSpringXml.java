package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//by assia abd
public class PresSpringXml {
    public static void main(String[] args) {
        // nous avons crée ici un objet de type ApplicationcContext
        ApplicationContext ctx=new AnnotationConfigApplicationContext("dao","metier");
        //ApplicationContext context=new ClassPathXmlApplicationContext("spring-ioc.xml");
        // nous recherchons ici sur un objet qui s'appelle metier
        //IMetier metier= (IMetier) context.getBean("metier");
        IMetier metier=ctx.getBean(IMetier.class);
        // test
        System.out.println(metier.calcul());
    }
}
