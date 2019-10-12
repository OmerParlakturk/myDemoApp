package com.mycompany.app;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;
public class App 
{

   public static boolean myMethod(ArrayList<Integer> a1, ArrayList<Integer> a2, int i1, int i2)
/* this method check the sum of first i1 elements in array a1 and compare to sum of i2 elements in array a2, if the sum will be equal then it returns true*/
   {
	if(a1 == null)
	return false;
	
	if(a2 == null)
	return false;

	if(a1.size() == 0)
	return false;

	if(a2.size() == 0)
	return false;

	int tempSum1 = 0;
	int tempSum2 = 0;

	for(int i = 0 ; i< i1 ; i++){
	        tempSum1 = a1.get(i);
	}
	for(int i = 0 ; i< i2 ; i++){
		tempSum2 = a2.get(i);
	}

	return (tempSum1 == tempSum2);

   }
   public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "This method check the sum of first i1 elements in array a1 and compare to sum of i2 elements in array a2, if the sum will be equal then it returns true");

        post("/compute", (req, res) -> {

////...	
          String input1 = req.queryParams("input1");
	  java.util.Scanner sc1 = new java.util.Scanner(input1);
	  sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> a1 = new java.util.ArrayList<>();
	  
	  while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            a1.add(value);
          }
	  System.out.println(a1);

	  String input2 = req.queryParams("input2");
	  java.util.Scanner sc2 = new java.util.Scanner(input2);
	  sc2.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> a2 = new java.util.ArrayList<>();
	  
	  while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            a2.add(value);
          }
	  System.out.println(a2);

          String input3 = req.queryParams("input3").replaceAll("\\s","");
	  int i1 = Integer.parseInt(input3);

	  String input4 = req.queryParams("input4").replaceAll("\\s","");
	  int i2 = Integer.parseInt(input4);

	  boolean result = App.myMethod(a1,a2,i1,i2);

////...

         Map map = new HashMap();
          map.put("result", result);        
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
    return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
