package gym_system.gym_management_system;

import Gym_Components.Trainer;
import System_Users.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class removetrainerWindow extends JFrame{
    private JTextField txt_nationalid;
    private JButton button1;
    private JButton deleteButton;
    private JButton cancelButton;
    private JLabel lbl_delete_assure;
    private JPanel removetrainerPanel;
    private JButton backToMenuButton;


    removetrainerWindow(){
        setContentPane(removetrainerPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setTitle("Remove Trainer");
        setVisible(true);
        setLocationRelativeTo(null);
        deleteButton.setVisible(false);
        cancelButton.setVisible(false);
        lbl_delete_assure.setVisible(false);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trainer_id = txt_nationalid.getText();
                Trainer delete_trainer2= Administrator.findTrainer(trainer_id);

                if(delete_trainer2!=null)
                {
                    deleteButton.setVisible(true);
                    cancelButton.setVisible(true);
                    lbl_delete_assure.setVisible(true);
                    txt_nationalid.setEnabled(false);
                    String message = "Are you sure you want to remove " + delete_trainer2.get_name();
                    lbl_delete_assure.setText(message);
                    lbl_delete_assure.setForeground(new Color(0,0,0));
                }
                else {
                    deleteButton.setVisible(false);
                    cancelButton.setVisible(false);
                    lbl_delete_assure.setVisible(true);
                    lbl_delete_assure.setText("No Trainer was found was this ID");
                    lbl_delete_assure.setForeground(new Color(255,0,0));

                }


            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trainer_id = txt_nationalid.getText();
                Trainer delete_trainer3= Administrator.findTrainer(trainer_id);
                GymSystem.getTrainers().remove(delete_trainer3);
                dispose();
                adminWindow adminwindow = new adminWindow();
                String message = delete_trainer3.get_name() + " was removed successfully.";
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
                trainermanagmentWindow trainermanagmentwindow = new trainermanagmentWindow();
            }
        });
    }
}
