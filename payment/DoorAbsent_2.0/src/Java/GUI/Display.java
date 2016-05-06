package Java.GUI;

import Java.Logic.MethodImpl;
import Java.Logic.MethodInfc;
import Java.Logic.Model;
import Java.Logic.Relay;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Display extends javax.swing.JFrame {

    public MethodInfc method = new MethodImpl();
    public Model model = new Model();
    Menu menu = new Menu("");
    
    public Display(int flag) {
        initComponents();
        StartUp(flag);
    }
    
    private void StartUp(int flag){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_SPACE) && 
                        ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                    menu.setVisible(true);
                    menu.setDefaultCloseOperation(Menu.DISPOSE_ON_CLOSE);
                    menu.setLocationRelativeTo(null);   
                }
            }
        });
        
        method.Set_Port(0);
        if(flag==0){
            File file = new File("resources/urlserver.txt");
            if(file.exists()){
                method.Get_Auth();
            }
            method.Access_ByCard(this, model);
        }
        else if(flag==1){
            Relay relay = new Relay();
            method.Relay_ByPin(this, relay);
        }
        Date date = new Date();
        dateLbl.setText(method.Get_DateTime());
        method.Clock(dateLbl);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PaneUtama = new javax.swing.JPanel();
        panelSSIC = new javax.swing.JPanel();
        headerText = new javax.swing.JLabel();
        panelIcon = new javax.swing.JPanel();
        labelIconLock = new javax.swing.JLabel();
        panelDate = new javax.swing.JPanel();
        dateLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PaneUtama.setBackground(new java.awt.Color(0, 153, 204));

        panelSSIC.setBackground(new java.awt.Color(0, 153, 204));

        headerText.setFont(new java.awt.Font("Times New Roman", 1, 72)); // NOI18N
        headerText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerText.setText("SCCIC");
        headerText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelSSICLayout = new javax.swing.GroupLayout(panelSSIC);
        panelSSIC.setLayout(panelSSICLayout);
        panelSSICLayout.setHorizontalGroup(
            panelSSICLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSSICLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelSSICLayout.setVerticalGroup(
            panelSSICLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSSICLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(headerText, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        panelIcon.setBackground(new java.awt.Color(0, 153, 204));

        labelIconLock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconLock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/lock_on.png"))); // NOI18N
        labelIconLock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelIconLock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelIconLockMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelIconLayout = new javax.swing.GroupLayout(panelIcon);
        panelIcon.setLayout(panelIconLayout);
        panelIconLayout.setHorizontalGroup(
            panelIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIconLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelIconLock)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelIconLayout.setVerticalGroup(
            panelIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIconLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelIconLock)
                .addGap(10, 10, 10))
        );

        panelDate.setBackground(new java.awt.Color(0, 153, 204));

        dateLbl.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        dateLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelDateLayout = new javax.swing.GroupLayout(panelDate);
        panelDate.setLayout(panelDateLayout);
        panelDateLayout.setHorizontalGroup(
            panelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelDateLayout.setVerticalGroup(
            panelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDateLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout PaneUtamaLayout = new javax.swing.GroupLayout(PaneUtama);
        PaneUtama.setLayout(PaneUtamaLayout);
        PaneUtamaLayout.setHorizontalGroup(
            PaneUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneUtamaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PaneUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSSIC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PaneUtamaLayout.setVerticalGroup(
            PaneUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneUtamaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelSSIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(panelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(panelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PaneUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PaneUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelIconLockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconLockMouseClicked
        method.Direct_ToKeypad(this);
    }//GEN-LAST:event_labelIconLockMouseClicked

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (info.getName().equals("Nimbus")) {
                    UIManager.setLookAndFeel(info.getClassName());
                    UIDefaults defaults = UIManager.getLookAndFeelDefaults();
                    defaults.put("Table.gridColor", new Color (214,217,223));
                    defaults.put("Table.showGrid", true);
                    defaults.put("Table.intercellSpacing", new Dimension(1, 1));
                }
            }
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException 
                | InstantiationException | IllegalAccessException ex) {
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Display display = new Display(0);
                display.setVisible(true);
                display.setDefaultCloseOperation(Display.DISPOSE_ON_CLOSE);
                display.setExtendedState(JFrame.MAXIMIZED_BOTH);
                display.method.CreateResources(display.model);
                display.method.Process_UpdateUID(display.model);
                display.method.Update_ListUID(display.model);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PaneUtama;
    public javax.swing.JLabel dateLbl;
    public javax.swing.JLabel headerText;
    public javax.swing.JLabel labelIconLock;
    private javax.swing.JPanel panelDate;
    private javax.swing.JPanel panelIcon;
    private javax.swing.JPanel panelSSIC;
    // End of variables declaration//GEN-END:variables
}
