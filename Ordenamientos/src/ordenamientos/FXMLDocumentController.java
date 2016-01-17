/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamientos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


/**
 *
 * @author Equipo 3
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtNombre;
    @FXML
    private Button btnLeer;
    
    private int[] datos; //datos leídos
    private int[] datosO; //Arreglo para los datos que serán ordenados
    
    @FXML
    private void andleButtonAction(ActionEvent event) {
       
    }
    
    @FXML
    private void readFile(ActionEvent event){
        if(!txtNombre.getText().equals(" ")){
            AnalizaFile a = new AnalizaFile(txtNombre.getText());
            datos = a.getNumbers();
            datosO = a.getNumbers();
        }else{
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
}
