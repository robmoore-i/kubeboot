@file:JvmName("MainClass")

package rm.kubeboot

import org.springframework.boot.runApplication

fun main(args: Array<String>) {
    runApplication<KubebootApplication>(*args)
}
