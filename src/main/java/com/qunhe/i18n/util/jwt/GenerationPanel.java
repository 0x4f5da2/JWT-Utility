package com.qunhe.i18n.util.jwt;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Component;

public class GenerationPanel extends JPanel {

    public JButton btnGenerate;
    public JTextField secretTextField;
    public JTextArea payloadTextArea;
    public JTextArea headerTextArea;

    private static final String HEADER = "{\n" +
            "  \"alg\": \"HS256\",\n" +
            "  \"typ\": \"JWT\"\n" +
            "}";


    /**
     * Create the panel.
     */
    public GenerationPanel() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        secretTextField = new JTextField();
        secretTextField.setBounds(25, 385, 425, 35);
        secretTextField.setColumns(10);
        add(secretTextField);


        payloadTextArea = new JTextArea();
        payloadTextArea.setLineWrap(true);
        payloadTextArea.setWrapStyleWord(true);
        JScrollPane qScroller = new JScrollPane(payloadTextArea);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        qScroller.setBounds(25, 150, 425, 200);
        add(qScroller);

        JLabel lblPayload = new JLabel("PAYLOAD(IN YAML FORMAT)");
        lblPayload.setBounds(25, 125, 55, 15);
        add(lblPayload);

        JLabel lblSecret = new JLabel("SECRET");
        lblSecret.setBounds(25, 360, 54, 15);
        add(lblSecret);

        btnGenerate = new JButton("GENERATE");
        btnGenerate.setBounds(25, 430, 425, 35);

        add(btnGenerate);

        JLabel lblHeader = new JLabel("HEADER");
        lblHeader.setBounds(25, 10, 55, 15);
        add(lblHeader);


        headerTextArea = new JTextArea();
        headerTextArea.setLineWrap(true);
        headerTextArea.setWrapStyleWord(true);
        headerTextArea.setText(HEADER);
        headerTextArea.setEditable(false);
        headerTextArea.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(headerTextArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(25, 35, 425, 80);
        add(scrollPane);
    }
}

