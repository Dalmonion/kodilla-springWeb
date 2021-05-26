package com.crud.tasks.mapper;


import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrelloMapperTest {
    private final TrelloMapper mapper = new TrelloMapper();

    @Test
    void mapToBoardsAndListTest() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "test1", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "test2", false);

        List<TrelloListDto> trelloListDtos1 = new ArrayList<>();
        Collections.addAll(trelloListDtos1, trelloListDto1, trelloListDto2);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "testName1", trelloListDtos1);
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto);
        //When
        List<TrelloBoard> trelloBoards = mapper.mapToBoards(trelloBoardDtos);

        //Then
        assertSame(trelloBoards.get(0).getClass(), TrelloBoard.class);
        assertSame(trelloBoards.get(0).getLists().get(0).getClass(), TrelloList.class);
        assertEquals(1, trelloBoards.size());
        assertEquals(2, trelloBoards.get(0).getLists().size());
    }

    @Test
    void mapToBoardsDtoAndListDtoTest() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "test1", true);
        TrelloList trelloList2 = new TrelloList("2", "test2", false);

        List<TrelloList> trelloList = new ArrayList<>();
        Collections.addAll(trelloList, trelloList1, trelloList2);

        TrelloBoard trelloBoard = new TrelloBoard("1", "testName1", trelloList);
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard);
        //When
        List<TrelloBoardDto> trelloBoardDtos = mapper.mapToBoardsDto(trelloBoardList);

        //Then
        assertSame(trelloBoardDtos.get(0).getClass(), TrelloBoardDto.class);
        assertSame(trelloBoardDtos.get(0).getLists().get(0).getClass(), TrelloListDto.class);
        assertEquals(1, trelloBoardDtos.size());
        assertEquals(2, trelloBoardDtos.get(0).getLists().size());
    }

    @Test
    void testMapToCardDto() {
        //Given
        TrelloCard card = new TrelloCard("testName", "test description", "test post", "1");
        //When
        TrelloCardDto cardDto = mapper.mapToCardDto(card);
        //Then
        assertSame(cardDto.getClass(), TrelloCardDto.class);
    }

    @Test
    void testMapToCard() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("testName", "test description", "test post", "1");
        //When
        TrelloCard card = mapper.mapToCard(cardDto);
        //Then
        assertSame(card.getClass(), TrelloCard.class);
    }
}