package com.examples;

import com.examples.swing.Sweater;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.*;

public class Main {
    private final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
//        Password dialog = new Password();

        SessionFactory sessionFactory;
        sessionFactory = new Configuration().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Sweater dialog = new Sweater();

        dialog.pack();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        System.exit(0);


        System.out.println("end");
    }

}
