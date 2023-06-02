/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DAO.TaskDAO;
import DAO.UserDAO;
import Models.FeedbackModel;
import Models.RepublicModel;
import Models.TaskModel;
import Models.UserModel;
import Views.MyTasksView;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author gabri
 */
public class MyTasksController {
    private RepublicController republicController;
    private MyTasksView tasksView;
    private ArrayList<TaskModel> tasks;
    private TaskDAO taskDAO;
    private RepublicModel republic;
    private UUID userId;
    
    public MyTasksController(RepublicController republicController) {
        this.republicController = republicController;
        this.tasksView = new MyTasksView(this);
        this.taskDAO = new TaskDAO();
    }
    
    public void view() {
        this.load();
        this.tasksView.setVisible(true);
    }
    
    public void load() {
        this.tasks =  this.taskDAO.getAllTasksOfUser(this.userId.toString());
        this.tasksView.setTasks(tasks);
        this.tasksView.load();
    }
    
    public void close() {
        this.tasksView.setVisible(false);
    }
    
    public void republicView() {
        this.close();
        this.republicController.view();
    }
    public void setUserId(UUID userId) {
        System.out.println("userID" + userId);
        this.userId = userId;
    }
}
