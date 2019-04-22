package com.qunhe.i18n.util.jwt;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class ResultGui extends JDialog {


    private JTextArea textArea;

    /**
     * Create the dialog.
     */
    public ResultGui() {
        setModal(true);
        setTitle("RESULT");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JLabel lblResult = new JLabel("RESULT");
        contentPanel.add(lblResult, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane();
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setViewportView(textArea);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("OK");
        okButton.setActionCommand("OK");
        okButton.addActionListener((e) -> {
            dispose();
        });
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
    }

    public ResultGui setContent(String content) {
        textArea.setText(content);
        return this;
    }

    public void showResult() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

}
