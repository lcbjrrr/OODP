package acme;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GUI {
    private App app;

    public GUI(RepositoriesAbstractFactory factory){
        this.app = new App(factory);
    }

    public void run(){
        System.out.println("### Menu ###");
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GUI gui = context.getBean(GUI.class);
        gui.run();
    }
}
