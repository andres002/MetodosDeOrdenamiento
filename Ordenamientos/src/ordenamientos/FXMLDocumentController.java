/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamientos;

import algoritmos.Insercion;
import algoritmos.Merge;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author Equipo 3
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextArea txtMerge, txtInsercion;
    @FXML
    private TextField txtNombre;
    @FXML
    private Button btnLeer, btnOrdenarMerge;
    @FXML
    private AnchorPane AnchorLeer, AnchorOrdenar;
    
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
        setAnchorOrdenar();
        txtMerge.setText("El número de iteracciones es: "+mergeBestCase(datos.length));
        txtInsercion.setText("Número de Comparaciones Minimas: "+((datos.length)-1)+
                "\nNúmero de Comparaciones Maximas: "+(insercionCompMax(datos.length))+
                "\nNúmero de Movimientos Minimos: 0"+ "\nNúmero de Movimientos Maximos: "+
                insercionMovMax(datos.length));
        
        
    }
    @FXML
    private void Merge(ActionEvent event){
        Merge merge = new Merge();
        merge.merge_sort(datosO);
        txtMerge.setText(txtMerge.getText()+"\n"+merge.getComparaciones());
        merge.imprimir();
    }
    
    @FXML
    private void Insercion(ActionEvent event){
        Insercion in = new Insercion();
      //  in.ordenarInsercion(datosO);
        txtInsercion.setText(txtInsercion.getText()+"\nDatos a ordenar: \n"+ datosO+"\n");
        txtInsercion.setText(txtInsercion.getText()+"\nDatos Ordenados: \n"+in.ordenarInsercion(datosO));
        txtInsercion.setText(txtInsercion.getText()+"\nComparaciones Totales: "+in.getComp()+
                "\nMovimientos Totales: "+in.getMov());
        
    }
    @FXML 
    private void Leer(){
        setAnchorLeer();
    }
   
    private void setAnchorLeer(){
        AnchorLeer.setVisible(true);
        AnchorOrdenar.setVisible(false);
    }
    private void setAnchorOrdenar(){
        AnchorLeer.setVisible(false);
        AnchorOrdenar.setVisible(true);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setAnchorLeer();
    }    
    
/* Comparaciones del merge según el caso*/
    
    public double mergeBestCase(int n){
        return n * Math.log(n);
    }
    
    public double insercionCompMax(int n){
        return (Math.pow(n,2)/2)-(n/2);
    }
    
    public double insercionMovMax(int n){
        return (Math.pow(n,2)/2)-(n/2);
    }
  
    
}
