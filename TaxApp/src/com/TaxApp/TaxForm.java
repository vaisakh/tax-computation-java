package com.TaxApp;

import com.TaxEngine.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class TaxForm implements ActionListener {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel nameLabel = new JLabel("Name");
    private JTextField nameText = new JTextField(20);
    private JLabel ageLabel = new JLabel("Age");
    private JTextField ageText = new JTextField(20);
    private JLabel sexLabel = new JLabel("Sex");
    private JTextField sexText = new JTextField(20);
    private JLabel locationLabel = new JLabel("Location");
    private JTextField locationText = new JTextField(20);
    private JLabel basicLabel = new JLabel("Basic");
    private JTextField basicText = new JTextField(20);
    private JLabel daLabel = new JLabel("DA");
    private JTextField daText = new JTextField(20);
    private JLabel hraLabel = new JLabel("HRA");
    private JTextField hraText = new JTextField(20);
    private JLabel allowanceLabel = new JLabel("Allowance");
    private JTextField allowanceText = new JTextField(20);
    private JLabel deductionLabel = new JLabel("Deduction");
    private JTextField deductionText = new JTextField(20);
    private JLabel cessLabel = new JLabel("Cess");
    private JTextField cessText = new JTextField(20);
    private JLabel surChargeLabel = new JLabel("Surcharge");
    private JTextField surChargeText = new JTextField(20);
    private JLabel outputLabel = new JLabel("Output : 0");


    public TaxForm() {
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        frame.setSize(350,200);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tax App GUI");
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//
//        JLabel idLabel = new JLabel("ID");
//        idLabel.setBounds(10, 20, 80, 25);
//        panel.add(idLabel);

        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        ageLabel.setBounds(110, 20, 80, 25);
        panel.add(ageLabel);
        nameText.setBounds(200, 20, 165, 25);
        panel.add(ageText);

        sexLabel.setBounds(10, 30, 80, 25);
        panel.add(sexLabel);
        sexText.setBounds(100, 30, 165, 25);
        panel.add(sexText);

        locationLabel.setBounds(110, 20, 80, 25);
        panel.add(locationLabel);
        locationText.setBounds(200, 20, 165, 25);
        panel.add(locationText);

        basicLabel.setBounds(110, 20, 80, 25);
        panel.add(basicLabel);
        basicText.setBounds(200, 20, 165, 25);
        panel.add(basicText);

        daLabel.setBounds(110, 20, 80, 25);
        panel.add(daLabel);
        daText.setBounds(200, 20, 165, 25);
        panel.add(daText);

        hraLabel.setBounds(110, 20, 80, 25);
        panel.add(hraLabel);
        hraText.setBounds(200, 20, 165, 25);
        panel.add(hraText);

        allowanceLabel.setBounds(110, 20, 80, 25);
        panel.add(allowanceLabel);
        allowanceText.setBounds(200, 20, 165, 25);
        panel.add(allowanceText);

        deductionLabel.setBounds(110, 20, 80, 25);
        panel.add(deductionLabel);
        deductionText.setBounds(200, 20, 165, 25);
        panel.add(deductionText);

        cessLabel.setBounds(110, 20, 80, 25);
        panel.add(cessLabel);
        cessText.setBounds(200, 20, 165, 25);
        panel.add(cessText);

        surChargeLabel.setBounds(110, 20, 80, 25);
        panel.add(surChargeLabel);
        surChargeText.setBounds(200, 20, 165, 25);
        panel.add(surChargeText);

        JButton button = new JButton("Submit");
        button.addActionListener(this);
        panel.add(button);

        panel.add(outputLabel);

        frame.pack();
        frame.setVisible(true);

    }

    public static void viewHandler(TaxForm taxForm) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        TaxableEntity entity = getEntityFromUI(taxForm);

        if(entity == null) {
            System.out.println("Error in input");
            return;
        }

        boolean result = TaxComputationFacade.compute(entity);
        if(result) {
            System.out.println("success!");
            taxForm.outputLabel.setText(String.valueOf(entity.taxParams.taxLiability));
        } else {
            System.out.println("Failed");
        }
    }

    public static TaxableEntity getEntityFromUI(TaxForm taxForm) {
        TaxableEntity entity = new TaxableEntity();
        entity.taxParams = new TaxParamVO();

        entity.id = 1;
        entity.name = taxForm.nameText.getText();
        entity.age = Integer.parseInt(taxForm.ageText.getText());
        entity.sex = ((taxForm.sexText.getText()).charAt(0) == 'M' || (taxForm.sexText.getText()).charAt(0) == 'm') ? 'M': 'F';
        entity.location = taxForm.locationText.getText();

        entity.taxParams.da = Double.parseDouble(taxForm.daText.getText());
        entity.taxParams.basic = Double.parseDouble(taxForm.basicText.getText());
        entity.taxParams.allowance = Double.parseDouble(taxForm.allowanceText.getText());
        entity.taxParams.hra = Double.parseDouble(taxForm.hraText.getText());
        entity.taxParams.deductions = Double.parseDouble(taxForm.deductionText.getText());
        entity.taxParams.cess = Double.parseDouble(taxForm.cessText.getText());
        entity.taxParams.computed = false;
        return entity;
    }

    public static String computeArchetype(TaxableEntity entity) {
        return  (entity.age > 60 ) ? "SeniorCitizen" :"OrdinaryCitizen";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        outputLabel.setText("Calculating Tax Liability: ");
        try {
            viewHandler(this);
        } catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        } catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }
}
