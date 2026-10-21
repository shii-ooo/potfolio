package portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller 
public class HomeController {

    @GetMapping("/") //トップページのURL / にアクセスしたときに処理する
    public String home() {
        return "index"; //index.html という画面を表示するよう指定する
    }
    
}
