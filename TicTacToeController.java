/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Guille
 */
public class TicTacToeController implements Initializable {

    @FXML
    private Button B1;
    @FXML
    private Button B2;
    @FXML
    private Button B3;
    @FXML
    private Button B4;
    @FXML
    private Button B5;
    @FXML
    private Button B6;
    @FXML
    private Button B7;
    @FXML
    private Button B8;
    @FXML
    private Button B9;
    @FXML
    private Text contador_ronda;
    @FXML
    private Text ganador;
    /**
     * 9 variables, una para cada botón:
     * 
     * ->accionarBn == TRUE, permite usar el botón
     * ->accionarBn == FALSE, inhabilita el botón
     */
    boolean accionarB1 = true;
    boolean accionarB2 = true;
    boolean accionarB3 = true;
    boolean accionarB4 = true;
    boolean accionarB5 = true;
    boolean accionarB6 = true;
    boolean accionarB7 = true;
    boolean accionarB8 = true;
    boolean accionarB9 = true;
    //variable contador del numero de rondas
    private int i = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    /**
     * 
     * 9 Botones, el valor i debe estar entre (1...9) para que funcionen.
     * Si el boton INICIAR no es pulsado -> i==0 por lo tanto, ningún 
     * botón funciona.
     * Si se está en la ronda 9(i==9), no se permite accionar ningún botón más.
     * La variable accionado controla que se pulse solo una vez cada botón.
     * 
     */
    @FXML
    private void pulsadoB1(ActionEvent event) {
        if(i>=1 && i<=9 && accionarB1){llenarCasilla(B1); accionarB1 = false;}
    }

    @FXML
    private void pulsadoB2(ActionEvent event) {
        if(i>=1 && i<=9 && accionarB2){llenarCasilla(B2); accionarB2 = false;}
    }

    @FXML
    private void pulsadoB3(ActionEvent event) {
        if(i>=1 && i<=9 && accionarB3){llenarCasilla(B3); accionarB3 = false;}
    }

    @FXML
    private void pulsadoB4(ActionEvent event) {
        if(i>=1 && i<=9 && accionarB4){llenarCasilla(B4); accionarB4 = false;}
    }

    @FXML
    private void pulsadoB5(ActionEvent event) {
        if(i>=1 && i<=9 && accionarB5){llenarCasilla(B5); accionarB5 = false;}
    }

    @FXML
    private void pulsadoB6(ActionEvent event) {
        if(i>=1 && i<=9 && accionarB6){llenarCasilla(B6); accionarB6 = false;}
    }

    @FXML
    private void pulsadoB7(ActionEvent event) {
        if(i>=1 && i<=9 && accionarB7){llenarCasilla(B7); accionarB7 = false;}
    }

    @FXML
    private void pulsadoB8(ActionEvent event) {
        if(i>=1 && i<=9 && accionarB8){llenarCasilla(B8); accionarB8 = false;}
    }

    @FXML
    private void pulsadoB9(ActionEvent event) {
        if(i>=1 && i<=9 && accionarB9){llenarCasilla(B9); accionarB9 = false;}
    }
    
    /**
     * Al accionar cualquier boton se lanza el método llenarCasilla para dicho
     * boton.
     * El método muestra un contador con valor i
     * Dependiendo si la i es par o impar, se imprime X o O en la casilla
     * Se lanza el metodo showGanador que devuelve el nombre del ganador(String)
     * Asigna i=i+1 para pasar a la siguiente ronda 
     * 
     */
    private int llenarCasilla(Button B){
        
        contador_ronda.setText("Ronda: " + i);
        if(i%2== 0){B.setText("O");}
        else{B.setText("X");}
        ganador.setText(showGanador());
        return i++;
    }
    
    /**
     * Al pulsar el boton INICIAR se lanza el método pulsa_iniciar que:
     * 
     * Asigna i=1
     * Borra el contenido(Strings) de los botones
     * Borra el contenido(nombre del ganador) de la casilla ganador
     * Asigna TRUE a las variable accionar
     * Muestra en el contador "Ronda 1"
     */
    @FXML
    private void pulsa_iniciar(ActionEvent event) {
        i = 1;
        ganador.setText("");
        contador_ronda.setText("Ronda: " + i);
        B1.setText("");
        B2.setText("");
        B3.setText("");
        B4.setText("");
        B5.setText("");
        B6.setText("");
        B7.setText("");
        B8.setText("");
        B9.setText("");
        accionarB1 = true;
        accionarB2 = true;
        accionarB3 = true;
        accionarB4 = true;
        accionarB5 = true;
        accionarB6 = true;
        accionarB7 = true;
        accionarB8 = true;
        accionarB9 = true;
    }
    /**
     * Metodo que devuelve:
     * 
     * -> String del jugador ganador ("O"/"X") si se cumple la alineación de 3 
     *    Strings iguales y diferentes a "". Se asigna i=10 para impedir que se
     *    puedan activar mas botones.
     * -> "EMPATE" si se ha llegado a la ronda 9 (todas las casillas llenas) y 
     *     no se han cuplido las condiciones anteriores.
     * -> "" si no se cumplen ninguna de las condiciones anteriores.
     * 
     * Se crean las variables (cas1...cas9) para asignarles los valores de los
     * Strings de los botones (1...9) respectivamente.
     *  
     */
    private String showGanador(){
        String cas1= B1.getText();
        String cas2= B2.getText();
        String cas3= B3.getText();
        String cas4= B4.getText();
        String cas5= B5.getText();
        String cas6= B6.getText();
        String cas7= B7.getText();
        String cas8= B8.getText();
        String cas9= B9.getText();
        
        if(cas1.equals(cas2) && cas1.equals(cas3) && !cas1.equals(""))
        {i=10; return cas1;}
        else if(cas4.equals(cas5) && cas4.equals(cas6) && !cas4.equals(""))
        {i=10; return cas4;}
        else if(cas7.equals(cas8) && cas7.equals(cas9) && !cas7.equals(""))
        {i=10; return cas7;}
        else if(cas1.equals(cas4) && cas1.equals(cas7) && !cas1.equals(""))
        {i=10; return cas1;}
        else if(cas2.equals(cas5) && cas2.equals(cas8) && !cas2.equals(""))
        {i=10; return cas2;}
        else if(cas3.equals(cas6) && cas3.equals(cas9) && !cas3.equals(""))
        {i=10; return cas3;}
        else if(cas1.equals(cas5) && cas1.equals(cas9) && !cas1.equals(""))
        {i=10; return cas1;}
        else if(cas3.equals(cas5) && cas3.equals(cas7) && !cas3.equals(""))
        {i=10; return cas3;}
        else if(i == 9){return "Empate";}
        else{return "";}
    }
}
