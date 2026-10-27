package cl.duoc.ticketpro.controller;

import cl.duoc.ticketpro.model.Entrada;
import cl.duoc.ticketpro.model.General;
import cl.duoc.ticketpro.model.Vip;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.skin.ComboBoxListViewSkin;

import java.util.ArrayList;

public class EntradaController {
    @FXML
    public ComboBox<String> comboBoxTe;
    @FXML
    public TextField textFieldDes;
    @FXML
    public Label labelCodigo;
    @FXML
    public Label labelEvento;
    @FXML
    public Label labelPrBa;
    @FXML
    public Label labelTe;
    @FXML
    public Label labelDes;
    @FXML
    public Button ButtonReg;
    @FXML
    public TextField textFieldCodigo;
    @FXML
    public TextField textFieldEvento;
    @FXML
    public TextField textFieldPrBa;
    @FXML
    public TableView<Entrada> tableViewRe;
    @FXML
    public Label labelNuAs;
    @FXML
    public TextField textFieldNuAs;
    @FXML
    public TableColumn<Entrada, Integer> tableColumnCodigo;
    @FXML
    public TableColumn<Entrada, String>  tableColumnEvento;
    @FXML
    public TableColumn<Entrada, Double>  tableColumnPrecioB;
    @FXML
    public Label labelMensaje;
    @FXML
    public Button buttonEl;

    ArrayList<Entrada> entradas = new ArrayList<>();

    public void cargarTabla(){
        tableColumnCodigo.setCellValueFactory( new PropertyValueFactory<>("Código") );
        tableColumnEvento.setCellValueFactory( new PropertyValueFactory<>("Evento") );
        tableColumnPrecioB.setCellValueFactory( new PropertyValueFactory<>("Precio base") );

        ObservableList<Entrada> data = FXCollections.observableArrayList(entradas);
        tableViewRe.setItems(data);
    }


    @FXML
    public void initialize(){
        comboBoxTe.getItems().addAll("VP","General");
        comboBoxTe.setOnAction(evento->{
            String tipo = comboBoxTe.getValue();
            if(tipo.equals("VP")){
                textFieldNuAs.setVisible(false);
                labelNuAs.setVisible(false);
                textFieldDes.setVisible(true);
                labelDes.setVisible(true);
            }
            else{
                textFieldDes.setVisible(false);
                labelDes.setVisible(false);
                textFieldNuAs.setVisible(true);
                labelNuAs.setVisible(true);

            }
        });
    }
    @FXML
    public void agregarProducto() {
        try{
            if(comboBoxTe.getValue()==null){
                labelMensaje.setText("Debe elegir un tipo de entrada!");
                return;
            }

            Entrada e;
            //1. Rescatar valores; 2.Crear objeto; 3.Guardar en array.
            int codigo = Integer.parseInt(textFieldCodigo.getText());
            String nombreEvento= textFieldEvento.getText();
            double precio = Double.parseDouble(textFieldPrBa.getText());


            String tipo = comboBoxTe.getValue();
            if(tipo.equals("ViP")){
                double descuento = Double.parseDouble(textFieldDes.getText());
                e = new Vip(codigo,nombreEvento,precio,descuento);
            }else{
                int numAsiento= Integer.parseInt(textFieldNuAs.getText());
                e = new General(codigo,nombreEvento,precio,numAsiento);
            }
            entradas.add(e);
            cargarTabla();
            mostrarMensaje("PRODUCTO AGREGADO.");
            limpiar();
        }catch (NumberFormatException ex){
            labelMensaje.setText("Debe ingresar números para campos numéricos.");
        }catch (Exception ex){
            labelMensaje.setText( ex.getMessage() );
        }
    }
    @FXML
    public void eliminarProducto() {
        //1. Eliminar un producto eligiendolo de la tableView.
        try {
            Entrada e = tableViewRe.getSelectionModel().getSelectedItem();
            if(e==null){
                labelMensaje.setText("Debe seleccionar un producto de la tabla.");
                return;
            }
            entradas.remove(e);
            cargarTabla();
            mostrarMensaje("PRODUCTO ELIMINADO!");
            limpiar();
        }catch (Exception ex){
            labelMensaje.setText( ex.getMessage() );
        }
    }
    //método auxiliares:
    public void mostrarMensaje(String mensaje){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Información");
        alerta.setContentText(mensaje);
        alerta.show();
    }
    public void limpiar(){
        comboBoxTe.setValue(null);
        comboBoxTe.setSkin(new ComboBoxListViewSkin<>(comboBoxTe)); /*Esto es para que se vuelva a cargar el prompText o sus cualidades iniciales.*/
        textFieldCodigo.clear();
        textFieldEvento.clear();
        textFieldDes.clear();
        textFieldNuAs.clear();
        textFieldPrBa.clear();


        labelMensaje.setText("-");

    }
}
