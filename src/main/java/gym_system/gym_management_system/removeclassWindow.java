package gym_system.gym_management_system;

import Gym_Components.Gym_Class;
import System_Users.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class removeclassWindow extends JFrame{
    private JPanel removeclassPanel;
    private JTextField txt_class;
    private JButton button1;
    private JLabel lbl_delete_assure;
    private JButton cancelButton;
    private JButton deleteButton;
    private JLabel lbl_name;
    private JButton backToMenuButton;


    removeclassWindow(){
        setContentPane(removeclassPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setTitle("Remove Class");
        setVisible(true);
        setLocationRelativeTo(null);
        deleteButton.setVisible(false);
        cancelButton.setVisible(false);
        lbl_delete_assure.setVisible(false);



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String class_type = txt_class.getText().toUpperCase(Locale.ROOT);
                Gym_Class delete_class2 = Administrator.findClass(class_type);

                if(delete_class2 != null){
                    deleteButton.setVisible(true);
                    cancelButton.setVisible(true);
                    lbl_delete_assure.setVisible(true);
                    txt_class.setEnabled(false);
                    String message = "Are you sure you want to remove " + delete_class2.getType();
                    lbl_delete_assure.setText(message);
                    lbl_delete_assure.setForeground(new Color(0,0,0));
                }
                else{
                    deleteButton.setVisible(false);
                    cancelButton.setVisible(false);
                    lbl_delete_assure.setVisible(true);
                    lbl_delete_assure.setText("No Class was found was this name");
                    lbl_delete_assure.setForeground(new Color(255,0,0));
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String class_type = txt_class.getText().toUpperCase(Locale.ROOT);
                Gym_Class delete_class3 =Administrator.findClass(class_type);
                GymSystem.getGym_classes().remove(delete_class3);
                dispose();
                adminWindow adminwindow = new adminWindow();
                String message = delete_class3.getType() + " was removed successfully.";
                adminwindow.lbl_admin_home.setText(message);
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                adminWindow adminwindow = new adminWindow();
            }
        });
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                classesmanagmentWindow classesmanagmentwindow = new classesmanagmentWindow();
            }
        });
    }
}

