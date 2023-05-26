/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controllers.MyProfileController;
import Controllers.RepublicController;
import Models.FeedbackModel;
import Models.RepublicModel;
import Models.TaskModel;
import Models.UserModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabri
 */
public class MyProfileView extends javax.swing.JFrame {
    private UserModel profile; 
    private ArrayList<FeedbackModel> feedbacks;
    private MyProfileController myProfileController;
    
    public void setProfile(UserModel user, RepublicModel republic, ArrayList<FeedbackModel> feedbacks) {
        this.profile = user;
        this.nameField.setText(user.getName());
        this.usernameField.setText(user.getUsername());
        this.feedbacks = feedbacks;
        if (republic != null) {
            this.republicLabel.setText("República: " + republic.getName());
        } else {
            this.republicLabel.setText("República: -");
        }
        
        System.out.println(feedbacks);

        //add feedbacks to this.feedbacksTable

        DefaultTableModel model = (DefaultTableModel) this.feedbacksTable.getModel();
        model.setRowCount(0);
        for (FeedbackModel feedback : feedbacks) {
            TaskModel task = this.myProfileController.getTaskFeedback(feedback.getTaskUuid().toString());
            UserModel userrep = this.myProfileController.getUserFeedback(feedback.getUserUuid().toString());
            model.addRow(new Object[]{task.getTitle(), this.profile.getName(), feedback.getScore(), feedback.getCreatedAt()});
        }
    }
    
    /**
     * Creates new form MyProfileView
     */
    public MyProfileView(MyProfileController myProfileController) {
        this.myProfileController = myProfileController;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        oldPasswordField = new javax.swing.JPasswordField();
        nameField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        republicLabel = new javax.swing.JLabel();
        feedbackPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        feedbacksTable = new javax.swing.JTable();
        usernameField = new javax.swing.JLabel();
        newPasswordField = new javax.swing.JPasswordField();
        confirmNewPasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        contentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Meu Perfil"));

        oldPasswordField.setBorder(javax.swing.BorderFactory.createTitledBorder("Senha Atual"));

        nameField.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));

        saveButton.setBackground(new java.awt.Color(76, 180, 82));
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Salvar");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        republicLabel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        republicLabel.setText("República");

        feedbackPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Feedbacks"));

        feedbacksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tarefa", "Usuário", "Score", "Criação"
            }
        ));
        jScrollPane1.setViewportView(feedbacksTable);

        javax.swing.GroupLayout feedbackPanelLayout = new javax.swing.GroupLayout(feedbackPanel);
        feedbackPanel.setLayout(feedbackPanelLayout);
        feedbackPanelLayout.setHorizontalGroup(
            feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feedbackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );
        feedbackPanelLayout.setVerticalGroup(
            feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feedbackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addContainerGap())
        );

        usernameField.setText("Usuário");
        usernameField.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuário"));

        newPasswordField.setBorder(javax.swing.BorderFactory.createTitledBorder("Nova Senha"));

        confirmNewPasswordField.setBorder(javax.swing.BorderFactory.createTitledBorder("Confirmar Nova Senha"));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmNewPasswordField)
                    .addComponent(nameField)
                    .addComponent(republicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(oldPasswordField)
                    .addComponent(feedbackPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newPasswordField)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField)
                .addGap(8, 8, 8)
                .addComponent(oldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(republicLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton)
                .addGap(18, 18, 18)
                .addComponent(feedbackPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        saveButton.setOpaque(true);
        saveButton.setBorderPainted(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            String name = this.nameField.getText();
            String oldPassword = new String(this.oldPasswordField.getPassword());
            String newPassword = new String(this.newPasswordField.getPassword());
            String confirmNewPassword = new String(this.confirmNewPasswordField.getPassword());

            if (name.isEmpty() && oldPassword.isEmpty() && newPassword.isEmpty() && confirmNewPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            this.myProfileController.updateUser(name, oldPassword, newPassword, confirmNewPassword);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, error.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmNewPasswordField;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel feedbackPanel;
    private javax.swing.JTable feedbacksTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JPasswordField oldPasswordField;
    private javax.swing.JLabel republicLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel usernameField;
    // End of variables declaration//GEN-END:variables
}
