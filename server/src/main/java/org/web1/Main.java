package org.web1;

import com.fastcgi.*;
import java.util.HashMap;
import java.util.function.Function;

import org.validator.ValidatedRecordFactory;
import org.web1.DTOs.RequestDTO;
import org.web1.checkers.Checker;
import org.web1.checkers.CheckerFunction;
import org.web1.netUtils.JsonBuilder;
import org.web1.netUtils.QueryStringToHashmap;
import org.web1.netUtils.ResponseFactory;
import org.web1.timer.Timer;

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

                String result = ResponseFactory.create(
                        new JsonBuilder()
                                .add("result", checkResult)
                                .add("elapsedTimeNs", timer.stop())
                );

                System.out.println(result);
            } catch (Exception e) {
                String result = ResponseFactory.create(
                        new JsonBuilder().add("error", '"'+e.getMessage()+'"')
                );
                System.out.println(result);
            }
        }
    }
}