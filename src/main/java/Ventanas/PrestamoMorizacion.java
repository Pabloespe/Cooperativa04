/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CDK
 */
public class PrestamoMorizacion extends javax.swing.JFrame {

    int periodo;
    double cuota;
    double amotizacion;
    int promedio;
    double interes1 = 0.0133;
    double interes2 = 0.0083;
    double saldopro;
    float capital;
    double inter;
    private String fecha;
    int meses;
    
    /**
     * Creates new form PrestamoMorizacion
     */
    public PrestamoMorizacion() {
        initComponents();
    }
    
    public PrestamoMorizacion(int saldo, int mes) {
        initComponents();
        capital = saldo;
        meses = mes;
        cargar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Periodo", "Fecha", "Cuota", "Amortizacion", "Interes", "Pendiente"
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(448, 448, 448))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(PrestamoMorizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrestamoMorizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrestamoMorizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrestamoMorizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrestamoMorizacion().setVisible(true);
            }
        });
    }
    
    public void cargar() {
        DefaultTableModel modelo = (DefaultTableModel) tblDatos.getModel();
        Calendar cal = Calendar.getInstance();
        
        Object[] fila = new Object[7];
       // R = P [(i (1 + i)n) / ((1 + i)n – 1)]
        // R = 1000 [(0.04 (1 + 0.04)5) / ((1 + 0.04)5 – 1)]
        double suma = 0.0;
        if(meses < 12)
            cuota = (capital)*(Math.pow((1+interes1), meses)*interes1)/((Math.pow((1+interes1), meses)-1));
        else
            cuota = (capital)*(Math.pow((1+interes2), meses)*interes2)/((Math.pow((1+interes2), meses)-1));
        
        cuota = Math.round(cuota*100.0)/100.0;
        saldopro = capital;
        int m=0,d=0,a=0;
        m=(cal.get(Calendar.MONTH)+2);
        d=cal.get(Calendar.DAY_OF_MONTH);
        a=cal.get(Calendar.YEAR);

        for (int i = 1; i <= meses; i++) {
            if (i == 1) {
                if(meses < 12)
                    inter = interes1 * capital;
                else
                    inter = interes2 * capital;
                amotizacion = cuota - inter;
                amotizacion = Math.round(amotizacion * 100.0) / 100.0;
                System.out.println(interes1);
                fila[0] = Integer.toString(i);
                fila[1] = a + "-" + m + "-" + d;
                fila[2] = cuota;
                fila[3] = amotizacion;
                suma = suma + amotizacion;
                fila[4] = inter;
                saldopro = saldopro - amotizacion;
                fila[5] = saldopro;

            } else {
                System.out.println(saldopro + "---");
                if(meses < 12)
                    inter = (interes1 * saldopro);
                else
                    inter = (interes2 * saldopro);
                double interr = Math.round(inter);
                amotizacion = cuota - inter;
                amotizacion = Math.round(amotizacion * 100.0) / 100.0;
                saldopro = saldopro - amotizacion;
                saldopro = Math.round(saldopro * 100.0) / 100.0;
                System.out.println(inter);
                fila[0] = Integer.toString(i);
                if(m >= 12){
                    m=0;
                    m += 1;
                    a += 1;
                    fila[1] = a + "-" + m + "-" + d;
                }else{
                    m += 1;
                    fila[1] = a + "-" + m + "-" + d;
                }
                    
                fila[2] = cuota;
                suma = suma + amotizacion;
                fila[3] = amotizacion;
                fila[4] = interr;
                if (saldopro < 0) {
                    saldopro = 0;
                }
                fila[5] = saldopro;

            }
            fila[6] = suma;
            modelo.addRow(fila);
        }

        tblDatos.setModel(modelo);

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
