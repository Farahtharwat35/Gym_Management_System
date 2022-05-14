package gym_system.gym_management_system;

import Gym_Components.Trainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class removetrainerWindow extends JFrame{
    private JTextField txt_nationalid;
    private JButton button1;
    private JButton deleteButton;
    private JButton cancelButton;
    private JLabel lbl_delete_assure;
    private JPanel removetrainerPanel;

    GymSystem Gym_Management_System= new GymSystem();

    removetrainerWindow(){
        setContentPane(removetrainerPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setTitle("Employee Register");
        setVisible(true);
        deleteButton.setVisible(false);
        cancelButton.setVisible(false);
        lbl_delete_assure.setVisible(false);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trainer_id = txt_nationalid.getText();
                deleteButton.setVisible(true);
                cancelButton.setVisible(true);
                lbl_delete_assure.setVisible(true);
                Trainer delete_trainer2=Gym_Management_System.admin1.findTrainer(trainer_id);
                String message = "Are you sure you want to remove " + delete_trainer2.get_name();
                lbl_delete_assure.setText(message);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trainer_id = txt_nationalid.getText();
                Trainer delete_trainer3=Gym_Management_System.admin1.findTrainer(trainer_id);
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
    }
}
