package rm.kubeboot

import org.springframework.boot.ExitCodeGenerator
import org.springframework.boot.SpringApplication.exit
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@SpringBootApplication
@RestController
class SpringController {
    companion object {
        lateinit var context: ConfigurableApplicationContext

        fun start(portNumber: Int) {
            context = SpringApplicationBuilder(SpringController::class.java)
                    .properties(mapOf(Pair("server.port", portNumber)))
                    .run()
        }

        fun stop() {
            exit(context, ExitCodeGenerator { 0 })
        }
    }

    @GetMapping("/")
    fun home(): String {
        return "Hello, I am Kubeboot"
    }
}
