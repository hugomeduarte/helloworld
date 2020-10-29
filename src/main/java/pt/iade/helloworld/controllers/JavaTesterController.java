package pt.iade.helloworld.controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.helloworld.models.CurricularUnit;

@RestController
@RequestMapping(path="/api/java/tester") 
public class JavaTesterController {
    private Logger logger = LoggerFactory.getLogger(JavaTesterController.class); 
    
    @GetMapping(path = "/author", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getAuthor() {
        logger.info("Autor do tutorial");
            String name="Hugo Duarte";
            int number=20190843;
            double height=2;
            boolean fan=true;
            String color="Green";
            String text;
            if(fan) {
                text="Sou o "+name + "blablabla" + number + "tenho" + height + "metros e a"
                + "cor do meu clube fav é" + color;
            } else {
                text="Sou o "+name + "blablabla" + number + "tenho" + height + "metros e ja ta";
            }
            return text;

    // http://localhost:8080/api/java/tester/author
    }

    @GetMapping(path = "/access/{student}/{covid}", produces= MediaType.APPLICATION_JSON_VALUE)
    public boolean getGreeting(@PathVariable("student") boolean isStudent,
        @PathVariable("covid") boolean hasCovid) {
            if (isStudent && (!hasCovid)) {
                return true;
            } else {
                return false;
            }
    // http://localhost:8080/api/java/tester/access/true/false
    }

    @GetMapping(path = "/required/{student}/{temperature}/{classType}", produces= MediaType.APPLICATION_JSON_VALUE)
    public boolean getRequired(@PathVariable("student") boolean isStudent,
        @PathVariable("temperature") double hasCovid, @PathVariable("classType") String type) {
            if (isStudent && type.equals("presential") && (hasCovid > 34.5 && hasCovid < 37.5)) {
                return true;
            } else {
                return false;
            }
            // http://localhost:8080/api/java/tester/required/true/35/presential
        }

        @GetMapping(path = "/evacuation/{fire}/{numberOfCovids}/{powerShutdown}/{comeBackTime}", produces= MediaType.APPLICATION_JSON_VALUE)
        public boolean getEvacuated(@PathVariable("fire") boolean fire,
        @PathVariable("numberOfCovids") int numberOfCovids, @PathVariable("powerShutdown") boolean powerShutdown,
        @PathVariable("comeBackTime") int comeBackTime) {
            if (fire || numberOfCovids > 5 || (powerShutdown && comeBackTime > 15)) {
                return true;
            }
            else {
                return false;
            }
            // http://localhost:8080/api/java/tester/evacuation/false/4/true/16
        }
        
        private double grades[] = {10.5, 12, 14.5}; 
        private String ucs[] = {"FP","POO","BD"};

        @GetMapping(path = "/average", produces= MediaType.APPLICATION_JSON_VALUE)
        public double average() {
            double total =0;
            for(int i=0;i<grades.length;i++) {
                total+=grades[i];
            }
            double average = total/ucs.length;
            return average;
            // http://localhost:8080/api/java/tester/average
        }

        @GetMapping(path = "/maxgrade", produces= MediaType.APPLICATION_JSON_VALUE)
        public double maxgrade() {
            double max = grades [0];
            for(int i=0; i<grades.length; i++) {
                if (grades[i] > max) {
                    max = grades[i];
                }
            }
            return max;
            // http://localhost:8080/api/java/tester/maxgrade
        }

        @GetMapping(path = "/returngrade", produces= MediaType.APPLICATION_JSON_VALUE)
        public double returngrade() {
        String name="POO";                             
        int num = 0;
        for(int i=0; i<ucs.length; i++) {
            if (ucs[i].equals(name)) {
                num = i;
                break;
            }
        }
        double returngrade = grades[num];
        return returngrade;
        // http://localhost:8080/api/java/tester/returngrade
    }

    @GetMapping(path = "/minmaxgrade", produces= MediaType.APPLICATION_JSON_VALUE)
        public double minmaxgrade() {
        double min=11;
        double max=13;  
        int num=0;                          
        for(int i=0; i<grades.length; i++) {
            if (grades[i]>min && grades[i]<max) {
                num++;
            }
        }
        return num;
        // http://localhost:8080/api/java/tester/minmaxgrade
    }

    @GetMapping(path = "/stringgrade", produces= MediaType.APPLICATION_JSON_VALUE)
        public String stringgrade() {
        String text="";                  
        for(int i=0; i<grades.length; i++) {
            text+=ucs[i]+":"+grades[i];
            }
        
        return text;
        
        // http://localhost:8080/api/java/tester/stringgrade
    }

    private ArrayList<CurricularUnit> units = new ArrayList<CurricularUnit>();

    @PostMapping(path = "/units",produces= MediaType.APPLICATION_JSON_VALUE) 
    public CurricularUnit saveUnit(@RequestBody CurricularUnit unit) {
    logger.info("Added unit "+unit.getName());
    units.add(unit);
    return unit;
    }

    @GetMapping(path = "/units",produces= MediaType.APPLICATION_JSON_VALUE) 
    public ArrayList<CurricularUnit> getUnits() {
    logger.info("Get "+units.size()+" Units");
    return units;
}
// http://localhost:8080/saveUnit.html
// http://localhost:8080/api/java/tester/units

}

         
   
    

