package com.qunhe.i18n.util.jwt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainGui extends JFrame {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainGui frame = new MainGui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainGui() {
        setTitle("\u53EF\u80FD\u5E76\u6CA1\u6709\u4EC0\u4E48\u7528\u7684JWT\u5DE5\u5177");
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainGui.class.getResource("/icon.png")));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 485, 550);
        JTabbedPane tabbedPane = new JTabbedPane();

        VerificationPanel verificationPanel = new VerificationPanel();
        verificationPanel.btnStart.addActionListener((e) -> {
            String token = verificationPanel.tokenTextArea.getText().trim();
            String secret = verificationPanel.secretTextField.getText().trim();
            boolean verified = VerificationUtil.verify(token, secret);
            if(!verified) {
                JOptionPane.showMessageDialog(null, "FAIL", "MESSAGE", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
        });
        verificationPanel.btnDecode.addActionListener((e) -> {
            String token = verificationPanel.tokenTextArea.getText().trim();
            boolean checked = VerificationUtil.check(token);
            if(!checked){
                JOptionPane.showMessageDialog(null, "TOKEN FORMAT ERROR", "MESSAGE", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(null, VerificationUtil.getPayload(token));
        });



        GenerationPanel generationPanel = new GenerationPanel();
        generationPanel.btnGenerate.addActionListener((e) -> {
            String result = GenerationUtil.generate(generationPanel.payloadTextArea.getText().trim(), generationPanel.secretTextField.getText().trim());
            System.out.println(result);
        });


        tabbedPane.addTab("VERIFY", verificationPanel);
        tabbedPane.addTab("GENERATE", generationPanel);

        tabbedPane.setSelectedIndex(0);
        setContentPane(tabbedPane);
    }

}
