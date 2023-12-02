package org.example.controller;

import org.example.controller.action.ActionDraw;
import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.shape.factory.ShapeType;
import org.example.model.shape.fill.Fill;
import org.example.model.shape.fill.NoFill;
import org.example.view.MyFrame;
import org.example.view.MyPanel;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

@org.springframework.stereotype.Controller
public class Controller implements MenuObserver{
    private ActionDraw actionDraw;
    private Model model;
    private MyFrame frame;
    private MyPanel panel;
    private Point2D [] pd;
    private MyShape shape;
    //private MenuController menuController;

   /* public Controller() {

        model = new Model();

        shape = new MyShape(new Rectangle2D.Double());
        shape.setFb(new NoFill());
        model.setMyShape(shape);

        model.addObserver(panel);

        pd = new Point2D[2];
    }*/
    @PostConstruct
    public void init(){
        shape = ShapeType.RECTANGULAR.createShape(Color.black,new NoFill());
        /*shape.setFb(new NoFill());*/
        //shape=ShapeType.ELLIPSE.createShape(Color.black,new NoFill());

        model.setMyShape(shape);
        actionDraw.setSampleShape(shape);
        model.addObserver(panel);
        MenuController menuController=new MenuController();
        frame.setJMenuBar(menuController.getMenuBar());
        pd = new Point2D[2];
       // menuController.setController(this);
    }

    @Autowired
    public void setModel(Model model) {
        this.model = model;
    }
    @Autowired
    public void setPanel(MyPanel panel) {
        this.panel = panel;
    }
    @Autowired
    public void setFrame(MyFrame frame) {
        this.frame = frame;
    }
    @Autowired
    public void setActionDraw(ActionDraw actionDraw) {
        this.actionDraw = actionDraw;
    }
  //  @Autowired
  //  public void setMenuController(MenuController menuController){this.menuController=menuController;}

    public void mousePressed(Point point){
        actionDraw.createShape(point);
    }
    public void mouseDragget(Point point){
    actionDraw.stretchShape(point);
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }
}
