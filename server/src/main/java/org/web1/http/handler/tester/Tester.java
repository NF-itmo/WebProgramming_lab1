package org.web1.http.handler.tester;

import org.validator.ValidatedRecordFactory;
import org.validator.validation.exceptions.ValidationException;
import org.web1.http.RequestContext;
import org.web1.http.handler.tester.checkers.Checker;
import org.web1.http.handler.tester.checkers.CheckerFunction;
import org.web1.utils.json.JsonBuilder;
import org.web1.http.response.ResponseStatus;
import org.web1.utils.time.Stopwatch;

import java.util.function.Consumer;

public class Tester implements Consumer<RequestContext> {
    private static final Stopwatch timer = new Stopwatch();
    private static final CheckerFunction checker = new Checker();

    @Override
    public void accept(
            final RequestContext endpointData
    ) {
        timer.start();

        try {
            RequestDTO requestData = ValidatedRecordFactory.create(
                    RequestDTO.class,
                    endpointData.queryParams().get("x"),
                    endpointData.queryParams().get("r"),
                    endpointData.queryParams().get("y")
            );

            boolean checkResult = checker.test(
                    Integer.parseInt(requestData.X()),
                    Float.parseFloat(requestData.Y()),
                    Float.parseFloat(requestData.R())
            );

            endpointData.responseController().send(
                    new JsonBuilder()
                            .add("result", checkResult)
                            .add("elapsedTimeNs", timer.stop()),
                    ResponseStatus.OK
            );
        } catch (ValidationException e) {
            endpointData.responseController().send(
                    new JsonBuilder()
                            .add("error", '"' + e.getMessage() + '"'),
                    ResponseStatus.BAD_REQUEST
            );
        }

    }
}
