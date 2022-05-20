package gym_system.gym_management_system;

import Gym_Components.Member;
import Gym_Components.Trainer;
import System_Users.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class assigntrainertomemberWindow extends JFrame {
    private JPanel assigntrainertomemberPanel;
    private JTextField txt_id;
    private JTextField txt_member;
    private JLabel lbl_class;
    private JLabel lbl_assign_trainer;
    private JButton submitButton;
    private JButton backToMenuButton;


    assigntrainertomemberWindow() {
        setContentPane(assigntrainertomemberPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setTitle("Assign Trainer to Member");
        setLocationRelativeTo(null);
        setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trainer_national_id = txt_id.getText();
                String member_national_id = txt_member.getText();
                Trainer assigned_trainer= Administrator.findTrainer(trainer_national_id);
                Member assigned_member= Administrator.findMember(member_national_id);

                if (assigned_trainer==null) {
                    lbl_assign_trainer.setText("No such trainer was found ! Please try again !");
                    lbl_assign_trainer.setForeground(new Color(255, 0, 0));
                }
                else if(assigned_member==null){
                    lbl_assign_trainer.setText("No such member was found ! Please try again !");
                    lbl_assign_trainer.setForeground(new Color(255, 0, 0));
                }
                else if(Administrator.assign_trainer_to_member (assigned_trainer, assigned_member)==true)
                {
                    dispose();
                    adminWindow adminwindow = new adminWindow();
                    String message = assigned_trainer.get_name()+ " was assigned successfully to " + assigned_member.get_name();
                    adminwindow.lbl_admin_home.setText(message);
                    adminwindow.lbl_admin_home.setForeground(new Color(75, 181, 67));
                }
                else{
                    dispose();
                    adminWindow adminwindow = new adminWindow();
                    String message = assigned_trainer.get_name()+ " wasn't assigned to " + assigned_member.get_name() + "\n As " + assigned_trainer.get_name() + " is not available.";
                    adminwindow.lbl_admin_home.setText(message);
                    adminwindow.lbl_admin_home.setForeground(new Color(255, 0, 0));
                }
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