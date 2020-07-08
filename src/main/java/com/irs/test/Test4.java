package com.irs.test;


import com.irs.util.CertHttpUtil;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;


import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Test4 extends JFrame {
    JLabel lblNewLabel = new JLabel("");
    boolean a=true;
    long longTime;
    long currentTime;
    long distTime;
    long day, hours,minutes, seconds;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    public Test4(){
        this.setSize(660, 245);


        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblNewLabel, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);

        final JButton btnNewButton = new JButton("\u5F00\u59CB");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                a=true;
                Thread t=new Thread(new CountTime());
                t.start();
                btnNewButton.setEnabled(false);
            }
        });
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u505C\u6B62");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a=false;
                btnNewButton.setEnabled(true);
            }
        });
        panel.add(btnNewButton_1);

        JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.NORTH);

        JLabel lblNewLabel_7 = new JLabel("\u8F93\u5165\u8981\u5012\u8BA1\u65F6\u7684\u65F6\u95F4");
        panel_1.add(lblNewLabel_7);

        textField = new JTextField();
        panel_1.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u5E74");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        panel_1.add(lblNewLabel_1);

        textField_1 = new JTextField();
        panel_1.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("\u6708");
        panel_1.add(lblNewLabel_2);

        textField_2 = new JTextField();
        panel_1.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("\u65E5");
        panel_1.add(lblNewLabel_3);

        textField_3 = new JTextField();
        panel_1.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("\u65F6");
        panel_1.add(lblNewLabel_4);

        textField_4 = new JTextField();
        panel_1.add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("\u5206");
        panel_1.add(lblNewLabel_5);

        textField_5 = new JTextField();
        panel_1.add(textField_5);
        textField_5.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("\u79D2");
        panel_1.add(lblNewLabel_6);
        this.setVisible(true);
        this.getDefaultCloseOperation();

    }
    class CountTime implements Runnable{

        @Override
        public void run() {
            Calendar cal = Calendar.getInstance();

            while(a){

                cal.set(Integer.valueOf(textField.getText()),Integer.valueOf(textField_1.getText()),Integer.valueOf(textField_2.getText()),Integer.valueOf(textField_3.getText()),Integer.valueOf(textField_4.getText()),Integer.valueOf(textField_5.getText()));
                longTime  = cal.getTimeInMillis();
                currentTime = new Date().getTime();
                distTime = longTime - currentTime;
                day = ((distTime / 1000) / (3600 * 24));
                hours = ((distTime / 1000) - day * 86400) / 3600;
                minutes = ((distTime / 1000) - day * 86400 - hours * 3600) / 60;
                seconds = (distTime / 1000) - day * 86400 - hours * 3600 - minutes * 60;
                try {
                    lblNewLabel.setText("距这天"+day+"天"+hours+"小时:"+minutes+"分钟:"+seconds+"秒");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }
        }

    }
    public static void main(String[] args) {
        /*String result=
                "<xml>" +
                        "   <appid>wx7500e60816b113c8</appid>" +
                        "   <mch_id>1516361731</mch_id>" +
                        "   <nonce_str>6cefdb308e1e2e8aabd48cf79e546a02</nonce_str> " +
                        "   <out_refund_no>20190328133844434354</out_refund_no>" +
                        "   <out_trade_no>20190328150541477127</out_trade_no>" +
                        "   <refund_fee>0.01</refund_fee>" +
                        "   <total_fee>0.01</total_fee>" +
                        "   <sign>6F7E2E7050931AC4853B385AF3083EA2</sign>" +
                        "</xml>";
        String resXml = CertHttpUtil.postData("https://api.mch.weixin.qq.com/secapi/pay/refund", result);
        System.out.println(resXml);*/
        String str1="1";
        String str2="4";
        BigDecimal num1 = new BigDecimal(str1);
        BigDecimal num2 = new BigDecimal(str2);
        BigDecimal result=num1.divide(num2);
        System.out.println(String.format("%.0f",result));
    }



}


