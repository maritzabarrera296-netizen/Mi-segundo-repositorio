package persona.info.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonaController {

    @GetMapping("/info_persona")
    public String mostrarInfo(Model model) {
        model.addAttribute("nombre", "Luis");
        return "info_persona";
    }


}
