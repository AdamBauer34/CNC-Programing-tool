/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam;

import java.util.ArrayList;
import java.util.Objects;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.GridPane.setColumnSpan;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

/**
 *
 * @author AdamB
 */
public class theView implements Builder<Region> {

    private TextField toolNumberTF;
    private TextField spindleTF;
    private TextField feedTF;
    private TextField safetyHeightTF;
    private TextField retractHeightTF;
    private TextField depthTF;
    private TextField peckTF;
    private int tempNum;

    private final theModel model;
    private final Label labell;
    private final Label numLabel;
    private BorderPane panel1;
    private GridPane gPane;

    private BlockNumber bN;

    public theView(theModel model) {
        this.bN = BlockNumber.getInstance();
        this.tempNum = tempNum;
        this.toolNumberTF = new TextField("");
        this.spindleTF = new TextField("");
        this.feedTF = new TextField("");
        this.safetyHeightTF = new TextField("");
        this.retractHeightTF = new TextField("");
        this.depthTF = new TextField("");
        this.peckTF = new TextField("");

        this.gPane = new GridPane();
        this.numLabel = new Label();
        this.labell = new Label();
        //this.model = model;
        this.panel1 = new BorderPane();
        this.model = model;
    }

    @Override
    public Region build() {
        panel1.setPrefSize(1024, 768);
        System.out.println("Before call");
        panel1.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("/styleSheet.css")).toExternalForm());
        System.out.println("After call");
        panel1.setTop(MainMenuInfo());
        panel1.setLeft(ButtonOptions());
        panel1.setRight(profiles());

        return panel1;
    }

    /* private Node rightPanelDefault(){
        Label label = new Label("");
        HBox box = new HBox(label);
        box.getStyleClass().add("right-menu-buttons");
        return box;
    }
    
    private Node centerPaneDefult(){
        HBox box = new HBox();
        box.getStyleClass().add("center-menu-buttons");
        return box;
    }*/
    private Node profiles() {
        Button profile = new Button("Profile");

        profile.setMinWidth(150);

        profile.setOnAction(evt -> {
            panel1.setCenter(profileSelection());
            panel1.setRight(null);
        });

        VBox box = new VBox();
        box.getChildren().addAll(profile);
        box.getStyleClass().add("right-menu-buttons");
        box.setSpacing(20);
        box.setPadding(new Insets(20));
        return box;
    }

    private Node profileSelection() {
        //arraylist is a new profile class
        ArrayList profiles = new ArrayList<>();
        Button newProfile = new Button("New Profile");

        newProfile.setMinWidth(150);

        for (int i = 0; i < profiles.size(); i++) {
            new Button("add shit");
        }

        panel1.setLeft(backToMain());

        System.out.println("Before vbox");
        VBox box = new VBox();
        box.getChildren().addAll(newProfile);
        box.getStyleClass().add("center-menu-buttons");
        box.setSpacing(20);
        box.setPadding(new Insets(20));
        return box;
    }

    private Node backToMain() {
        Button back = new Button("Back");

        back.setMinWidth(150);

        back.setOnAction(evt -> {
            backToMainFromProfiles();
        });

        System.out.println("Before vbox");
        VBox box = new VBox();
        box.getChildren().addAll(back);
        box.getStyleClass().add("left-menu-buttons");
        box.setSpacing(20);
        box.setPadding(new Insets(20));
        return box;
    }

    private void backToMainFromProfiles() {
        panel1.setRight(profiles());
        panel1.setLeft(ButtonOptions());
        panel1.setCenter(null);
    }

    private Node MainMenuInfo() {
        Label tile = new Label("CAM Prototype");
        tile.getStyleClass().add("main-menu-text");
        HBox box = new HBox(10, tile);
        box.setPadding(new Insets(15));
        box.setSpacing(10);
        box.getStyleClass().add("main-menu");
        return box;
    }

    private Node ButtonOptions() {
        panel1.setLeft(null);
        System.out.println("Button options");
        Button drill = new Button("Drilling Cycles");
        Button mill = new Button("Milling Cycles");
        Button code = new Button("Code Blocks");
        Button exCode = new Button("Execute Code");
        Button graph = new Button("Graph");
        Button exit = new Button("Exit");

        drill.setMinWidth(150);
        mill.setMinWidth(150);
        code.setMinWidth(150);
        exCode.setMinWidth(150);
        graph.setMinWidth(150);
        exit.setMinWidth(150);

        drill.setOnAction(evt -> {
            panel1.setLeft(drillButtons());
            panel1.setRight(null);
            System.out.println("Drill");
        });

        exCode.setOnAction(evt -> {
            model.printBlocks();
            /*for (int i = 0; i < model.getBlockSize(); i++) {

                if (model.getBlockNum(i).getName().equals("Drill")) {
                    model.getBlockNum(i).getDrill().drillCycle();
                } else if (model.getBlockNum(i).getName().equals("Mill")) {
                    //Mill is not made yet
                    //model.getBlockNum(i).getMill().getToolnumber();
                }
            }*/
            Printable.closerWriter();
        });

        System.out.println("Before vbox");
        VBox box = new VBox();
        box.getChildren().addAll(drill, mill, code, exCode, graph, exit);
        box.getStyleClass().add("left-menu-buttons");
        box.setSpacing(20);
        box.setPadding(new Insets(20));
        return box;
    }

    private Node drillButtons() {
        Button centerDrill = new Button("Center Drill");
        Button drill = new Button("Drill");
        Button tap = new Button("Tap");
        Button ream = new Button("Ream");
        Button back = new Button("Back");

        centerDrill.setMinWidth(150);
        drill.setMinWidth(150);
        tap.setMinWidth(150);
        ream.setMinWidth(150);
        back.setMinWidth(150);

        drill.setOnAction(evt -> {
            drillPane();
            model.newDrill();
            System.out.println("Drill Programing");
        });
        back.setOnAction(evt -> {
            panel1.setLeft(ButtonOptions());
            panel1.setRight(profiles());
            System.out.println("Back");
        });

        VBox box = new VBox();
        box.getChildren().addAll(centerDrill, drill, tap, ream, back);
        box.getStyleClass().add("left-menu-buttons");
        box.setSpacing(20);
        box.setPadding(new Insets(20));
        return box;
    }

    private void drillPane() {
        panel1.setCenter(drillCenterPane());
        panel1.setRight(drillRight());
        panel1.setLeft(drillBackAndConfirm());
    }

    private Node drillCenterPane() {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        RowConstraints row1 = new RowConstraints();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(25);
        pane.getStyleClass().add("input-menu");

        Label drillTitle = new Label("Drilling Block Settings");
        drillTitle.getStyleClass().add("title-names");

        pane.add(drillTitle, 0, 0);
        setColumnSpan(drillTitle, 2);

        Label toolNumberLabel = new Label("Tool Number:");
        pane.add(toolNumberLabel, 0, 1);
        pane.add(toolNumberTF, 1, 1);

        Label spindleSpeedLabel = new Label("Spindle Speed:");
        pane.add(spindleSpeedLabel, 0, 2);
        pane.add(spindleTF, 1, 2);

        Label feedLabel = new Label("Feed:");
        pane.add(feedLabel, 0, 3);
        pane.add(feedTF, 1, 3);

        Label safetyHeight = new Label("Safety Height:");
        pane.add(safetyHeight, 0, 4);
        pane.add(safetyHeightTF, 1, 4);

        Label drillRetrLabel = new Label("Retract Height:");
        pane.add(drillRetrLabel, 0, 5);
        pane.add(retractHeightTF, 1, 5);

        Label finalDepthLabel = new Label("Final Depth:");
        pane.add(finalDepthLabel, 0, 6);
        pane.add(depthTF, 1, 6);

        Label peckLabel = new Label("Peck:");
        pane.add(peckLabel, 0, 7);
        pane.add(peckTF, 1, 7);

        return pane;
    }

    private Node drillRight() {
        return null;
    }

    private Node drillBackAndConfirm() {
//        int toolNumber;
//        int spindle;
//        double feed;
//        double saftey;
//        double retract;
//        double depth;
//        double peck;
        Button back = new Button("Back");
        Button confirm = new Button("Confirm");

        confirm.setMinWidth(150);
        back.setMinWidth(150);

        confirm.setOnAction(evt -> {
            panel1.setCenter(null);
            panel1.setLeft(drillLocationPatterns());
            System.out.println("Confirm -> Patterns");
            System.out.println("Drill Number While In View" + toolNumberTF);
            int toolNumber = Integer.valueOf(toolNumberTF.getText());
            int spindle = Integer.valueOf(spindleTF.getText());
            double feed = Double.valueOf(feedTF.getText());
            double saftey = Double.valueOf(safetyHeightTF.getText());
            double retract = Double.valueOf(retractHeightTF.getText());
            double depth = Double.valueOf(depthTF.getText());
            double peck = Double.valueOf(peckTF.getText());
            //Will not run the method if there is an empty text field
            model.drillCycle(toolNumber, spindle, feed, saftey, retract, depth, peck);
        });
        back.setOnAction(evt -> {
            panel1.setCenter(null);
            panel1.setLeft(drillButtons());
            System.out.println("Back");
        });

        VBox box = new VBox();
        box.getChildren().addAll(confirm, back);
        box.getStyleClass().add("left-menu-buttons");
        box.setSpacing(20);
        box.setPadding(new Insets(20));
        return box;
    }

    private Node drillLocationPatterns() {
        Label patternTitle = new Label("Patterns");
        Button patternLocation = new Button("Locations");
        Button patternRectangular = new Button("Rectangular");
        Button patternBolt = new Button("Bolt Circle");
        Button back = new Button("Back");

        patternLocation.setMinWidth(150);
        patternRectangular.setMinWidth(150);
        patternBolt.setMinWidth(150);
        back.setMinWidth(150);

        patternLocation.setOnAction(evt -> {
            panel1.setCenter(patternLocationNumber());
        });

        back.setOnAction(evt -> {
            drillPane();
        });

        VBox box = new VBox();
        box.getChildren().addAll(patternTitle, patternLocation, patternRectangular, patternBolt, back);
        box.getStyleClass().add("left-menu-buttons");
        box.setSpacing(20);
        box.setPadding(new Insets(20));
        return box;
    }

    private Node patternLocationNumber() {
        Label locationNumber = new Label("How many drill holes?");
        TextField number = new TextField("");
        Button numberEnter = new Button("Enter");
        locationNumber.setMinWidth(150);
        locationNumber.setPadding(new Insets(8));
        number.setMinWidth(150);
        numberEnter.setMaxWidth(150);

        numberEnter.setOnAction(evt -> {
            System.out.println("Before temp num");
            tempNum = Integer.valueOf(number.getText());
            System.out.println("Before pattern Locations");
            patternLocations();
            System.out.println("After pattern");
        });

        HBox box = new HBox(locationNumber, number, numberEnter);
        box.getStyleClass().add("input-menu");
        box.setSpacing(20);
        box.setPadding(new Insets(20));
        return box;
    }

    public void patternLocations() {
        System.out.println("GridPane for pattern");
        GridPane pane = new GridPane();
        int index = 0;
        int col = 0;
        int row = 0;
        Label[] label = new Label[tempNum];
        TextField[] x = new TextField[tempNum];
        TextField[] y = new TextField[tempNum];
        while (index < tempNum) {
            if ((index >= 14) && (col < 5)) {
                col += 5;
                row = 0;
            }
            if ((index >= 28) && (col < 10)) {
                col += 5;
                row = 0;
            }
            if ((index >= 42) && (col < 15)) {
                col += 5;
                row = 0;
            }
            label[index] = new Label((index + 1) + ":");
            Label xl = new Label("X");
            Label y1 = new Label("Y");

            x[index] = new TextField("");
            y[index] = new TextField("");

            pane.add(label[index], col, row);
            pane.add(xl, col + 1, row);
            pane.add(x[index], col + 2, row);
            pane.add(y1, col + 3, row);
            pane.add(y[index], col + 4, row);

            x[index].setPrefWidth(40);
            y[index].setPrefWidth(40);
            index++;
            row++;
        }
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.getStyleClass().add("input-menu");
        panel1.setCenter(pane);

        Button confirm = new Button("Confirm Locations");
        Button back = new Button("Back");

        confirm.setMinWidth(150);
        back.setMinWidth(150);

        back.setOnAction(evt -> {
            panel1.setCenter(patternLocationNumber());
        });

        //Take arrays and move the locations to the block
        //double xtemp;
        //double ytemp;
        confirm.setOnAction(evt -> {
            for (int i = 0; i < tempNum; i++) {
                if ((x[i].getText() == "null") || (y[i].getText() == "null")) {
                    continue;
                }
                if (x[i].getText().isEmpty() || y[i].getText().isEmpty()) {
                    continue;
                }
                double xtemp = Double.valueOf(x[i].getText());
                double ytemp = Double.valueOf(y[i].getText());
                model.addDrillPatternLocations(xtemp, ytemp);
            }
            model.getLocs(); //prints locations in output
            //model.addDrill();
            System.out.println("After confirm");
            //model.getLocs();
            //System.out.println(model.getBlockNum(0).getDrill().getLocations());
            panel1.setTop(MainMenuInfo());
            panel1.setLeft(ButtonOptions());
            panel1.setRight(profiles());
            model.drillNumAdd();
            panel1.setCenter(centerPaneBlocks());
        });

        VBox box = new VBox(confirm, back);
        box.getStyleClass().add("left-menu-buttons");
        box.setSpacing(20);
        box.setPadding(new Insets(20));
        panel1.setLeft(box);
    }

    private Node centerPaneBlocks() {
        GridPane pane = new GridPane();
        int size = model.getCurrentBlockNum();
        System.out.println(model.getCurrentBlockNum());
        int row = 0;
        int drillIndex = 0;
        int col = 0;

        Label[] blockNum = new Label[size];
        Label[] blockType = new Label[size];
        Label[] toolNumber = new Label[size];
        Label[] type = new Label[size];

        for (int i = 0; i <= (bN.getNumber() - 1); i++) {
//            blockNum[i] = new Label("Block: " + (i + 1));
//            blockType[i] = new Label(model.getBlockNum(i).getName());
//            type[i] = new Label("Type: ");
            if (model.getDrillatNum(drillIndex).getBlockNum() == (i)) {
                blockNum[i] = new Label("Block: " + (i + 1));
                blockType[i] = new Label("Drill");
                type[i] = new Label("Type: ");
                toolNumber[i] = new Label(String.valueOf(model.getDrillatNum(drillIndex).getToolnumber()));
                drillIndex++;
            }/*else if(mList.get(i).getBlockNum() == (i+1)){
                mList.get(i).drillCycle();
            }*/ else {
                continue;
            }

            /* if (model.getBlockNum(i).getName().equals("Drill")) {
                toolNumber[i] = new Label(String.valueOf(model.getBlockNum(i).getDrill().getToolnumber()));
            } else if (model.getBlockNum(i).getName().equals("Mill")) {
                //Mill is not made yet
                //model.getBlockNum(i).getMill().getToolnumber();
            }*/
            pane.add(blockNum[i], col, row);
            pane.add(type[i], col + 1, row);
            pane.add(blockType[i], col + 2, row);
            pane.add(toolNumber[i], col + 3, row);
            row++;
            col++;

        }
//        for (int i = 0; i < model.getBlockSize(); i++) {
//            blockNum[i] = new Label("Block: " + (i + 1));
//            blockType[i] = new Label(model.getBlockNum(i).getName());
//            type[i] = new Label("Type: ");
//
//            if (model.getBlockNum(i).getName().equals("Drill")) {
//                toolNumber[i] = new Label(String.valueOf(model.getBlockNum(i).getDrill().getToolnumber()));
//            } else if (model.getBlockNum(i).getName().equals("Mill")) {
//                //Mill is not made yet
//                //model.getBlockNum(i).getMill().getToolnumber();
//            }
//            pane.add(blockNum[i], i, row);
//            pane.add(type[i], i + 1, row);
//            pane.add(blockType[i], i + 2, row);
//            pane.add(toolNumber[i], i + 3, row);
//            row++;
//
//        }

        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.getStyleClass().add("input-menu");

        return pane;
    }

}
