package org.example.controller;

import org.example.controller.action.ActionDraw;
import org.example.model.MyShape;
import org.example.model.shape.factory.ShapeType;
import org.example.model.shape.fill.Fill;
import org.example.model.shape.fill.FillBehavior;
import org.example.model.shape.fill.NoFill;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RectangularShape;

public class MenuController extends Controller{
    JMenu shapeMenuu=createShapeMenu();
    JMenu colorMenu=createColorMenu();
    JMenu fillMenu=createFillMenu();
    ActionDraw actionDraw;
    Controller controller;

    private ShapeType selectedShape;
    private Color selectedColor;
    private FillBehavior selectedFill;
    @PostConstruct
    public JMenuBar getMenuBar(){
        JMenuBar menu=new JMenuBar();
        JMenu shapeMenu=createShapeMenu();
        JMenu colorMenu=createColorMenu();
        JMenu fillMenu=createFillMenu();
        menu.add(colorMenu);
        menu.add(shapeMenu);
        menu.add(fillMenu);
        return menu;
    }
    private JMenu createShapeMenu() {
        JMenu shapeMenu = new JMenu("Фигура");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem square = new JRadioButtonMenuItem("Прямоугольник");
        square.addActionListener(e -> selectedShape = ShapeType.RECTANGULAR);
        shapeMenuu.add(square);
        group.add(square);
        JRadioButtonMenuItem ellipse = new JRadioButtonMenuItem("Эллипс");
        ellipse.addActionListener(e -> selectedShape = ShapeType.ELLIPSE);
        shapeMenuu.add(ellipse);
        group.add(ellipse);
        JRadioButtonMenuItem roundRectangular = new JRadioButtonMenuItem("Закругленный прямоугольник");
        roundRectangular.addActionListener(e -> selectedShape = ShapeType.ROUND_RECTANGULAR);
        shapeMenuu.add(roundRectangular);
        group.add(roundRectangular);
        return shapeMenu;
    }
    private JMenu createColorMenu(){
        JMenu shapeMenu = new JMenu("Цвет");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem black=new JRadioButtonMenuItem("Чёрный");
        black.addActionListener(e -> selectedColor = Color.BLACK);
        colorMenu.add(black);
        group.add(black);
        JRadioButtonMenuItem blue=new JRadioButtonMenuItem("Синий");
        blue.addActionListener(e -> selectedColor = Color.BLUE);
        colorMenu.add(blue);
        group.add(blue);
        JRadioButtonMenuItem red=new JRadioButtonMenuItem("Красный");
        red.addActionListener(e -> selectedColor = Color.RED);
        colorMenu.add(red);
        group.add(red);
        JRadioButtonMenuItem green=new JRadioButtonMenuItem("Зелёный");
        green.addActionListener(e -> selectedColor = Color.GREEN);
        colorMenu.add(green);
        group.add(green);
        JRadioButtonMenuItem yellow=new JRadioButtonMenuItem("Жёлтый");
        yellow.addActionListener(e -> selectedColor = Color.YELLOW);
        colorMenu.add(yellow);
        group.add(yellow);
        return shapeMenu;
    }
    private JMenu createFillMenu(){
        JMenu shapeMenu = new JMenu("Закрашивание");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem fill=new JRadioButtonMenuItem("Закрашено");
        fill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedFill = new Fill();
                selectedFill.setColor(selectedColor);
                MyShape shape=selectedShape.createShape(selectedColor,selectedFill);
                selectedFill.serShape(shape.getShape());
                MenuObserver.notifyAllSubscribers();
            }
        });
        fillMenu.add(fill);
        group.add(fill);
        JRadioButtonMenuItem nofill=new JRadioButtonMenuItem("Не закрашено");
        //nofill.addActionListener(e -> selectedFill=);
        fillMenu.add(nofill);
        group.add(nofill);
        return shapeMenu;
    }

    /*public void setController(Controller controller) {
        this.controller=controller;
    }*/
}
