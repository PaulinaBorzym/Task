package com.crud.tasks.trello.client;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TrelloMapperTest {

    TrelloMapper trelloMapper = new TrelloMapper();
    @Test
    public void mapToBoardsTest() {
        //Given
        List<TrelloListDto> trelloListDto1 = new ArrayList<>();
        List<TrelloListDto> trelloListDto2 = new ArrayList<>();
        TrelloListDto trello1 = new TrelloListDto("1","A",true);
        TrelloListDto trello2 = new TrelloListDto("2","B",false);
        TrelloListDto trello3 = new TrelloListDto("3","C",true);
        trelloListDto1.add(trello1);
        trelloListDto1.add(trello2);
        trelloListDto2.add(trello3);
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1","AA",trelloListDto1);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2","BB",trelloListDto2);
        List<TrelloBoardDto> trelloBoardsDtoList = new ArrayList<>();
        trelloBoardsDtoList.add(trelloBoardDto1);
        trelloBoardsDtoList.add(trelloBoardDto2);
        //When
        List<TrelloBoard> result = trelloMapper.mapToBoards(trelloBoardsDtoList);
        //Then
        Assertions.assertEquals(2,result.size());
        Assertions.assertEquals(2,result.get(0).getLists().size());
        Assertions.assertEquals(1,result.get(1).getLists().size());
    }
    @Test
    public void mapToBoardsDToTest() {
        //Given
        List<TrelloList> trelloList1 = new ArrayList<>();
        List<TrelloList> trelloList2 = new ArrayList<>();
        TrelloList trello1 = new TrelloList("1","A",true);
        TrelloList trello2 = new TrelloList("2","B",false);
        TrelloList trello3 = new TrelloList("3","C",true);
        trelloList1.add(trello1);
        trelloList1.add(trello2);
        trelloList2.add(trello3);
        TrelloBoard trelloBoard1 = new TrelloBoard("1","AA",trelloList1);
        TrelloBoard trelloBoard2 = new TrelloBoard("2","BB",trelloList2);
        List<TrelloBoard> trelloBoardsList = new ArrayList<>();
        trelloBoardsList.add(trelloBoard1);
        trelloBoardsList.add(trelloBoard2);
        //When
        List<TrelloBoardDto> result = trelloMapper.mapToBoardsDto(trelloBoardsList);
        //Then
        Assertions.assertEquals(2,result.size());
        Assertions.assertEquals(2,result.get(0).getLists().size());
        Assertions.assertEquals(1,result.get(1).getLists().size());
    }
    @Test
    public void mapToListTest(){
        //Given
        List<TrelloListDto> trelloListDto1 = new ArrayList<>();
        List<TrelloListDto> trelloListDto2 = new ArrayList<>();
        TrelloListDto trello1 = new TrelloListDto("1","A",true);
        TrelloListDto trello2 = new TrelloListDto("2","B",false);
        TrelloListDto trello3 = new TrelloListDto("3","C",true);
        trelloListDto1.add(trello1);
        trelloListDto1.add(trello2);
        trelloListDto2.add(trello3);
        //When
        List<TrelloList> trelloListsDto1 = trelloMapper.mapToList(trelloListDto1);
        List<TrelloList> trelloListsDto2 = trelloMapper.mapToList(trelloListDto2);
        //Then
        Assertions.assertEquals(2, trelloListsDto1.size());
        Assertions.assertEquals(1, trelloListsDto2.size());
        Assertions.assertEquals("A", trelloListsDto1.get(0).getName());
        Assertions.assertEquals("3",trelloListsDto2.get(0).getId());
    }
    @Test
    public void mapToListDtoTest(){
        //Given
        List<TrelloList> trelloList1 = new ArrayList<>();
        List<TrelloList> trelloList2 = new ArrayList<>();
        TrelloList trello1 = new TrelloList("1","A",true);
        TrelloList trello2 = new TrelloList("2","B",false);
        TrelloList trello3 = new TrelloList("3","C",true);
        trelloList1.add(trello1);
        trelloList1.add(trello2);
        trelloList2.add(trello3);
        //When
        List<TrelloListDto> trelloLists1 = trelloMapper.mapToListDto(trelloList1);
        List<TrelloListDto> trelloLists2 = trelloMapper.mapToListDto(trelloList2);
        //Then
        Assertions.assertEquals(2, trelloLists1.size());
        Assertions.assertEquals(1, trelloLists2.size());
        Assertions.assertEquals("A", trelloLists1.get(0).getName());
        Assertions.assertEquals("3",trelloLists2.get(0).getId());
    }
    @Test
    public void mapToCartDtoTest(){
        //Given
        TrelloCard trelloCard1 = new TrelloCard("A","abc","qwe","1");
        //When
        TrelloCardDto result = trelloMapper.mapToCardDto(trelloCard1);
        //Then
        Assertions.assertEquals("A",result.getName());
        Assertions.assertEquals("qwe",result.getPos());
    }
    @Test
    public void mapToCartTest(){
        //Given
        TrelloCardDto trelloCardDto1 = new TrelloCardDto("B","cde","123","2");
        //When
        TrelloCard result =trelloMapper.mapToCard(trelloCardDto1);
        //Then
        Assertions.assertEquals("2",result.getListId());
        Assertions.assertEquals("cde",result.getDescription());
    }
}
