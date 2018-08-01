package com.qunhe.i18n.util.jwt;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class VerificationPanel extends JPanel {

    public JButton btnStart;
    public JButton btnDecode;
    public JTextField secretTextField;
    public JTextArea tokenTextArea;

    /**
     * Create the panel.
     */
    public VerificationPanel() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        secretTextField = new JTextField();
        secretTextField.setBounds(25, 385, 425, 35);
        add(secretTextField);
        secretTextField.setColumns(10);

        tokenTextArea = new JTextArea();
        tokenTextArea.setLineWrap(true);
        tokenTextArea.setWrapStyleWord(true);
        JScrollPane qScroller = new JScrollPane(tokenTextArea);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        qScroller.setBounds(25, 35, 425, 315);
        add(qScroller);

        JLabel lblToken = new JLabel("TOKEN");
        lblToken.setBounds(25, 10, 55, 15);
        add(lblToken);

        JLabel lelSecret = new JLabel("SECRET");
        lelSecret.setBounds(25, 360, 54, 15);
        add(lelSecret);

        btnStart = new JButton("VERIFY");
        btnStart.setBounds(250, 430, 200, 35);

        add(btnStart);

        btnDecode = new JButton("DECODE PAYLOAD");
        btnDecode.setBounds(25, 430, 200, 35);

        add(btnDecode);
    }

}
