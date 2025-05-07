package org.acme;

import jakarta.inject.Inject;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import java.util.List;

@Path("/questions")
@Produces(MediaType.APPLICATION_JSON)
public class QuestionsResource {
    @Inject
    QuestionService questionService;

    @GET
    @Operation(summary = "Returns all the questions from the database")
    public Response getAllQuestions() {
        List<Question> questions = questionService.getQuestions();
        if (questions == null) {
            return Response.noContent().build();
        }
        return Response.ok(Question.class, MediaType.APPLICATION_JSON).entity(questions).build();
    }

    @GET
    @Path("/{id}")
    public Response getQuestion(@Parameter(description = "id of the question to look for") @PathParam("id") @Min(1) long id) {
        Question q = questionService.getQuestion(id);
        if (q == null) {
            return Response.noContent().build();
        }
        return Response.ok(Question.class, MediaType.APPLICATION_JSON).entity(q).build();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countQuestions() {
        Long questionsCount= questionService.countQuestions();
        if (questionsCount == 0) {
            return Response.noContent().build();
        }
        return Response.ok(questionsCount).build();
    }
}
