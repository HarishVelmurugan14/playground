package zoho.designstudio.test.djangoTemplateLanguage.controllers;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

@Service
public class TemplateService {

    private final Configuration configuration;

    public TemplateService() {
        configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setClassForTemplateLoading(getClass(), "/templates");
        configuration.setDefaultEncoding("UTF-8");
    }

    public String processTemplate(String templateName, Map<String, Object> dataModel) throws IOException, TemplateException {
        Template template = configuration.getTemplate(templateName);
        StringWriter stringWriter = new StringWriter();
        template.process(dataModel, stringWriter);
        return stringWriter.toString();
    }
}
