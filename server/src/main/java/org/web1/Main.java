package org.web1;

import com.fastcgi.*;
import java.util.HashMap;
import java.util.function.Function;

import org.web1.checkers.Checker;
import org.web1.checkers.CheckerFunction;
import org.web1.utils.JsonBuilder;
import org.web1.utils.QueryStringToHashmap;
import org.web1.utils.ResponseController;
import org.web1.utils.Timer;

public class Main {
    private static final Function<String, HashMap<String,String>> parseQuery = new QueryStringToHashmap();
    private static final CheckerFunction checker = new Checker();

    public static void main(String[] args) {
        FCGIInterface fastCGI = new FCGIInterface();
        Timer timer = new Timer();

        while (fastCGI.FCGIaccept() >= 0) {
            timer.start();

            HashMap<String, String> queryParams = parseQuery.apply(
                    FCGIInterface.request.params.getProperty("QUERY_STRING")
            );
            boolean checkResult = checker.test(queryParams);

            String result = ResponseController.create(
                    new JsonBuilder()
                            .add("result", checkResult)
                            .add("elapsedTimeNs", timer.stop())
            );

            System.out.println(result);
        }
    }
}