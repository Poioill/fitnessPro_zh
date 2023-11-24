package com.example.demo2lastihope;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class ThirdController implements Initializable {

    @FXML
    private TreeView myTree;

    public void selectItem() {
        TreeItem<String> treeItem = (TreeItem<String>) myTree.getSelectionModel().getSelectedItem();
        if (treeItem != null){
            System.out.println(treeItem.getValue());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TreeItem<String> rootItem = new TreeItem<>("Root");

        TreeItem<String> branch1 = new TreeItem<>("Pictures");
        TreeItem<String> branch2 = new TreeItem<>("Music");
        TreeItem<String> branch3 = new TreeItem<>("Stiff");

        TreeItem<String> pic1 = new TreeItem<>("Pic1");
        TreeItem<String> pic2 = new TreeItem<>("pic2");
        TreeItem<String> mus1 = new TreeItem<>("mus1");
        TreeItem<String> mus2 = new TreeItem<>("mus2");
        TreeItem<String> st1 = new TreeItem<>("st1");
        TreeItem<String> st2 = new TreeItem<>("St2");


        rootItem.getChildren().addAll(branch2, branch1, branch3);

        branch1.getChildren().addAll(pic1, pic2);
        branch2.getChildren().addAll(mus1, mus2);
        branch3.getChildren().addAll(st1, st2);

//        Hide the root directory
//        myTree.setShowRoot(false);
        myTree.setRoot(rootItem);
    }
}
