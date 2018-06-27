/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerdatenpflegewerkzeugstamm;
import GUI.ManagerFrame;
import java.awt.Toolkit;

/**
 *
 * @author schmidtu
 */
public class ManagerDatenpflegeWerkzeugstamm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ManagerFrame myManager = new ManagerFrame();
        myManager.setTitle("Manager Werkzeugstamm");
        myManager.setSize(244, Toolkit.getDefaultToolkit().getScreenSize().height - 30);
        myManager.setVisible(true);
    }
    
}
