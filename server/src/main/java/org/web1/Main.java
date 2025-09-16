package org.web1;

import com.fastcgi.*;

import java.util.HashMap;
import java.util.function.Function;

import org.validator.ValidatedRecordFactory;
import org.validator.validation.exceptions.ValidationException;
import org.web1.DTOs.RequestDTO;
import org.web1.checkers.Checker;
import org.web1.checkers.CheckerFunction;
import org.web1.utils.mappers.JsonBuilder;
import org.web1.utils.mappers.QueryStringToHashmap;
import org.web1.utils.responce.ResponseController;
import org.web1.utils.responce.ResponseStatus;
import org.web1.utils.timer.Timer;

public class Main {
    private static final Function<String, HashMap<String,String>> parseQuery = new QueryStringToHashmap();
    private static final CheckerFunction checker = new Checker();

    public static void main(String[] args) {
        FCGIInterface fastCGI = new FCGIInterface();
        Timer timer = new Timer();

        while (fastCGI.FCGIaccept() >= 0) {
            timer.start();

            final HashMap<String, String> queryParams = parseQuery.apply(
                    FCGIInterface.request.params.getProperty("QUERY_STRING")
            );

            try {
                RequestDTO requestData = ValidatedRecordFactory.create(
                        RequestDTO.class,
                        queryParams.get("x"),
                        queryParams.get("r"),
                        queryParams.get("y")
                );

                boolean checkResult = checker.test(
                        Integer.parseInt(requestData.X()),
                        Float.parseFloat(requestData.Y()),
                        Float.parseFloat(requestData.R())
                );

                ResponseController.send(
                        new JsonBuilder()
                                .add("result", checkResult)
                                .add("elapsedTimeNs", timer.stop()),
                        ResponseStatus.OK
                );
            } catch (ValidationException e) {
                ResponseController.send(
                        new JsonBuilder()
                                .add("error", '"'+e.getMessage()+'"'),
                        ResponseStatus.BAD_REQUEST
                );
            }
        }
    }
}