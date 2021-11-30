package com.github.SkaYXVIII;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    public static final String TITLE = "Login screen";
    private JTextField userNameField = new JTextField(15);
    private JPasswordField passwordField = new JPasswordField(15);
    private final JTextArea passwordText = new JTextArea("Password:");
    private final JTextArea userNameText = new JTextArea("Username:");
    private final DataBase dataBase = new DataBase(true);

    public LoginFrame(){
        super(TITLE);
    }

    public void run(){
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        passwordPanel.add(passwordText);
        passwordPanel.add(passwordField);
        passwordPanel.setOpaque(false);

        JPanel userNamePanel = new JPanel();
        userNamePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        userNamePanel.add(userNameText);
        userNamePanel.add(userNameField);
        userNamePanel.setOpaque(false);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel,BoxLayout.Y_AXIS));
        loginPanel.add(userNamePanel);
        loginPanel.add(passwordPanel);
        loginPanel.setOpaque(false);

        JPanel buttonPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        JButton clearButton = new JButton("Clear");
        loginButton.addActionListener(e -> inspectLogin());
        clearButton.addActionListener(o -> clearFields());
        buttonPanel.add(loginButton);
        buttonPanel.add(clearButton);
        buttonPanel.setOpaque(false);


        getContentPane().add(BorderLayout.CENTER,loginPanel);
        getContentPane().add(BorderLayout.SOUTH,buttonPanel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);

    }

    public void inspectLogin(){
        if (dataBase.checkUser(userNameField.getText(),passwordField.getPassword())){
            getContentPane().setBackground(Color.green);
        }
        else {
            getContentPane().setBackground(Color.red);
        }
        clearFields();
    }
    private void clearFields(){
        passwordField.setText("");
        userNameField.setText("");
    }

}
