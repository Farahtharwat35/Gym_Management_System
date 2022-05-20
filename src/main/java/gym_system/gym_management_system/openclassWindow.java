package gym_system.gym_management_system;

import Gym_Components.Gym_Class;
import System_Users.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.*;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class openclassWindow extends JFrame {
    private JTextField txt_day;
    private JTextField txt_name;
    private JTextField txt_time1;
    private JSpinner spin_max;
    private JLabel lbl_open_class;
    private JTextArea txt_description;
    private JPanel openclassPanel;
    private JButton submitButton;
    private JComboBox comboBox1;
    private JTextField txt_time2;
    private JButton backToMenuButton;
    LocalTime start_time;
    LocalTime end_time;



    openclassWindow() {

        setContentPane(openclassPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setTitle("Open Class");
        setVisible(true);
        setLocationRelativeTo(null);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String errormsg="";
                try {
                    String class_name = txt_name.getText().toUpperCase(Locale.ROOT);
                    String day = (String) comboBox1.getItemAt(comboBox1.getSelectedIndex());
                    try {
                        start_time = LocalTime.parse(txt_time1.getText() + ":00.00");
                    }
                    catch (Exception ex1){
                        errormsg= "Error in Start Time format";
                        throw new Exception();
                    }
                    try {
                        end_time = LocalTime.parse(txt_time2.getText() + ":00.00");
                    }
                    catch (Exception ex2){
                        errormsg="Error in End Time format";
                        throw new Exception();
                    }

                    try {

                        String description = txt_description.getText();
                        int maxMemberCount = (Integer) (spin_max.getValue());
                        Gym_Class new_class = Administrator.findClass(class_name);

                        if (new_class == null) {
                            Gym_Class open_class = new Gym_Class(class_name, description, day, maxMemberCount, start_time, end_time);

                            GymSystem.getGym_classes().add(open_class);
                            dispose();
                            adminWindow adminwindow = new adminWindow();
                            adminwindow.lbl_admin_home.setText("Class " + open_class.getType() + " has been added successfully!");
                            adminwindow.lbl_admin_home.setForeground(new Color(75, 181, 67));

                        } else {
                            lbl_open_class.setText("Class " + class_name + " already exists");
                            lbl_open_class.setForeground(new Color(255, 0, 0));
                        }
                    }
                    catch (Exception ex3){
                        errormsg="Unknown Error";
                        throw new Exception();
                    }
                }
                catch (Exception ex4){
                    lbl_open_class.setText(errormsg);
                    lbl_open_class.setForeground(new Color(255, 0, 0));
                }
            }
        });
        txt_time1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                txt_time1.setText("");
                txt_time1.setForeground(Color.black);

            }
        });
        txt_time2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                txt_time2.setText("");
                txt_time2.setForeground(Color.black);
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
