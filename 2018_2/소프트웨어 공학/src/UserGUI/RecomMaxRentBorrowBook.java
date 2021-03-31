package UserGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DBtask.selectTask;
import UserTask.User;

class RecomMaxRentBorrowBook implements ActionListener {

	   int rank= 0;
	   User user;
	   RecomMaxRentBorrowBook(User user,int rank){
	      this.user = user;
	      this.rank=rank;
	   }
	   
	   
	   public void actionPerformed(ActionEvent arg0) {
	      selectTask seltask = new selectTask();
	      seltask.RecomMaxRentBorrowBook(user , rank);
	      
	   }
	   
	}