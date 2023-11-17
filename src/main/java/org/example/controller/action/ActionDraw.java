package org.example.controller.action;

import org.example.controller.Controller;
import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class ActionDraw extends Controller {
    private MyShape sampleShape;
    private MyShape shape;
    private Point2D[] p;
    private Model model;
    public ActionDraw() {
    }
  /*  public ActionDraw(Model model){
        shape=new MyShape();
    }*/
     public void stretchShape(Point point){
        p[1] =(Point2D) point;
        shape.setFrame(p);
    }
    public void createShape(Point point){
        p[0] = (Point2D)point;
        shape = sampleShape.clone();
        model.createCurrentShape(shape);
    }
}
