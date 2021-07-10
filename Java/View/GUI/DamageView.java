/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GUI;

import deepspace.DamageToUI;

/**
 *
 * @author german_padua
 */
public class DamageView extends javax.swing.JPanel {

    /**
     * Creates new form DamageView
     */
    public DamageView() {
        initComponents();
    }
    
    void setDamageView(DamageToUI damage){
        if (damage == null){
            setVisible(false);
        }else{
            nshields_label.setText(String.valueOf(damage.getNShields()));
            damagew_label.setText(damage.getWeaponInfo());
            repaint();
            revalidate();
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        damage_scroll = new javax.swing.JScrollPane();
        damage_panel = new javax.swing.JPanel();
        nshields_label = new javax.swing.JLabel();
        shields_label = new javax.swing.JLabel();
        weap_label = new javax.swing.JLabel();
        damagew_label = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        nshields_label.setText("jLabel3");

        shields_label.setText("Escudos:");

        weap_label.setText("Armas:");

        damagew_label.setText("jLabel4");

        javax.swing.GroupLayout damage_panelLayout = new javax.swing.GroupLayout(damage_panel);
        damage_panel.setLayout(damage_panelLayout);
        damage_panelLayout.setHorizontalGroup(
            damage_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(damage_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(damage_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(weap_label)
                    .addComponent(shields_label))
                .addGap(46, 46, 46)
                .addGroup(damage_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(damagew_label)
                    .addComponent(nshields_label))
                .addContainerGap(313, Short.MAX_VALUE))
        );
        damage_panelLayout.setVerticalGroup(
            damage_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(damage_panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(damage_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nshields_label)
                    .addComponent(shields_label))
                .addGap(39, 39, 39)
                .addGroup(damage_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weap_label)
                    .addComponent(damagew_label))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        damage_scroll.setViewportView(damage_panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(damage_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(damage_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel damage_panel;
    private javax.swing.JScrollPane damage_scroll;
    private javax.swing.JLabel damagew_label;
    private javax.swing.JLabel nshields_label;
    private javax.swing.JLabel shields_label;
    private javax.swing.JLabel weap_label;
    // End of variables declaration//GEN-END:variables
}
