package org.example.controller.menu;

import org.example.model.MyShape;
import org.example.model.shape.factory.ShapeType;
import org.example.model.shape.factory.fill.Fill;
import org.example.model.shape.factory.fill.FillBehavior;
import org.example.model.shape.factory.fill.NoFill;
import org.example.undoredo.UndoMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class MenuController {
    JMenuBar menu;
    private ShapeType selectedShape;
    private Color selectedColor;
    public Color selectedColorFill;
    private  FillBehavior selectedFill;
    private MenuObserver menuObserver;
    private UndoMachine undoMachine;

    //private ShapeType selectedShape1;
    //private Color selectedColor1;
    //private  FillBehavior selectedFill1;

    @PostConstruct
    public void init() {
        menu = new JMenuBar();
        JMenu shapeMenu = createShapeMenu();
        JMenu colorMenu = createColorMenu();
        JMenu fillMenu = createFillMenu();
        JMenu fillBezZalivki = createFrameBezZalivkiMenu();
        JMenu undoRedoMenu = createUndoRedoMenu();
        menu.add(shapeMenu);
        menu.add(colorMenu);
        menu.add(fillMenu);
        menu.add(fillBezZalivki);
        menu.add(undoRedoMenu);
        defaultState();
    }

    private void defaultState() {
        selectedShape = ShapeType.RECTANGULAR;
        selectedColor = Color.BLACK;
        selectedFill = new NoFill();

    }

    private JMenu createShapeMenu() {
        JMenu shapeMenu = new JMenu("Фигура");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem square = new JRadioButtonMenuItem("Прямоугольник");
        square.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedShape = ShapeType.RECTANGULAR;
                selectedShape.createShape(selectedColor,selectedFill);
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
                selectedShape.createShape(selectedColor,selectedFill);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(ellipse);
        group.add(ellipse);
        return shapeMenu;
    }

    private JMenu createFillMenu(){
        JMenu shapeMenu = new JMenu("Заливка");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem zalivka = new JRadioButtonMenuItem("Есть заливка");
        zalivka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedFill = new Fill();
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });

        shapeMenu.add(zalivka);
        group.add(zalivka);
        JRadioButtonMenuItem netZalivki = new JRadioButtonMenuItem("Нет заливки");
        netZalivki.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedFill = new NoFill();
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(netZalivki);
        group.add(netZalivki);

        return shapeMenu;
    }

    private JMenu createColorMenu() {
        JMenu shapeMenu = new JMenu("Цвет");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem black = new JRadioButtonMenuItem("Черный");
        black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.BLACK;
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(black);
        group.add(black);
        JRadioButtonMenuItem red = new JRadioButtonMenuItem("Красный");
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.RED;
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(red);
        group.add(red);
        JRadioButtonMenuItem blue = new JRadioButtonMenuItem("Синий");
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.BLUE;
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(blue);
        group.add(blue);
        JRadioButtonMenuItem green = new JRadioButtonMenuItem("Зеленый");
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
        shapeMenu.add(green);
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
        shapeMenu.add(yellow);
        group.add(yellow);
        JRadioButtonMenuItem cyan = new JRadioButtonMenuItem("Циановый");
        cyan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.CYAN;
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(cyan);
        group.add(cyan);
        JRadioButtonMenuItem magenta = new JRadioButtonMenuItem("Пурпурный");
        magenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.MAGENTA;
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(magenta);
        group.add(magenta);
        JRadioButtonMenuItem orange = new JRadioButtonMenuItem("Оранжевый");
        orange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.ORANGE;
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(orange);
        group.add(orange);
        return shapeMenu;
    }

    private JMenu createFrameBezZalivkiMenu(){
        JMenu shapeMenu = new JMenu("Цвет рамки");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem blue = new JRadioButtonMenuItem("Синий");
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.BLUE;
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(blue);
        group.add(blue);
        JRadioButtonMenuItem green = new JRadioButtonMenuItem("Зеленый");
        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.GREEN;
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(green);
        group.add(green);
        JRadioButtonMenuItem red = new JRadioButtonMenuItem("Красный");
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.RED;
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(red);
        group.add(red);
        JRadioButtonMenuItem yellow = new JRadioButtonMenuItem("Жёлтый");
        yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.YELLOW;
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(yellow);
        group.add(yellow);
        JRadioButtonMenuItem cyan = new JRadioButtonMenuItem("Циановый");
        cyan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.CYAN;
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });

        shapeMenu.add(cyan);
        group.add(cyan);
        return shapeMenu;
    }
    private JMenu createUndoRedoMenu() {
        JMenu shapeMenu = new JMenu("Undo|Redo");
        ButtonGroup group = new ButtonGroup();
        JButton undoButton = new JButton("Undo");
        shapeMenu.add(undoButton);

        group.add(undoButton);
        JButton redoButton = new JButton("Redo");
        shapeMenu.add(redoButton);
        group.add(redoButton);

//        undoButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                undoMachine.executeUndo();
//                undoButton.setEnabled(undoMachine.isEnableUndo());
//                redoButton.setEnabled(undoMachine.isEnableRedo());
//            }
//        });

        undoButton.addActionListener(e -> {
            undoMachine.executeUndo();
            undoButton.setEnabled(undoMachine.isEnableUndo());
            redoButton.setEnabled(undoMachine.isEnableRedo());
        });

        redoButton.addActionListener(e -> {
            undoMachine.executeRedo();
            undoButton.setEnabled(undoMachine.isEnableUndo());
            redoButton.setEnabled(undoMachine.isEnableRedo());
        });

        //Вызов метода updateUndoRedoButtons делать в контроллере на событие
        //нажатия мыши (mousePressed) и на события нажатия кнопки (actionListener
        //кнопок undo и redo)

        return shapeMenu;
    }

    public void updateUndoRedoButtons(){
        //Дописать
        //Для JButton с кнопками undo и redo
        //вызывать метод setEnabled
    }


    @Autowired
    public MenuController(UndoMachine undoMachine) {
        this.undoMachine = undoMachine;
    }

    public JMenuBar getMenu() {
        return menu;
    }

    public Color selectedColor(){
        return null;
    }

    public FillBehavior selectedFill(){
        return null;
    }

    public ShapeType getSelectedShape() {
        return selectedShape;
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public FillBehavior getSelectedFill() {
        return selectedFill;
    }
    @Autowired
    public void setMenuObserver(MenuObserver menuObserver) {
        this.menuObserver = menuObserver;
    }
}