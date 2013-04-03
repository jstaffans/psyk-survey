package fi.bitrite.psyksurvey.repositories;

import fi.bitrite.psyksurvey.domain.Survey;

import java.util.Collection;

public interface SurveyRepository {

    public Collection<Survey> get();

    public Survey get(Long id);

    public Survey save(Survey survey);

    public void delete(Long id);
}
