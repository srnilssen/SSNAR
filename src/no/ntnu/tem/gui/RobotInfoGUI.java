/*
 * This code is written as a part of a Master Thesis
 * the spring of 2016.
 *
 * Thor Eivind Andersen and Mats Rødseth (Master 2016 @ NTNU)
 */
package no.ntnu.tem.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import no.ntnu.tem.robot.Robot;

/**
 * This class represents the robot-specific info window, containing information
 * about the robots position, orientation and corrupt message count. It provides
 * a button for opening the manual command window.
 *
 * @author Thor Eivind and Mats (Master 2016 @ NTNU)
 */
public class RobotInfoGUI extends javax.swing.JFrame {

    private Robot robot;
    private MainGUI mainGUI;
    private ManualDriveCartesianGUI manualDriveGUI;

    /**
     * Constructor of the class RobotInfoGUI
     */
    public RobotInfoGUI() {
        initComponents();
    }

    /**
     * Second constructor of the class RobotInfoGUI
     *
     * @param r robot to associate with the gui
     * @param mainGUI the main window of the application
     */
    public RobotInfoGUI(Robot r, MainGUI mainGUI) {
        initComponents();
        robot = r;
        lblRobotName.setText(robot.getName());
        setLocationRelativeTo(mainGUI);
        setTitle(r.getName());
        manualDriveGUI = new ManualDriveCartesianGUI(robot, mainGUI);
        this.mainGUI = mainGUI;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRobotName = new javax.swing.JLabel();
        pnlAttributes = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblyPos = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblxPos = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblRobotOrientation = new javax.swing.JLabel();
        lblCorrupt = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblBattery = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnManualDrive = new javax.swing.JButton();
        btnDiscRobot = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnResume = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblRobotName.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        lblRobotName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRobotName.setText("Robot Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Position:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("y:");

        lblyPos.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblyPos.setText("99999");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("x:");

        lblxPos.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblxPos.setText("99999");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Orientation:");

        lblRobotOrientation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblRobotOrientation.setText("9999");

        lblCorrupt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblCorrupt.setText("99999");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Corrupt messages:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Battery:");

        lblBattery.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblBattery.setText("11,1");

        javax.swing.GroupLayout pnlAttributesLayout = new javax.swing.GroupLayout(pnlAttributes);
        pnlAttributes.setLayout(pnlAttributesLayout);
        pnlAttributesLayout.setHorizontalGroup(
            pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAttributesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAttributesLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblxPos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblyPos))
                    .addGroup(pnlAttributesLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorrupt)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlAttributesLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRobotOrientation, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(pnlAttributesLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBattery, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        pnlAttributesLayout.setVerticalGroup(
            pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAttributesLayout.createSequentialGroup()
                .addGroup(pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(lblxPos)
                    .addComponent(jLabel3)
                    .addComponent(lblyPos)
                    .addComponent(jLabel6)
                    .addComponent(lblRobotOrientation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblCorrupt)
                    .addComponent(jLabel8)
                    .addComponent(lblBattery)))
        );

        btnManualDrive.setText("Manual Drive");
        btnManualDrive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManualDriveActionPerformed(evt);
            }
        });

        btnDiscRobot.setText("Disconnect Robot");
        btnDiscRobot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiscRobotActionPerformed(evt);
            }
        });

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnResume.setText("Resume");
        btnResume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnManualDrive, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnResume, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDiscRobot, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnManualDrive)
                .addComponent(btnDiscRobot)
                .addComponent(btnHome)
                .addComponent(btnResume))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRobotName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlAttributes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblRobotName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlAttributes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManualDriveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManualDriveActionPerformed
        manualDriveGUI.setVisible(true);
    }//GEN-LAST:event_btnManualDriveActionPerformed

    private void btnDiscRobotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiscRobotActionPerformed
        mainGUI.getApplication().disconnectRobot(robot.getName());
        this.dispose();
    }//GEN-LAST:event_btnDiscRobotActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        robot.setGoingHome(true);
        System.out.println("Home button");
        robot.setAtBase(false);
        robot.setDock(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnResumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumeActionPerformed
        robot.setGoingHome(false);
        robot.setConfirmPose(false);
        robot.setDock(false);
        robot.setAtBase(false);
        robot.setHome(false);
        robot.setRobotAligned(false);
        robot.setAdjustRobot(6);
    }//GEN-LAST:event_btnResumeActionPerformed

    /**
     * Method that starts the thread that updates the info in the window
     */
    private void startThread() {
        Thread updateThread = new Thread(robot.getName() + " Info Updater") {
            boolean running = true;

            @Override
            public void run() {
                while (running) {
                    if (isInterrupted()) {
                        running = false;
                    }
                    updateParams();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        interrupt();
                    }
                }
            }
        };
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                updateThread.interrupt();
            }
        });
        updateThread.start();
    }

    /**
     * Method that modifies the visibility of the window
     *
     * @param b true if visible
     */
    @Override
    public void setVisible(boolean b) {
        if (b) {
            startThread();
        }
        super.setVisible(b);
    }

    /**
     * Method for updating the parameters
     */
    private void updateParams() {
        lblRobotOrientation.setText("" + robot.getRobotOrientation());
        lblxPos.setText("" + robot.getPosition()[0]);
        lblyPos.setText("" + robot.getPosition()[1]);
        lblCorrupt.setText("" + robot.getCorruptCount());
        lblBattery.setText("" + robot.Bat2Screen());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDiscRobot;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnManualDrive;
    private javax.swing.JButton btnResume;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBattery;
    private javax.swing.JLabel lblCorrupt;
    private javax.swing.JLabel lblRobotName;
    private javax.swing.JLabel lblRobotOrientation;
    private javax.swing.JLabel lblxPos;
    private javax.swing.JLabel lblyPos;
    private javax.swing.JPanel pnlAttributes;
    // End of variables declaration//GEN-END:variables
}
