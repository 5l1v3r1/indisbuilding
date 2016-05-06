package Java.GUI;

import java.util.ArrayList;
import java.util.List;

public class Keypad extends javax.swing.JFrame {

    public List<String> list = new ArrayList<>();
    public List<String> simbol = new ArrayList<>();
    public Display frame;
    
    public Keypad(Display frame) {
        initComponents();
        StartUp(frame);
    }
    
    private void StartUp(Display frame){
        this.frame=frame;
        autoDirect();
        frame.method.Register_UID(this, frame.model);
        pinText.setText("_________");
    }
    
    public String PIN(){
        StringBuilder sb = new StringBuilder();
        for (String s : list){
            sb.append(s);
        }
        return sb.toString();
    }
    
    private String SIMBOL(){
        StringBuilder sb = new StringBuilder();
        for (String s : simbol){
            sb.append(s);
        }
        return sb.toString();
    }
    
    public void autoDirect(){
        frame.method.AutoDirect_ToDisplay(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_0 = new javax.swing.JLabel();
        lbl_enterDown = new javax.swing.JLabel();
        lbl_clearDown = new javax.swing.JLabel();
        lbl_clearUp = new javax.swing.JLabel();
        lbl_enterUp = new javax.swing.JLabel();
        lbl_8 = new javax.swing.JLabel();
        lbl_7 = new javax.swing.JLabel();
        lbl_9 = new javax.swing.JLabel();
        lbl_5 = new javax.swing.JLabel();
        lbl_6 = new javax.swing.JLabel();
        lbl_4 = new javax.swing.JLabel();
        lbl_3 = new javax.swing.JLabel();
        lbl_1 = new javax.swing.JLabel();
        lbl_2 = new javax.swing.JLabel();
        pinText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        lbl_0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/0.png"))); // NOI18N
        lbl_0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_0MouseClicked(evt);
            }
        });

        lbl_enterDown.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_enterDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/enterDown.png"))); // NOI18N
        lbl_enterDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_enterDownMouseClicked(evt);
            }
        });

        lbl_clearDown.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_clearDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/clearDown.png"))); // NOI18N
        lbl_clearDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_clearDownMouseClicked(evt);
            }
        });

        lbl_clearUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_clearUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/clearUp.png"))); // NOI18N
        lbl_clearUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_clearUpMouseClicked(evt);
            }
        });

        lbl_enterUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_enterUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/enterUp.png"))); // NOI18N
        lbl_enterUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_enterUpMouseClicked(evt);
            }
        });

        lbl_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/8.png"))); // NOI18N
        lbl_8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_8MouseClicked(evt);
            }
        });

        lbl_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/7.png"))); // NOI18N
        lbl_7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_7MouseClicked(evt);
            }
        });

        lbl_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/9.png"))); // NOI18N
        lbl_9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_9MouseClicked(evt);
            }
        });

        lbl_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/5.png"))); // NOI18N
        lbl_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_5MouseClicked(evt);
            }
        });

        lbl_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/6.png"))); // NOI18N
        lbl_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_6MouseClicked(evt);
            }
        });

        lbl_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/4.png"))); // NOI18N
        lbl_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_4MouseClicked(evt);
            }
        });

        lbl_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3.png"))); // NOI18N
        lbl_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_3MouseClicked(evt);
            }
        });

        lbl_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1.png"))); // NOI18N
        lbl_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_1MouseClicked(evt);
            }
        });

        lbl_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/2.png"))); // NOI18N
        lbl_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_clearUp)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_7)
                            .addComponent(lbl_4))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_5)
                            .addComponent(lbl_8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_clearDown)
                        .addGap(2, 2, 2)
                        .addComponent(lbl_0, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_1)
                        .addGap(2, 2, 2)
                        .addComponent(lbl_2)))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(lbl_9)
                            .addGap(1, 1, 1)
                            .addComponent(lbl_enterUp))
                        .addComponent(lbl_enterDown))
                    .addComponent(lbl_3)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_3)
                    .addComponent(lbl_2)
                    .addComponent(lbl_1))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_5)
                    .addComponent(lbl_6)
                    .addComponent(lbl_4))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_clearUp)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_clearDown, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbl_7)
                                .addComponent(lbl_8)
                                .addComponent(lbl_9))
                            .addComponent(lbl_enterUp, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_enterDown)
                            .addComponent(lbl_0))))
                .addGap(0, 0, 0))
        );

        pinText.setFont(new java.awt.Font("Tahoma", 0, 72)); // NOI18N
        pinText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pinText.setText("_________");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pinText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pinText, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_0MouseClicked
        list.add("0");
        simbol.add("*");
        pinText.setText(SIMBOL());
    }//GEN-LAST:event_lbl_0MouseClicked

    private void lbl_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_1MouseClicked
        list.add("1");
        simbol.add("*");
        pinText.setText(SIMBOL());
    }//GEN-LAST:event_lbl_1MouseClicked

    private void lbl_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_2MouseClicked
        list.add("2");
        simbol.add("*");
        pinText.setText(SIMBOL());
    }//GEN-LAST:event_lbl_2MouseClicked

    private void lbl_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_3MouseClicked
        list.add("3");
        simbol.add("*");
        pinText.setText(SIMBOL());
    }//GEN-LAST:event_lbl_3MouseClicked

    private void lbl_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_4MouseClicked
        list.add("4");
        simbol.add("*");
        pinText.setText(SIMBOL());
    }//GEN-LAST:event_lbl_4MouseClicked

    private void lbl_5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_5MouseClicked
        list.add("5");
        simbol.add("*");
        pinText.setText(SIMBOL());
    }//GEN-LAST:event_lbl_5MouseClicked

    private void lbl_6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_6MouseClicked
        list.add("6");
        simbol.add("*");
        pinText.setText(SIMBOL());
    }//GEN-LAST:event_lbl_6MouseClicked

    private void lbl_7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_7MouseClicked
        list.add("7");
        simbol.add("*");
        pinText.setText(SIMBOL());
    }//GEN-LAST:event_lbl_7MouseClicked

    private void lbl_8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_8MouseClicked
        list.add("8");
        simbol.add("*");
        pinText.setText(SIMBOL());
    }//GEN-LAST:event_lbl_8MouseClicked

    private void lbl_9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_9MouseClicked
        list.add("9");
        simbol.add("*");
        pinText.setText(SIMBOL());
    }//GEN-LAST:event_lbl_9MouseClicked

    private void lbl_enterDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_enterDownMouseClicked
        frame.method.Access_ByPIN(this, frame.model);    
    }//GEN-LAST:event_lbl_enterDownMouseClicked

    private void lbl_enterUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_enterUpMouseClicked
        frame.method.Access_ByPIN(this, frame.model);  
    }//GEN-LAST:event_lbl_enterUpMouseClicked

    private void lbl_clearDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_clearDownMouseClicked
        String txt = pinText.getText();
        if(txt.matches("_________")){
            frame.method.Direct_ToDisplay(this, 0);
        }
        else{
            list.clear();
            simbol.clear();
            pinText.setText("_________");
            pinText.setFont(new java.awt.Font("Tahoma", 0, 72));
        }       
    }//GEN-LAST:event_lbl_clearDownMouseClicked

    private void lbl_clearUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_clearUpMouseClicked
        String txt = pinText.getText();
        if(txt.matches("_________")){
            frame.method.Direct_ToDisplay(this, 0);
        }
        else{
            list.clear();
            simbol.clear();
            pinText.setText("_________");
            pinText.setFont(new java.awt.Font("Tahoma", 0, 72));
        }         
    }//GEN-LAST:event_lbl_clearUpMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_0;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_2;
    private javax.swing.JLabel lbl_3;
    private javax.swing.JLabel lbl_4;
    private javax.swing.JLabel lbl_5;
    private javax.swing.JLabel lbl_6;
    private javax.swing.JLabel lbl_7;
    private javax.swing.JLabel lbl_8;
    private javax.swing.JLabel lbl_9;
    private javax.swing.JLabel lbl_clearDown;
    private javax.swing.JLabel lbl_clearUp;
    private javax.swing.JLabel lbl_enterDown;
    private javax.swing.JLabel lbl_enterUp;
    public javax.swing.JLabel pinText;
    // End of variables declaration//GEN-END:variables
}
