package controller;

import Models.UsersModel;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class UserController {
//    private final UserService UserService = new UserService();

    public HttpHandler createUser = exchange -> {
        if ("POST".equals(exchange.getRequestMethod())) {
            String requestBody = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
            // Parse request body (ex: "name=John&age=30")
            String[] params = requestBody.split("&");
            String name = params[0].split("=")[1];
            int age = Integer.parseInt(params[1].split("=")[1]);

//            User User = UserService.createUser(name, age);
            sendResponse(exchange, 201, "Created: ");
        } else {
            sendResponse(exchange, 405, "Method Not Allowed");
        }
    };

    public static HttpHandler getUser = exchange -> {
        if ("GET".equals(exchange.getRequestMethod())) {
            String[] path = exchange.getRequestURI().getPath().split("/");
            int id = Integer.parseInt(path[path.length - 1]);
//            UsersModel User = UsersModel.getID(id);

            if (1 == 1) {
                sendResponse(exchange, 200, ".toString()");
            } else {
                sendResponse(exchange, 404, "User not found");
            }
        }
    };

    public static void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "text/plain");
        exchange.sendResponseHeaders(statusCode, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}