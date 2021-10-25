package Dictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteMethod extends JFrame implements ActionListener {
    private JButton deleteButton;
    private JButton closeButton;
    private JTextField targetField;
    private JPanel mainPanel;
    private JLabel statusField;

    public deleteMethod() {
        initComponent();
        initActionListener();
    }

    private void initComponent() {
        setTitle("Delete word");
        setSize(330,220);
        setResizable(false);
        setContentPane(mainPanel);
        setVisible(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private void initActionListener() {
        deleteButton.addActionListener(this);
        closeButton.addActionListener(this);
    }

    private void btnDeleteClick() {
        String target_word = targetField.getText();
        String status = DictionaryAppMethod.delete(target_word);
        statusField.setText(status);
    }

    private void btnCloseClick() {
        statusField.setText("none");
        targetField.setText("");
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(deleteButton)) {
            btnDeleteClick();
        }
        else if(e.getSource().equals(closeButton)) {
            btnCloseClick();
        }
    }
}