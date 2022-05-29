package gym_system.gym_management_system;

import Gym_Components.Gym_Class;
import Gym_Components.Member;
import Gym_Components.Trainer;
import System_Users.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class addmembertoclassWindow extends JFrame {
    public JTextField txt_id;
    private JButton addButton;
    private JButton backToMenuButton;
    private JPanel addmembertoclassPanel;
    private JTextField txt_class;
    public JLabel lbl_add_member_to_class;

    addmembertoclassWindow() {
        setContentPane(addmembertoclassPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setLocationRelativeTo(null);
        setTitle("Add Member to Class");
        setVisible(true);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String national_id,gymClassName;
                gymClassName = txt_class.getText().toUpperCase(Locale.ROOT);
                Gym_Class gym_class = Employee.findGymClass(gymClassName);
                national_id = txt_id.getText();
                Member addedMember = Employee.findMember(national_id);
                try {
                    if (national_id.isEmpty() ||gymClassName.isEmpty() ){
                        throw new NullPointerException("Please Enter missing data !");
                    }
                    long input = Long.parseLong(national_id);
                    if ((national_id.length() != 14)){
                        throw new InvalidID ("National ID size is not 14 numbers !");
                    }
                    else {

                if(addedMember==null)
                {
                    lbl_add_member_to_class.setText("No Member exists with this ID");
                    lbl_add_member_to_class.setForeground(new Color(255,0,0));

                }
                else if(gym_class==null){
                    lbl_add_member_to_class.setText("No Class exists with this name");
                    lbl_add_member_to_class.setForeground(new Color(255,0,0));
                }
                else{
                    boolean is_found=false;
                    for (Gym_Class C : addedMember.getMemberAttendedClasses() ) {
                        if (C.getType().equals(gym_class.getType())) {
                            is_found=true ;
                            break;
                        }

                    }
                    if(is_found==true){
                        lbl_add_member_to_class.setText(addedMember.get_name() + " is already assigned to " + gym_class.getType());
                        lbl_add_member_to_class.setForeground(new Color(255,0,0));

                    }
                    else {
                        addedMember.getMemberAttendedClasses().add(gym_class);
                        gym_class.addMemberToClass(addedMember);
                        dispose();
                        employeemanagmentWindow employeemanagmentwindow = new employeemanagmentWindow();
                        employeemanagmentwindow.lbl_employee_management_home.setText(addedMember.get_name() + " was added successfully to " + gym_class.getType());
                        employeemanagmentwindow.lbl_employee_management_home.setForeground(new Color(75, 181, 67));
                    } }

                }

            }
//                catch (Exception x){
//                    lbl_add_member_to_class.setText(x.getMessage());
//                    lbl_add_member_to_class.setForeground(new Color(255, 0, 0));
//                }
                catch (NumberFormatException n ){
                    lbl_add_member_to_class.setText(n.getMessage());
                    lbl_add_member_to_class.setForeground(new Color(255,0,0));
                }
                catch (InvalidID z){
                    lbl_add_member_to_class.setText(z.getMessage());
                    lbl_add_member_to_class.setForeground(new Color(255,0,0));
                }
                catch (NullPointerException f){
                    lbl_add_member_to_class.setText(f.getMessage());
                    lbl_add_member_to_class.setForeground(new Color(255,0,0));
                }
        }});
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                employeemanagmentWindow employeemanagmentwindow = new employeemanagmentWindow();
            }
        });
    }
}
