package com.examples.swing;

import com.examples.sweater.model.Message;
import com.examples.sweater.model.User;
import com.examples.sweater.repos.MessageRepo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sweater extends JFrame {
    private final Logger log = Logger.getLogger(Sweater.class);

    @Autowired
    private MessageRepo messageRepo;

    private JTextField fieldText;
    private JTextField fieldTag;
    private JButton buttonAdd;
    private JTextField fieldFilter;
    private JButton buttonFilter;
    private JTable tableMessages;
    private JButton buttonClearFilter;
    private JPanel rootPanel;
    private JButton exitButton;

    public Sweater() {
        setContentPane(rootPanel);

        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMessage();
            }
        });
        exitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


    private void showMessages(Iterable<Message> messages) {
        tableMessages.removeAll();
//        tableMessages.col
        for (Message m : messages) {


        }
    }

    private void addMessage() {
        if (fieldText.getText().length() > 0) {
            Message message = new Message(fieldText.getText(), fieldTag.getText(), new User());
            messageRepo.save(message);
        }
        fieldText.setText("");
        fieldTag.setText("");
    }


}
