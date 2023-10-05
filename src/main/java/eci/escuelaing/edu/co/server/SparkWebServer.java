package eci.escuelaing.edu.co.server;

import eci.escuelaing.edu.co.connection.MongoConnection;
import static spark.Spark.*;



public class SparkWebServer {

    public static void main(String... args){
        port(getPort());
        get("/logs", (req,res) -> {
            String log = req.queryParams("log");
            MongoConnection.insertLog(log);
            return MongoConnection.getLast10Logs();
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }

}