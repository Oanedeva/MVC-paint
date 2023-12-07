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

public class MenuController {
    JMenu shapeMenuu=createShapeMenu();
    JMenu colorMenu=createColorMenu();
    JMenu fillMenu=createFillMenu();
    MenuObserver  menuObserver;
    JMenuBar menu;
    private ShapeType selectedShape;
    private Color selectedColor;
    private FillBehavior selectedFill;
    @PostConstruct
    public void init() {
        menu = new JMenuBar();
        JMenu shapeMenu = createShapeMenu();
        JMenu colorMenu = createColorMenu();
        JMenu fillMenu = createFillMenu();
       /* JMenu frameFillMenu = createFillBezRamkiMenu();
        JMenu fillBezZalivki = createFrameBezZalivkiMenu();
        JMenu frameBezRamki = createFillBezRamkiMenu();
        menu.add(shapeMenu);
        menu.add(colorMenu);
        menu.add(fillMenu);
        menu.add(fillBezZalivki);
        menu.add(frameFillMenu);*/
    }
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
        square.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedShape = ShapeType.RECTANGULAR;
                selectedShape.createShape(selectedColor, selectedFill);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(square);
        group.add(square);
        JRadioButtonMenuItem ellipse = new JRadioButtonMenuItem("Эллипс");
         ellipse.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent actionEvent) {
                 selectedShape = ShapeType.ELLIPSE;
                 selectedShape.createShape(selectedColor, selectedFill);
                 MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                 selectedFill.serShape(shape.getShape());
                 menuObserver.notifyAllSubscribers();
             }
         });
        shapeMenu.add(ellipse);
        group.add(ellipse);
        /*JRadioButtonMenuItem roundRectangular = new JRadioButtonMenuItem("Закругленный прямоугольник");
        roundRectangular.addActionListener(e -> selectedShape = ShapeType.ROUND_RECTANGULAR);
        shapeMenuu.add(roundRectangular);
        group.add(roundRectangular);*/
        return shapeMenu;
    }
    private JMenu createColorMenu(){
        JMenu colorMenu = new JMenu("Цвет");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem black=new JRadioButtonMenuItem("Чёрный");
        black.addActionListener(  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.BLACK;
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        colorMenu.add(black);
        group.add(black);
        JRadioButtonMenuItem blue=new JRadioButtonMenuItem("Синий");
        blue.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.BLUE;
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        colorMenu.add(blue);
        group.add(blue);
        JRadioButtonMenuItem red=new JRadioButtonMenuItem("Красный");
        red.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.RED;
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        colorMenu.add(red);
        group.add(red);
        JRadioButtonMenuItem green=new JRadioButtonMenuItem("Зелёный");
        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.GREEN;
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        colorMenu.add(green);
        group.add(green);
        JRadioButtonMenuItem yellow=new JRadioButtonMenuItem("Жёлтый");
        yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.YELLOW;
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        colorMenu.add(yellow);
        group.add(yellow);
        return colorMenu;
    }
    private JMenu createFillMenu(){
        JMenu fillMenu = new JMenu("Закрашивание");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem fill=new JRadioButtonMenuItem("Закрашено");
        fill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedFill = new Fill();
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        fillMenu.add(fill);
        group.add(fill);
        JRadioButtonMenuItem nofill=new JRadioButtonMenuItem("Не закрашено");
        nofill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedFill = new NoFill();
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        fillMenu.add(nofill);
        group.add(nofill);
        return fillMenu;
    }

    public void setMenuObserver(MenuObserver menuObserver) {
        this.menuObserver = menuObserver;
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public FillBehavior getSelectedFill() {
        return selectedFill;
    }

    public ShapeType getSelectedShape() {
        return selectedShape;
    }
}
