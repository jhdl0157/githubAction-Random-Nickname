package com.example.gitaction;



import com.example.gitaction.common.ListResult;
import com.example.gitaction.common.service.ResponseService;
import com.example.gitaction.service.NicknameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.IIOException;
import javax.xml.ws.Response;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class TestController {
    private final NicknameService nicknameService;
    private final ResponseService responseService;

    @GetMapping("/nickname") public ResponseEntity<ListResult<String>> getnickname(@RequestParam(defaultValue = "2")  int count)
    {
        return  new ResponseEntity<>(responseService.getListResult(nicknameService.makeNickname(count)), HttpStatus.OK);
    }
    @GetMapping("/crawling")
    public String getCrawling() throws IOException {
        return nicknameService.getCraw();
    }
}


