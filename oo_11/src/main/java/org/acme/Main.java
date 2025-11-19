package org.acme;

import org.acme.data.StudentRepositoryDB;
import org.acme.gui.GUI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI(new StudentRepositoryDB());
        gui.run();
    }

//    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//    GUI gui = context.getBean(GUI.class);
//        gui.run();
}