/*
 * This code is written as a part of a Master Thesis
 * the spring of 2016.
 *
 * Eirik Thon(Master 2016 @ NTNU)
 */
package no.ntnu.et.simulator;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JViewport;
import javax.swing.Timer;
import no.ntnu.et.general.Pose;
/**
 * This class is the main GUI frame of the simulator and connects all of the
 * GUI
 * @author Eirik Thon
 */
public class SimulatorGUI extends JFrame {
    private Simulator simulator;
    private InitialPoseDialog initDiag;
    private SimWorld world;
    private JDialog mapDiag;
    private GraphicContent content;
    
    /**
     * Constructor.
     * @param simulator Simulator
     * @param world SimWorld
     */
    public SimulatorGUI(Simulator simulator, SimWorld world) {
        initComponents();
        initDiag = new InitialPoseDialog(this, world, simulator);
        mapDiag = new JDialog(this, false);
        this.world = world;
        this.simulator = simulator;
        initMapDialog();
        
        content = new GraphicContent(world);
        content.setVisible(true);
        contentPanel.add(content);
        DisplayHandler displayHandler = this.new DisplayHandler();
        Timer updateDisplay = new Timer(10, displayHandler);
        updateDisplay.start();
        
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                if(evt.isControlDown()){
                    zoom(evt.getUnitsToScroll());
                }
            }
        });
        
        ViewportDragListener l = new ViewportDragListener(content);
        JViewport v = jScrollPane1.getViewport();
        v.addMouseMotionListener(l);
        v.addMouseListener(l);
        
        populateButton.setVisible(false); // this button is a shortcut to easily make 3 robots ant is not displayed by default
    }
    
    class ViewportDragListener extends MouseAdapter {
        private final Cursor defaultCursor;
        private final Cursor handCursor = Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
        private final JComponent label;
        private final Point startPt = new Point();

        public ViewportDragListener(JComponent comp) {
            super();
            this.label = comp;
            this.defaultCursor = comp.getCursor();
        }
        
        
        @Override public void mouseDragged(MouseEvent e) {
            JViewport vport = (JViewport) e.getComponent();
            Point pt = e.getPoint();
            int dx = startPt.x - pt.x;
            int dy = startPt.y - pt.y;
            Point vp = vport.getViewPosition();
            vp.translate(dx, dy);
            label.scrollRectToVisible(new Rectangle(vp, vport.getSize()));
            startPt.setLocation(pt);
        }
        
        @Override public void mousePressed(MouseEvent e) {
            e.getComponent().setCursor(handCursor); //label.setCursor(handCursor);
            startPt.setLocation(e.getPoint());
        }
        
        @Override public void mouseReleased(MouseEvent e) {
            e.getComponent().setCursor(defaultCursor); //label.setCursor(defaultCursor);
        }
        
        @Override public void mouseExited(MouseEvent e) {
            e.getComponent().setCursor(defaultCursor); //label.setCursor(defaultCursor);
        }
    }
    
    void zoom(int zoomAmount) {
        content.changeScale(-zoomAmount);
        int scale = (int)Math.round(content.getScale()*100);
        jLabel7.setText(scale + "%");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        newRobotButton = new javax.swing.JButton();
        populateButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSlider2 = new javax.swing.JSlider();
        jLabel8 = new javax.swing.JLabel();
        selectMapButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contentPanel = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setTitle("Simulator");
        setFocusCycleRoot(false);
        setSize(new java.awt.Dimension(779, 780));

        newRobotButton.setText("Create new robot");
        newRobotButton.setToolTipText("Add a new robot to the simulator.");
        newRobotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRobotButtonActionPerformed(evt);
            }
        });

        populateButton.setText("Populate world");
        populateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                populateButtonActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Display options");

        jCheckBox10.setText("Show estimated positions");
        jCheckBox10.setToolTipText("Show the the location of each robot's estimated pose");
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });

        jCheckBox6.setText("Show target positions");
        jCheckBox6.setToolTipText("Show the target-location given by the last command for each of the robots");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jLabel2.setText("Zoom:");

        jCheckBox2.setText("Show sensor beams");
        jCheckBox2.setToolTipText("Show the line of sight of the sensors for each robot.");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel7.setText("100%");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 83, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jCheckBox6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox2)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox10)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox6)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox2)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCheckBox7.setText("No estimate error");
        jCheckBox7.setToolTipText("Remove estimate error. (This only stops the error from accumulating further)");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jCheckBox8.setText("No measurement error");
        jCheckBox8.setToolTipText("Remove measurement-error");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        jLabel4.setText("Simulation options");

        jLabel6.setText("Simulation speed:");

        jSlider2.setMajorTickSpacing(50);
        jSlider2.setMinorTickSpacing(2);
        jSlider2.setPaintTicks(true);
        jSlider2.setSnapToTicks(true);
        jSlider2.setToolTipText("Change simulation-speed");
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });

        jLabel8.setText("100%");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox7)
                            .addComponent(jCheckBox8)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox8)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox7)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        selectMapButton.setText("Select map");
        selectMapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectMapButtonActionPerformed(evt);
            }
        });

        jPanel2.setPreferredSize(new java.awt.Dimension(601, 601));

        jScrollPane1.setWheelScrollingEnabled(false);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 812, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(contentPanel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newRobotButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(populateButton)
                    .addComponent(selectMapButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(newRobotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(selectMapButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(populateButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        simulator.flipEstimateNoiseEnabled();
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        content.flipShowTarget();
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
        content.flipShowEstimatedPose();
    }//GEN-LAST:event_jCheckBox10ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        simulator.flipSensorNoiseEnabled();
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        JSlider source = (JSlider)evt.getSource();
        if (!source.getValueIsAdjusting()) {
            // This formula is only used to get an exponensial slider
            int speed = (int)Math.round(1-(0.5401623/0.0441455)*(1-Math.exp(0.0441455*source.getValue())));
            simulator.setSimulationSpeed(speed);
            jLabel8.setText(speed + "%");
        }
    }//GEN-LAST:event_jSlider2StateChanged

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        content.flipShowSensorBeams();
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void newRobotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRobotButtonActionPerformed
        initDiag.setLocationRelativeTo(this);
        initDiag.setVisible(true);
    }//GEN-LAST:event_newRobotButtonActionPerformed

    private void populateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_populateButtonActionPerformed

    }//GEN-LAST:event_populateButtonActionPerformed

    private void selectMapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectMapButtonActionPerformed
        // TODO add your handling code here:
        mapDiag.setLocationRelativeTo(this);
        mapDiag.setVisible(true);
    }//GEN-LAST:event_selectMapButtonActionPerformed

    void checkMeasurementErrorOff () {
        jCheckBox8.setSelected(true);
    }
    
    void checkEstimationErrorOff () {
        jCheckBox7.setSelected(true);
    }
    
    void initMapDialog(){
        File mapFolder = new File("maps");
        DefaultListModel<String> listModel = new DefaultListModel();
        //mapList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        File[] allMaps = mapFolder.listFiles();
        for (int i = 0; i < allMaps.length; i++) {
            if (allMaps[i].isFile()) {
                String fileName = allMaps[i].getName();
                listModel.addElement(fileName);
            }
        }
        JList<String> mapList = new JList(listModel);
        //int selectedIndex = mapList.
        
        mapList.setSelectedValue(listModel.get(0), true);
        JScrollPane sp = new JScrollPane(mapList);
        Container contentPane = mapDiag.getContentPane();
        contentPane.add(sp, BorderLayout.CENTER);
        
        JButton selectBtn = new JButton();
        selectBtn.setText("Select");
        selectBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedMap = mapList.getSelectedValue();
                String fileName = "maps\\" + selectedMap;
                world.initMap(fileName);
                mapDiag.setVisible(false);
                content.updateDimension();
            }
        });
        contentPane.add(selectBtn, BorderLayout.SOUTH);
        mapDiag.setSize(150, 200);
        mapDiag.setTitle("Select map");
    }
    
    private class DisplayHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            contentPanel.setPreferredSize(content.getSize());
            contentPanel.revalidate();
            content.repaint();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JButton newRobotButton;
    private javax.swing.JButton populateButton;
    private javax.swing.JButton selectMapButton;
    // End of variables declaration//GEN-END:variables
    
}