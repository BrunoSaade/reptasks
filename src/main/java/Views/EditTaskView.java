/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controllers.RepublicController;
import Models.TaskModel;
import Models.UserModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class EditTaskView extends javax.swing.JFrame {
    private RepublicController republicController;
    private ArrayList<UserModel> usersModel;
    private TaskModel taskModel;
    private UserModel selectedUser;
    
    public void closeView() {
        this.dispose();
    }
    
    public void setUsers(ArrayList<UserModel> usersModel) {
        this.usersModel = usersModel;
        this.setUserList();
    }
    
    public void setUserList() {
        DefaultListModel listModel = new DefaultListModel();
        for (UserModel userModel : this.usersModel) {
            listModel.addElement(userModel.getName());
        }
        this.userList.setModel(listModel);
    }
    
    public void setSelectedUser(UserModel user) {
        this.selectedUser = user;
    }
    
    public void setTaskModel(TaskModel task) {
        this.taskModel = task;
    }
    
    public void load() {
        this.titleField.setText(this.taskModel.getTitle());
        this.descriptionArea.setText(this.taskModel.getDescription());
        
        if (this.taskModel.getExpiresAt() != null) {
            try {
                String expires = this.taskModel.getExpiresAt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                this.expiresField.setText(expires);
            } catch (Exception error) {
                System.out.println(error.getMessage());
            }
        }
        
        if (this.selectedUser != null) {
            int id = 0;
            for (UserModel user : this.usersModel) {
                if (user.getUuid().equals(this.selectedUser.getUuid())) {
                    this.userList.setSelectedIndex(id);
                }
                id++;
            }
        }
    }
            
    /**
     * Creates new form EditTaskView
     */
    public EditTaskView(RepublicController republicController) {
        this.republicController = republicController;
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
        titleField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList<>();
        editButton = new javax.swing.JButton();
        expiresField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        contentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tarefa"));

        titleField.setBorder(javax.swing.BorderFactory.createTitledBorder("Título"));

        descriptionArea.setColumns(20);
        descriptionArea.setRows(5);
        descriptionArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));
        jScrollPane1.setViewportView(descriptionArea);

        userList.setBorder(javax.swing.BorderFactory.createTitledBorder("Responsável"));
        userList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(userList);

        editButton.setBackground(new java.awt.Color(176, 180, 82));
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Atualizar Tarefa");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        expiresField.setBorder(javax.swing.BorderFactory.createTitledBorder("Expiração / Deadline"));

        jLabel1.setText("Exemplo: 20/06/1997 20:35");

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(expiresField)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(expiresField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(editButton)
                .addContainerGap())
        );

        editButton.setOpaque(true);
        editButton.setBorderPainted(false);

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

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        try {
            
            String title = this.titleField.getText().trim();
            String description = this.descriptionArea.getText();
            String deadline = this.expiresField.getText();
            int userId = this.userList.getSelectedIndex();

            String userUuid = this.usersModel.get(userId).getUuid().toString();

            if (title.isEmpty() || description.isEmpty() || deadline.isEmpty() || userId == -1 || userUuid.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                LocalDateTime expiresAt = LocalDateTime.parse(deadline, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

                this.republicController.editTask(this.taskModel.getUuid().toString(), title, description, userUuid, expiresAt);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Data inválida", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Dados inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_editButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField expiresField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField titleField;
    private javax.swing.JList<String> userList;
    // End of variables declaration//GEN-END:variables
}
