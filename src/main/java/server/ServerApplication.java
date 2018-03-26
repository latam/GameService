package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import server.network.Server;

@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(ServerApplication.class, args);
        Server serverBean = ctx.getBean(Server.class);
        serverBean.run();
    }
}
