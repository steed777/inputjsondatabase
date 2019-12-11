package input.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;
import java.util.UUID;

@Controller
public class UploaderController {
private String uploadpath;

@Value("${upload.path}")
    @GetMapping("/uploader")
    public String uploader(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model){
    model.put("name", name);


    return "uploader";
}
        @PostMapping("/uploader")
                public String add(@RequestParam("file") MultipartFile file){
  if (file != null){
            File upload = new File(uploadpath);

            if (!upload.exists()){
                upload.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
        }
    return "uploader";
    }

    }


