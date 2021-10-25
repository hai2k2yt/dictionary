package Dictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeMethod extends JFrame implements ActionListener {
    private JTextField targetTextField;
    private JTextArea explainTextArea;
    private JButton changeButton;
    private JButton closeButton;
    private JButton currentExplainButton;
    private JPanel mainPanel;
    private JLabel statusLabel;

    public changeMethod() {
        initComponent();
        initActionListener();
    }

    private void initComponent() {
        setTitle("Change word");
        setSize(720,430);
        setResizable(false);
        setContentPane(mainPanel);
        setVisible(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private void initActionListener() {
        currentExplainButton.addActionListener(this);
        changeButton.addActionListener(this);
        closeButton.addActionListener(this);
    }

    private void btnCurrentExplainClick() {
        String target_word = targetTextField.getText();
        String explain_word = DictionaryAppMethod.translate(target_word);
        explainTextArea.setText(explain_word);
        explainTextArea.select(0, 0);
    }

    private void btnChangeClick() {
        String target_word = targetTextField.getText();
        String explain_word = explainTextArea.getText();
        String status = DictionaryAppMethod.change(target_word,explain_word);
        statusLabel.setText(status);
    }

    private void btnCloseClick() {
        statusLabel.setText("none");
        targetTextField.setText("");
        explainTextArea.setText("");
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(currentExplainButton)) {
            btnCurrentExplainClick();
        }
        else if(e.getSource().equals(changeButton)) {
            btnChangeClick();
        }
        else if(e.getSource().equals(closeButton)) {
            btnCloseClick();
        }
    }
}