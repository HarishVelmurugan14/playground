package zoho.designstudio.test.djangoTemplateLanguage.controllers;

import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {

    private final TemplateService templateService;

    @Autowired
    public MyController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping("/")
    public String showForm() {
        return "inputForm";
    }

    @PostMapping("/generateHTML")
    public ResponseEntity<String> generateHTML(@RequestParam String name) {
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("name", name);

        try {
            String html = templateService.processTemplate("dynamicTemplate.ftl", dataModel);
            return ResponseEntity.ok().body(html);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing template");
        }
    }
}
