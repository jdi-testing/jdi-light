package org.mytests.tests.example;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.mytests.tests.SimpleTestsInit;
import org.testng.annotations.Test;

import static org.influxdb.InfluxDBFactory.*;

public class PerfGrafanaTest extends SimpleTestsInit {

    @Test
    public void loginTest() {
        /*String host = System.getenv().getOrDefault("influx.host", "influxdb");
        InfluxDB db = connect("http://"+host+":8086", "root", "root");
        db.createDatabase();*/

    }
}
