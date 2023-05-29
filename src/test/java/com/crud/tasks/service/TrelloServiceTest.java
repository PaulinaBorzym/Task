package com.crud.tasks.service;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TrelloServiceTest {

    @Autowired
    TrelloService trelloService;
    @Test
    void fetchTrelloBoardTest(){
        //Given
        List<TrelloList> trelloList1 = new ArrayList<>();
        List<TrelloList> trelloList2 = new ArrayList<>();
        TrelloBoard trelloBoard1 = new TrelloBoard("1","A",trelloList1);
        TrelloBoard trelloBoard2 = new TrelloBoard("2","B",trelloList2);
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard1);
        trelloBoardList.add(trelloBoard2);
        //When
        List<TrelloBoardDto> result = trelloService.fetchTrelloBoards();
        //Then
        Assertions.assertEquals(2,result.size());
    }
}
