import com.sun.net.httpserver.HttpServer;

public class App {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        PersonController personController = new PersonController();
        TaskController taskController = new TaskController();

        // Contexte global pour /api
        server.createContext("/api", exchange -> {
            String path = exchange.getRequestURI().getPath();
            String method = exchange.getRequestMethod();

            // Route POST /api/persons
            if ("POST".equals(method) && "/api/persons".equals(path)) {
                personController.createPerson.handle(exchange);
            }
            // Route POST /api/tasks
            else if ("POST".equals(method) && "/api/tasks".equals(path)) {
                taskController.createTask.handle(exchange);
            }
            // Route non trouvée
            else {
                personController.sendResponse(exchange, 404, "Endpoint not found");
            }
        });

        server.start();
        System.out.println("Server started on port 8080");
    }
}