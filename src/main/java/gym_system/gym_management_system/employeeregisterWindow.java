package gym_system.gym_management_system;

import System_Users.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class employeeregisterWindow extends JFrame {
    private JTextField txt_national_id;
    private JTextField txt_name;
    private JTextField txt_phone;
    private JTextField txt_user;
    private JTextField txt_pass;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JRadioButton otherRadioButton;
    private JButton checkButton;
    private JButton btn_submit;
    private JPanel employeeregisterPanel;
    private JComboBox gender_combobox;
    private JLabel lbl_employee_register;
    private JButton backToLoginButton;


    employeeregisterWindow(){
        setContentPane(employeeregisterPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setTitle("Employee Registration");
        setVisible(true);
        setLocationRelativeTo(null);


        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String national_id = txt_national_id.getText();
                try {
                    if (national_id.isEmpty()){
                        throw new NullPointerException("Please Enter an ID");
                    }
                    try {
                        long input = Long.parseLong(national_id);
                        if ((national_id.length() != 14)){
                            throw new InvalidID ("National ID size is not 14 numbers !");
                        }
                        else if(GymSystem.checkid(national_id) == true)
                        {
                            lbl_employee_register.setText("No Employee was found was this ID");
                            lbl_employee_register.setForeground(new Color(75, 181, 67));
                            txt_name.setEnabled(true);
                            gender_combobox.setEnabled(true);
                            txt_phone.setEnabled(true);
                            txt_user.setEnabled(true);
                            txt_pass.setEnabled(true);
                            btn_submit.setEnabled(true);
                            txt_national_id.setEnabled(false);
                            checkButton.setVisible(false);
                        }
                        else
                        {

                            lbl_employee_register.setText("An Employee already exists with this ID");
                            lbl_employee_register.setForeground(new Color(255, 0, 0));
                            txt_name.setEnabled(false);
                            gender_combobox.setEnabled(false);
                            txt_phone.setEnabled(false);
                            txt_user.setEnabled(false);
                            txt_pass.setEnabled(false);
                            btn_submit.setEnabled(false);
                            txt_national_id.setEnabled(true);
                        }
                    }
                    catch (NumberFormatException u ){
                        lbl_employee_register.setText(u.getMessage());
                    }
                    catch (InvalidID v){
                        lbl_employee_register.setText(v.getMessage());
                    }

                }
                catch (Exception y){
                    lbl_employee_register.setText(y.getMessage());
                }

            }
        });
        btn_submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = "";
                try {

                    String name = txt_name.getText();
                    String gender = (String) gender_combobox.getItemAt(gender_combobox.getSelectedIndex());
                    String national_id = txt_national_id.getText();

                    String phone_number = txt_phone.getText();
                    String username = txt_user.getText();
                    String password = txt_pass.getText();
                    if (((name.isEmpty())|| (gender.isEmpty()) || (national_id.isEmpty()) || (phone_number.isEmpty()) ||  (username.isEmpty()) || (password.isEmpty()))) {

                            throw new NullPointerException("Please Complete missing data");
                    }
                      else {
                        GymSystem.employees.add(new Employee(name, national_id, gender, phone_number, username, password));
                        dispose();
                        employeeloginWindow employeeloginwindow = new employeeloginWindow();
                        employeeloginwindow.lbl_invalid_employee_login.setForeground(new Color(75, 181, 67));
                        employeeloginwindow.lbl_invalid_employee_login.setText("Account Created Successfully");
                    }

                }
                catch (Exception x){
                    lbl_employee_register.setText(x.getMessage());
                    lbl_employee_register.setForeground(new Color(255, 0, 0));

                }


            }
        });
        backToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                employeeloginWindow employeeloginwindow = new employeeloginWindow();
            }
        });
    }

}
