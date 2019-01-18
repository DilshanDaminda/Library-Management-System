package lk.ijse.dep.library.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.library.business.BOFactory;
import lk.ijse.dep.library.business.costom.MemberManageBO;
import lk.ijse.dep.library.dto.MemberDTO;
import lk.ijse.dep.library.entity.Member;
import lk.ijse.dep.library.view.util.MemberTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MemberManageFormController {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField TxtMemId;
    @FXML
    private JFXTextField TxtMemName;
    @FXML
    private JFXTextField txtType;
    @FXML
    private JFXTextField Txtdate;
    @FXML
    private JFXButton BtnSave;
    @FXML
    private JFXButton BtnDelete;
    @FXML
    private TableView <MemberTM> Tblmember;
    @FXML
    private ImageView btnHome;
    @FXML
    private ImageView btnAdd;

    private MemberManageBO manageBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MEMBER_MANAGE);
    public void initialize() throws Exception {



        Tblmember.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("memberid"));
        Tblmember.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("member_name"));
        Tblmember.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("membertype"));
        Tblmember.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("memberdate"));
        BtnSave.setDisable(false);
        BtnDelete.setDisable(false);

        List<MemberDTO> memberDB = manageBO.getMember();


        ObservableList<MemberDTO> memberDTOS  = FXCollections.observableArrayList(memberDB);
        ObservableList<MemberTM> tblItems = FXCollections.observableArrayList();
        for (MemberDTO memberDTO : memberDTOS)
        { tblItems.add(new MemberTM(memberDTO.getMemberid(),memberDTO.getMember_name(),memberDTO.getMembertype(),memberDTO.getMemberdate()));
        }
   Tblmember.setItems(tblItems);
        Tblmember.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MemberTM>() {
            @Override
            public void changed(ObservableValue<? extends MemberTM> observable, MemberTM oldValue, MemberTM newValue) {
                if(newValue == null){
                    return;
                }
                TxtMemId.setText(newValue.getMemberid());
                TxtMemName.setText(newValue.getMember_name());
                txtType.setText(newValue.getMembertype());
                Txtdate.setText(newValue.getMemberdate());
                     BtnDelete.setDisable(false);
                TxtMemId.setDisable(true);
            }
        });
    }


    public void Save(ActionEvent actionEvent) throws Exception {
        if(TxtMemId.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Member  ID is empty", ButtonType.OK).showAndWait();
            TxtMemId.requestFocus();
            return;
        }
        else if (TxtMemName.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Member Name is empty", ButtonType.OK).showAndWait();
            TxtMemName.requestFocus();
            return;
        }
        else if (txtType.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Member Type is empty", ButtonType.OK).showAndWait();
            txtType.requestFocus();
            return;
        }
        else if(Txtdate.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Member Date is empty", ButtonType.OK).showAndWait();
            Txtdate.requestFocus();
        }
        if(Tblmember.getSelectionModel().isEmpty()){

            ObservableList <MemberTM> items = Tblmember.getItems();
            for(MemberTM memberTM : items){
                if(memberTM.getMemberid().equals(TxtMemId.getText())){
                    new Alert(Alert.AlertType.ERROR, "Duplicate Member IDs are not allowed").showAndWait();
                    TxtMemId.requestFocus();
                    return;
                }
            }
       MemberTM memberTM = new MemberTM(TxtMemId.getText(),TxtMemName.getText(),txtType.getText(),Txtdate.getText());
           Tblmember.getItems().add(memberTM);
           MemberDTO memberDTO = new MemberDTO(TxtMemId.getText(),TxtMemName.getText(),txtType.getText(),Txtdate.getText());
           boolean result = manageBO.createMember(memberDTO);

           if(result){
               new Alert(Alert.AlertType.INFORMATION, "Member has been saved successfully", ButtonType.OK).showAndWait();
               Tblmember.scrollTo(memberTM);
           }else {
               new Alert(Alert.AlertType.INFORMATION, "Failed To Save Member", ButtonType.OK).showAndWait();

           }
        }
        else {
            MemberTM selectmember = Tblmember.getSelectionModel().getSelectedItem();
            selectmember.setMember_name(TxtMemName.getText());
            selectmember.setMember_name(TxtMemName.getText());
            Tblmember.refresh();

            String selectedmemberDB = Tblmember.getSelectionModel().getSelectedItem().getMemberid();

            boolean result = manageBO.updateMember(new MemberDTO(TxtMemId.getText(),TxtMemName.getText(),txtType.getText(),Txtdate.getText()));

            if(result){
                new Alert(Alert.AlertType.INFORMATION, "Member has been updated successfully", ButtonType.OK).showAndWait();

            }else {
                new Alert(Alert.AlertType.ERROR, "Failed to update", ButtonType.OK).showAndWait();

            }


        }

            reset();

    }

    public void Delete(ActionEvent actionEvent) throws Exception {
        Alert confirmMsg = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure to delete this file",ButtonType.YES, ButtonType.NO);
        Optional<ButtonType > buttonType = confirmMsg.showAndWait();

        if(buttonType.get()== ButtonType.YES){
            String selectionmember = Tblmember.getSelectionModel().getSelectedItem().getMemberid();
            Tblmember.getItems().remove(Tblmember.getSelectionModel().getSelectedItem());
            boolean result =manageBO.deleteMember(selectionmember);
                if(!result) {
                    new Alert(Alert.AlertType.ERROR,"Failed To Delete",ButtonType.OK).showAndWait();
                }
                else {
                    reset();
                }

        }
    }

    public void Home(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/library/view/DashboardForm.fxml"));
        Scene scene  = new Scene(load);
        Stage mainstage = (Stage)root.getScene().getWindow();
        mainstage.setScene(scene);


   }

    public void Add(MouseEvent mouseEvent) {
        reset();
    }

    private void reset(){
        TxtMemId.clear();
        TxtMemName.clear();
        Txtdate.clear();
        txtType.clear();
        TxtMemId.setDisable(false);
        BtnSave.setDisable(false);
        BtnDelete.setDisable(true);
        Tblmember.getSelectionModel().clearSelection();

    }
}
