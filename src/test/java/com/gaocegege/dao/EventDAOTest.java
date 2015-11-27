package com.gaocegege.dao;

import junit.framework.Assert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gaocegege.HibernateSpatialExampleApplication;
import com.gaocegege.domain.Event;
import com.jayway.restassured.RestAssured;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

/**
 * EventDAO Test Class
 * 
 * @author gaoce
 * @version $Id: EventDAOTest.java, v 0.1 2015年11月27日 下午12:54:35 gaoce Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HibernateSpatialExampleApplication.class)
@WebIntegrationTest("server.port:0")
public class EventDAOTest {
    @Autowired
    private EventDAO  eventDAO;

    private Logger    logger = LogManager.getLogger(EventDAOTest.class);

    private WKTReader reader = new WKTReader();

    private Point buildGeometry(int x, int y) throws ParseException {
        final String format = String.format("POINT(%s %s)", x, y);
        final Geometry result = reader.read(format);
        // this is ot the most elegant way to build a point
        return (Point) result;
    }

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void testInsertAndQuery() throws ParseException {
        Point location;
        location = buildGeometry(10, 5);

        Event item = new Event();
        item.setLocation(location);
        eventDAO.save(item);

        Event result = eventDAO.findByLocation(location);
        Assert.assertNotNull(result);
    }
}
