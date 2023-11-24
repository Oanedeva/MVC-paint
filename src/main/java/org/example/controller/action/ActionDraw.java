package org.example.controller.action;

import org.example.controller.Controller;
import org.example.model.Model;
import org.example.model.MyShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
@Component
public class ActionDraw extends Controller {
    private MyShape sampleShape;
    private MyShape shape;
    private Point2D[] p;
    private Model model;

    @PostConstruct
    public void init(){
        shape=new MyShape();
        p=new Point2D[2];
    }
    public void setSampleShape(MyShape shape){
        this.sampleShape=shape;
    }

    public void setShape(MyShape shape){this.shape=shape;}
     public void stretchShape(Point point){
        p[1] =(Point2D) point;
        shape.setFrame(p);
    }

    @Autowired
    public void setModel(Model model) {
        this.model = model;
    }

    public void createShape(Point point){
        p[0] = (Point2D)point;
        shape = sampleShape.clone();
        model.createCurrentShape(shape);
    }
}
