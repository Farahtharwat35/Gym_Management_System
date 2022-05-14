package gym_system.gym_management_system;

import Gym_Components.Gym_Class;
import Gym_Components.Trainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class assigntrainerWindow extends JFrame {
    private JTextField txt_id;
    private JTextField txt_class;
    private JButton submitButton;
    private JLabel lbl_assign_trainer;
    private JLabel lbl_class;
    private JPanel assigntrainerPanel;

    GymSystem Gym_Management_System = new GymSystem();

    assigntrainerWindow() {
        setContentPane(assigntrainerPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setTitle("Employee Register");
        setVisible(true);


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trainer_id = txt_id.getText();
                String class_type = txt_class.getText().toUpperCase(Locale.ROOT);

                Trainer assigned_trainer=Gym_Management_System.admin1.findTrainer(trainer_id);
                Gym_Class assigned_class=Gym_Management_System.admin1.findClass(class_type);

                boolean is_available = true;
                if (assigned_class==null || assigned_trainer==null) {
                    lbl_assign_trainer.setText("No such trainer or class found ! Please try again !");
                    lbl_assign_trainer.setForeground(new Color(255, 0, 0));
                }
                else if(Gym_Management_System.admin1.assign_trainer_to_class(assigned_trainer,assigned_class)==true){
                    dispose();
                    adminWindow adminwindow = new adminWindow();
                    String message = assigned_trainer.get_name()+ " was assigned successfully to " + assigned_class.getType();
                    adminwindow.lbl_admin_home.setText(message);
                    adminwindow.lbl_admin_home.setForeground(new Color(75, 181, 67));
                }
                else{
                    dispose();
                    adminWindow adminwindow = new adminWindow();
                    String message = assigned_trainer.get_name()+ " wasn't assigned to " + assigned_class.getType();
                    adminwindow.lbl_admin_home.setText(message);
                    adminwindow.lbl_admin_home.setForeground(new Color(255, 0, 0));
                }


            }
        });
    }

}