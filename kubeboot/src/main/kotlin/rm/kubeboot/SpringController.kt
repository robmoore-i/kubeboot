package rm.kubeboot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SpringController {
    @GetMapping("/")
    fun home(): String {
        return requestHandler.home()
    }

    companion object {
        lateinit var requestHandler: RequestHandler
    }
}