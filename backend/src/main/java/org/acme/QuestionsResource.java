package org.acme;

import io.vertx.core.cli.annotations.Summary;
import jakarta.inject.Inject;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("/api/questions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionsResource {
    @Inject
    QuestionService questionService;

    @GET
    @Operation(summary = "Returns all the questions from the database")
    @APIResponse(responseCode = "200", description = "Questions found",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = Question.class, type = SchemaType.ARRAY)))
    @APIResponse(responseCode = "404", description = "No questions found")
    public Response getAllQuestions() {
        List<Question> questions = questionService.getQuestions();
        if (questions == null) {
            return Response.noContent().build();
        }
        return Response.ok(Question.class, MediaType.APPLICATION_JSON).entity(questions).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Retrieve a single question by its ID")
    @APIResponse(responseCode = "200", description = "Question found!",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = Question.class)))
    @APIResponse(responseCode = "404", description = "Question not found!")
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
    @Operation(summary = "Return the total number of questions stored in the db")
    @APIResponse(responseCode = "200",
            description = "Questions found in the db",
            content = @Content(mediaType = MediaType.TEXT_PLAIN,
                    schema = @Schema(implementation = Long.class)))
    public Response countQuestions() {
        Long questionsCount = questionService.countQuestions();
        if (questionsCount == 0) {
            return Response.noContent().build();
        }
        return Response.ok(questionsCount).build();
    }


    @POST
    @Operation(summary = "Adds a question to the database")
    @APIResponse(responseCode = "201",
            description = "Question added to the db",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Question.class)))
    public Response createQuestion(Question question) throws URISyntaxException {
        Question q = questionService.insertQuestion(question);
        // Reminder: if I don't build the <entity>, I have no body of the response.
        return Response.created(URI.create("/questions/" + q.id)).entity(q).build();
    }
}
