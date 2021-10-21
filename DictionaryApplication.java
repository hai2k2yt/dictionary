package Dictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DictionaryApplication extends JFrame implements ActionListener {
    private JTextField targetWordField;
    private JButton translateButton;
    private JButton addButton;
    private JButton deleteButton;
    private JButton saveButton;
    private JButton exitButton;
    private JButton searchButton;
    private JLabel ExplainLabel;
    private JPanel mainPanel;
    private JTextArea ExplainTextArea;
    private addMethod add_word;

    public DictionaryApplication() {
        initComponents();
        startWordData();
        initActionListener();
    }

    private void initActionListener() {
        translateButton.addActionListener(this);
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        saveButton.addActionListener(this);
        exitButton.addActionListener(this);
        searchButton.addActionListener(this);
    }

    private void initComponents() {
        setTitle("DictionaryApplication");
        setSize(620,430);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setVisible(true);
        add_word = new addMethod();
    }

    private void startWordData() {
        DictionaryManagement.insertFromFile();
    }

    private void btnTranslateButtonClick() {
        ExplainLabel.setText("Explain");
        String target_word = targetWordField.getText();
        String explain_word = DictionaryAppMethod.translate(target_word);
        ExplainTextArea.setText(target_word + '\n' + explain_word);
    }

    private void btnAddButtonClick() {
        add_word.setVisible(true);
    }

    private void btnDeleteButtonClick() {

    }

    private void btnSaveButtonClick() {

    }

    private void btnExitButtonClick() {
        System.exit(0);
    }

    private void btnSearchButtonClick() {
        ExplainLabel.setText("Search");
        String search_word = targetWordField.getText();
        String list_word = DictionaryAppMethod.search(search_word);
        ExplainTextArea.setText(list_word);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(translateButton)) {
            btnTranslateButtonClick();
        }
        else if(e.getSource().equals(addButton)) {
            btnAddButtonClick();
        }
        else if(e.getSource().equals(deleteButton)) {
            btnDeleteButtonClick();
        }
        else if(e.getSource().equals(saveButton)) {
            btnSaveButtonClick();
        }
        else if(e.getSource().equals(exitButton)) {
            btnExitButtonClick();
        }
        else if(e.getSource().equals(searchButton)) {
            btnSearchButtonClick();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DictionaryApplication();
            }
        });
    }
}
