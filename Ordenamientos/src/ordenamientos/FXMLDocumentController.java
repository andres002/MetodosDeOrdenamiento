/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamientos;

import algoritmos.Insercion;
import algoritmos.Merge;
import algoritmos.Shell;
import algoritmos.Burbuja;
import java.net.URL;
import java.util.Random;
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
    private TextArea txtMerge, txtInsercion,txtshell, txtBurbuja;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextArea txtDatos,txtDatosO;
    @FXML
    private Button btnLeer, btnOrdenarMerge;
    @FXML
    private AnchorPane AnchorLeer, AnchorOrdenar;
    
    private int[] datos; //datos leídos
    private int[] datosO; //Arreglo para los datos que serán ordenados
    int asdes = 0; // 1-- Ascendente  2.-- Descendente  3.-- Desordenado
    
    
    @FXML
    private void readFile(ActionEvent event){
        if(!txtNombre.getText().equals(" ")){
            AnalizaFile a = new AnalizaFile(txtNombre.getText());
            datos = a.getNumbers();
            datosO = a.getNumbers();
            verifica(datosO);
            setDatosLeidos();
        }
   
        
        setAnchorOrdenar();
        txtMerge.setText("Número de Comparaciones: "+mergeBestCase(datos.length));
        if (this.asdes==1){
            txtInsercion.setText("Número de Comparaciones: "+((datos.length)-1)+
                    "\nNúmero de Intercambios: 0");
            txtBurbuja.setText("Numero de Comparaciones: " + BubleCase(datos.length) + 
                "\nNumero de Intercambios: " + BubleCase2(datos.length));
            txtshell.setText("Numero de Comparaciones: "+ShellBestCase(datos.length));
            
        }else{
        txtInsercion.setText("Número de Comparaciones: "+(insercionCompMax(datos.length))+
                 "\nNúmero de Intercambios: "+insercionMovMax(datos.length));
        txtBurbuja.setText("Numero de Comparaciones: " + BubleCase(datos.length) +
                "\nNumero de Intercambios: " + BubleCase(datos.length));
        txtshell.setText("Numero de Comparaciones: "+ShellWorstCase(datos.length));
       }
    }
    @FXML
    private void Merge(ActionEvent event){
        Merge merge = new Merge();
        merge.merge_sort(datosO);
        txtMerge.setText(txtMerge.getText()+"\nComparaciones Totales: "+merge.getComparaciones());
        merge.imprimir();
        setDatosOrdenados();
        //Para recuperar el arreglo desordenado
        getDatosLeidos();
    }
    
    @FXML
    private void Insercion(ActionEvent event){
        Insercion in = new Insercion();
        in.ordenarInsercion(datosO);
        txtInsercion.setText(txtInsercion.getText()+"\nComparaciones Totales: "+in.getComp()+
                "\nIntercambios Totales: "+in.getMov());
         setDatosOrdenados();
        //Para recuperar el arreglo desordenado
        getDatosLeidos();
        
    }
    
    
    @FXML
    private void Shellsort(ActionEvent event){
        Shell a = new Shell();
        a.shellA(datosO);
        txtshell.setText(txtshell.getText()+"\nIntercambios Totales: "+a.getIntercambios() + 
                "\nComparaciones Totales: "+ a.getComparaciones());
         setDatosOrdenados();
        //Para recuperar el arreglo desordenado
        getDatosLeidos();
        
    }
    
    @FXML
    private void Burbuja(ActionEvent event){
        Burbuja burbu = new Burbuja();
        switch(this.asdes){
            case 2:
                burbu.burbujaD(datosO);
                break;
            case 1:
            case 3:
                burbu.burbujaA(datosO);
                break;
        }
       txtBurbuja.setText(txtBurbuja.getText()+"\nNúmero de Comparaciones Reales: "+ burbu.compa +
               "\nNúmero de Intercambios Reales: " + burbu.inte);
        //merge.imprimir();
       setDatosOrdenados();
        //Para recuperar el arreglo desordenado
        getDatosLeidos();
    }
     private void setDatosLeidos(){
        for (int i = 0; i < datos.length; i++) {
            txtDatos.setText(txtDatos.getText() + " "+ datos[i]+"\n");
        }     
    }
    private void setDatosOrdenados(){
        for (int i = 0; i < datosO.length; i++) {
            txtDatosO.setText(txtDatosO.getText() + " "+ datosO[i]+"\n");
        }  
    }
    private void getDatosLeidos(){
  
        String[] data = txtDatosO.getText().split("\n");
        int aux = 0;
        for (int i = 0; i < data.length; i++) {
            if(!" ".equals(data[i]) ){
                datosO[aux] = Integer.parseInt(data[i].replace(" ",""));    
                aux++;
            }
        }
   
 
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
    
    
    public void verifica(int[] arreglo){// 1-- Ascendente  2.-- Descendente  3.-- Desordenado
		int pos;
		int buffer ='\0'; 
		int x = 0;
		while(x < arreglo.length){
			if(buffer != '\0'){
				if(buffer < arreglo[x] && (this.asdes == 1 || this.asdes == 0)){
					this.asdes = 1;
				}else if(buffer > arreglo[x] && (this.asdes == 2 || this.asdes == 0)){
					this.asdes = 2;
				}else{
					this.asdes =3;
				}
			}
			buffer= arreglo[x];
			x ++;
		}
		if(this.asdes == 0)
			this.asdes = 1;		

	}
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setAnchorLeer();
    }    
    
/* Comparaciones del merge según el caso*/
    
    public double mergeBestCase(int n){
        return n * Math.log(n) /Math.log(2);
    }
    
    public double insercionCompMax(int n){
        return (Math.pow(n,2)/2)-(n/2);
    }
    
    public double insercionMovMax(int n){
        return (Math.pow(n,2)/2)-(n/2);
    }
    
    public double BubleCase(int n){
        return ((Math.pow(n, 2))-n)/2;  //aplica para Comparaciones e intercambios mas desfavorables
    }
    
    
   public int BubleCase2(int n){
        return 0;  //aplica para intercambios caso mas favorable
    }
   public int ShellWorstCase(int n){
         return (int) (Math.pow(n, 1.25));
    }
    public int ShellBestCase(int n){
        return (int) (n * Math.log(n) /Math.log(2));
    
    }
    
}
