package gym_system.gym_management_system;

import Gym_Components.Trainer;
import System_Users.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addtrainerWindow extends JFrame {
    private JPanel addtrainerPanel;
    private JTextField txt_national_id;
    private JTextField txt_name;
    private JTextField txt_phone;
    private JTextField txt_user;
    private JButton checkButton;
    private JLabel lbl_add_trainer;
    private JPasswordField txt_pass;
    private JComboBox gender_combobox;
    private JButton btn_submit;
    private JButton resetButton;
    private JButton backToMenuButton;

    addtrainerWindow(){
        setContentPane(addtrainerPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setLocationRelativeTo(null);
        setTitle("Add Trainer");
        setVisible(true);

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String national_id = txt_national_id.getText();
                if(Administrator.checktrainer_id(national_id) == true)
                {
                    lbl_add_trainer.setText("No Trainer was found was this ID");
                    lbl_add_trainer.setForeground(new Color(75, 181, 67));
                    txt_name.setEnabled(true);
                    gender_combobox.setEnabled(true);
                    txt_phone.setEnabled(true);
                    btn_submit.setEnabled(true);
                    txt_national_id.setEnabled(false);
                    checkButton.setVisible(false);
                    resetButton.setVisible(true);
                }
                else
                {
                    lbl_add_trainer.setText("A Trainer already exists with this ID");
                    lbl_add_trainer.setForeground(new Color(255, 0, 0));
                    txt_name.setEnabled(false);
                    gender_combobox.setEnabled(false);
                    txt_phone.setEnabled(false);
                    btn_submit.setEnabled(false);
                    txt_national_id.setEnabled(true);
                }
            }
        });
        btn_submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txt_name.getText();
                String gender = (String) gender_combobox.getItemAt(gender_combobox.getSelectedIndex());
                String national_id = txt_national_id.getText();
                String phone_number = txt_phone.getText();
                Trainer trainer = new Trainer(name, national_id, gender,phone_number);
                GymSystem.getTrainers().add(trainer);
                dispose();
                adminWindow adminwindow = new adminWindow();
                adminwindow.lbl_admin_home.setForeground(new Color(75, 181, 67));
                adminwindow.lbl_admin_home.setText(name +" was added successfully");

            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                addtrainerWindow addtrainerwindow = new addtrainerWindow();
            }
        });
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                trainermanagmentWindow trainermanagmentwindow= new trainermanagmentWindow();
            }
        });
    }
}