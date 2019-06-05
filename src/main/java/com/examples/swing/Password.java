package com.examples.swing;

import com.examples.screen.Screen;

import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;


public class Password extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPasswordField fieldPassword;
    private JTextField fieldLogin;
    private JLabel labelLogin;
    private JLabel labelPassword;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JProgressBar progressBar;


    public Password() {

        setContentPane(contentPane);
        setModal(true);
        setAlwaysOnTop(true);
        getRootPane().setDefaultButton(buttonOK);
        this.setResizable(false);

        new Screen().setInCenterMonitor(this);


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }


    private void onOK() {
        // add your code here
        System.out.println("Ok select. login:" + fieldLogin.getText() + " pass:"+ Arrays.toString(fieldPassword.getPassword()));
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Password dialog = new Password();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
