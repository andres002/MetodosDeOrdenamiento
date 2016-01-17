package ordenamientos;

import java.io.*;

public class AnalizaFile {

    String s;
    String nombre;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;

    //Constructores
    public AnalizaFile() {

    }

    public AnalizaFile(String name) {
        nombre = name; //guarda el nombre del archivo en el atributo
    }

    //Métodos
    public int getLines() { //Consigue el número de lineas en el archivo
        int lineas = 0;
        try {
            archivo = new File(nombre);
            fr = new FileReader(archivo); //lee el archivo
            br = new BufferedReader(fr);  //permite accesar al metodo readLine()
            while ((s = br.readLine()) != null) {
                lineas++;
            }
        } catch (IOException exc) {
            return -1;
        } finally {
            try {
                if (null != fr) {
                    fr.close();  //cierra archivo   
                }
            } catch (Exception e2) {
            }

        }
        return lineas; //regresa el número de líneas
    }

    public String getFirstLine() { //Consigue la primer línea
        String primerfila = new String("Error: archivo no encontrado");
        String mensajeError = new String("Error: archivo no encontrado");
        try {
            archivo = new File(nombre);
            fr = new FileReader(archivo); //lee archivo
            br = new BufferedReader(fr);  //permite accesar al metodo readLine()
            primerfila = br.readLine(); //Lee primer línea
        } catch (IOException exc) {
            return mensajeError;
        } finally {
            try {
                if (null != fr) {
                    fr.close();  //cierra archivo   
                }
            } catch (Exception e2) {
            }
        }
        return primerfila; //Regresa la primer linea del documento
    }

    public String getLastLine() { //Consigue última línea

        String ultimafila = new String("Error: archivo no encontrado");
        String mensajeError = new String("Error: archivo no encontrado");
        try {
            archivo = new File(nombre);
            fr = new FileReader(archivo); //lee archivo
            br = new BufferedReader(fr); //permite accesar al metodo readLine()
            ultimafila = br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                ultimafila = linea; //Consigue última línea
            }
        } catch (IOException exc) {
            return mensajeError;
        } finally {
            try {
                if (null != fr) {
                    fr.close();  //cierra archivo  
                }
            } catch (Exception e2) {
            }
        }
        return ultimafila;
    }

    public int[] getNumbers() { //Consigue última línea
        int i;
        int[] allLines = new int[getLines()];
        try {
            archivo = new File(nombre);
            fr = new FileReader(archivo); //lee archivo
            br = new BufferedReader(fr); //permite accesar al metodo readLine()
            //allLines[0] = br.readLine(); 
            String linea;
            i = 0;
            while ((linea = br.readLine()) != null) {
                allLines[i] = Integer.parseInt(linea);
                i++;
            }
        } catch (IOException exc) {
            System.out.println("Error");
        } finally {
            try {
                if (null != fr) {
                    fr.close();  //cierra archivo  
                }
            } catch (Exception e2) {
            }
        }
        return allLines;
    }

    public String[] getAllLines() { //Consigue última línea
        int i;
        String[] allLines = new String[getLines()];
        try {
            archivo = new File(nombre);
            fr = new FileReader(archivo); //lee archivo
            br = new BufferedReader(fr); //permite accesar al metodo readLine()
            //allLines[0] = br.readLine(); 
            String linea;
            i = 0;
            while ((linea = br.readLine()) != null) {
                allLines[i] = linea;
                i++;
            }
        } catch (IOException exc) {
            System.out.println("Error");
        } finally {
            try {
                if (null != fr) {
                    fr.close();  //cierra archivo  
                }
            } catch (Exception e2) {
            }
        }
        return allLines;
    }

    public String getAnyLines(int n) { //Consigue última línea
        int i;
        try {
            archivo = new File(nombre);
            fr = new FileReader(archivo); //lee archivo
            br = new BufferedReader(fr); //permite accesar al metodo readLine()
            //allLines[0] = br.readLine(); 
            String linea;
            i = 1;
            while ((linea = br.readLine()) != null) {
                if (i == n) {
                    return linea;
                }
                i++;
            }
        } catch (IOException exc) {
            System.out.println("Error");
        } finally {
            try {
                if (null != fr) {
                    fr.close();  //cierra archivo  
                }
            } catch (Exception e2) {
            }
        }
        return "123N/A";
    }

    public void setFileName(String nfile) { //Método default para recibir nombre del archivo
        nombre = nfile;
    }

}
