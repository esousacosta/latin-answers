package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

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
    public Response getSingleQuestion() {
        return Response.ok("returns a single question that was fetched by its id").build();
    }
}
