/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package application.views;

import application.models.UserModel;
import application.utils.DatabaseUtil;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 *
 * @author mhdja
 */
public class MenuView extends javax.swing.JFrame {
    private UserModel loggedInUser;
    /**
     * Creates new form MenuView
     */
    public MenuView(UserModel user) {
        this.loggedInUser = user; // Simpan data user yang login
        initComponents();
        
        MainContent.add(Home);
        MainContent.repaint();
        MainContent.revalidate();
        
//        restrictAccess();
    }
   
    public void start(UserModel user){
        JFrame frame = new MenuView(user);
        frame.setTitle("Menu Utama");
        
        UIManager.put("OptionPane.yesButtonText", "Ya");
        UIManager.put("OptionPane.noButtonText", "Tidak");
        
        // Membuka jendela dalam mode fullscreen
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JFrame frame = (JFrame)e.getSource();

                int result = JOptionPane.showConfirmDialog(
                    frame,
                    "Apakah Anda yakin ingin keluar dari aplikasi?",
                    "Keluar dari Aplikasi",
                    JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION){
                    DatabaseUtil.getInstance().closeConnection();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    System.exit(0);
                }
            }
        });
        
        Home.setLayout(new GridBagLayout()); // agar isi panel di tengah otomatis
       
        JLabel homeLabel = new JLabel("Selamat datang di aplikasi kami!");
        homeLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        Home.add(homeLabel); // otomatis di tengah
        
        // Panel utama
        jPanel1.setLayout(new BorderLayout()); // penting supaya anak komponen fleksibel ukurannya

        Sidebar.setBackground(Color.BLACK);
        Sidebar.setPreferredSize(new Dimension(250, 0)); // 200px lebar, tinggi otomatis
        jPanel1.add(Sidebar, BorderLayout.WEST);
        
        jPanel2.setLayout(new BorderLayout());
        
        Header.setLayout(new BorderLayout());
        Header.setBackground(Color.GRAY);
        Header.setPreferredSize(new Dimension(0, 120));
        Header.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 40)); // Padding: atas, kiri, bawah, kanan

        // Panel kanan atas buat label user
        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setLayout(new BoxLayout(userInfoPanel, BoxLayout.Y_AXIS));
        userInfoPanel.setOpaque(false); // Biar background-nya transparan

        // Label 1: Selamat datang
        JLabel welcomeLabel = new JLabel("Selamat datang, Admin");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        welcomeLabel.setAlignmentX(Component.RIGHT_ALIGNMENT); // Penting buat posisi kanan

        // Label 2: Role
        JLabel roleLabel = new JLabel("Role Kamu adalah, Admin");
        roleLabel.setForeground(Color.WHITE);
        roleLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        roleLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        // Tambahkan ke panel userInfo
        userInfoPanel.add(welcomeLabel);
        userInfoPanel.add(Box.createVerticalStrut(5)); // Jarak antar label
        userInfoPanel.add(roleLabel);

        // Tambahkan ke Header di kanan
        Header.add(userInfoPanel, BorderLayout.EAST);

        // MainContent (di bawah header)
        MainContent.setBackground(Color.WHITE);
        MainContent.setPreferredSize(new Dimension(0, 600));
        
        // Tambahkan header dan main content ke panel tengah
        jPanel2.add(Header, BorderLayout.NORTH);
        jPanel2.add(MainContent, BorderLayout.CENTER);
        
        jPanel1.add(jPanel2, BorderLayout.CENTER);
        
        // Set ke frame
        frame.setContentPane(jPanel1);
        
        frame.setVisible( true );   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Home = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Sidebar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        listData = new javax.swing.JLabel();
        profil = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        perhitunganSPK = new javax.swing.JLabel();
        dataTraining = new javax.swing.JLabel();
        prediksi = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        MainContent = new javax.swing.JPanel();

        Home.setPreferredSize(new java.awt.Dimension(700, 700));

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Sidebar.setBackground(new java.awt.Color(0, 0, 0));
        Sidebar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SidebarMouseEntered(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("              KELUAR");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        listData.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        listData.setForeground(new java.awt.Color(255, 255, 255));
        listData.setText("      DATA KARYAWAN");
        listData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listDataMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listDataMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                listDataMouseExited(evt);
            }
        });

        profil.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        profil.setForeground(new java.awt.Color(255, 255, 255));
        profil.setText("      REGISTER");
        profil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profilMouseExited(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/logo_yakult.png"))); // NOI18N

        perhitunganSPK.setBackground(new java.awt.Color(0, 0, 0));
        perhitunganSPK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        perhitunganSPK.setForeground(new java.awt.Color(255, 255, 255));
        perhitunganSPK.setText("      PERHITUNGAN");
        perhitunganSPK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                perhitunganSPKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                perhitunganSPKMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                perhitunganSPKMouseExited(evt);
            }
        });

        dataTraining.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dataTraining.setForeground(new java.awt.Color(255, 255, 255));
        dataTraining.setText("      DATA TRAINING");
        dataTraining.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTrainingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dataTrainingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dataTrainingMouseExited(evt);
            }
        });

        prediksi.setBackground(new java.awt.Color(0, 0, 0));
        prediksi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        prediksi.setForeground(new java.awt.Color(255, 255, 255));
        prediksi.setText("      PREDIKSI");
        prediksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prediksiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                prediksiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                prediksiMouseExited(evt);
            }
        });

        javax.swing.GroupLayout SidebarLayout = new javax.swing.GroupLayout(Sidebar);
        Sidebar.setLayout(SidebarLayout);
        SidebarLayout.setHorizontalGroup(
            SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(profil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SidebarLayout.createSequentialGroup()
                .addGroup(SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dataTraining, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(prediksi, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
            .addComponent(perhitunganSPK, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
            .addGroup(SidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SidebarLayout.setVerticalGroup(
            SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(listData)
                .addGap(18, 18, 18)
                .addComponent(dataTraining)
                .addGap(18, 18, 18)
                .addComponent(perhitunganSPK)
                .addGap(18, 18, 18)
                .addComponent(prediksi)
                .addGap(18, 18, 18)
                .addComponent(profil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 904, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1771, Short.MAX_VALUE)
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 117, Short.MAX_VALUE)
        );

        MainContent.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(MainContent, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 990, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MainContent, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(761, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1784, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(345, 345, 345)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 30, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SidebarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SidebarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_SidebarMouseEntered

    private void profilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilMouseExited
        // TODO add your handling code here:
        profil.setBackground(new Color(45,49,74));
        profil.setForeground(Color.white);
    }//GEN-LAST:event_profilMouseExited

    private void profilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilMouseEntered
        // TODO add your handling code here:
        profil.setBackground(new Color(41,44,69));
        profil.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profil.setForeground(new Color(255, 187, 0));
    }//GEN-LAST:event_profilMouseEntered

    private void listDataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDataMouseEntered
        // TODO add your handling code here:
        listData.setBackground(new Color(41,44,69));
        listData.setCursor(new Cursor(Cursor.HAND_CURSOR));
        listData.setForeground(new Color(255, 187, 0));
    }//GEN-LAST:event_listDataMouseEntered

    private void listDataMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDataMouseExited
        // TODO add your handling code here:
        listData.setBackground(new Color(45,49,74));
        listData.setForeground(Color.white);
    }//GEN-LAST:event_listDataMouseExited

    private void profilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilMouseClicked
        // TODO add your handling code here:
        UserModel user = new UserModel();
        
        MainContent.removeAll();
        MainContent.repaint();
        MainContent.revalidate();

        // add Panel, add panel
        MainContent.add(new AkunView(loggedInUser));
        MainContent.repaint();
        MainContent.revalidate();
    }//GEN-LAST:event_profilMouseClicked

    private void listDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDataMouseClicked
        // TODO add your handling code here:
        MainContent.removeAll();
        MainContent.repaint();
        MainContent.revalidate();

        // add Panel, add panel
        MainContent.add(new Karyawan());
        MainContent.repaint();
        MainContent.revalidate();
    }//GEN-LAST:event_listDataMouseClicked

    private void perhitunganSPKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perhitunganSPKMouseClicked
        // TODO add your handling code here:
        MainContent.removeAll();
        MainContent.repaint();
        MainContent.revalidate();

        // add Panel, add panel
        MainContent.add(new PerhitunganNaiveBayesView());
        MainContent.repaint();
        MainContent.revalidate();
    }//GEN-LAST:event_perhitunganSPKMouseClicked

    private void perhitunganSPKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perhitunganSPKMouseEntered
        // TODO add your handling code here:
        perhitunganSPK.setBackground(new Color(41,44,69));
        perhitunganSPK.setCursor(new Cursor(Cursor.HAND_CURSOR));
        perhitunganSPK.setForeground(new Color(255, 187, 0));
    }//GEN-LAST:event_perhitunganSPKMouseEntered

    private void perhitunganSPKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perhitunganSPKMouseExited
        // TODO add your handling code here:
        perhitunganSPK.setBackground(new Color(45,49,74));
        perhitunganSPK.setForeground(Color.white);
    }//GEN-LAST:event_perhitunganSPKMouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
       int result = JOptionPane.showConfirmDialog(
            this,
            "Apakah Anda yakin ingin keluar dari aplikasi?",
            "Konfirmasi Keluar",
            JOptionPane.YES_NO_OPTION
        );

        if (result == JOptionPane.YES_OPTION) {
            DatabaseUtil.getInstance().closeConnection(); // Tutup koneksi DB (kalau ada)
            System.exit(0); // Keluar dari aplikasi
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setBackground(new Color(41,44,69));
        jLabel3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel3.setForeground(new Color(255, 187, 0));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
        jLabel3.setBackground(new Color(45,49,74));
        jLabel3.setForeground(Color.white);
    }//GEN-LAST:event_jLabel3MouseExited

    private void dataTrainingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTrainingMouseClicked
        MainContent.removeAll();
        MainContent.repaint();
        MainContent.revalidate();

        // add Panel, add panel
        MainContent.add(new DataTrainingView());
        MainContent.repaint();
        MainContent.revalidate();
    }//GEN-LAST:event_dataTrainingMouseClicked

    private void dataTrainingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTrainingMouseEntered
        // TODO add your handling code here:
        dataTraining.setBackground(new Color(41,44,69));
        dataTraining.setCursor(new Cursor(Cursor.HAND_CURSOR));
        dataTraining.setForeground(new Color(255, 187, 0));
    }//GEN-LAST:event_dataTrainingMouseEntered

    private void dataTrainingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTrainingMouseExited
        // TODO add your handling code here:
        dataTraining.setBackground(new Color(45,49,74));
        dataTraining.setForeground(Color.white);
    }//GEN-LAST:event_dataTrainingMouseExited

    private void prediksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prediksiMouseClicked
         // TODO add your handling code here:
        MainContent.removeAll();
        MainContent.repaint();
        MainContent.revalidate();

        // add Panel, add panel
        MainContent.add(new PrediksiView());
        MainContent.repaint();
        MainContent.revalidate();
    }//GEN-LAST:event_prediksiMouseClicked

    private void prediksiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prediksiMouseEntered
        // TODO add your handling code here:
        prediksi.setBackground(new Color(41,44,69));
        prediksi.setCursor(new Cursor(Cursor.HAND_CURSOR));
        prediksi.setForeground(new Color(255, 187, 0));
    }//GEN-LAST:event_prediksiMouseEntered

    private void prediksiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prediksiMouseExited
        // TODO add your handling code here:
        prediksi.setBackground(new Color(45,49,74));
        prediksi.setForeground(Color.white);
    }//GEN-LAST:event_prediksiMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MenuView().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel MainContent;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JLabel dataTraining;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel listData;
    private javax.swing.JLabel perhitunganSPK;
    private javax.swing.JLabel prediksi;
    private javax.swing.JLabel profil;
    // End of variables declaration//GEN-END:variables
}
