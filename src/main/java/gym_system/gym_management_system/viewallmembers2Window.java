package gym_system.gym_management_system;

        import Gym_Components.Member;
        import System_Users.Person;

        import javax.swing.*;
        import javax.swing.text.BadLocationException;
        import javax.swing.text.Document;
        import java.io.IOException;
        import java.io.OutputStream;
        import java.io.PrintStream;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.Locale;

public class viewallmembers2Window extends JFrame {
    private JPanel viewallmembers2Panel;
    private JLabel lbl_view_all_members;
    private JTextPane textPane1;

    private JButton backToMenuButton;

    private void updateTextPane(final String text) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Document doc = textPane1.getDocument();
                try {
                    doc.insertString(doc.getLength(), text, null);
                } catch (BadLocationException e) {
                    throw new RuntimeException(e);
                }
                textPane1.setCaretPosition(doc.getLength() - 1);
            }
        });
    }

    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(final int b) throws IOException {
                updateTextPane(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateTextPane(new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };

        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }

    GymSystem Gym_Managment_System = new GymSystem();


    viewallmembers2Window() {

        setContentPane(viewallmembers2Panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setTitle("View All Members");
        setVisible(true);

        redirectSystemStreams();
        if (!GymSystem.getMembers().isEmpty()) {
            System.out.println("\n------------------------------------" + "All Members info" +
                    "------------------------------------\n");
            System.out.format("%16s\t%24s\t%6s\t%11s\n",
                    "Name",
                    "National ID",
                    "Gender" ,
                    "Phone_Number"
            );

            for (Person member : GymSystem.getMembers()) {
                System.out.format("%16s%24s\t%6s\t%11s\n",
                        member.get_name(),
                        member.get_national_id(),
                        member.get_gender(),
                        member.getPhone_number());
            }
            System.out.println("\n-----------------------------------------------" +
                    "-----------------------------------------------\n");
        }else {
            System.out.println("There are no members available !");
        }


        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                employeemanagmentWindow employeemanagmentwindow = new employeemanagmentWindow();
            }
        });
    }
}

