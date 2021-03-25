package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;
    
    @FXML
    private Button btnCancella;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    private void visualizza (List<String> S) {
    	for (int i=0; i<S.size(); i++) {
    		txtResult.appendText(S.get(i)+'\n');
    	}
    }

    @FXML
    void doInsert(ActionEvent event) {
    	String inser = txtParola.getText();
    	if (inser == "") {
    		txtResult.appendText("La parola non deve essere vuota! \n");
    		return;
    	}
    	this.elenco.addParola(inser);
    	txtResult.clear();
    	List <String> risultato = this.elenco.getElenco();
    	this.visualizza(risultato);
    }

    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	txtResult.clear();
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	txtResult.clear();
    	if (this.elenco.cancellazione(txtParola.getText())){
    		txtResult.appendText("Cancellazione avvenuta con successo! \n\n");
    	} else {
    		txtResult.appendText("Parola non trovata! \n\n");
    	}
    	this.visualizza(this.elenco.getElenco());

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Parole m) {
    	this.elenco=m;
    }
}
