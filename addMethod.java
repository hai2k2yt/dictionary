package Dictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addMethod extends JFrame implements ActionListener {
    private JButton addButton;
    private JButton closeButton;
    private JTextField targetField;
    private JTextArea explainTextArea;
    private JPanel mainPanel;
    private JLabel statusField;

    public addMethod() {
        initComponent();
        initActionListener();
    }

    private void initComponent() {
        setTitle("Add word");
        setSize(550,340);
        setResizable(false);
        setContentPane(mainPanel);
        setVisible(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private void initActionListener() {
        addButton.addActionListener(this);
        closeButton.addActionListener(this);
    }

    private void btnAddClick() {
        String target_word = targetField.getText();
        String explain_word = explainTextArea.getText();
        String status = DictionaryAppMethod.add(target_word,explain_word);
        statusField.setText(status);
    }

    private void btnCloseClick() {
        statusField.setText("none");
        targetField.setText("");
        explainTextArea.setText("");
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(addButton)) {
            btnAddClick();
        }
        else if(e.getSource().equals(closeButton)) {
            btnCloseClick();
        }
    }
}
