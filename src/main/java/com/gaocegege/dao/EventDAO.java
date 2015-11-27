package com.gaocegege.dao;

import org.springframework.data.repository.CrudRepository;

import com.gaocegege.domain.Event;
import com.vividsolutions.jts.geom.Point;

/**
 * Event DAO
 * 
 * @author gaoce
 * @version $Id: EventDAO.java, v 0.1 2015年11月27日 下午1:00:27 gaoce Exp $
 */
public interface EventDAO extends CrudRepository<Event, Integer> {
    public Event findByLocation(Point location);
}
