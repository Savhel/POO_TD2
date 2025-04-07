package controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import service.UserService;
import model.User;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class UserController {
    private final UserService UserService = new UserService();

    public HttpHandler createUser = exchange -> {
        if ("POST".equals(exchange.getRequestMethod())) {
            String requestBody = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
            // Parse request body (ex: "name=John&age=30")
            String[] params = requestBody.split("&");
            String name = params[0].split("=")[1];
            int age = Integer.parseInt(params[1].split("=")[1]);

            User User = UserService.createUser(name, age);
            sendResponse(exchange, 201, "Created: " + User.getId());
        } else {
            sendResponse(exchange, 405, "Method Not Allowed");
        }
    };

    public HttpHandler getUser = exchange -> {
        if ("GET".equals(exchange.getRequestMethod())) {
            String[] path = exchange.getRequestURI().getPath().split("/");
            int id = Integer.parseInt(path[path.length - 1]);
            User User = UserService.getUser(id);

            if (User != null) {
                sendResponse(exchange, 200, User.toString());
            } else {
                sendResponse(exchange, 404, "User not found");
            }
        }
    };

    private void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "text/plain");
        exchange.sendResponseHeaders(statusCode, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}