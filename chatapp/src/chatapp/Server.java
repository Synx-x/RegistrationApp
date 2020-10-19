package chatapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Server extends javax.swing.JFrame {

    //server variables
    static ServerSocket ssckt;
    static Socket sckt;
    static DataInputStream dis;
    static DataOutputStream dos;

    public Server() {
        initComponents();
    }

    //method for clearing text
    public void clearText() {
        txtbxfield.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtbxarea = new javax.swing.JTextArea();
        txtbxfield = new javax.swing.JTextField();
        btnsend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnsend1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server Chat");

        txtbxarea.setEditable(false);
        txtbxarea.setColumns(20);
        txtbxarea.setRows(5);
        jScrollPane1.setViewportView(txtbxarea);

        txtbxfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbxfieldActionPerformed(evt);
            }
        });

        btnsend.setText("Send");
        btnsend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsendActionPerformed(evt);
            }
        });

        jLabel2.setText("Server ");

        btnsend1.setText("Exit");
        btnsend1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsend1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtbxfield, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnsend)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnsend1)
                                .addGap(0, 6, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbxfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsend, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsend1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbxfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbxfieldActionPerformed
    }//GEN-LAST:event_txtbxfieldActionPerformed

    private void btnsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsendActionPerformed

        try {
            String msgout = "";
            //retrieves the time and formats the time to only have HH:MM:SS
            String currentTime = java.time.LocalTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME);
            msgout = txtbxfield.getText().trim();
            dos.writeUTF(msgout);
            txtbxarea.append("\n" + currentTime + " Server: " + msgout);

        } catch (Exception e) {
        }
        //clears text after message has been sent
        clearText();
    }//GEN-LAST:event_btnsendActionPerformed

    private void btnsend1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsend1ActionPerformed
        //exits program when clicked
        System.exit(0);
    }//GEN-LAST:event_btnsend1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });

        String msgin = "";
        try {
            //retrieves the time and formats the time to only have HH:MM:SS
            LocalTime currentTime = java.time.LocalTime.now();
            currentTime = currentTime.truncatedTo(ChronoUnit.SECONDS);
            //conntects to localhost on port 9000
            ssckt = new ServerSocket(9000);
            sckt = ssckt.accept();
            dis = new DataInputStream(sckt.getInputStream());
            dos = new DataOutputStream(sckt.getOutputStream());
            while (!msgin.equals("exit")) {
                msgin = dis.readUTF();
                txtbxarea.setText(txtbxarea.getText().trim() + "\n" + currentTime + " Client:" + msgin);
            }

        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsend;
    private javax.swing.JButton btnsend1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea txtbxarea;
    private javax.swing.JTextField txtbxfield;
    // End of variables declaration//GEN-END:variables

}
