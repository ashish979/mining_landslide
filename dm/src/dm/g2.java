/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dm;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import org.math.plot.Plot2DPanel;

/**
 *
 * @author ashish
 */
public class g2 extends javax.swing.JFrame {

    /**
     * Creates new form g2
     */
    public g2(){
        initComponents();
    }
    public g2(double[][] x) {
        initComponents();
       // double[][] x = {{1,2.5},{3,10.66666},{5,20.22422},{7,5.453535},{9,11.25533}}; // 1000 random numbers from a log normal statistical law
                double[] y={1,1,1,1,1};
		// create your PlotPanel (you can use it as a JPanel)
		Plot2DPanel plot = new Plot2DPanel();
 
		// add the histogram (50 slices) of x to the PlotPanel
		plot.addHistogramPlot("Plot",x,y);
                jPanel1.setLayout(new GridLayout());
                jPanel1.setSize(600,600);
 this.setSize(600,600);
 jPanel1.add(plot,0);
 //jPanel1.add(servericon,0);
 
 jPanel1.setBackground(Color.BLUE);
 jPanel1.revalidate();
 jPanel1.repaint();

               /* jPanel1.add(plot);
                jPanel1.setVisible(false); 
                jPanel1.removeAll(); 
                jPanel1.invalidate(); 
                jPanel1.repaint(); 
                jPanel1.setVisible(true);*/
                
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(g2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(g2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(g2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(g2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new g2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
