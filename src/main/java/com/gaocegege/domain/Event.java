package com.gaocegege.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;

/**
 * Event Domain
 * 
 * @author gaoce
 * @version $Id: Event.java, v 0.1 2015年11月27日 下午12:50:02 gaoce Exp $
 */
@Entity
@Table(name = "event")
public class Event {
    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int   id;

    @Column(name = "location")
    @NotNull
    @Type(type = "org.hibernate.spatial.GeometryType")
    private Point location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
