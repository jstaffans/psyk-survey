package fi.bitrite.psyksurvey.repositories;

import fi.bitrite.psyksurvey.domain.Survey;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemorySurveyRepository implements SurveyRepository {

    private long maxId = 3L;

    private final Map<Long, Survey> surveys = new HashMap<Long, Survey>() {
        private static final long serialVersionUID = 1L;
        {
            put(1L, new Survey(1L, "First Survey"));
            put(2L, new Survey(2L, "Second Survey"));
            put(3L, new Survey(3L, "Third Survey"));
        }
    };

    @Override
    public void delete(Long id) {
        surveys.remove(id);
    }

    @Override
    public Collection<Survey> get() {
        return surveys.values();
    }

    @Override
    public Survey get(Long id) {
        return surveys.get(id);
    }

    private synchronized long nextId() {
        return ++maxId;
    }

    @Override
    public Survey save(Survey survey) {
        if (survey.getId() == null) {
            survey.setId(nextId());
        }

        surveys.put(survey.getId(), survey);
        return survey;
    }
}
