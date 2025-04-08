import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.net.InetSocketAddress;
import java.io.IOException;
import java.io.OutputStream;
import controller.UserController;

// Supprimez cet import statique qui n'est pas approprié
// import static java.sql.DriverManager.println;

public class App {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(9000), 0);
//        PersonController personController = new PersonController();
//        TaskController taskController = new TaskController();

        // Contexte global pour /api
        server.createContext("/api", exchange -> {
            String path = exchange.getRequestURI().getPath();
            String method = exchange.getRequestMethod();

            // Route POST /api/persons
            if ("POST".equals(method) && "/api/persons/{id}".equals(path)) {
                UserController.getUser.handle(exchange);
                System.out.println("POST /api/persons");
            }
            // Route POST /api/tasks
            else if ("POST".equals(method) && "/api/tasks".equals(path)) {
//                taskController.createTask.handle(exchange);
                System.out.println("POST /api/tasks");
            }
            // Route non trouvée
            else {
                // Remplacer l'appel à controller.UserController.sendResponse par une méthode locale
                sendResponse(exchange, 404, "Endpoint not found");
            }
        });

        server.start();
        System.out.println("Server started on port 9000");
    }
    
    // Ajout d'une méthode pour envoyer des réponses HTTP
    private static void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        // Set Content-Type header to application/json
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(statusCode, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}