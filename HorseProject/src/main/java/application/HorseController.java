package application;

import data.HorseDao;
import model.Horse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HorseController {
    String url = "jdbc:postgresql://localhost:5432/HorseProject";
    public static List<Horse> horses = new ArrayList<>();

    @GetMapping("/horses")
    public String horsesMainPage(Model model) {
        model.addAttribute("horse_list", HorseDao.getInstance().getHorseDatabase());
        return "horses";
    }

    @GetMapping("/horses/add")
    public String addHorses(Model model) {
        model.addAttribute("horse_list", HorseDao.getInstance().getHorseDatabase());
        return "horse_add";
    }

    @RequestMapping(value = "/horses/add/addHorse")
    public ResponseEntity<String> addHorseToDatabase(@RequestParam("name") String name,
                                             @RequestParam("sex") String sex,
                                             @RequestParam("breed") String breed,
                                             @RequestParam("year") int year,
                                             @RequestParam("country") String country,
                                             @RequestParam("gait") String gait,
                                             @RequestParam("race") String race) {

        Horse horse = new Horse(String.valueOf(HorseDao.getInstance().getHorseDatabase().size()+1), name, breed, year, country, sex, gait, race, "", "", "");
        try {
            Class.forName("org.postgresql.Driver");
            //change to usernamer and password
        Connection conn = DriverManager.getConnection(url,"postgres","DJcoco12%");
        //to here
        Statement stmt = conn.createStatement();
        //stmt.execute("insert into Horses values(HorseDao.getInstance().getHorseDatabase().size+1),)
        HorseDao.getInstance().getHorseDatabase().add(horse);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/horses/search")
    public String searchHorses(Model model) {
        model.addAttribute("horse_list", HorseDao.getInstance().getHorseDatabase());
        return "horse_search";
    }

    @RequestMapping(path="/horses/{horse_id}")
    public String getMessage(@PathVariable("horse_id") String horseId, Model model) {
        model.addAttribute("horse", HorseDao.getInstance().getHorseDatabase().get(Integer.valueOf(horseId)-1));
        return "horse_info";
    }
    @RequestMapping(path="/horses/edit/{horse_id}")
    public String get
}
