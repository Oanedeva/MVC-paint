package org.example.model;

import org.example.model.shape.fill.Fill;
import org.example.model.shape.fill.FillBehavior;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class MyShape implements Cloneable{
    private Color color;
    private RectangularShape shape;

    private FillBehavior fillBehavior;
    Cloneable cloneable;

    public void setShape(RectangularShape shape) {
        this.shape = shape;
    }

    public RectangularShape getShape() {
        return shape;
    }

    public void setFrame(Point2D[] pd) {
        shape.setFrameFromDiagonal(pd[0], pd[1]);
    }

    public MyShape(RectangularShape shape) {
        this.shape = shape;
        color = Color.GRAY;
        fillBehavior = new Fill();
        fillBehavior.setColor(color);
        fillBehavior.serShape(shape);
    }

    public MyShape() {
        color = Color.YELLOW;
        shape = new Rectangle2D.Double();
        fillBehavior = new Fill();
        fillBehavior.setColor(color);
        fillBehavior.serShape(shape);
    }

    public MyShape(Color color, RectangularShape shape, FillBehavior fillBehavior) {
        this.color = color;
        this.shape = shape;
        this.fillBehavior =fillBehavior;
        this.fillBehavior.serShape(shape);
        this.fillBehavior.setColor(color);
    }

    public void setFillBehavior(FillBehavior fillBehavior) {
        this.fillBehavior = fillBehavior;
        fillBehavior.serShape(shape);
        fillBehavior.setColor(color);
    }
    void draw(Graphics2D g) {
        fillBehavior.draw(g);
        fillBehavior.setColor(color);
        fillBehavior.serShape(shape);
    }
    @Override
    public MyShape clone(){
        MyShape clone=new MyShape();
        clone.shape= (RectangularShape) this.shape.clone();
        clone.fillBehavior=this.fillBehavior;
        clone.color=this.color;
        clone.setShape(clone.shape);
        return clone;
    }

}
