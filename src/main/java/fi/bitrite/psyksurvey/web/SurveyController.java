package fi.bitrite.psyksurvey.web;

import fi.bitrite.psyksurvey.domain.Survey;
import fi.bitrite.psyksurvey.repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;

    @ModelAttribute("allSurveys")
    public Collection<Survey> populateSurveys() {
        return surveyRepository.get();
    }

    @RequestMapping("/")
    public String home() {
        return "surveys";
    }
}
