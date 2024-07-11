package co.com.apirest.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.apirest.project.utils.Constants.STATUS;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteQuestion implements Question<Boolean> {

    private int statusDelete;

    public DeleteQuestion(int statusDelete) {
        this.statusDelete = statusDelete;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse(STATUS, response -> response.statusCode(statusDelete)
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))));
        return true;
    }

    public static DeleteQuestion successFul(int statusDelete){
        return new DeleteQuestion(statusDelete);
    }
}
