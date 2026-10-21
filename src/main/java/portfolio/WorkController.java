
package portfolio;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
public class WorkController { // リクエストを受け取り、処理を依頼する

    private final WorkRepository workRepository;

    public WorkController(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @GetMapping("/api/works")
    public List<Map<String, Object>> getWorks() {
        return workRepository.findAll();
    }

    @PostMapping("/api/works/save-image")
    public String saveImage() throws java.io.IOException {
        String imagePath = "C:\\javasrc\\ShioneHp\\potfolio\\src\\main\\resources\\static\\images\\todo.png";

        int result = workRepository.saveImage("ToDoリスト", imagePath);

        return result + "件の作品を保存しました";

        //ターミナルでInvoke-RestMethod -Method Post -Uri "http://localhost:8080/api/works/save-image" を実行して保存
    }

    @GetMapping("/api/works/{id}/image")
    public ResponseEntity<byte[]> getWorkImage(
            @org.springframework.web.bind.annotation.PathVariable int id) {

        Map<String, Object> image = workRepository.findImageById(id);

        byte[] imageData = (byte[]) image.get("image_data");

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(imageData);
    }
}
