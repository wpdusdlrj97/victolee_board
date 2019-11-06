package com.example.vt.victolee_login.controller;

import com.example.vt.victolee_login.dto.BoardDto;
import com.example.vt.victolee_login.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//다음으로 URL을 매핑하고, 비즈니스 로직 함수를 호출하여 view에 뿌려주는 역할을 하는 컨트롤러를 구현해보겠습니다.

@Controller
//컨트롤러임을 명시하는 어노테이션입니다.
//MVC에서 컨트롤러로 명시된 클래스의 메서드들은 반환 값으로 템플릿 경로를 작성하거나, redirect를 해줘야 합니다.
//템플릿 경로는 templates 패키지를 기준으로한 상대경로입니다.
@AllArgsConstructor
//Bean 주입 방식과 관련이 있으며, 생성자로 Bean 객체를 받는 방식을 해결해주는 어노테이션입니다.
//그래서 BoardService 객체를 주입 받을 때 @Autowired 같은 특별한 어노테이션을 부여하지 않았습니다.
//그 밖에, @NoArgsConstructor @RequiredArgsConstructor 어노테이션이 있습니다.
public class BoardController {

    private BoardService boardService;

    //@GetMapping / @PostMapping
    //URL을 매핑해주는 어노테이션이며, HTTP Method에 맞는 어노테이션을 작성하면 됩니다.

    /* 게시글 목록 */
    @GetMapping("/")
    public String list(Model model) { //Model 객체를 통해 View에 데이터를 전달합니다.
        List<BoardDto> boardList = boardService.getBoardlist();

        model.addAttribute("boardList", boardList);
        return "/board/list.html";
    }

    @GetMapping("/post")
    public String write() {
        return "/board/write.html";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);
        return "redirect:/";
    }
}