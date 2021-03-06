package com.examples.swing;

import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class UpdateListAction implements ActionListener {
    private final Logger log = Logger.getLogger(UpdateListAction.class);


    private JList<String> list;

    public UpdateListAction(JList<String> list) {
        this.list = list;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        ArrayList<String> lookAndFeelList = new ArrayList<>();
        UIManager.LookAndFeelInfo[] infoArray =
                UIManager.getInstalledLookAndFeels();
        int lookAndFeelIndex = 0;
        int currentLookAndFeelIndex = 0;
        String currentLookAndFeelClassName =
                UIManager.getLookAndFeel().getClass().getName();

        for (UIManager.LookAndFeelInfo info : infoArray) {
            if (info.getClassName().equals(currentLookAndFeelClassName)) {
                currentLookAndFeelIndex = lookAndFeelIndex;
            }
            lookAndFeelList.add(info.getName());
            lookAndFeelIndex++;
        }

        String[] listDataArray = new String[lookAndFeelList.size()];
        final String[] newListData =
                lookAndFeelList.toArray(listDataArray);
        final int newSelectedIndex = currentLookAndFeelIndex;

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                list.setListData(newListData);
                list.setSelectedIndex(newSelectedIndex);
            }
        });
    }
}


