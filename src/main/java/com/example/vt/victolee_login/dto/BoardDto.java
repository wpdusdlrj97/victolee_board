package com.example.vt.victolee_login.dto;

import com.example.vt.victolee_login.domain.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;


//dto는 Controller <-> Service <-> Repository 간에 필요한 데이터를 캡슐화한 데이터 전달 객체입니다.
//그런데 예제에서 Service에서 Repository 메서드를 호출할 때, Entity를 전달한 이유는 JpaRepository에 정의된 함수들은 미리 정의되어 있기 때문입니다.
// 그래서 Entity를 전달할 수 밖에 없었는데, 요점은 각 계층에서 필요한 객체전달은 Entity 객체가 아닌 dto 객체를 통해 주고받는 것이 좋다는 것입니다.
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public BoardEntity toEntity(){
        //dto에서 필요한 부분을 빌더패턴을 통해 entity로 만듭니다.
        //필요한 Entity는 이런식으로 추가하면 됩니다.
        BoardEntity build = BoardEntity.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long id, String title, String content, String writer, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}