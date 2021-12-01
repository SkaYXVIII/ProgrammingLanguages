package com.github.SkaYXVIII;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginFrame extends JFrame {

    public static final String TITLE = "Login screen";
    private JTextField userNameField = new JTextField(15);
    private JPasswordField passwordField = new JPasswordField(15);
    private final JTextArea passwordText = new JTextArea("Password:");
    private final JTextArea userNameText = new JTextArea("Username:");
    private final JTextArea massageText = new JTextArea("Wrong password or name!");
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

        JPanel massagePanel = new JPanel();
        massagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        massageText.setVisible(false);
        massagePanel.add(massageText);
        massagePanel.setOpaque(false);

        JPanel userNamePanel = new JPanel();
        userNamePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        userNamePanel.add(userNameText);
        userNamePanel.add(userNameField);
        userNamePanel.setOpaque(false);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel,BoxLayout.Y_AXIS));
        loginPanel.add(userNamePanel);
        loginPanel.add(passwordPanel);
        loginPanel.add(massagePanel);
        loginPanel.setOpaque(false);

        JPanel buttonPanel = new JPanel();
        JButton loginButton = new LoginButton();
        JButton clearButton = new ClearButton();
        buttonPanel.add(loginButton);
        buttonPanel.add(clearButton);
        buttonPanel.setOpaque(false);

        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Opcje");
        menuBar.add(optionsMenu);
        JButton loginToolBar = new LoginButton();
        JButton clearToolBar = new ClearButton();
        optionsMenu.add(loginToolBar);
        optionsMenu.add(clearToolBar);

        passwordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) inspectLogin();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        getContentPane().add(BorderLayout.CENTER,loginPanel);
        getContentPane().add(BorderLayout.SOUTH,buttonPanel);
        getContentPane().add(BorderLayout.NORTH,menuBar);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
    }

    public void inspectLogin(){
        if (dataBase.checkUser(userNameField.getText(),passwordField.getPassword())){
            getContentPane().setBackground(Color.green);
            massageText.setVisible(false);
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

    private class LoginButton extends JButton{
        private static final String NAME = "Login";
        private LoginButton(){
            super(NAME);
            this.addActionListener(e -> inspectLogin());
        }

    }

    private class ClearButton extends JButton{
        private static final String NAME = "Clear";
        private ClearButton(){
            super(NAME);
            this.addActionListener(e -> clearFields());
        }

    }

}
