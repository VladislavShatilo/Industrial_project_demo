package com.example.pp1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;


public class ApplicationController {

    private static final FileInformation file = new FileInformation();

    @FXML
    private void newWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("output.fxml"));
        Parent root = loader.load();
        Stage secondStage = new Stage();
        secondStage.setTitle("Output");

        secondStage.setScene(new Scene(root));

        secondStage.show();
    }
    @FXML
    private void newWindow2() throws IOException {
        //Close current
        FXMLLoader loader = new FXMLLoader(getClass().getResource("outputName.fxml"));
        Parent root = loader.load();

        Stage secondStage = new Stage();
        secondStage.setTitle("Output Name");

        secondStage.setScene(new Scene(root));

        secondStage.show();

    }
    @FXML
    private void newWindow3() throws IOException {
        //Close current
        FXMLLoader loader = new FXMLLoader(getClass().getResource("finish.fxml"));
        Parent root = loader.load();

        Stage secondStage = new Stage();
        secondStage.setTitle("");

        secondStage.setScene(new Scene(root));

        secondStage.show();

    }



    @FXML
    private void txtInputButtonAction(ActionEvent event) throws IOException {
        file.setInputExpanse("txt");
        System.out.println("txt");
        newWindow();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

    }


    @FXML
    public void jsonInputButtonAction(ActionEvent actionEvent) throws IOException{
        file.setInputExpanse("json");
        newWindow();
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
    @FXML

    public void xmlInputButtonAction(ActionEvent actionEvent) throws IOException{
        file.setInputExpanse("xml");
        newWindow();
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();

    }
    @FXML
    public void zipInputButtonAction(ActionEvent actionEvent)throws IOException {
        file.setInputExpanse("zip");
        newWindow();
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
    @FXML
    public void rarInputButtonAction(ActionEvent actionEvent)throws IOException {
        file.setInputExpanse("rar");
        newWindow();
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
    @FXML
    public void jarInputButtonAction(ActionEvent actionEvent) throws IOException{
        file.setInputExpanse("jar");
        newWindow();
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
    @FXML
    private void txtOutputButtonAction(ActionEvent event) throws IOException {
        file.setOutputExpanse("txt");
        newWindow2();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
    @FXML
    public void AESOutputButtonAction(ActionEvent actionEvent) throws IOException {
        file.setOutputExpanse("txt");
        file.setCipher(1);
        newWindow2();
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
    @FXML
    public void jarOutputButtonAction(ActionEvent actionEvent) throws IOException {
        file.setOutputExpanse("jar");
        newWindow2();
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
    @FXML
    public void zipOutputButtonAction(ActionEvent actionEvent) throws IOException {
        file.setOutputExpanse("zip");
        newWindow2();
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
    @FXML
    public void xmlOutputButtonAction(ActionEvent actionEvent) throws IOException {
        file.setOutputExpanse("xml");
        newWindow2();
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
    @FXML
    public void jsonOutputButtonAction(ActionEvent actionEvent) throws IOException {
        file.setOutputExpanse("json");
        newWindow2();
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
    @FXML
    private TextField textFieldName;
    @FXML
    public void finish(ActionEvent actionEvent) throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        String text = this.textFieldName.getText();
        file.setOutputName(text +"." + file.outputExpanse);
        YachtBuilder builder = new YachtBuilder();
        Manager manage = new Manager(builder,file.inputExpanse,file.outputName);
        List<Yachts> yachts = manage.chooseBuilder();
        manage.chooseOutput(yachts,file.cipher);
        newWindow3();
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
    @FXML
    public void finishMap(ActionEvent actionEvent) throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        String text = this.textFieldName.getText();
        file.setOutputName(text +"." + file.outputExpanse);
        YachtBuilder builder = new YachtBuilder();
        Manager manage = new Manager(builder,file.inputExpanse,file.outputName);
        Map<Integer,Yachts> yachts= manage.chooseMapBuilder();
        manage.chooseOutputMap(yachts,file.cipher);
        newWindow3();
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
}