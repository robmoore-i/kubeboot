package rm.kubeboot

import org.springframework.boot.ExitCodeGenerator
import org.springframework.boot.SpringApplication.exit
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class SpringApplication {
    companion object {
        lateinit var context: ConfigurableApplicationContext

        fun start(portNumber: Int) {
            start(portNumber, RequestHandler())
        }

        fun start(portNumber: Int, requestHandler: RequestHandler) {
            SpringController.requestHandler = requestHandler
            context = SpringApplicationBuilder(SpringApplication::class.java)
                    .properties(mapOf(Pair("server.port", portNumber)))
                    .run()
        }

        fun stop() {
            exit(context, ExitCodeGenerator { 0 })
        }
    }
}
