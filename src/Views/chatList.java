/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.UserController;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author naufalabdillah
 */
public class chatList extends javax.swing.JFrame {
    UserController ctr = new UserController();
    String user_now;
    /**
     * Creates new form chatList
     */
    
    public void fillFriends(String user_now){
        this.user_now = user_now;
        DefaultListModel listModel = new DefaultListModel();
        ArrayList<String> friends = new ArrayList<>();
        friends = ctr.findFriends(user_now);
        for(String f : friends){
            listModel.addElement(f);
        }
        friend_list.setModel(listModel);
    }
    
    public void list_clear(){
        DefaultListModel listModel = new DefaultListModel();
        listModel.clear();
        friend_list.setModel(listModel);
    }
    
    public chatList(String user_now) {
        initComponents();
        fillFriends(user_now);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        friend_list = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        name_disp = new javax.swing.JLabel();
        time_disp = new javax.swing.JLabel();
        btn_open = new javax.swing.JButton();
        btn_add_friend = new javax.swing.JButton();
        btn_reload = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        friend_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                friend_listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(friend_list);

        jLabel1.setText("Name: ");

        jLabel2.setText("Last Online: ");

        time_disp.setText("WIP");

        btn_open.setText("Open");
        btn_open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openActionPerformed(evt);
            }
        });

        btn_add_friend.setText("Add Friend");
        btn_add_friend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_friendActionPerformed(evt);
            }
        });

        btn_reload.setText("Reload");
        btn_reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reloadActionPerformed(evt);
            }
        });

        btn_logout.setText("Logout");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_reload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_add_friend))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btn_open))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(54, 54, 54)
                                .addComponent(name_disp))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(time_disp))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(name_disp))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(time_disp))
                        .addGap(32, 32, 32)
                        .addComponent(btn_open)
                        .addGap(38, 38, 38)
                        .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add_friend)
                    .addComponent(btn_reload))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openActionPerformed
        // TODO add your handling code here:
        String selectedFriend = friend_list.getSelectedValue();
        
        chatWindow chatWindow = new chatWindow(user_now, selectedFriend);
        chatWindow.show();
        this.dispose();
    }//GEN-LAST:event_btn_openActionPerformed

    private void btn_add_friendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_friendActionPerformed
        // TODO add your handling code here:
        AddFriendDialog d = new AddFriendDialog(this, true, user_now);
        d.show();
    }//GEN-LAST:event_btn_add_friendActionPerformed

    private void friend_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_friend_listMouseClicked
        // TODO add your handling code here:
        int index = friend_list.getSelectedIndex();
        name_disp.setText(friend_list.getSelectedValue());
    }//GEN-LAST:event_friend_listMouseClicked

    private void btn_reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reloadActionPerformed
        // TODO add your handling code here:
        fillFriends(user_now);
    }//GEN-LAST:event_btn_reloadActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
        LoginView login = new LoginView();
        login.show();
        this.dispose();
    }//GEN-LAST:event_btn_logoutActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_friend;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_open;
    private javax.swing.JButton btn_reload;
    private javax.swing.JList<String> friend_list;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel name_disp;
    private javax.swing.JLabel time_disp;
    // End of variables declaration//GEN-END:variables
}
