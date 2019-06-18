package rm.kubeboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KubebootApplication

fun main(args: Array<String>) {
	runApplication<KubebootApplication>(*args)
}
