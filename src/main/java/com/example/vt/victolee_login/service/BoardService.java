package com.example.vt.victolee_login.service;

import com.example.vt.victolee_login.domain.entity.BoardEntity;
import com.example.vt.victolee_login.domain.repository.BoardRepository;
import com.example.vt.victolee_login.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
//Controller에서 봤던 어노테이션 입니다.
//마찬가지로 Repository를 주입하기 위해 사용합니다.
//Autowired가 필요없다
@Service
//서비스 계층임을 명시해주는 어노테이션입니다.
public class BoardService {

    private BoardRepository boardRepository;

    @Transactional
    //선언적 트랜잭션이라 부르며, 트랜잭션을 적용하는 어노테이션입니다.
    public Long savePost(BoardDto boardDto) {
        //JpaRepository에 정의된 메서드로, DB에 INSERT, UPDATE를 담당합니다.
        //매개변수로는 Entity를 전달합니다.
        return boardRepository.save(boardDto.toEntity()).getId();

    }

    @Transactional
    //선언적 트랜잭션이라 부르며, 트랜잭션을 적용하는 어노테이션입니다.
    //Controller와 Service간에 데이터 전달은 dto 객체로 하기 위해, Repository에서 가져온 Entity를 반복문을 통해 dto로 변환하는 작업이 있습니다.
    public List<BoardDto> getBoardlist() {

        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for ( BoardEntity boardEntity : boardEntities) {
            BoardDto boardDTO = BoardDto.builder()
                    .id(boardEntity.getId())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .writer(boardEntity.getWriter())
                    .createdDate(boardEntity.getCreatedDate())
                    .build();

            boardDtoList.add(boardDTO);
        }

        return boardDtoList;
    }



}
